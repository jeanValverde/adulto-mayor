/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.dao;


import cl.app.adultomayor.dto.Token;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jean
 */
@Repository
public interface TokenDao extends JpaRepository<Token, Integer> {
    
    
     @Query(value="SELECT * FROM get_token " , nativeQuery=true)
     List<Token> usuPrueba();
     
     @Query(value=" select * from get_token_activo where id_usuario = ?1 " , nativeQuery=true)
     Token getTokenByIdUsuario(Integer idUsuario);
     
     
     
    
}
