package GUI;

import FuenteYcolor.ColorInterface;
import FuenteYcolor.ColorYfuenteLetras;
import FuenteYcolor.Fuente;
import Logica.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Configuraciones extends JFrame implements ColorInterface, ColorYfuenteLetras {

    public JPanel JPanel1;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JTextField textField5;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel boton;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JPanel JPanel5;
    private JPanel JPanel6;
    private JPanel JPanel7;

    public static String EtextField1="";
    public static String EtextField2="";
    public static String EtextField3="";
    public static String EtextField4="";
    public static String EtextField5="";

    Fuente tipoFuente;

    public Configuraciones(){
        colorYtamaño();

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                boton.setForeground(presionBoton);

                try {
                    enviarDatos();
                    Principal.archivos.guardarModificacionConfiguracion();
                    Principal.archivos.leerArchivo();
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "ERROR "+x, "Configuraciones", JOptionPane.WARNING_MESSAGE);
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                boton.setForeground(pasandoBoton);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                boton.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                boton.setForeground(colorBotones);
            }
        });
    }

    public void colorYtamaño(){
        tipoFuente=new Fuente();
        add(JPanel1);

        JPanel1.setBackground(secundario);
        JPanel2.setBackground(secundario);
        JPanel3.setBackground(secundario);
        JPanel4.setBackground(secundario);
        JPanel5.setBackground(secundario);
        JPanel6.setBackground(secundario);
        JPanel7.setBackground(secundario);

        label.setFont(fuente1);
        label1.setFont(fuente1);
        label2.setFont(fuente1);
        label3.setFont(fuente1);
        label4.setFont(fuente1);
        label5.setFont(fuente1);
        label6.setFont(fuente1);

        label.setForeground(colorLetras);
        label1.setForeground(colorLetras);
        label2.setForeground(colorLetras);
        label3.setForeground(colorLetras);
        label4.setForeground(colorLetras);
        label5.setForeground(principal);
        label6.setForeground(principal);

        textField1.setBackground(secundario);
        textField2.setBackground(secundario);
        textField3.setBackground(secundario);
        textField4.setBackground(secundario);
        textField5.setBackground(secundario);

        textField1.setForeground(colorletrasInternas);
        textField2.setForeground(colorletrasInternas);
        textField3.setForeground(colorletrasInternas);
        textField4.setForeground(colorletrasInternas);
        textField5.setForeground(colorletrasInternas);

        textField1.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField2.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField3.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField4.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField5.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));

        textField1.setCaretColor(colorCaretColor);
        textField2.setCaretColor(colorCaretColor);
        textField3.setCaretColor(colorCaretColor);
        textField4.setCaretColor(colorCaretColor);
        textField5.setCaretColor(colorCaretColor);

        textField1.setFont(fuente1);
        textField2.setFont(fuente1);
        textField3.setFont(fuente1);
        textField4.setFont(fuente1);
        textField5.setFont(fuente1);

        boton.setBackground(secundario);
        boton.setForeground(colorBotones);
        boton.setFont(tipoFuente.fuente(tipoFuente.DelaGo,0,tamaño ));
    }

    public void enviarDatos(){
        EtextField1=textField1.getText();
        EtextField2=textField2.getText();
        EtextField3=textField3.getText();
        EtextField4=textField4.getText();
        EtextField5=textField5.getText();
    }
}
