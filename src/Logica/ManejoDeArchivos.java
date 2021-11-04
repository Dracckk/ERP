package Logica;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ManejoDeArchivos {
    static String ubicacionArchivoR="";
    static String ubicacionArchivo="";
    static String ubicacionArchivoG="";

    File archivoC = new File("data/Configuraciones.txt");

    Principal pl=new Principal();
    static int i=0;

    ArrayList datos=Principal.datos;

    public void leerArchivo() throws IOException {
        File archivo = new File(ubicacionArchivo);
        DataInputStream dis =new DataInputStream(new FileInputStream(archivo));

        boolean salir=false;

        do {
            try {
                String tipo = dis.readUTF();
                int NreciboEntrada = dis.readInt();
                int NreciboSalida = dis.readInt();
                int NreciboCorriente=dis.readInt();
                String fecha = dis.readUTF();
                int precio = dis.readInt();
                String nombre = dis.readUTF();
                String id = dis.readUTF();
                String precio_string = dis.readUTF();
                String concepto = dis.readUTF();
                String recibio = dis.readUTF();

            }catch (EOFException e){
                salir=true;
            }
        }while (!salir);


    }

    public void leerConfiguracion() throws IOException {

        String ndatos;

        FileReader reader = new FileReader(archivoC);
        BufferedReader bufer = new BufferedReader(reader);

        ndatos = bufer.readLine();
        ndatos = bufer.readLine();
        pl.contrasenaAdmin = (ndatos);
        ndatos = bufer.readLine();
        ndatos = bufer.readLine();
        pl.contrasenaUsuario = (ndatos);
        ndatos = bufer.readLine();
        ndatos = bufer.readLine();
        ubicacionArchivo=(ndatos);
        ndatos = bufer.readLine();
        ndatos = bufer.readLine();
        ubicacionArchivoR=(ndatos);
        ndatos = bufer.readLine();
        ndatos = bufer.readLine();
        ubicacionArchivoG=(ndatos);
    }

    public void leerYescribir(){
        try {
            leerConfiguracion();
        }catch (Exception e){

        }

        pl.config.textField1.setText(pl.contrasenaAdmin);
        pl.config.textField2.setText(pl.contrasenaUsuario);
        pl.config.textField3.setText(ubicacionArchivoR);
        pl.config.textField4.setText(ubicacionArchivoG);
        pl.config.textField5.setText(ubicacionArchivo);

    }

    public void guardarModificacionConfiguracion() {

        try {
            BufferedWriter bufer = new BufferedWriter(new FileWriter(archivoC));

            bufer.write("Contraseña Administrador:\n");
            bufer.write(pl.config.EtextField1+"\n");
            bufer.write("Contraseña General:\n");
            bufer.write(pl.config.EtextField2+"\n");
            bufer.write("Ubicacion Archivo de guardado:\n");
            bufer.write(pl.config.EtextField5+"\n");
            bufer.write("Ubicacion de generacion de reporte:\n");
            bufer.write(pl.config.EtextField3+"\n");
            bufer.write("Ubicacion Archivo de copia:\n");
            bufer.write(pl.config.EtextField4+"\n");

            bufer.close();

            leerConfiguracion();

            JOptionPane.showMessageDialog(null, "Se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception E){

        }

    }



    public void generarReporte() {
        File archivoR = new File(ubicacionArchivoR);
        try {
            PrintWriter archivog = new PrintWriter(archivoR);

            archivog.println("FECHA"+";"+"TIPO"+";"+"RECIBO CAJA NUMERO"+";"+"RECIBO EGRESOS NUMERO"+";"+"RECIBO CORRIENTE"+";"+"PRECIO"+";"+"NOMBRE"+";"+"ID"+";"+"PRECIO STRING"+";"+"CONCEPTO"+";"+"RECIBIO");
            archivog.println();
            i=0;

            archivog.close();

            Desktop reporte =Desktop.getDesktop();
            reporte.open(archivoR);

            String mensaje=("Abriendo");
            JOptionPane.showMessageDialog(null,mensaje);

        } catch (Exception e) {

        }
    }

    public void TestAll() {
        File archivoG = new File(ubicacionArchivoG);

        String ndatos;
        int ndatosc;

        String tipo;
        int NreciboEntrada;
        int NreciboSalida;
        int NreciboCorriente;
        String fecha;
        int precio;
        String nombre;
        String id;
        String precio_string;
        String concepto;
        String recibio;

        datos.clear();

        try {
            FileReader reader = new FileReader(archivoG);
            BufferedReader bufer = new BufferedReader(reader);

            ndatos = bufer.readLine();
            ndatosc = Integer.parseInt(ndatos);
            ndatos = bufer.readLine();

            for (int i = 0; i < ndatosc; i++) {

                ndatos = bufer.readLine();
                tipo = (ndatos);
                ndatos = bufer.readLine();
                NreciboEntrada = Integer.parseInt(ndatos);
                ndatos = bufer.readLine();
                NreciboSalida = Integer.parseInt(ndatos);
                ndatos= bufer.readLine();
                NreciboCorriente=Integer.parseInt(ndatos);
                ndatos = bufer.readLine();
                fecha = ndatos;
                ndatos = bufer.readLine();
                precio = Integer.parseInt(ndatos);
                ndatos = bufer.readLine();
                nombre = ndatos;
                ndatos = bufer.readLine();
                id = ndatos;
                ndatos = bufer.readLine();
                precio_string = ndatos;
                ndatos = bufer.readLine();
                concepto = ndatos;
                ndatos = bufer.readLine();
                recibio = ndatos;
                ndatos = bufer.readLine();


            }


            bufer.close();
            reader.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
