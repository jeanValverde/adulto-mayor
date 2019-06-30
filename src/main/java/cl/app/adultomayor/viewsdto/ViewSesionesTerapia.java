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
@Table(name = "GET_SESIONES_TERAPIA")
public class ViewSesionesTerapia {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_SESION_TERAPIA")
    private Long id;

    @NotNull
    @Column(name = "FECHA_TERAPIA")
    private Date fechaTerapia;

    @NotNull
    @Column(name = "NOMBRE_TERAPIA")
    private String nombreTerapia;

    @NotNull
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @NotNull
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @NotNull
    @Column(name = "PATERNO_USUARIO")
    private String paternoUsuario;

    @NotNull
    @Column(name = "CORREO")
    private String correoUsuario;

    @NotNull
    @Column(name = "DIRECCION_USUARIO")
    private String direccionUsuario;

    @NotNull
    @Column(name = "ID_TERAPEUTA")
    private Long idTerapuuta;

    @NotNull
    @Column(name = "NOMBRE_TERAPEUTA")
    private String nombreTerapeuta;

    @NotNull
    @Column(name = "PATERNO_TERAPEUTA")
    private String paternoTerapeuta;

    @NotNull
    @Column(name = "CORREO_TERAPEUTA")
    private String correoTerapeuta;

    @NotNull
    @Column(name = "NUMERO_TELEFONICO")
    private Integer numeroTelefonicoTerapeuta;

    @NotNull
    @Column(name = "SEXO_TERAPEUTA")
    private char sexo;

    public ViewSesionesTerapia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaTerapia() {
        return fechaTerapia;
    }

    public void setFechaTerapia(Date fechaTerapia) {
        this.fechaTerapia = fechaTerapia;
    }

    public String getNombreTerapia() {
        return nombreTerapia;
    }

    public void setNombreTerapia(String nombreTerapia) {
        this.nombreTerapia = nombreTerapia;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPaternoUsuario() {
        return paternoUsuario;
    }

    public void setPaternoUsuario(String paternoUsuario) {
        this.paternoUsuario = paternoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public Long getIdTerapuuta() {
        return idTerapuuta;
    }

    public void setIdTerapuuta(Long idTerapuuta) {
        this.idTerapuuta = idTerapuuta;
    }

    public String getNombreTerapeuta() {
        return nombreTerapeuta;
    }

    public void setNombreTerapeuta(String nombreTerapeuta) {
        this.nombreTerapeuta = nombreTerapeuta;
    }

    public String getPaternoTerapeuta() {
        return paternoTerapeuta;
    }

    public void setPaternoTerapeuta(String paternoTerapeuta) {
        this.paternoTerapeuta = paternoTerapeuta;
    }

    public String getCorreoTerapeuta() {
        return correoTerapeuta;
    }

    public void setCorreoTerapeuta(String correoTerapeuta) {
        this.correoTerapeuta = correoTerapeuta;
    }

    public Integer getNumeroTelefonicoTerapeuta() {
        return numeroTelefonicoTerapeuta;
    }

    public void setNumeroTelefonicoTerapeuta(Integer numeroTelefonicoTerapeuta) {
        this.numeroTelefonicoTerapeuta = numeroTelefonicoTerapeuta;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    

}
