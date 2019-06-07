/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.viewsdto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "GET_LLAVE_CLAVE")
public class ViewLlaveUsuario  {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_USUARIO")
    private Long id;
    
    @NotNull
    @Column(name = "LLAVE")
    private String llave;

    public ViewLlaveUsuario() {
    }

   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }
    
    
    
}
   
