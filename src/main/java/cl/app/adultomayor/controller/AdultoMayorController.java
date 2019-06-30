/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.controller;

import cl.app.adultomayor.dao.ProcedureQuery;
import cl.app.adultomayor.dao.ViewServicioAlimentacionMenuDao;
import cl.app.adultomayor.dto.Usuario;
import cl.app.adultomayor.security.SecurityController;
import cl.app.adultomayor.service.ContrasenaService;
import cl.app.adultomayor.service.TokenService;
import cl.app.adultomayor.service.UsuarioService;
import cl.app.adultomayor.viewsdto.ViewAdulto;
import cl.app.adultomayor.viewsdto.ViewServicioAlimentacionMenu;
import cl.app.adultomayor.viewsdto.ViewSesionesTerapia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jean
 */
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.OPTIONS})
@RequestMapping("/adulto")
@RestController
public class AdultoMayorController {

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
    public List<ViewAdulto> objeterTodosUsuariosPublic() {
        return usuarioService.getAllAdultoMayor(); 
    }
    
    @RequestMapping(value = "/inicioAdulto", method = RequestMethod.GET)
    public ViewAdulto adultoMayorInicio(@RequestHeader HttpHeaders headers) throws Exception{
        
        long id = Long.parseLong(this.securityController.obtenerIdHeader(headers));
        
        List<ViewAdulto> adultos = this.usuarioService.getAllAdultoMayor();
        
        for (ViewAdulto adulto : adultos) {
            if(adulto.getId() == id){
                return adulto;
            }
        }
        
        throw new Exception("No encontrado o no tiene permiso");
          
    }
    
    @RequestMapping(value = "/inicioAdultoAlimentacion", method = RequestMethod.GET)
    public List<ViewServicioAlimentacionMenu> adultoMayorInicioAlimentacion(@RequestHeader HttpHeaders headers) throws Exception{
        
        long id = Long.parseLong(this.securityController.obtenerIdHeader(headers));
        
        List<ViewServicioAlimentacionMenu> ViewServicioAlimentacion = this.usuarioService.obtenerServicioAliemntacionJoinMenu();
        
        List<ViewServicioAlimentacionMenu> servicios = new ArrayList<>();
        
        ViewServicioAlimentacion.stream().filter((servicio) -> (servicio.getIdUsuario() == id )).forEachOrdered((servicio) -> {
            servicios.add(servicio);
        });
        
        
        return servicios;
   
    }
    
    @RequestMapping(value = "/inicioAdultoTerapia", method = RequestMethod.GET)
    public List<ViewSesionesTerapia> adultoSesionesTerapia(@RequestHeader HttpHeaders headers) throws Exception{
        
        long id = Long.parseLong(this.securityController.obtenerIdHeader(headers));
        
        List<ViewSesionesTerapia> viewSesionesTerapia = this.usuarioService.obtenerSesionesTerapia(); 
        
        List<ViewSesionesTerapia> sesiones = new ArrayList<>();
        
        viewSesionesTerapia.stream().filter((sesion) -> (sesion.getIdUsuario()== id )).forEachOrdered((sesion) -> {
            sesiones.add(sesion);
        });
        
        
        return sesiones;
   
    }
    
    
    

}
