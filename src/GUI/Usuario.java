package GUI;

import ColorYtamaño.ColorYtamaño;
import Fuente.Fuente;
import Logica.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Usuario extends JFrame implements ColorYtamaño {
    private JPanel JPanel1;
    private JPanel panelImagen;
    private JLabel Contraseña;
    public JPasswordField passwordField1;
    private JLabel enviar;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JTextField textField1;
    private JLabel Usuario;

    public static String password="";
    static Principal pl=new Principal();
    Fuente tipoFuente;
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public Usuario() {

        colorYtamaño();

        enviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                enviar.setForeground(presion);
                enviarDatos();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                enviar.setForeground(sinPresion);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                enviar.setForeground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                enviar.setForeground(sinPresion);
            }
        });
    }

    public void colorYtamaño(){
        tipoFuente=new Fuente();
        Font font1 = new Font(nombreFuente,Font.PLAIN, tamañoFuentePrincipal);

        add(JPanel1);
        setTitle("Usuario");
        panelImagen.setBackground(principal);
        JPanel1.setBackground(secundario);
        JPanel2.setBackground(secundario);
        JPanel3.setBackground(secundario);
        textField1.setBackground(secundario);
        passwordField1.setBackground(secundario);

        passwordField1.setForeground(letras);
        textField1.setForeground(letras);
        Contraseña.setForeground(letras);
        enviar.setForeground(letras);
        Usuario.setForeground(letras);

        passwordField1.setCaretColor(letras);
        textField1.setCaretColor(letras);

        passwordField1.setFont(tipoFuente.fuente(tipoFuente.DelaGo,0, tamañoFuenteSecundaria));
        textField1.setFont(tipoFuente.fuente(tipoFuente.DelaGo,0, tamañoFuenteSecundaria));
        Contraseña.setFont(font1);
        Usuario.setFont(font1);
        enviar.setFont(font1);

        int h=313;
        int w=446;
        setBounds((ancho/2)-(w/2),(alto/2)-(h/2),w,h);
        setResizable(true);
    }

    public void enviarDatos(){
        password=passwordField1.getText();
        pl.verificarUsuario();
    }

}