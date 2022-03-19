/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEnCargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex_
 */
public class ClsNegCargo {
    
    public boolean MtdRegistrarCargo(ClsEnCargo car)
    {
        String sql = "INSERT INTO cargo(nombre,formularioproducto,formularioclinica,formularioinventario,formularioreporte,formulariousuario,formulariocliente,"
                + "formularioventa,formulariospa) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst=null;
       try{
            pst= ClsConexion.Conectar().prepareStatement(sql);
            pst.setString(1,car.getNombre());
            pst.setString(2,car.getFproducto());
            pst.setString(3,car.getFclinica());
            pst.setString(4,car.getFinventario());
            pst.setString(5,car.getFreporte());
            pst.setString(6,car.getFusuario());
            pst.setString(7,car.getFcliente());
            pst.setString(8,car.getFventa());
            pst.setString(9,car.getFspa());
            
               if(pst.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }
        catch(SQLException ex){
            
            return false;
        }
         
    }
    
    public DefaultTableModel ListarCargo()
    {
        String []  nombresColumnas = {"ID","NOMBRE","S. PRODUCTO","S. CLINICA","S. INVENTARIO","S. REPORTE","S. USUARIO","S. CLIENTE",
        "S. VENTA","S. SPA"};
        String [] registros = new String[10];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM cargo";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = ClsConexion.Conectar();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("idcargo");               
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("formularioproducto"); 
                registros[3] = rs.getString("formularioclinica"); 
                registros[4] = rs.getString("formularioinventario"); 
                registros[5] = rs.getString("formularioreporte"); 
                registros[6] = rs.getString("formulariousuario"); 
                registros[7] = rs.getString("formulariocliente"); 
                registros[8] = rs.getString("formularioventa"); 
                registros[9] = rs.getString("formulariospa"); 
                
                
                modelo.addRow(registros);                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    public boolean MtdModificarCargo(ClsEnCargo objEC) {
        //To change body of generated methods, choose Tools | Templates.
        try{
            String SQL = ("UPDATE cargo SET nombre=?,formularioproducto=?,formularioclinica=?,formularioinventario=?,formularioreporte=?,formulariousuario=?,"
                    + "formulariocliente=?,formularioventa=?,formulariospa=? where idcargo = ?");
            Connection con = ClsConexion.Conectar();
            PreparedStatement pst = con.prepareStatement(SQL);                           
            
            pst.setString(1,objEC.getNombre());
            pst.setString(2,objEC.getFproducto());
            pst.setString(3,objEC.getFclinica());
            pst.setString(4,objEC.getFinventario());
            pst.setString(5,objEC.getFreporte());
            pst.setString(6,objEC.getFusuario());
            pst.setString(7,objEC.getFcliente());
            pst.setString(8,objEC.getFventa());
            pst.setString(9,objEC.getFspa());
            pst.setInt(10,objEC.getId());
              
            if(pst.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }
        catch(SQLException ex){
            return false;
        }
    }
    public boolean MtdEliminarCargo(ClsEnCargo objEC) {
        //To change body of generated methods, choose Tools | Templates.
        try{
            String SQL = "Delete cargo set Descripcioncargo = ? where Codigocargo = ?";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1,objEC.getNombre());           
            st.setInt(2,objEC.getId());
           // st.setString(1,objEC.getDescripcion());
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }
        catch(SQLException ex){
            return false;
        }
    }
    
}
