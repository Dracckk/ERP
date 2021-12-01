package ControllerDatabase;

import Controller.Principal;
import Views.Usuario;

import javax.swing.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VerifyUser {
    static Principal pl = new Principal();

    public PrintStream verificarUsuariodb() {
        boolean encontrado = false;
        try {

            String b = pl.usuario.txtusuario;

            pl.db.pst =  pl.db.conn.prepareStatement("SELECT Usuario, Contraseña, Tipo_De_Usuario from erp.usuarios where Usuario = ?");
            pl.db.pst.setString(1, b);
            ResultSet rs =  pl.db.pst.executeQuery();

            if (rs.next() == true) {
                encontrado = true;
                String contraseña = rs.getString(2);
                int tipo = rs.getInt(3);

                if (contraseña.equals( pl.usuario.txtpassword)) {
                    try {
                        pl.archivos.leerConfiguracion();
                        pl.archivos.leerArchivo();
                    } catch (Exception e) {

                    }
                    if (tipo == 0) {
                        pl.usuario.setVisible(false);
                        pl.menu.setVisible(true);
                    } else if (tipo == 1) {
                        pl.usuario.setVisible(false);
                        pl.agregarUsuario.setVisible(true);
                    }
                } else {
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "CLAVE DE ACCESO INCORRECTA", "Inicio", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO", "Inicio", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR " + ex, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
        return System.out.printf(String.valueOf("Verify User message: "+encontrado+" /n "));
    }
}
