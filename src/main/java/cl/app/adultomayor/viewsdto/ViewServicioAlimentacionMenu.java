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
@Table(name = "GET_SERVICIO_ALIMENTACION_MENU")
public class ViewServicioAlimentacionMenu {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_SERVICIO_ALIMENTACION")
    private Long id;

    @NotNull
    @Column(name = "FECHA")
    private Date fechaServicio;

    @NotNull
    @Column(name = "DESCRIPCION")
    private String descripcionServicio;

    @NotNull
    @Column(name = "TIPO_INSUMO")
    private String tipoInsumo;

    @NotNull
    @Column(name = "TIPO_MEDIDA")
    private String tipoMedida;

    @NotNull
    @Column(name = "ID_MENU")
    private Long idMenu;

    @NotNull
    @Column(name = "TIPO_MENU")
    private String tipoMenu;

    @NotNull
    @Column(name = "DESCRIPCION_MENU")
    private String descripcionMenu;
    
    
    @NotNull
    @Column(name = "DIA_MENU")
    private String diaMenu;

    @NotNull
    @Column(name = "FOTO_MENU")   
    private String fotoMenu;
    
    
    @NotNull
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    public ViewServicioAlimentacionMenu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(String tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    public String getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(String tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public String getDescripcionMenu() {
        return descripcionMenu;
    }

    public void setDescripcionMenu(String descripcionMenu) {
        this.descripcionMenu = descripcionMenu;
    }

    public String getDiaMenu() {
        return diaMenu;
    }

    public void setDiaMenu(String diaMenu) {
        this.diaMenu = diaMenu;
    }

    public String getFotoMenu() {
        return fotoMenu;
    }

    public void setFotoMenu(String fotoMenu) {
        this.fotoMenu = fotoMenu;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    

}
