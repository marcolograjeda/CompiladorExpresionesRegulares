/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Junior
 */
public class NodoArbol {
    public NodoArbol izquierda, derecha;
    public String lado;
    public String padre;
    public String primeros = "";
    public String siguientes = "";
    public boolean anulable = false;
    public boolean hoja = false;
    public Object dato;
    public int tipoOperador;
    public int contador;
    public int numHoja;
    public NodoArbol(String dato) {
        this.dato = dato;
    }
    
    public NodoArbol() {
    }
}
