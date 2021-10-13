package Logica;
import GUI.*;
import GUI.Menu;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
    public static ArrayList datos = new ArrayList();

    static Usuario usuario = new Usuario();
    public static Menu menu = new Menu();
    public static GUIRecibo recibo = new GUIRecibo();
    public static Buscar busqueda = new Buscar();
    public static Tabla tabla = new Tabla();


    public static void main(String[] args) {
        usuario.setVisible(true);
        //menu.setVisible(true);
        usuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        recibo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        busqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void verificarUsuario() {
        String USadmin   = "93348";
        String USgeneral = "1234";

        String n = usuario.password;
        if (n.equals(USadmin)) {
            usuario.setVisible(false);
            menu.setVisible(true);

        } else if (n.equals(USgeneral)) {
            usuario.setVisible(false);
            recibo.setVisible(true);
        } else {
            usuario.passwordField1.setText("");
            JOptionPane.showMessageDialog(null, "CLAVE DE ACCESO INCORRECTA", "Inicio", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void estadoMenuIngresarRecibo() {
        busqueda.JPanel1.setVisible(false);
        recibo.JPanel1.setVisible(true);
        tabla.JPanel1.setVisible(false);
        menu.MultiPanel.add(recibo.JPanel1);
        int h = 422;
        int w = 917;
        menu.setSize(w, h);
        SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
    }

    public void estadoMenuBuscar() {
        recibo.JPanel1.setVisible(false);
        tabla.JPanel1.setVisible(false);
        busqueda.JPanel1.setVisible(true);
        menu.MultiPanel.add(busqueda.JPanel1);
        int h = 422;
        int w = 703;
        menu.setSize(w, h);
        SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
    }

    public void estadoMenuGenerar() {
        busqueda.JPanel1.setVisible(false);
        recibo.JPanel1.setVisible(false);
        tabla.JPanel1.setVisible(true);
        menu.MultiPanel.add(tabla.JPanel1);
        int h=422;
        int w=611;
        menu.setSize(w, h);
        menu.setResizable(true);
        SwingUtilities.updateComponentTreeUI(menu.MultiPanel);
    }
}