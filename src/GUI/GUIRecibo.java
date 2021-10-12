package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ColorYtamaño.ColorYtamaño;
import Fuente.Fuente;
import Logica.Principal;

public class GUIRecibo extends JFrame implements ColorYtamaño {
    public JPanel JPanel1;
    private JLabel texto;
    public Principal pl=new Principal();
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public GUIRecibo() {
        colorYtamaño();
    }

    public void colorYtamaño(){
        add(JPanel1);
        setBackground(secundario);
        texto.setForeground(Color.WHITE);
        JPanel1.setBackground(secundario);
        int h=399;
        int w=916;
        setBounds((ancho/2)-(w/2),(alto/2)-(h/2),w,h);
        setResizable(false);
    }
}
