/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.dao;

import cl.app.adultomayor.dto.Contrasena;
import cl.app.adultomayor.dto.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jean
 */
@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

  
     @Query(value=" select * from get_contrasenas_activas where id_usuario = ?1 " , nativeQuery=true)
     Contrasena getContrasenaByUsuario(Integer idUsuario);
     
     //validar usuario por contrasena o correo electronico 
     @Query(value=" select id_usuario , rut ,nombre,  materno, paterno , correo , estado , fecha_nacimiento , numero_telefonico, sexo  from validar_usuario_is_contrasena " +
                  " where contrasena = ?1  and rut=?2 or contrasena = ?1 and correo=?3  " , nativeQuery=true)
     Usuario validarUsuarioWithContrasena(String contrasena , Integer rut, String correo );
    
     @Query(value=" select * from usuario where rut = ?1 or correo = ?2 " , nativeQuery=true)
     Usuario getUsuarioWithCorreoOrRut(Integer rut, String correo);

      
     
}
