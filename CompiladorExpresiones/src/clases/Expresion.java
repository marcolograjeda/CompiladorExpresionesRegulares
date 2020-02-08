/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class Expresion {
    public String nombre;
    public NodoArbol raiz;
    public ArrayList<NodoTablaFollow> follow = new ArrayList();
    public ArrayList<Estado> estados = new ArrayList();
    public NodoListaEstado listaEstados;
    public int numEstados = 0;
    public String[] lexemas;
    public Expresion(String nombre, NodoArbol raiz) {
        this.nombre = nombre;
        this.raiz = raiz;
        this.listaEstados = null;
    }

    public Expresion() {
    }

    public void agregarEstado(Estado estado){
        NodoListaEstado nuevo = new NodoListaEstado(estado);
        if(listaEstados == null){
            listaEstados = nuevo;
        }else{
            NodoListaEstado tmp = listaEstados;
            while(tmp.siguiente!=null){
                tmp = tmp.siguiente;
            }
            tmp.siguiente = nuevo;
        }
    }
}
