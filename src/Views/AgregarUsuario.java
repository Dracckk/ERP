package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Resource.ColorInterface;
import Resource.ColorYfuenteLetras;
import Resource.Fuente;
import Controller.Principal;

public class AgregarUsuario extends JFrame implements ColorYfuenteLetras, ColorInterface {
    public JPanel JPanel1;
    private JTextField textField1;
    private JRadioButton administradorRadioButton;
    private JRadioButton usuarioGeneralRadioButton;
    private JLabel LabelUsuario;
    private JLabel LabelContraseña;
    private JLabel enviar;
    private JPanel JPanel2;
    private JPasswordField passwordField1;

    public static String textUsuario="";
    public static String textContraseña="";
    public static int tipoUsuario;

    Fuente tipoFuente;
    public static Principal pl=new Principal();
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    ButtonGroup tipo=new ButtonGroup();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public AgregarUsuario() {
        colorYtamaño();
        enviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                enviar.setForeground(presionBoton);

                if(administradorRadioButton.isSelected() || usuarioGeneralRadioButton.isSelected()){
                    enviarDatos();
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR NO A SELECCIONADO EL TIPO DE USUARIO", "Agregar Usuario", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                enviar.setForeground(colorBotones);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                enviar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                enviar.setForeground(colorBotones);
            }
        });
    }

    public void colorYtamaño(){
        add(JPanel1);
        setBackground(secundario);
        JPanel1.setBackground(secundario);
        JPanel2.setBackground(secundario);
        int h=399;
        int w=916;
        setBounds((ancho/2)-(w/2),(alto/2)-(h/2),w,h);
        setResizable(false);

        tipo.add(administradorRadioButton);
        tipo.add(usuarioGeneralRadioButton);

        tipoFuente=new Fuente();

        LabelUsuario.setForeground(colorLetras);
        LabelContraseña.setForeground(colorLetras);
        enviar.setForeground(colorLetras);
        LabelUsuario.setFont(fuente1);
        LabelContraseña.setFont(fuente1);
        enviar.setFont(fuente1);

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

        passwordField1.setBackground(secundario);
        passwordField1.setForeground(colorletrasInternas);
        passwordField1.setCaretColor(colorCaretColor);
        passwordField1.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));
        passwordField1.setFont(fuente1);
        passwordField1.setFont(fuente1);



    }

    public void enviarDatos(){

        try {
            textUsuario = textField1.getText();
            textContraseña = passwordField1.getText();
            if (administradorRadioButton.isSelected()) {
                tipoUsuario = 0;
            } else if (usuarioGeneralRadioButton.isSelected()) {
                tipoUsuario = 1;
            }

            pl.ingresarUsuariodb();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR "+e, "Agregar Usuario", JOptionPane.WARNING_MESSAGE);
        }
        textField1.setText("");
        passwordField1.setText("");
    }
}
