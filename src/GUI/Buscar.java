package GUI;

import ColorYtamaño.ColorYtamaño;
import Fuente.Fuente;
import Logica.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buscar extends JFrame implements ColorYtamaño {

    public JPanel JPanel1;
    private JLabel texto;

    public Principal pl=new Principal();
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public Buscar(){
        colorYtamaño();
    }

    public void colorYtamaño(){
        add(JPanel1);
        texto.setForeground(Color.WHITE);
        setBackground(secundario);
        JPanel1.setBackground(secundario);
        int w = 449;
        int h = 288;
        setBounds((ancho/2)-(w/2),(alto/2)-(h/2),w,h);
        setResizable(false);
    }
}
