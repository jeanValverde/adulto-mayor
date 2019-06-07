/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.dao;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jean
 */
@Repository
public class ProcedureQuery {

    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public boolean insertNewContrasena(Integer idUusario, String contrasena, Integer cod, String rol) {

        try {
            em.createNamedStoredProcedureQuery("procedureInsertarContrasenaNew")
                    .setParameter("p_id_usuario", idUusario)
                    .setParameter("p_contrasena", contrasena)
                    .setParameter("p_codigo_recuperacion", cod)
                    .setParameter("p_rol", rol).execute();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    public boolean insertNewToken(Integer idUusario, String token, String maquina, Integer latitud, Integer longitud, String ip) {

        try {
            em.createNamedStoredProcedureQuery("procedureInsertarTokenNew")
                    .setParameter("p_id_usuario", idUusario)
                    .setParameter("p_token", token)
                    .setParameter("p_maquina", maquina)
                    .setParameter("p_latitu", latitud)
                    .setParameter("p_longitud", longitud)
                    .setParameter("p_ip", ip).execute();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    public boolean updateDateToken(Integer idToken) {
        try {
            em.createNamedStoredProcedureQuery("procedureUpdateDateToken")
                    .setParameter("p_id_token", idToken).execute();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
