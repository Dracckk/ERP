package GUI;

import FuenteYcolor.ColorInterface;
import FuenteYcolor.ColorYfuenteLetras;
import FuenteYcolor.Fuente;
import Logica.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutionException;

public class ModificarUsuario extends JFrame implements ColorYfuenteLetras, ColorInterface {
    public JPanel JPanel1;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JRadioButton administradorRadioButton;
    public JRadioButton usuarioGeneralRadioButton;
    private JLabel idLabel;
    private JLabel usuarioLabel;
    private JLabel contraseñaLabel;
    private JLabel tipoDeUsuario;
    public JLabel modificar;
    public JLabel guardar;
    public JLabel cancelar;
    public JLabel eliminar;

    Fuente tipoFuente;
    public static Principal pl=new Principal();
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    ButtonGroup tipo=new ButtonGroup();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public static int id=0;
    public static String usuario = "";
    public static String contraseña = "";
    public static int tipoUsuario = 0;

    public  ModificarUsuario(){
        colorYtamaño();

        modificar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                modificar.setForeground(presionBoton);
                pl.habilitarModificacion();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                modificar.setForeground(colorBotones);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                modificar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                modificar.setForeground(colorBotones);
            }
        });

        cancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cancelar.setForeground(presionBoton);
                pl.estadoMenuBuscar();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                cancelar.setForeground(colorBotones);
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

        guardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                guardar.setForeground(presionBoton);

                try{
                    enviarDatos();
                    pl.comprobarPermisoParaModificar();
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "ERROR "+x, "Modificar Usuario", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                guardar.setForeground(colorBotones);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                guardar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                guardar.setForeground(colorBotones);
            }
        });

        eliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                eliminar.setForeground(presionBoton);

                try {
                    enviarDatos();
                    pl.eliminarUsuario();
                }catch (Exception x){
                    JOptionPane.showMessageDialog(null, "ERROR "+x, "Modificar Usuario", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                eliminar.setForeground(colorBotones);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                eliminar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                eliminar.setForeground(colorBotones);
            }
        });
    }

    public void colorYtamaño(){
        add(JPanel1);
        setBackground(secundario);
        JPanel1.setBackground(secundario);
        int h=399;
        int w=916;
        setBounds((ancho/2)-(w/2),(alto/2)-(h/2),w,h);
        setResizable(false);

        tipo.add(administradorRadioButton);
        tipo.add(usuarioGeneralRadioButton);

        tipoFuente=new Fuente();

        idLabel.setForeground(colorLetras);
        usuarioLabel.setForeground(colorLetras);
        contraseñaLabel.setForeground(colorLetras);
        tipoDeUsuario.setForeground(colorLetras);
        guardar.setForeground(colorLetras);
        modificar.setForeground(colorLetras);
        cancelar.setForeground(colorLetras);
        eliminar.setForeground(colorLetras);
        idLabel.setFont(fuente1);
        eliminar.setFont(fuente1);
        usuarioLabel.setFont(fuente1);
        contraseñaLabel.setFont(fuente1);
        tipoDeUsuario.setFont(fuente1);
        guardar.setFont(fuente1);
        modificar.setFont(fuente1);
        cancelar.setFont(fuente1);

        administradorRadioButton.setBackground(secundario);
        usuarioGeneralRadioButton.setBackground(secundario);
        administradorRadioButton.setForeground(colorLetras);
        usuarioGeneralRadioButton.setForeground(colorLetras);
        administradorRadioButton.setFont(fuente1);
        usuarioGeneralRadioButton.setFont(fuente1);

        textField1.setBackground(secundario);
        textField1.setForeground(colorletrasInternas);
        textField1.setCaretColor(colorCaretColor);
        textField1.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField1.setFont(fuente1);

        textField2.setBackground(secundario);
        textField2.setForeground(colorletrasInternas);
        textField2.setCaretColor(colorCaretColor);
        textField2.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField2.setFont(fuente1);

        textField3.setBackground(secundario);
        textField3.setForeground(colorletrasInternas);
        textField3.setCaretColor(colorCaretColor);
        textField3.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        textField3.setFont(fuente1);
    }

    public void enviarDatos(){

        try{
            id=Integer.parseInt(textField1.getText());
            usuario = textField2.getText();
            contraseña = textField3.getText();

            if (administradorRadioButton.isSelected()){
                tipoUsuario=0;
            }else if(usuarioGeneralRadioButton.isSelected()){
                tipoUsuario=1;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR "+e, "Modificar Usuario", JOptionPane.WARNING_MESSAGE);
        }

    }
}
