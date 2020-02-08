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
public class Estado {
    public int numeroEstado;
    public String formacion = "";
    public int transiciones[];
    public boolean aceptacion = false;
    public Estado(int numeroEstado, String formacion, int numero) {
        this.numeroEstado = numeroEstado;
        this.formacion = formacion;
        this.transiciones = new int[numero];
    }

    public Estado() {
    }

    public Estado(int numeroEstado, int numero) {
        this.numeroEstado = numeroEstado;
        this.transiciones = new int[numero];
    }
    
    
}
