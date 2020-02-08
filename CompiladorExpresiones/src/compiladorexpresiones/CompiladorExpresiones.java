/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorexpresiones;

import clases.*;
import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class CompiladorExpresiones {
    public static ArrayList<Token> listaErrores = new ArrayList();
    public static ArrayList<Token> tokens = new ArrayList();
    public static ArrayList<NodoArbol> arboles = new ArrayList();
    public static ArrayList<Expresion> expresiones = new ArrayList();
    public static ArrayList<Conjunto> conjuntos = new ArrayList();
    public static ArrayList<ArrayList> tablaFollow = new ArrayList();
    public static ArrayList<NodoTablaFollow> follow = new ArrayList();
    public static ArrayList<EntradaAnalisis> entradasAnalizar = new ArrayList();
    //public static ArrayList<String> expresiones = new ArrayList();
    public static String graficar;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Visual visual = new Visual();
        visual.show();
        
        // TODO code application logic here
    }
    
}
