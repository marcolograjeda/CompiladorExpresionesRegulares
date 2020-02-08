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
public class NodoListaEstado {
    public Estado estado;
    public NodoListaEstado siguiente;

    public NodoListaEstado(Estado estado) {
        this.estado = estado;
        this.siguiente = null;
    }
}
