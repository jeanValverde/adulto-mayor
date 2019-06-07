/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.dto;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "CONTRASENA")
public class Contrasena {

    @Column(name = "ID_CONTRASENA")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "CONTRASENA", nullable = false, length = 60)
    private String contrasena;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private boolean estado;

    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;

    @Column(name = "COD_RECUPERACION", nullable = false)
    private Integer codRecuperacion;

    @Column(name = "ROL", nullable = false, length = 30)
    private String rol;

    @Column(name = "ID_USUARIO", nullable = false)
    private Integer usuario;

    public Contrasena() {
    }

    public Contrasena(Integer id, String contrasena, boolean estado, Date fechaCreacion, Integer codRecuperacion, String rol, Integer usuario) {
        this.id = id;
        this.contrasena = contrasena;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.codRecuperacion = codRecuperacion;
        this.rol = rol;
        this.usuario = usuario;
    }

    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCodRecuperacion() {
        return codRecuperacion;
    }

    public void setCodRecuperacion(Integer codRecuperacion) {
        this.codRecuperacion = codRecuperacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

  
    
}
