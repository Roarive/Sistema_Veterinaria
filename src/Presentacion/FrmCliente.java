/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author Alex_
 */
public class FrmCliente extends javax.swing.JPanel {

    /**
     * Creates new form FrmCliente
     */
    public FrmCliente() {
        initComponents();
        TxtNombreM.setVisible(false);
        TxtEspecie.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtDni = new javax.swing.JTextField();
        TxtDireccion = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtNombreM = new javax.swing.JTextField();
        TxtEspecie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtRaza = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TxtEdad = new javax.swing.JTextField();
        TxtPeso = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TxtCliente = new javax.swing.JTextField();
        TxtParticularidades = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CboSexo = new javax.swing.JComboBox<>();
        BtnModificar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        BtnRegMascota = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblMascota = new javax.swing.JTable();
        TxtColor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        BtnGuardar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(64, 69, 76));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Nombre");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Dni");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Direccion");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 154, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Telefono");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 122, -1, -1));
        add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 59, 122, -1));
        add(TxtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 91, 122, -1));
        add(TxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 123, 122, -1));
        add(TxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 155, 243, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("DATOS CLIENTE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 14, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("DATOS MASCOTA");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 14, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Nombre");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));
        add(TxtNombreM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 122, -1));
        add(TxtEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 122, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Peso");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 103, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Especie");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));
        add(TxtRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 122, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Sexo");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Raza");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        TxtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEdadActionPerformed(evt);
            }
        });
        add(TxtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 122, -1));
        add(TxtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 122, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Edad");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Particularidades");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));
        add(TxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 122, -1));
        add(TxtParticularidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 243, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Cliente");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, -1));

        CboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hembra", "Macho" }));
        add(CboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 91, -1));

        BtnModificar.setBackground(new java.awt.Color(4, 41, 68));
        BtnModificar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BtnModificar.setForeground(new java.awt.Color(255, 255, 255));
        BtnModificar.setText("Modificar");
        BtnModificar.setBorder(null);
        add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 70, -1));

        BtnNuevo.setBackground(new java.awt.Color(4, 41, 68));
        BtnNuevo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BtnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        BtnNuevo.setText("Nuevo");
        BtnNuevo.setBorder(null);
        add(BtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 70, -1));

        BtnRegMascota.setBackground(new java.awt.Color(4, 41, 68));
        BtnRegMascota.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BtnRegMascota.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegMascota.setText("Guardar");
        BtnRegMascota.setBorder(null);
        add(BtnRegMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 70, -1));

        TblMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TblMascota);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 770, 110));
        add(TxtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 122, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Color");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 103, -1));

        BtnGuardar1.setBackground(new java.awt.Color(4, 41, 68));
        BtnGuardar1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BtnGuardar1.setForeground(new java.awt.Color(255, 255, 255));
        BtnGuardar1.setText("Registrar Mascota");
        BtnGuardar1.setBorder(null);
        add(BtnGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void TxtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtEdadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardar1;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnRegMascota;
    private javax.swing.JComboBox<String> CboSexo;
    private javax.swing.JTable TblMascota;
    private javax.swing.JTextField TxtCliente;
    private javax.swing.JTextField TxtColor;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtDni;
    private javax.swing.JTextField TxtEdad;
    private javax.swing.JTextField TxtEspecie;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtNombreM;
    private javax.swing.JTextField TxtParticularidades;
    private javax.swing.JTextField TxtPeso;
    private javax.swing.JTextField TxtRaza;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
