/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.app.adultomayor.procedureDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jean
 */

@Entity
@Table
@Getter
@Setter
@NamedStoredProcedureQueries(
        {
            @NamedStoredProcedureQuery(name = "procedureInsertarContrasenaNew", procedureName = "proce_insertarContrasenaNueva",
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_usuario", type = Integer.class)
                        ,
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_contrasena", type = String.class)
                        ,
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codigo_recuperacion", type = Integer.class)
                        ,
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rol", type = String.class)
                    }
            )
            , 
            @NamedStoredProcedureQuery(name = "procedureInsertarTokenNew", procedureName = "pr_insertar_token_nuevo",
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_usuario", type = Integer.class)
                        ,
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_token", type = String.class)
                        ,
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_maquina", type = String.class)
                        ,
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_latitu", type = Integer.class)
                        , 
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_longitud", type = Integer.class)
                        ,
                    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ip", type = String.class)
                    }
            ),
            @NamedStoredProcedureQuery(name = "procedureUpdateDateToken", procedureName = "pr_upte_date_new_token",
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_token", type = Integer.class)
                    }
            )
        }
)
public class ProcedureQueryDto {

    @Id
    private int id;
}
