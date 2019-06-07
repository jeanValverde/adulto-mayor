/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.dao;

import cl.app.adultomayor.dto.Contrasena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jean
 */
@Repository
public interface ContrasenaDao extends JpaRepository<Contrasena, Integer> {
    
  
     @Query(value=" select * from get_contrasenas_activas where id_usuario = ?1 " , nativeQuery=true)
     Contrasena getContrasenaByUsuario(Integer idUsuario);
 
     
    
     
    
}
