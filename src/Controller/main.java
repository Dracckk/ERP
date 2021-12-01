package Controller;

import javax.swing.*;

public class main {

    static Principal pl=new Principal();

    public static void main(String[] args) {
        pl.usuario.setVisible(true);
        //pl.menu.setVisible(true);

        pl.usuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pl.menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pl.agregarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
