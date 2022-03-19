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
import Entidad.ClsEnEmpleado;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.JComboBox;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import Recursos.ClsRender;

/**
 *
 * @author Alex_
 */
public class ClsNegEmpleado {
    public static Statement consulta;
    public static ResultSet resultado;
   /* public DefaultTableModel ListarEmpleados()
    {
        String []  nombresColumnas = {"ID","NOMBRE","APELLIDO","DNI","TELEFONO","DIRECCION","ID_CARGO","CODIGO","CLAVE","ESTADO"};
        String [] registros = new String[10];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM empleados";
        
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
                registros[0] = rs.getString("idempleados");
                
                registros[1] = rs.getString("nombre");
                
                registros[2] = rs.getString("apellido");
                
                registros[3] = rs.getString("dni");
                
                registros[4] = rs.getString("telefono");
                
                registros[5] = rs.getString("direccion");
                
                registros[6] = rs.getString("cargo_idcargo");
                
                registros[7] = rs.getString("codigo");
                
                registros[8] = rs.getString("clave");
                
                registros[9] = rs.getString("estado");               
                
                
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
    }*/
    
   
        public ArrayList<ClsEnEmpleado> Listar_Empleado(){
        ArrayList<ClsEnEmpleado> list = new ArrayList<ClsEnEmpleado>();
        ClsConexion conec= new ClsConexion();
        String sql = "SELECT * FROM empleados";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try{
            pst = ClsConexion.Conectar().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                ClsEnEmpleado vo = new ClsEnEmpleado();
                vo.setIdempleado(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setApellido(rs.getString(3));
                vo.setDni(rs.getInt(4));
                vo.setTelefono(rs.getString(5));
                vo.setDireccion(rs.getString(6));
                vo.setIdcargo(rs.getInt(7));
                vo.setCodigo(rs.getInt(8));
                vo.setClave(rs.getString(9));
                vo.setEstado(rs.getString(10));
                vo.setFoto(rs.getBytes(11));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                pst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }


/*Metodo agregar*/
    public void GuardarEmpleado(ClsEnEmpleado emp){
        ClsConexion conec = new ClsConexion();
        String sql = "INSERT INTO empleados(nombre,apellido,dni,telefono,direccion,cargo_idcargo,codigo,clave,estado,foto) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        try{
            pst = ClsConexion.Conectar().prepareStatement(sql);
            pst.setString(1,emp.getNombre());
            pst.setString(2,emp.getApellido());
            pst.setInt(3,emp.getDni());
            pst.setString(4,emp.getTelefono());
            pst.setString(5,emp.getDireccion());
            pst.setInt(6,emp.getIdcargo());
            pst.setInt(7,emp.getCodigo());
            pst.setString(8,emp.getClave());
            pst.setString(9,emp.getEstado());
            pst.setBytes(10,emp.getFoto());
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                pst.close();
                //conec.desconectar();
            }catch(Exception ex){}
        }
    }
    /*public boolean MtdRegistrarEmpleado(ClsEnEmpleado objEE) {
        //To change body of generated methods, choose Tools | Templates.
        try{
            String SQL = "INSERT INTO empleados(nombre,apellido,dni,telefono,direccion,cargo_idcargo,codigo,clave,estado) VALUES(?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1,objEE.getNombre());
            st.setString(2,objEE.getApellido());
            st.setInt(3,objEE.getDni());
            st.setString(4,objEE.getTelefono());
            st.setString(5,objEE.getDireccion());
            st.setInt(6,objEE.getIdcargo());
            st.setInt(7,objEE.getCodigo());
            st.setString(8,objEE.getClave());
            st.setString(9,objEE.getEstado());
            //st.executeUpdate();
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
    }*/
    /*public boolean MtdModificarEmpleado(ClsEnEmpleado objEE) {
        //To change body of generated methods, choose Tools | Templates.
        try{
            String SQL = ("UPDATE empleados SET nombre=?, apellido=?,dni=?, telefono=?, direccion=?, cargo_idcargo=?, codigo=?, clave=?, estado=? where idempleados = ?");
            Connection con = ClsConexion.Conectar();
            PreparedStatement st = con.prepareStatement(SQL);       
            st.setString(1,objEE.getNombre());
            st.setString(2,objEE.getApellido());
            st.setInt(3,objEE.getDni());
            st.setString(4,objEE.getTelefono());
            st.setString(5,objEE.getDireccion());
            st.setInt(6,objEE.getIdcargo());
            st.setInt(7,objEE.getCodigo());
            st.setString(8,objEE.getClave());
            st.setString(9,objEE.getEstado());
            st.setInt(10,objEE.getIdempleado());
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
    }*/
    public void Listar_Cargos(JComboBox CboCargo){
        
        String SQL = ("SELECT nombre FROM cargo");
        try{
            Connection con = ClsConexion.Conectar();
            PreparedStatement st = con.prepareStatement(SQL);
            ResultSet result = st.executeQuery();
            CboCargo.addItem("Seleccione una Opcion");
            while(result.next())
            {
                CboCargo.addItem(result.getString("nombre"));
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void visualizar_Empleado(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new ClsRender());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("NOMBRE");
        dt.addColumn("APELLIDO");
        dt.addColumn("DNI");
        dt.addColumn("TELEFONO");
        dt.addColumn("DIRECCION");
        dt.addColumn("ID_CARGO");
        dt.addColumn("CODIGO");
        dt.addColumn("CLAVE");
        dt.addColumn("ESTADO");
        dt.addColumn("FOTO");

        ClsEnEmpleado vo = new ClsEnEmpleado();
        ArrayList<ClsEnEmpleado> list = Listar_Empleado();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[11];
                vo = list.get(i);
                fila[0] = vo.getIdempleado();
                fila[1] = vo.getNombre();
                fila[2] = vo.getApellido();
                fila[3] = vo.getDni();
                fila[4] = vo.getTelefono();
                fila[5] = vo.getDireccion();
                fila[6] = vo.getIdcargo();
                fila[7] = vo.getCodigo();
                fila[8] = vo.getClave();
                fila[9] = vo.getEstado();
                
                try{
                    byte[] bi = vo.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[10] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[10] = new JLabel("No imagen");
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
    
    public void Modificar_Empleado(ClsEnEmpleado emp){
        ClsConexion conec = new ClsConexion();
        String sql = "UPDATE empleados SET nombre=?, apellido=?,dni=?, telefono=?, direccion=?, cargo_idcargo=?, codigo=?, clave=?, estado=?,foto=? where idempleados = ?";
        PreparedStatement pst = null;
        try{
            pst = ClsConexion.Conectar().prepareStatement(sql);
            pst.setString(1,emp.getNombre());
            pst.setString(2,emp.getApellido());
            pst.setInt(3,emp.getDni());
            pst.setString(4,emp.getTelefono());
            pst.setString(5,emp.getDireccion());
            pst.setInt(6,emp.getIdcargo());
            pst.setInt(7,emp.getCodigo());
            pst.setString(8,emp.getClave());
            pst.setString(9,emp.getEstado());
            pst.setBytes(10,emp.getFoto());
            pst.setInt(11,emp.getIdempleado()); 
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                pst.close();
                //conec.desconectar();
            }catch(Exception ex){}
        }
    }

    public void Modificar_Empleado2(ClsEnEmpleado emp){
        ClsConexion conec = new ClsConexion();
        String sql = "UPDATE empleados SET nombre=?, apellido=?,dni=?, telefono=?, direccion=?, cargo_idcargo=?, codigo=?, clave=?, estado=? where idempleados = ?";
        PreparedStatement pst = null;
        try{
            pst = ClsConexion.Conectar().prepareStatement(sql);
            pst.setString(1,emp.getNombre());
            pst.setString(2,emp.getApellido());
            pst.setInt(3,emp.getDni());
            pst.setString(4,emp.getTelefono());
            pst.setString(5,emp.getDireccion());
            pst.setInt(6,emp.getIdcargo());
            pst.setInt(7,emp.getCodigo());
            pst.setString(8,emp.getClave());
            pst.setString(9,emp.getEstado());
            pst.setInt(10,emp.getIdempleado());             
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                pst.close();
                //conec.desconectar();
            }catch(Exception ex){}
        }
    }
        public ArrayList<ClsEnCargo> Listar_cargo(){
        ArrayList<ClsEnCargo> list = new ArrayList<ClsEnCargo>();
        ClsConexion conec= new ClsConexion();
        String sql = "SELECT * FROM cargo";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try{
            pst = ClsConexion.Conectar().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                ClsEnCargo vo = new ClsEnCargo();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setFproducto(rs.getString(3));
                vo.setFclinica(rs.getString(4));
                vo.setFinventario(rs.getString(5));
                vo.setFreporte(rs.getString(6));
                vo.setFusuario(rs.getString(7));
                vo.setFcliente(rs.getString(8));
                vo.setFventa(rs.getString(9));
                vo.setFspa(rs.getString(10));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                pst.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }
    
    public void visualizar_Cbocargo(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new ClsRender());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("NOMBRE");
        dt.addColumn("PRODUCTO");
        dt.addColumn("CLINICA");
        dt.addColumn("INVENTARIO");
        dt.addColumn("REPORTE");
        dt.addColumn("USUARIO");
        dt.addColumn("CLIENTE");
        dt.addColumn("VENTA");
        dt.addColumn("SPA");

        ClsEnCargo vo = new ClsEnCargo();
        ArrayList<ClsEnCargo> list = Listar_cargo();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                vo = list.get(i);
                fila[0] = vo.getId();
                fila[1] = vo.getNombre();
                fila[2] = vo.getFproducto();
                fila[3] = vo.getFclinica();
                fila[4] = vo.getFinventario();
                fila[5] = vo.getFreporte();
                fila[6] = vo.getFusuario();
                fila[7] = vo.getFcliente();
                fila[8] = vo.getFventa();
                fila[9] = vo.getFspa();               
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
}
