package GUI;

import FuenteYcolor.ColorInterface;
import FuenteYcolor.ColorYfuenteLetras;
import FuenteYcolor.Fuente;
import Logica.ManejoDeArchivos;
import Logica.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Generar extends JFrame implements ColorInterface, ColorYfuenteLetras {
    public JPanel JPanel1;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    private JLabel ingresosLabel;
    private JLabel egresosLabel;
    private JLabel corrienteLabel;
    private JLabel totalLabel;
    private JLabel cargar;
    private JLabel generar;
    private JLabel textoLabel;
    static Principal pl=new Principal();
    Fuente tipoFuente;

    public Generar(){
        colorYtamaño();

        generar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                generar.setForeground(presionBoton);
                try{
                    new ManejoDeArchivos().generarReporte();
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "ERROR "+x, "Generar", JOptionPane.WARNING_MESSAGE);
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                generar.setForeground(colorBotones);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                generar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                generar.setForeground(colorBotones);
            }
        });

        cargar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cargar.setForeground(presionBoton);
                pl.estadoMenuConfirmar();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                cargar.setForeground(colorBotones);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cargar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                cargar.setForeground(colorBotones);
            }
        });
    }

    public void colorYtamaño(){
        tipoFuente=new Fuente();


        add(JPanel1);
        JPanel1.setBackground(secundario);

        textoLabel.setForeground(colorLetras);
        ingresosLabel.setForeground(colorLetras);
        egresosLabel.setForeground(colorLetras);
        corrienteLabel.setForeground(colorLetras);
        totalLabel.setForeground(principal);

        cargar.setForeground(colorBotones);
        generar.setForeground(colorBotones);

        textoLabel.setFont(fuente1);
        ingresosLabel.setFont(fuente1);
        egresosLabel.setFont(fuente1);
        corrienteLabel.setFont(fuente1);
        totalLabel.setFont(fuente1);
        cargar.setFont(fuente1);
        generar.setFont(fuente1);

        textField1.setBackground(secundario);
        textField2.setBackground(secundario);
        textField3.setBackground(secundario);
        textField4.setBackground(secundario);

        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);

        textField1.setForeground(colorletrasInternas);
        textField2.setForeground(colorletrasInternas);
        textField3.setForeground(colorletrasInternas);
        textField4.setForeground(principal);

        textField1.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField2.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField3.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField4.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));

        textField1.setCaretColor(colorCaretColor);
        textField2.setCaretColor(colorCaretColor);
        textField3.setCaretColor(colorCaretColor);
        textField4.setCaretColor(colorCaretColor);

        textField1.setFont(fuente1);
        textField2.setFont(fuente1);
        textField3.setFont(fuente1);
        textField4.setFont(fuente1);

    }
}
