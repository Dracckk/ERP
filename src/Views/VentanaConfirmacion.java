package Views;

import Resource.ColorInterface;
import Resource.ColorYfuenteLetras;
import Resource.Fuente;
import Controller.ManejoDeArchivos;
import Controller.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaConfirmacion extends JFrame implements ColorInterface, ColorYfuenteLetras {
    public JPanel Jpanel1;
    private JLabel texto;
    private JLabel confirmar;
    private JLabel cancelar;
    private JPanel Jpanel2;
    Fuente tipoFuente;
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public VentanaConfirmacion(){
        colorYtamaño();
        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                confirmar.setForeground(presionBoton);
                new ManejoDeArchivos().TestAll();
                new Principal().estadoMenuGenerar();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                confirmar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                confirmar.setForeground(colorBotones);
            }
        });

        cancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cancelar.setForeground(presionBoton);
                JOptionPane.showMessageDialog(null, "ACCION CANCELADA", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                new Principal().estadoMenuGenerar();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cancelar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                cancelar.setForeground(colorBotones);
            }
        });
    }

    public void colorYtamaño(){
        add(Jpanel1);
        Jpanel1.setBackground(secundario);
        Jpanel2.setBackground(secundario);

        setTitle("Confirmar");
        tipoFuente=new Fuente();


        texto.setFont(tipoFuente.fuente(tipoFuente.DelaGo,0,tamaño ));
        confirmar.setFont(tipoFuente.fuente(tipoFuente.DelaGo,0,tamaño ));
        cancelar.setFont(tipoFuente.fuente(tipoFuente.DelaGo,0,tamaño ));

        texto.setForeground(colorLetras);
        confirmar.setForeground(colorBotones);
        cancelar.setForeground(colorBotones);

        int h=159;
        int w=792;
        setBounds((ancho/2)-w/2,(alto/2)-h/2,w,h);
        setResizable(false);
    }
}
