/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.security;

import cl.app.adultomayor.dao.ProcedureQuery;
import cl.app.adultomayor.dto.Contrasena;
import cl.app.adultomayor.dto.Token;
import cl.app.adultomayor.dto.Usuario;
import cl.app.adultomayor.service.ContrasenaService;
import cl.app.adultomayor.service.TokenService;
import cl.app.adultomayor.service.UsuarioService;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jean
 */
@RestController
public class SecurityController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ContrasenaService contrasenaService;

    @Autowired
    TokenService tokenService;

    @Autowired
    ProcedureQuery procedureQuery;

    public SecurityController() {
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    //cada que se inicie la sesión 
    private String generarToken(Usuario usuario, String rol) {

        UUID uuid = UUID.randomUUID();

        int id = usuario.getId();

        String token;

        token = uuid.toString() + "_" + id + "_" + rol;

        registrarToken(token, usuario);

        return token;

    }

    //al iniciar sesión 
    public boolean validadToken(HttpHeaders headers) {

        List<String> headersAtri = headers.get("Authorization");

        //validar en la base de datos la autentificación 
        //una vez los datos son correctos entregar el token a la cookies
        String authorization = headersAtri.get(0);

        if (authorization != null || authorization != "") {
            Token token = new Token();

            String idUsuarioHeaders = obtenerDatosHeaders(authorization, "idUsuario");

            Integer idUsuario = Integer.parseInt(idUsuarioHeaders);

            token = this.tokenService.getTokenByIdUsuario(idUsuario);

            if(validarHoraToken(token.getFechaSesion(), token)){
                return true;
            }else{
                return false;
            }

        }

        return false;
    }

    private boolean validarHoraToken(Date fechaSesion, Token token) {

        try {
            Date fechaActual = new Date();

            long diferencia = fechaActual.getTime() - fechaSesion.getTime();

            long min = TimeUnit.MILLISECONDS.toMinutes(diferencia);

            //valor de la sesion 
            if (min < 30) {

                if (min > 27) {
                    return this.procedureQuery.updateDateToken(token.getId());
                }
                
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {

            return false;

        }

    }

    private String obtenerDatosHeaders(String authorization, String accion) {
        String[] parts = authorization.split("_");
        String dato = "";
        switch (accion) {
            case "token":
                dato = parts[0];
                break;
            case "idUsuario":
                dato = parts[1];
                break;
            case "rol":
                dato = parts[2];
                break;
            default:
                dato = "403";
                break;
        }
        return dato;
    }

    //nuevos usuarios 
    private void registrarToken(String token, Usuario usuario) {

    }

    private String encriptarContrasena(String texto, String llave) {

        String secretKey = llave; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    private String desencriptarContrasena(String textoEncriptado, String llave) throws Exception {

        String secretKey = llave; //llave para desenciptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    private String getLlavePrivada(Integer idUsuario) {
        try {
            return this.usuarioService.getLlaveUsuario(idUsuario).get().getLlave();
        } catch (Exception ex) {
            return "";
        }
    }

    public Token login(String contrasena, Integer rut, String correo) {
        //buscar uusario 
        Token tokenObject = new Token();
        Usuario usuario = new Usuario();
        
        try {
            Usuario usuarioTemporal = null;
            usuarioTemporal = this.usuarioService.getUsuarioByRutOrCorreo(rut, correo);
            if (usuarioTemporal != null) {
                String contrasenaEncriptada = this.encriptarContrasena(contrasena, this.getLlavePrivada(usuarioTemporal.getId()));
                usuario = this.usuarioService.validarUsuarioWithContrasena(contrasenaEncriptada, rut, correo);
                if (usuario != null && usuario.getId() != null) {
                    //encontro el usuario 
                    Contrasena contrasenaActiva = new Contrasena();
                    contrasenaActiva = this.contrasenaService.getContrasenaByUsuario(usuario.getId());
                    String token = generarToken(usuario, contrasenaActiva.getRol());
                    //maquina , latitud , longitud , id
                    boolean result = this.procedureQuery.insertNewToken(usuario.getId(), token , "SIN REGISTRO", 0, 0, "SIN REGISTRO");
                    if (result) {
                        //buscar token insertado 
                        tokenObject = this.tokenService.getTokenByIdUsuario(usuario.getId());
                        if (tokenObject.getId() != null || tokenObject != null) {
                            return tokenObject;
                        }
                    }
                }
            }
            return null;
        } catch (Exception ex) {
            return null;
        }

    }

}
