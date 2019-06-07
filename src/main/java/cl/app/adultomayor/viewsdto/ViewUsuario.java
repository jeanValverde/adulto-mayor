/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.viewsdto;

import java.io.Serializable;
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
@Table(name = "VIEW_USUARIO")
public class ViewUsuario  {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_USUARIO")
    private Long id;
   
    @NotNull
    @Column(name = "NOMBRE_COMPLETO")
    private String nombre;
    
    @NotNull
    @Column(name = "EDAD")
    private Integer edad;

    public ViewUsuario() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
     
    
   

}
