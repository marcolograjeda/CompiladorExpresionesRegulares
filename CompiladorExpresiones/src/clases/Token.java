package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior
 */
public class Token {
    public String id, token, tipo, fila, columna;

    public Token(int num, String tk, String tipo, String fila, String columna) {
        this.id = Integer.toString(num);
        this.token = tk;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }
    
    public Token(){
        
    }
}
