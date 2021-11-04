package BaseDeDatos;

import Logica.Principal;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    public static Connection conn;
    public static PreparedStatement pst;
    private static String db="erp";
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="root";
    private static final String password="12345";
    private static final String url="jdbc:mysql://localhost:3306/"+db+"?useTimezone=true&serverTimezone=UTC";

    public Conexion() {
        conn=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url, user, password);
            if (conn!=null){
                System.out.println("Conexion Exitosa");
            }
        }catch (ClassNotFoundException| SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR "+e, "SQL Exception", JOptionPane.WARNING_MESSAGE);
        }
    }

    public Connection getConnection(){
        return conn;
    }
}

