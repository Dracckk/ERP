package Controller;

import DatabaseConnection.Conexion;
import ControllerDatabase.EnterNewUser;
import ControllerDatabase.ModifyUser;
import ControllerDatabase.SearchUser;
import ControllerDatabase.VerifyUser;
import Resource.ColorInterface;
import Resource.ColorYfuenteLetras;
import Views.*;
import Views.Menu;
import javax.swing.*;
import java.util.ArrayList;

public class Principal implements ColorInterface, ColorYfuenteLetras {

    public static ArrayList datos = new ArrayList();
    protected static String contrasenaAdmin="";
    protected static String contrasenaUsuario="";

    public static Usuario usuario = new Usuario();
    public static VentanaConfirmacion ventana=new VentanaConfirmacion();
    public static Menu menu = new Menu();
    public static AgregarUsuario agregarUsuario = new AgregarUsuario();
    public static Buscar busqueda = new Buscar();
    public static Generar generar = new Generar();
    public static ModificarUsuario modificarUsuario = new ModificarUsuario();
    public static Configuraciones config=new Configuraciones();
    public static ManejoDeArchivos archivos= new ManejoDeArchivos();

    public static Conexion db=new Conexion();
    public static VerifyUser vu = new VerifyUser();
    public static EnterNewUser enu = new EnterNewUser();
    public static SearchUser su = new SearchUser();
    public static ModifyUser mu = new ModifyUser();

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