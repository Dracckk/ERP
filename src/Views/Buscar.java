package Views;

import Resource.ColorInterface;
import Resource.ColorYfuenteLetras;
import Resource.Fuente;
import Controller.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buscar extends JFrame implements ColorInterface, ColorYfuenteLetras {
    public JPanel JPanel1;
    private JPanel panelBuscar;
    private JLabel JLabel;
    private JLabel buscar;
    private JTextField textField1;
    private JRadioButton IDRadioButton;
    private JRadioButton usuarioRadioButton;
    private JPanel panelBuscar2;

    public static String variableAbuscar ="";
    public static int txtTipo =0;
    public Principal pl=new Principal();
    Fuente tipoFuente;
    ButtonGroup tipo=new ButtonGroup();
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public Buscar(){
        colorYtamaño();

        buscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                buscar.setForeground(presionBoton);
                enviarDatos();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                buscar.setForeground(colorBotones);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                buscar.setForeground(pasandoBoton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                buscar.setForeground(colorBotones);
            }
        });
    }

    public void colorYtamaño(){
        add(JPanel1);
        tipo.add(IDRadioButton);
        tipo.add(usuarioRadioButton);

        JPanel1.setBackground(secundario);
        panelBuscar.setBackground(secundario);
        panelBuscar2.setBackground(secundario);
        IDRadioButton.setBackground(secundario);
        usuarioRadioButton.setBackground(secundario);

        JLabel.setForeground(colorLetras);
        IDRadioButton.setForeground(colorLetras);
        usuarioRadioButton.setForeground(colorLetras);
        buscar.setForeground(colorBotones);

        textField1.setBackground(secundario);
        textField1.setForeground(colorletrasInternas);
        textField1.setCaretColor(colorCaretColor);
        textField1.setBorder(BorderFactory.createLineBorder(colorBorde, tamañoBorde));

        tipoFuente=new Fuente();

        textField1.setFont(fuente1);
        IDRadioButton.setFont(fuente1);
        usuarioRadioButton.setFont(fuente1);
        JLabel.setFont(fuente1);
        buscar.setFont(fuente1);

        setBounds((ancho/2)-225,(alto/2)-144,449,288);
        setResizable(false);
    }

    public void enviarDatos(){
        try {
            variableAbuscar =textField1.getText();
            if (IDRadioButton.isSelected()){
                txtTipo=0;
            }else if(usuarioRadioButton.isSelected()){
                txtTipo=1;
            }
            pl.su.buscardb();
            textField1.setText("");
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ERROR ", "Buscar", JOptionPane.WARNING_MESSAGE);
        }catch (Exception x){
            JOptionPane.showMessageDialog(null, "ERROR DESCONOCIDO ", "Buscar", JOptionPane.WARNING_MESSAGE);
        }

    }
}
