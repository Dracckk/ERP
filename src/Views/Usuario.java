package Views;

import Resource.ColorInterface;
import Resource.ColorYfuenteLetras;
import Resource.Fuente;
import Controller.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Usuario extends JFrame implements ColorInterface, ColorYfuenteLetras {
    private JPanel JPanel1;
    private JPanel panelUsuario;
    private JPanel panelImagen;
    private JLabel Label;
    public JPasswordField passwordField1;
    private JLabel OKlabel;
    private JPanel JPanel2;
    private JTextField textField1;
    private JLabel labelcontraseña;
    private JButton OKButton;

    Fuente tipoFuente;
    public static String txtusuario ="";
    public static String txtpassword ="";
    static Principal pl=new Principal();
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public Usuario() {
        colorYtamaño();

        OKlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                OKlabel.setForeground(presionBoton);
                enviarDatos();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                OKlabel.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                OKlabel.setForeground(colorBotones);
            }
        });
    }

    public void colorYtamaño(){
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconoUsuarioC));
        setIconImage(icon);

        add(JPanel1);
        setTitle("Usuario");

        tipoFuente=new Fuente();

        panelUsuario.setBackground(secundario);
        panelImagen.setBackground(principal);
        JPanel1.setBackground(secundario);
        JPanel2.setBackground(secundario);


        Label.setFont(tipoFuente.fuente(tipoFuente.DelaGo,0,tamaño ));
        Label.setForeground(colorLetras);
        labelcontraseña.setFont(tipoFuente.fuente(tipoFuente.DelaGo,0,tamaño ));
        labelcontraseña.setForeground(colorLetras);
        OKlabel.setFont(fuente1);
        OKlabel.setForeground(colorBotones);

        textField1.setFont(fuente1);
        textField1.setBackground(secundario);
        textField1.setForeground(colorletrasInternas);
        textField1.setCaretColor(colorCaretColor);
        textField1.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));

        passwordField1.setFont(fuente1);
        passwordField1.setBackground(secundario);
        passwordField1.setForeground(colorletrasInternas);
        passwordField1.setCaretColor(colorCaretColor);
        passwordField1.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));

        int h=276;
        int w=445;
        setBounds((ancho/2)-w/2,(alto/2)-h/2,w,h);
        setResizable(false);
    }

    public void enviarDatos(){
        txtusuario = textField1.getText();
        txtpassword = passwordField1.getText();
        pl.verificarUsuariodb();
    }

}