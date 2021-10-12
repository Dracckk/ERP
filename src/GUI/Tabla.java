package GUI;

import ColorYtamaño.ColorYtamaño;
import Fuente.Fuente;
import Logica.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tabla extends JFrame implements ColorYtamaño {
    public JPanel JPanel1;
    private JLabel texto;
    Fuente tipoFuente;
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    static Principal pl=new Principal();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public Tabla(){
        colorYtamaño();
    }

    public void colorYtamaño(){
        add(JPanel1);
        JPanel1.setBackground(secundario);
        texto.setForeground(Color.WHITE);
        int h=422;
        int w=611;
        setBounds((ancho/2)-w/2,(alto/2)-h/2,w,h);
        setResizable(false);
    }
}
