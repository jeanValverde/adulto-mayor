/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.controller;

import cl.app.adultomayor.dao.ViewUsuarioDao;
import cl.app.adultomayor.dto.Contrasena;
import cl.app.adultomayor.dto.Usuario;
import cl.app.adultomayor.dao.ProcedureQuery;
import cl.app.adultomayor.dto.Token;
import cl.app.adultomayor.security.SecurityController;
import cl.app.adultomayor.service.ContrasenaService;
import cl.app.adultomayor.service.TokenService;
import cl.app.adultomayor.service.UsuarioService;
import cl.app.adultomayor.viewsdto.ViewUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jean
 */
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.OPTIONS})
@RequestMapping("/usuario")
//puta linea de codigo, perdi 2 horas de desarrollo 
//https://www.arquitecturajava.com/spring-rest-cors-y-su-configuracion/ resolver el problema 
//https://www.arquitecturajava.com/que-es-cors/
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ContrasenaService contrasenaService;

    @Autowired
    TokenService tokenService;

    @Autowired
    ProcedureQuery procedureQueryContrasena;

    @Autowired
    SecurityController securityController;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Usuario> objeterTodosUsuarios(@RequestHeader HttpHeaders headers) throws Exception {
        boolean permiso = this.securityController.validadToken(headers);
        if(permiso){
            return usuarioService.getAllUsuario();
        }
        throw new Exception("403");
    }
    
    @RequestMapping(value = "/public/all", method = RequestMethod.GET)
    public List<Usuario> objeterTodosUsuariosPublic() {
            return usuarioService.getAllUsuario();
    }

    @RequestMapping(value = "/addUsuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Usuario addNewUser(@RequestBody Usuario usuarioNuevo) {
        return this.usuarioService.addUsuario(usuarioNuevo);
    }

    @RequestMapping(value = "/addContrasena", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Contrasena addNewContrasena(@RequestBody Contrasena contrasena) {
        return contrasena;
        //this.contrasenaService.cre
        // this.contrasenaService.crearNuevaContrasena(contrasena.getUsuario(), contrasena.getContrasena(), contrasena.getCodRecuperacion()  , contrasena.getRol() );
    }

    @RequestMapping(value = "/viewUsuario", method = RequestMethod.GET)
    public List<ViewUsuario> objeterViewUsuario() {
        return usuarioService.getAllViewUsuario();
    }

    @RequestMapping(value = "/tokens", method = RequestMethod.GET)
    public List<Token> objeterView() {
        return this.tokenService.getttt();
    }

    @RequestMapping(value = "/tokensAll", method = RequestMethod.GET)
    public List<Token> objeterViewd() {
        return this.tokenService.getPruebaj();
    }

    @RequestMapping(value = "/contraPrueba", method = RequestMethod.GET)
    public boolean pruebaContra(@RequestParam("idUsuario") Integer idUusario,
            @RequestParam("contrasena") String contrasena,
            @RequestParam("cod") Integer cod,
            @RequestParam("rol") String rol) {

        return this.procedureQueryContrasena.insertNewContrasena(idUusario, contrasena, cod, rol);

    }

    @RequestMapping(value = "/validarToken", method = RequestMethod.GET)
    public boolean pruebaToken(@RequestHeader HttpHeaders headers) {

        return this.securityController.validadToken(headers);

    }

    
    @PostMapping("/iniciarSesion")
    public String login(@RequestParam("rut") Integer rut,
            @RequestParam("password") String contrasena,
            @RequestParam("correo") String correo) {

        //@RequestHeader HttpHeaders headers
        Token token = new Token();

        try {

            token = this.securityController.login(contrasena, rut, correo);

            if (token != null) {
                return token.getToken();
            }
        } catch (Exception ex) {
            return "403";
        }
        return "403";
    }

   

}
