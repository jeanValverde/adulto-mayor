/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.service;

import cl.app.adultomayor.dao.ContrasenaDao;
import cl.app.adultomayor.dto.Contrasena;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Integer;

/**
 *
 * @author jean
 */
@Service
public class ContrasenaService {

    @Autowired
    ContrasenaDao contrasenaDao;

    public List<Contrasena> getPrueba() {
        return this.contrasenaDao.findAll();
    }
    
    public Contrasena getContrasenaByUsuario(Integer idUsuario) {
        return this.contrasenaDao.getContrasenaByUsuario(idUsuario);
    }
    
    
        public Contrasena addUsuario(Contrasena contrasena) {
        return this.contrasenaDao.save(contrasena);
    }
    
    

}
