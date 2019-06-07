/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.service;

import cl.app.adultomayor.dao.TokenDao;
import cl.app.adultomayor.dto.Token;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author jean
 */
@Service
public class TokenService {
    
    @Autowired
    TokenDao tokenDao;

     public List<Token> getttt() {
        return this.tokenDao.usuPrueba();
    }
    
    public List<Token> getPruebaj() {
        return this.tokenDao.findAll();
    }
    
    public Token getTokenByIdUsuario( Integer idUsuario) {
        return this.tokenDao.getTokenByIdUsuario(idUsuario);
    }
    
    
}
