package ControllerDatabase;

import Controller.Principal;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyUser {
    static Principal pl = new Principal();

    public void comprobarPermisoParaModificar(){
        try{
            String b=pl.modificarUsuario.usuario;
            pl.db.pst = pl.db.conn.prepareStatement("SELECT Usuario, Contraseña, Tipo_De_Usuario from erp.usuarios where Usuario = ?");
            pl.db.pst.setString(1, b);
            ResultSet rs = pl.db.pst.executeQuery();

            if(rs.next()==true){
                JOptionPane.showMessageDialog(null, "ERROR EL NOMBRE DE USUARIO YA EXISTE", "Comprobando", JOptionPane.WARNING_MESSAGE);
                enviarModificacion();
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

            id = pl.modificarUsuario.id;
            usuario = pl.modificarUsuario.usuario;
            contraseña = pl.modificarUsuario.contraseña;
            tipo = pl.modificarUsuario.tipoUsuario;

            pl.db.pst = pl.db.conn.prepareStatement("update erp.usuarios set Usuario = ?,Contraseña = ?,Tipo_De_Usuario = ? where id = ?");
            pl.db.pst.setString(1, usuario);
            pl.db.pst.setString(2, contraseña);
            pl.db.pst.setInt(3, tipo);
            pl.db.pst.setInt(4, id);

            pl.db.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo el registro", "Registros", JOptionPane.INFORMATION_MESSAGE);
            pl.estadoMenuBuscar();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "ERROR "+e1, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void eliminarUsuario(){

        int id;
        id = pl.modificarUsuario.id;

        try {
            pl.db.pst = pl.db.conn.prepareStatement("delete from erp.usuarios  where id = ?");
            pl.db.pst.setInt(1, id);
            pl.db.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente", "Modificacion", JOptionPane.INFORMATION_MESSAGE);
            pl.estadoMenuBuscar();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "ERROR "+e1, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

}
