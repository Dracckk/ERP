package conexion;

import java.sql.*;

public class conexion {
    String usuario="root";
    String password ="12345";
    String url="jdbc:mysql://localhost:3306/erp";
    Connection con;
    Statement stmt;
    ResultSet rs;

    public void insercion(String consulta){
        try {
            this.con= DriverManager.getConnection(this.url, this.usuario, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
