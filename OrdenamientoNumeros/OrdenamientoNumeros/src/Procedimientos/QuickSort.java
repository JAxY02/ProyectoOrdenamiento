/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import java.io.IOException;

/**
 *
 * @author gus_d
 */
public class QuickSort {
    public void metodoQuicksort (int[] array) throws IOException{
        Operaciones oper = new Operaciones();
        array = quicks1(array);
        oper.guardarArchivo(array);
    }
    
    public int[] quicks1 (int numeros[]) throws IOException{
        return quicks2 (numeros,0,numeros.length-1);
    }
    
    public int[] quicks2 (int numeros[], int izqui, int dere) throws IOException{
    
    Operaciones oper = new Operaciones();
    if(izqui>=dere)
    return numeros;
    int i= izqui;
    int d= dere;
    if(izqui!=dere){
        int pivote;
        int auxi;
        pivote = izqui;
        while(izqui!=dere){
            while(numeros[dere]>=numeros[pivote] && izqui<dere)
                dere--;
            while(numeros[izqui]<numeros[pivote] && izqui< dere)
                izqui++;
            if(dere!=izqui){
                auxi = numeros[dere];
                numeros[dere]=numeros[izqui];
                numeros[izqui] = auxi;
            }
        }
        if(izqui==dere){
            quicks2(numeros,i,izqui-1);
            quicks2(numeros,izqui+1,d);
        }
    }else
        return numeros;
    
    return numeros;
    }
}
