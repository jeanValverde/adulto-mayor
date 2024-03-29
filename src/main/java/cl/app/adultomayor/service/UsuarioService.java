/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.service;

import cl.app.adultomayor.dao.UsuarioDao;
import cl.app.adultomayor.dao.ViewAdultoDao;
import cl.app.adultomayor.dao.ViewLlaveUsuarioDao;
import cl.app.adultomayor.dao.ViewServicioAlimentacionMenuDao;
import cl.app.adultomayor.dao.ViewSesionesTerapiaDao;
import cl.app.adultomayor.dao.ViewUsuarioDao;
import cl.app.adultomayor.dto.Usuario;
import cl.app.adultomayor.viewsdto.ViewAdulto;
import cl.app.adultomayor.viewsdto.ViewLlaveUsuario;
import cl.app.adultomayor.viewsdto.ViewServicioAlimentacionMenu;
import cl.app.adultomayor.viewsdto.ViewSesionesTerapia;
import cl.app.adultomayor.viewsdto.ViewUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jean
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    ViewUsuarioDao viewUsuario;

    @Autowired
    ViewLlaveUsuarioDao viewLlaveUsuario;

    @Autowired
    ViewAdultoDao viewAdulto;
    
    @Autowired
    ViewServicioAlimentacionMenuDao viewServicioAlimentacionMenu;
    
    @Autowired
    ViewSesionesTerapiaDao viewSesionesTerapia;
    
    
    

    public List<Usuario> getAllUsuario() {
        return this.usuarioDao.findAll();
    }

    public Usuario addUsuario(Usuario nuevoUsuario) {
        return this.usuarioDao.save(nuevoUsuario);
    }

    public Usuario getUsuarioByRutOrCorreo(Integer rut, String correo) {
        return this.usuarioDao.getUsuarioWithCorreoOrRut(rut, correo);
    }

    public List<ViewUsuario> getAllViewUsuario() {
        return (List<ViewUsuario>) this.viewUsuario.findAll();
    }

    public List<ViewAdulto> getAllAdultoMayor() {
        return (List<ViewAdulto>) this.viewAdulto.findAll();
    }  

    public Usuario validarUsuarioWithContrasena(String contrasena, Integer rut, String correo) {
        return this.usuarioDao.validarUsuarioWithContrasena(contrasena, rut, correo);
    }
    
    
    public List<ViewServicioAlimentacionMenu> obtenerServicioAliemntacionJoinMenu(){
        return (List<ViewServicioAlimentacionMenu>) this.viewServicioAlimentacionMenu.findAll(); 
    } 
    
    public List<ViewSesionesTerapia> obtenerSesionesTerapia(){
        return (List<ViewSesionesTerapia>) this.viewSesionesTerapia.findAll(); 
    } 

    public Optional<ViewLlaveUsuario> getLlaveUsuario(Integer idUsuario) {
        return this.viewLlaveUsuario.findById(idUsuario.longValue());
    }

}
