/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.viewsdto;

import java.util.Date;
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
@Table(name = "GET_ADULTO_MAYOR")
public class ViewAdulto {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_USUARIO")
    private Long id;

    @NotNull
    @Column(name = "CORREO")
    private String correo;

    @NotNull
    @Column(name = "ESTADO")
    private boolean estado;

    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @NotNull
    @Column(name = "MATERNO")
    private String materno;

    @NotNull
    @Column(name = "NOMBRE")
    private String nombre;

    @NotNull
    @Column(name = "NUMERO_TELEFONICO")
    private Integer numeroTelefonico;

    @NotNull
    @Column(name = "PATERNO")
    private String paterno;

    @NotNull
    @Column(name = "RUT")
    private String rut;
    
    
    @NotNull
    @Column(name = "DIRECCION")
    private String direccion;
    
    @NotNull
    @Column(name = "SEXO")
    private char sexo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(Integer numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
    

}
