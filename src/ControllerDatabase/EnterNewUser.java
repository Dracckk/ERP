package ControllerDatabase;

import Controller.Principal;

import javax.swing.*;
import java.io.PrintStream;
import java.sql.SQLException;

public class EnterNewUser {
    static Principal pl = new Principal();

    public PrintStream ingresarUsuariodb(){
        boolean ingresado=false;

        String usuario;
        String contraseña;
        int tipoDeUsuario = 0;

        usuario = pl.agregarUsuario.textUsuario;
        contraseña = pl.agregarUsuario.textContraseña;
        tipoDeUsuario= pl.agregarUsuario.tipoUsuario;

        try {
            pl.db.pst = pl.db.conn.prepareStatement("INSERT INTO erp.usuarios (Usuario, Contraseña, Tipo_De_Usuario)values(?, ?, ?)");
            pl.db.pst.setString(1, usuario);
            pl.db.pst.setString(2, contraseña);
            pl.db.pst.setInt(3, tipoDeUsuario);
            pl.db.pst.executeUpdate();
            ingresado=true;
            JOptionPane.showMessageDialog(null, "Se agrego el registro", "Registros", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException h){
            ingresado=false;
            JOptionPane.showMessageDialog(null, "ERROR "+h, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
        return System.out.printf(String.valueOf("Enter New User message: "+ingresado));
    }
}
