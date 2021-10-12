package GUI;

import ColorYtamaño.ColorYtamaño;
import Fuente.Fuente;
import Logica.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame implements ColorYtamaño {
    public JPanel MultiPanel;
    private JPanel PanelVacio;
    private JPanel PanelMenu;
    private JPanel JPanel1;
    private JPanel mMenu;
    private JPanel mMenu1;
    private JPanel mMenu2;
    private JPanel mMenu3;
    private JLabel LabelMenu;
    private JLabel ImagenGenerar;
    private JLabel imagenBuscar;
    private JLabel imagenAñadir;
    private JPanel mMenu4;
    private JLabel ImagenSalir;
    private JPanel mMenu5;
    private JLabel Label;

    boolean estadoAñadir=false;
    boolean estadoBuscar=false;
    boolean estadoGenerar=false;
    static Principal pl=new Principal();
    public static GUIRecibo recibo=new GUIRecibo();
    public static Buscar busqueda=new Buscar();
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    Fuente tipoFuente;
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public Menu(){
        colorYtamaño();
        add(JPanel1);
        setTitle("Menu");

        imagenAñadir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu.setBackground(pasandoMenu);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoAñadir==false){
                    mMenu.setBackground(principal);
                }else if (estadoAñadir==true){
                    mMenu.setBackground(secundario);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                estadoAñadir=true;
                estadoBuscar=false;
                estadoGenerar=false;
                mMenu.setBackground(secundario);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(principal);
                pl.estadoMenuIngresarRecibo();
            }
        });

        imagenBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu1.setBackground(pasandoMenu);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoBuscar==false){
                    mMenu1.setBackground(principal);
                }else if (estadoBuscar==true){
                    mMenu1.setBackground(secundario);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                estadoAñadir=false;
                estadoBuscar=true;
                estadoGenerar=false;
                mMenu.setBackground(principal);
                mMenu1.setBackground(secundario);
                mMenu2.setBackground(principal);

                pl.estadoMenuBuscar();
            }
        });

        ImagenGenerar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu2.setBackground(pasandoMenu);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoGenerar==false){
                    mMenu2.setBackground(principal);
                }else if (estadoGenerar==true){
                    mMenu2.setBackground(secundario);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                estadoAñadir=false;
                estadoBuscar=false;
                estadoGenerar=true;
                mMenu.setBackground(principal);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(secundario);

                pl.estadoMenuGenerar();
            }
        });

        ImagenSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mMenu4.setBackground(secundario);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu4.setBackground(pasandoMenu);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mMenu4.setBackground(principal);
            }
        });

        mMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu.setBackground(pasandoMenu);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoAñadir==false){
                    mMenu.setBackground(principal);
                }else if (estadoAñadir==true){
                    mMenu.setBackground(secundario);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

                estadoAñadir=true;
                estadoBuscar=false;
                estadoGenerar=false;
                super.mousePressed(e);
                mMenu.setBackground(secundario);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(principal);
                pl.estadoMenuIngresarRecibo();
            }
        });

        mMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu1.setBackground(pasandoMenu);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoBuscar==false){
                    mMenu1.setBackground(principal);
                }else if (estadoBuscar==true){
                    mMenu1.setBackground(secundario);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                estadoAñadir=false;
                estadoBuscar=true;
                estadoGenerar=false;
                mMenu.setBackground(principal);
                mMenu1.setBackground(secundario);
                mMenu2.setBackground(principal);

                pl.estadoMenuBuscar();
            }
        });

        mMenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu2.setBackground(pasandoMenu);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoGenerar==false){
                    mMenu2.setBackground(principal);
                }else if (estadoGenerar==true){
                    mMenu2.setBackground(secundario);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                estadoAñadir=false;
                estadoBuscar=false;
                estadoGenerar=true;
                mMenu.setBackground(principal);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(secundario);

                pl.estadoMenuGenerar();
            }
        });


        mMenu4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mMenu4.setBackground(secundario);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu4.setBackground(pasandoMenu);


            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mMenu4.setBackground(principal);
            }
        });
    }
    public void colorYtamaño(){
        imagenAñadir.setToolTipText("Añadir");
        imagenBuscar.setToolTipText("Buscar");
        ImagenGenerar.setToolTipText("Generar");
        ImagenSalir.setToolTipText("Salir");
        mMenu1.setToolTipText("Buscar");
        mMenu2.setToolTipText("Generar");
        mMenu4.setToolTipText("Salir");

        PanelVacio.setBackground(secundario);
        MultiPanel.setBackground(secundario);
        PanelMenu.setBackground(principal);
        mMenu.setBackground(principal);
        mMenu1.setBackground(principal);
        mMenu2.setBackground(principal);
        mMenu3.setBackground(principal);
        mMenu4.setBackground(principal);
        mMenu5.setBackground(secundario);

        tipoFuente=new Fuente();
        Font font1 = new Font(nombreFuente,Font.PLAIN, tamañoFuentePrincipal);

        Label.setFont(font1);
        Label.setForeground(letras);
        LabelMenu.setForeground(Color.red);
        setBackground(secundario);
        int h=422;
        int w=917;
        setBounds((ancho/2)-w/2,(alto/2)-h/2,w,h);
        setResizable(false);
    }
}
