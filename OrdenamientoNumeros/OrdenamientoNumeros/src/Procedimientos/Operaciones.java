/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Gus
 */
public class Operaciones {
    
    private static String origen, destino;

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public void ordenarNumeros(int[] array) throws IOException{
        int auxi;
        int cont1;
        int cont2;

        for(cont1 = 1; cont1<array.length; cont1++)
        {
            auxi = array [cont1];
            for(cont2 = cont1 - 1; cont2 >= 0 && array[cont2]>auxi; cont2--)
            {
                array[cont2+1] = array [cont2];
                array[cont2] = auxi;
            }
        }
        guardarArchivo(array);
    }
    
    public void capturarArchivo(String Origen, String Destino) throws IOException{
        
        setDestino(Destino);
        setOrigen(Origen);
        QuickSort QS = new QuickSort();
        
        File file = new File(getOrigen());
        Scanner archivo = null;
        try {
            archivo = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }
        
        int num = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        try {
            while(archivo.hasNext()){

                num = archivo.nextInt();
                array.add(num);
            }
            int [] arregloInt = new int[array.size()];
            for(int i=0; i<array.size(); i++){
                arregloInt[i] = array.get(i);
            }
            QS.metodoQuicksort(arregloInt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hay algún carácter deferente de un número entero");
        }
    }
    
    public void guardarArchivo(int[] array) throws IOException{
        String numerosOrdenados="";
        for(int num: array){
            numerosOrdenados = numerosOrdenados+num+"\n";
        }
        
        File destino = new File(getDestino());
        if(destino.exists()){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea sobreescribir el archivo?");
            if(respuesta == 0){
                JOptionPane.showMessageDialog(null, "Se sobreescribirá el archivo");
                escribirDatos(numerosOrdenados);
            }if(respuesta == 1){
                JOptionPane.showMessageDialog(null, "Ingrese otra ruta de destino");
            }
        }else{
            escribirDatos(numerosOrdenados);
        }
    }
    
    public void escribirDatos(String datos) throws IOException{
        File destino = new File(getDestino());
        
        FileWriter FW = new FileWriter(getDestino(), false);
        try {
            
            FW.write(datos);
            FW.close();
            JOptionPane.showMessageDialog(null, "Se escribieron correctamene los números en el archivo "+destino.getName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubó un error en la escritura");
        }
    }
}