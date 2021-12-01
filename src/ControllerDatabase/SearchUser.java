package ControllerDatabase;

import Controller.Principal;

import javax.swing.*;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchUser {
    static Principal pl = new Principal();

    public void buscardb(){
        try {
            String b = pl.busqueda.variableAbuscar;

            if (pl.busqueda.txtTipo==0){
                pl.db.pst = pl.db.conn.prepareStatement("SELECT id, Usuario, Contraseña, Tipo_De_Usuario from erp.usuarios where id = ?");
                int bc=Integer.parseInt(b);
                pl.db.pst.setInt(1, bc);
            }else if (pl.busqueda.txtTipo==1){
                pl.db.pst = pl.db.conn.prepareStatement("SELECT id, Usuario, Contraseña, Tipo_De_Usuario from erp.usuarios where Usuario = ?");
                pl.db.pst.setString(1, b);
            }

            ResultSet rs = pl.db.pst.executeQuery();

            if(rs.next()==true)
            {
                int id = rs.getInt(1);
                String usuario = rs.getString(2);
                String contraseña = rs.getString(3);
                int tipoDeUsuario = rs.getInt(4);

                pl.modificarUsuario.textField1.setText(String.valueOf(id));
                pl.modificarUsuario.textField2.setText(usuario);
                pl.modificarUsuario.textField3.setText(contraseña);

                if (tipoDeUsuario==0){
                    pl.modificarUsuario.administradorRadioButton.setSelected(true);
                    pl.modificarUsuario.usuarioGeneralRadioButton.setSelected(false);
                    pl.modificarUsuario.usuarioGeneralRadioButton.setVisible(false);
                    pl.modificarUsuario.usuarioGeneralRadioButton.setEnabled(false);
                }else if (tipoDeUsuario==1) {
                    pl.modificarUsuario.administradorRadioButton.setSelected(false);
                    pl.modificarUsuario.administradorRadioButton.setVisible(false);
                    pl.modificarUsuario.administradorRadioButton.setEnabled(false);
                    pl.modificarUsuario.usuarioGeneralRadioButton.setSelected(true);
                }

                pl.modificarUsuario.textField1.setEditable(false);
                pl.modificarUsuario.textField2.setEditable(false);
                pl.modificarUsuario.textField3.setEditable(false);

                pl.modificarUsuario.textField1.setEnabled(false);
                pl.modificarUsuario.textField2.setEnabled(false);
                pl.modificarUsuario.textField3.setEnabled(false);

                pl.modificarUsuario.guardar.setVisible(false);
                pl.modificarUsuario.eliminar.setVisible(false);
                pl.modificarUsuario.modificar.setEnabled(true);
                pl.modificarUsuario.cancelar.setText("Volver");

                pl.busqueda.JPanel1.setVisible(false);
                pl.modificarUsuario.JPanel1.setVisible(true);
                pl.menu.MultiPanel.add(pl.modificarUsuario.JPanel1);
                SwingUtilities.updateComponentTreeUI(pl.menu.MultiPanel);
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "ERROR "+ex, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }
}
