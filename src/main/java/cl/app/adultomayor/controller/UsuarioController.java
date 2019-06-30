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
import cl.app.adultomayor.dto.UsuarioContrasena;
import cl.app.adultomayor.security.SecurityController;
import cl.app.adultomayor.service.ContrasenaService;
import cl.app.adultomayor.service.TokenService;
import cl.app.adultomayor.service.UsuarioService;
import cl.app.adultomayor.viewsdto.ViewUsuario;
import java.util.Date;
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

    
    @RequestMapping(value = "/public/all", method = RequestMethod.GET)
    public List<Usuario> objeterTodosUsuariosPublic() {
            return usuarioService.getAllUsuario();
    }

    
    @RequestMapping(value = "/addUsuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public String addNewUser(@RequestBody UsuarioContrasena usuarioNuevo) throws Exception {  
        
        String resultado = this.securityController.registrarUsuarioWithContrasena(usuarioNuevo);
        
        if( resultado == "error"){
            
            throw new Exception(resultado);
            
        }
        
        return resultado ;
     
    }
 
   
    @PostMapping("/add")
    public Usuario addUsuario(@RequestParam("rut") String rut,
            @RequestParam("nombre") String nombre,
            @RequestParam("paterno") String paterno,
            @RequestParam("materno") String materno,
            @RequestParam("sexo") char sexo , 
            @RequestParam("fechaNacimiento") Date fechaNacimiento,
            @RequestParam("correo") String correo,
            @RequestParam("numeroTelefonico") Integer numeroTelefonico,
            @RequestParam("estado") boolean estado,
            @RequestParam("direccion") String direccion ) {
        
        Usuario usuario = new Usuario();
        usuario.setRut(rut); 
        usuario.setNombre(nombre); 
        usuario.setPaterno(paterno); 
        usuario.setMaterno(materno); 
        usuario.setSexo(sexo); 
        usuario.setFechaNacimiento(fechaNacimiento); 
        usuario.setCorreo(correo); 
        usuario.setNumeroTelefonico(numeroTelefonico); 
        usuario.setEstado(estado); 
        usuario.setDireccion(direccion);   
        try{
            
            usuario = this.usuarioService.addUsuario(usuario);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        
        return this.usuarioService.addUsuario(usuario);
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
