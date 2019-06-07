/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.dto;

import java.util.Date;
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
@Table(name = "TOKEN_SESION")
public class Token {
    
    @Column(name = "ID_TOKEN")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "TOKEN", nullable = false, length = 60)
    private String token;
    
    @Column(name = "FECHA_SESION", nullable = false, length = 60)
    private Date fechaSesion;
     
    @Column(name = "MAQUINA", nullable = false, length = 60)
    private String maquina;
      
    @Column(name = "LATITUD", nullable = false, length = 60)
    private Integer latitud;
    
    
    @Column(name = "LONGITUD", nullable = false, length = 60)
    private Integer longitud;
      
    @Column(name = "IP", nullable = false, length = 60)
    private String ip;
        
    @Column(name = "ID_USUARIO", nullable = false, length = 60)
    private Integer idUsuario;
          
    @Column(name = "ESTADO", nullable = false, length = 60)
    private boolean estado;

    public Token(Integer id, String token, Date fechaSesion, String maquina, Integer latitud, Integer longitud, String ip, Integer idUsuario, boolean estado) {
        this.id = id;
        this.token = token;
        this.fechaSesion = fechaSesion;
        this.maquina = maquina;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ip = ip;
        this.idUsuario = idUsuario;
        this.estado = estado;
    }

    public Token() {
    }
        

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(Date fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
        

    
}
