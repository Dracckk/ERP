package Logica;

import BaseDeDatos.Conexion;
import FuenteYcolor.ColorInterface;
import FuenteYcolor.ColorYfuenteLetras;
import GUI.*;
import GUI.Menu;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Principal implements ColorInterface, ColorYfuenteLetras {

    public static ArrayList datos = new ArrayList();
    protected static String contrasenaAdmin="";
    protected static String contrasenaUsuario="";
    static Usuario usuario = new Usuario();
    public static VentanaConfirmacion ventana=new VentanaConfirmacion();
    public static Menu menu = new Menu();
    public static AgregarUsuario agregarUsuario = new AgregarUsuario();
    public static Buscar busqueda = new Buscar();
    public static Generar generar = new Generar();
    public static ModificarUsuario modificarUsuario = new ModificarUsuario();
    public static Configuraciones config=new Configuraciones();
    public static ManejoDeArchivos archivos= new ManejoDeArchivos();
    static Conexion db=new Conexion();
    public static boolean permiso=false;

    public void verificarUsuariodb(){
        try {

           String b = usuario.txtusuario;

            db.pst = db.conn.prepareStatement("SELECT Usuario, Contraseña, Tipo_De_Usuario from erp.usuarios where Usuario = ?");
            db.pst.setString(1, b);
            ResultSet rs = db.pst.executeQuery();

            if(rs.next()==true)
            {
                String contraseña = rs.getString(2);
                int tipo = rs.getInt(3);

                if (contraseña.equals(usuario.txtpassword)){
                    try {
                        archivos.leerConfiguracion();
                        archivos.leerArchivo();
                    }catch (Exception e){

                    }
                    if (tipo==0){
                        usuario.setVisible(false);
                        menu.setVisible(true);
                    }else if(tipo==1){
                        usuario.setVisible(false);
                        agregarUsuario.setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "CLAVE DE ACCESO INCORRECTA", "Inicio", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO", "Inicio", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "ERROR "+ex, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ingresarUsuariodb(){

        String usuario;
        String contraseña;
        int tipoDeUsuario = 0;

        usuario = agregarUsuario.textUsuario;
        contraseña = agregarUsuario.textContraseña;
        tipoDeUsuario= agregarUsuario.tipoUsuario;

        try {
            db.pst = db.conn.prepareStatement("INSERT INTO erp.usuarios (Usuario, Contraseña, Tipo_De_Usuario)values(?, ?, ?)");
            db.pst.setString(1, usuario);
            db.pst.setString(2, contraseña);
            db.pst.setInt(3, tipoDeUsuario);
            db.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se agrego el registro", "Registros", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException h){
            JOptionPane.showMessageDialog(null, "ERROR "+h, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void buscardb(){
        try {
            String b=busqueda.variableAbuscar;

            if (busqueda.txtTipo==0){
                db.pst = db.conn.prepareStatement("SELECT id, Usuario, Contraseña, Tipo_De_Usuario from erp.usuarios where id = ?");
                int bc=Integer.parseInt(b);
                db.pst.setInt(1, bc);
            }else if (busqueda.txtTipo==1){
                db.pst = db.conn.prepareStatement("SELECT id, Usuario, Contraseña, Tipo_De_Usuario from erp.usuarios where Usuario = ?");
                db.pst.setString(1, b);
            }

            ResultSet rs = db.pst.executeQuery();

            if(rs.next()==true)
            {
                int id = rs.getInt(1);
                String usuario = rs.getString(2);
                String contraseña = rs.getString(3);
                int tipoDeUsuario = rs.getInt(4);

                modificarUsuario.textField1.setText(String.valueOf(id));
                modificarUsuario.textField2.setText(usuario);
                modificarUsuario.textField3.setText(contraseña);

                if (tipoDeUsuario==0){
                    modificarUsuario.administradorRadioButton.setSelected(true);
                    modificarUsuario.usuarioGeneralRadioButton.setSelected(false);
                    modificarUsuario.usuarioGeneralRadioButton.setVisible(false);
                    modificarUsuario.usuarioGeneralRadioButton.setEnabled(false);
                }else if (tipoDeUsuario==1) {
                    modificarUsuario.administradorRadioButton.setSelected(false);
                    modificarUsuario.administradorRadioButton.setVisible(false);
                    modificarUsuario.administradorRadioButton.setEnabled(false);
                    modificarUsuario.usuarioGeneralRadioButton.setSelected(true);
                }

                modificarUsuario.textField1.setEditable(false);
                modificarUsuario.textField2.setEditable(false);
                modificarUsuario.textField3.setEditable(false);

                modificarUsuario.textField1.setEnabled(false);
                modificarUsuario.textField2.setEnabled(false);
                modificarUsuario.textField3.setEnabled(false);

                modificarUsuario.guardar.setVisible(false);
                modificarUsuario.eliminar.setVisible(false);
                modificarUsuario.modificar.setEnabled(true);
                modificarUsuario.cancelar.setText("Volver");

                busqueda.JPanel1.setVisible(false);
                modificarUsuario.JPanel1.setVisible(true);
                menu.MultiPanel.add(modificarUsuario.JPanel1);
                SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "ERROR "+ex, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void habilitarModificacion(){
        modificarUsuario.modificar.setEnabled(false);
        modificarUsuario.cancelar.setVisible(true);
        modificarUsuario.guardar.setVisible(true);
        modificarUsuario.eliminar.setVisible(true);
        modificarUsuario.cancelar.setText("Cancelar");

        modificarUsuario.administradorRadioButton.setVisible(true);
        modificarUsuario.usuarioGeneralRadioButton.setVisible(true);

        modificarUsuario.administradorRadioButton.setEnabled(true);
        modificarUsuario.usuarioGeneralRadioButton.setEnabled(true);

        modificarUsuario.textField2.setEnabled(true);
        modificarUsuario.textField3.setEnabled(true);

        modificarUsuario.textField2.setEditable(true);
        modificarUsuario.textField3.setEditable(true);

        int h = 422;
        int w = 770;
        menu.setSize(w, h);
    }

    public void comprobarPermisoParaModificar(){
        try{
            String b=modificarUsuario.usuario;
            db.pst = db.conn.prepareStatement("SELECT Usuario, Contraseña, Tipo_De_Usuario from erp.usuarios where Usuario = ?");
            db.pst.setString(1, b);
            ResultSet rs = db.pst.executeQuery();

            if(rs.next()==true){
                JOptionPane.showMessageDialog(null, "ERROR EL NOMBRE DE USUARIO YA EXISTE", "Comprobando", JOptionPane.WARNING_MESSAGE);
            }else{
                enviarModificacion();
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR "+ex, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void enviarModificacion(){
        try {
            int id = 0;
            String usuario = "";
            String contraseña = "";
            int tipo = 0;

            id = modificarUsuario.id;
            usuario = modificarUsuario.usuario;
            contraseña = modificarUsuario.contraseña;
            tipo = modificarUsuario.tipoUsuario;

            db.pst = db.conn.prepareStatement("update erp.usuarios set Usuario = ?,Contraseña = ?,Tipo_De_Usuario = ? where id = ?");
            db.pst.setString(1, usuario);
            db.pst.setString(2, contraseña);
            db.pst.setInt(3, tipo);
            db.pst.setInt(4, id);

            db.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo el registro", "Registros", JOptionPane.INFORMATION_MESSAGE);
            estadoMenuBuscar();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "ERROR "+e1, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void eliminarUsuario(){

        int id;
        id = modificarUsuario.id;

        try {
            db.pst = db.conn.prepareStatement("delete from erp.usuarios  where id = ?");
            db.pst.setInt(1, id);
            db.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
            estadoMenuBuscar();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "ERROR "+e1, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void estadoMenuIngresarUsuario() {
        busqueda.JPanel1.setVisible(false);
        agregarUsuario.JPanel1.setVisible(true);
        generar.JPanel1.setVisible(false);
        ventana.Jpanel1.setVisible(false);
        config.JPanel1.setVisible(false);
        modificarUsuario.JPanel1.setVisible(false);


        menu.MultiPanel.add(agregarUsuario.JPanel1);
        int h = 422;
        int w = 650;
        menu.setSize(w, h);
        SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
    }

    public void estadoMenuBuscar() {
        agregarUsuario.JPanel1.setVisible(false);
        generar.JPanel1.setVisible(false);
        busqueda.JPanel1.setVisible(true);
        ventana.Jpanel1.setVisible(false);
        config.JPanel1.setVisible(false);
        modificarUsuario.JPanel1.setVisible(false);
        menu.MultiPanel.add(busqueda.JPanel1);
        int h = 422;
        int w = 550;
        menu.setSize(w, h);
        SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
    }

    public void estadoMenuGenerar() {
        busqueda.JPanel1.setVisible(false);
        agregarUsuario.JPanel1.setVisible(false);
        generar.JPanel1.setVisible(true);
        ventana.Jpanel1.setVisible(false);
        config.JPanel1.setVisible(false);
        modificarUsuario.JPanel1.setVisible(false);
        menu.MultiPanel.add(generar.JPanel1);
        int h=422;
        int w=700;
        menu.setSize(w, h);
        generar.JPanel1.setSize(w, h);
        menu.MultiPanel.setSize(w, h);
        menu.setResizable(false);
        SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
    }

    public void estadoMenuConfiguracion(){
        busqueda.JPanel1.setVisible(false);
        agregarUsuario.JPanel1.setVisible(false);
        generar.JPanel1.setVisible(false);
        ventana.Jpanel1.setVisible(false);
        config.JPanel1.setVisible(true);
        modificarUsuario.JPanel1.setVisible(false);
        menu.MultiPanel.add(config.JPanel1);
        int h=422;
        int w=700;
        menu.setSize(w, h);
        generar.JPanel1.setSize(w, h);
        menu.MultiPanel.setSize(w, h);
        menu.setResizable(false);
        SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
    }

    public void estadoMenuConfirmar(){
        busqueda.JPanel1.setVisible(false);
        agregarUsuario.JPanel1.setVisible(false);
        generar.JPanel1.setVisible(false);
        ventana.Jpanel1.setVisible(true);
        config.JPanel1.setVisible(false);
        modificarUsuario.JPanel1.setVisible(false);
        menu.MultiPanel.add(ventana.Jpanel1);
        int h=422;
        int w=870;
        menu.setSize(w, h);
        generar.JPanel1.setSize(w, h);
        menu.MultiPanel.setSize(w, h);
        menu.setResizable(false);
        SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
    }
}