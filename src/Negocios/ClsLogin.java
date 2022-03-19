/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEnEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Alex_
 */
public class ClsLogin {
    public boolean Login(ClsEnEmpleado objEE)
    {
       PreparedStatement ps = null;
       ResultSet rs = null;
       Connection con = ClsConexion.Conectar();
       String sql = "SELECT e.codigo,e.clave,e.cargo_idcargo,e.estado,e.nombre,t.nombre,t.formularioproducto,t.formularioclinica,"
               + "t.formularioinventario,t.formularioreporte,t.formulariousuario,t.formulariocliente,t.formularioventa,"
               + "t.formulariospa FROM empleados AS e INNER JOIN cargo AS t ON e.cargo_idcargo=t.idcargo WHERE codigo = ?";
       try{
           ps=con.prepareStatement(sql);
           ps.setInt(1,objEE.getCodigo());
           rs=ps.executeQuery();
           if(rs.next())
           {
               if(objEE.getClave().equals(rs.getString(2)) && objEE.getEstado().equals(rs.getString(4)))
               {
                   String sqlUpdate = "UPDATE empleados SET last_session = ? WHERE idempleados=?";
                   objEE.setCodigo(rs.getInt(1));
                   objEE.setClave(rs.getString(2));
                   objEE.setIdcargo(rs.getInt(3));
                   objEE.setEstado(rs.getString(4));
                   objEE.setNombre(rs.getString(5));
                   objEE.setNombrecargo(rs.getString(6));
                   objEE.setFproductocargo(rs.getString(7));
                   objEE.setFclinicacargo(rs.getString(8));
                   objEE.setFinventariocargo(rs.getString(9));
                   objEE.setFreportecargo(rs.getString(10));
                   objEE.setFusuariocargo(rs.getString(11));
                   objEE.setFclientecargo(rs.getString(12));
                   objEE.setFventacargo(rs.getString(13));
                   objEE.setFspacargo(rs.getString(14));
                   
                   
                   
                   
                   return true;
               }
               else
               {
                   return false;
               }
           }
           return false;
       }
       catch(SQLException ex){
           return false;
       }
    }
}
