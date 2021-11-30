package Views;

import Resource.ColorInterface;
import Controller.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame implements ColorInterface {
    public JPanel MultiPanel;
    private JPanel PanelVacio;
    private JPanel PanelMenu;
    private JPanel JPanel1;
    private JPanel mMenu;
    private JPanel mMenu1;
    private JPanel mMenu2;
    private JPanel mMenu3;
    private JLabel LabelMenu;
    private JLabel imagenGenerar;
    private JLabel imagenBuscar;
    private JLabel imagenAñadir;
    private JPanel mMenu4;
    private JLabel imagenSalir;
    private JLabel logoUCC;
    private JPanel mMenu5;
    private JLabel imagenConfig;

    boolean estadoAñadir=false;
    boolean estadoBuscar=false;
    boolean estadoGenerar=false;
    boolean estadoConfig=false;
    static Principal pl=new Principal();
    public static AgregarUsuario recibo=new AgregarUsuario();
    public static Buscar busqueda=new Buscar();
    Toolkit pantalla=Toolkit.getDefaultToolkit();
    Dimension tPantalla=pantalla.getScreenSize();
    int alto=tPantalla.height;
    int ancho=tPantalla.width;

    public Menu(){
        colorYtamaño();
        add(JPanel1);
        setTitle("Menu");

        String TextAñadir="Añadir";
        String TextBuscar="Buscar";
        String TextReporte="Reporte";
        String TextSalir="Salir";
        String TextConfig="Configuraciones";

        imagenAñadir.setToolTipText(TextAñadir);
        imagenBuscar.setToolTipText(TextBuscar);
        imagenGenerar.setToolTipText(TextReporte);
        imagenSalir.setToolTipText(TextSalir);
        imagenConfig.setToolTipText(TextConfig);
        mMenu.setToolTipText(TextAñadir);
        mMenu1.setToolTipText(TextBuscar);
        mMenu2.setToolTipText(TextReporte);
        mMenu4.setToolTipText(TextSalir);
        mMenu5.setToolTipText(TextConfig);



        imagenAñadir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu.setBackground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoAñadir==false){
                    mMenu.setBackground(principal);
                }else if (estadoAñadir==true){
                    mMenu.setBackground(presion);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                logoUCC.setVisible(false);
                estadoAñadir=true;
                estadoBuscar=false;
                estadoGenerar=false;
                estadoConfig=false;
                mMenu.setBackground(presion);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(principal);
                mMenu5.setBackground(principal);
                pl.estadoMenuIngresarUsuario();
            }
        });

        imagenBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu1.setBackground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoBuscar==false){
                    mMenu1.setBackground(principal);
                }else if (estadoBuscar==true){
                    mMenu1.setBackground(presion);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                logoUCC.setVisible(false);
                estadoAñadir=false;
                estadoBuscar=true;
                estadoGenerar=false;
                estadoConfig=false;
                mMenu.setBackground(principal);
                mMenu1.setBackground(presion);
                mMenu2.setBackground(principal);
                mMenu5.setBackground(principal);

                pl.estadoMenuBuscar();
            }
        });

        imagenGenerar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu2.setBackground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoGenerar==false){
                    mMenu2.setBackground(principal);
                }else if (estadoGenerar==true){
                    mMenu2.setBackground(presion);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                logoUCC.setVisible(false);
                estadoAñadir=false;
                estadoBuscar=false;
                estadoGenerar=true;
                estadoConfig=false;
                mMenu.setBackground(principal);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(presion);
                mMenu5.setBackground(principal);

                pl.estadoMenuGenerar();
            }
        });

        imagenConfig.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu5.setBackground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoConfig==false){
                    mMenu5.setBackground(principal);
                }else if (estadoConfig==true){
                    mMenu5.setBackground(presion);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                logoUCC.setVisible(false);
                estadoAñadir=false;
                estadoBuscar=false;
                estadoGenerar=false;
                estadoConfig=true;
                mMenu.setBackground(principal);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(principal);
                mMenu5.setBackground(presion);

                pl.estadoMenuConfiguracion();
                pl.archivos.leerYescribir();
            }
        });

        imagenSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mMenu4.setBackground(presion);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu4.setBackground(pasando);
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
                mMenu.setBackground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoAñadir==false){
                    mMenu.setBackground(principal);
                }else if (estadoAñadir==true){
                    mMenu.setBackground(presion);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                logoUCC.setVisible(false);
                estadoAñadir=true;
                estadoBuscar=false;
                estadoGenerar=false;
                estadoConfig=false;
                mMenu.setBackground(presion);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(principal);
                mMenu5.setBackground(principal);
                pl.estadoMenuIngresarUsuario();
            }
        });

        mMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu1.setBackground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoBuscar==false){
                    mMenu1.setBackground(principal);
                }else if (estadoBuscar==true){
                    mMenu1.setBackground(presion);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                logoUCC.setVisible(false);
                estadoAñadir=false;
                estadoBuscar=true;
                estadoGenerar=false;
                estadoConfig=false;
                mMenu.setBackground(principal);
                mMenu1.setBackground(presion);
                mMenu2.setBackground(principal);
                mMenu5.setBackground(principal);

                pl.estadoMenuBuscar();
            }
        });

        mMenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu2.setBackground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoGenerar==false){
                    mMenu2.setBackground(principal);
                }else if (estadoGenerar==true){
                    mMenu2.setBackground(presion);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                logoUCC.setVisible(false);
                estadoAñadir=false;
                estadoBuscar=false;
                estadoGenerar=true;
                estadoConfig=false;
                mMenu.setBackground(principal);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(presion);
                mMenu5.setBackground(principal);

                pl.estadoMenuGenerar();
            }
        });

        mMenu5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu5.setBackground(pasando);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (estadoConfig==false){
                    mMenu5.setBackground(principal);
                }else if (estadoConfig==true){
                    mMenu5.setBackground(presion);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                logoUCC.setVisible(false);
                estadoAñadir=false;
                estadoBuscar=false;
                estadoGenerar=false;
                estadoConfig=true;
                mMenu.setBackground(principal);
                mMenu1.setBackground(principal);
                mMenu2.setBackground(principal);
                mMenu5.setBackground(presion);

                pl.estadoMenuConfiguracion();
                pl.archivos.leerYescribir();
            }
        });


        mMenu4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mMenu4.setBackground(presion);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mMenu4.setBackground(pasando);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mMenu4.setBackground(principal);
            }
        });
    }
    public void colorYtamaño(){
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconoMenu));
        setIconImage(icon);

        PanelVacio.setBackground(secundario);
        MultiPanel.setBackground(secundario);
        PanelMenu.setBackground(principal);
        mMenu.setBackground(principal);
        mMenu1.setBackground(principal);
        mMenu2.setBackground(principal);
        mMenu3.setBackground(principal);
        mMenu4.setBackground(principal);
        mMenu5.setBackground(principal);

        setBackground(secundario);
        int h=422;
        int w=917;
        setBounds((ancho/2)-w/2,(alto/2)-h/2,w,h);
        setResizable(false);
    }

}
