/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import static compiladorexpresiones.CompiladorExpresiones.expresiones;
import static compiladorexpresiones.CompiladorExpresiones.entradasAnalizar;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Junior
 */
public class AnalisisDeEntrada {
    public String salida = "<SALIDA>";
    
    public AnalisisDeEntrada(){
        
    }
    
    public void ejecutarAnalisis(){
        for(EntradaAnalisis ex:entradasAnalizar){
            for(Expresion expresion:expresiones){
                if(expresion.nombre.equals(ex.nombreExpresion)){
                      analizar(ex.entrada, expresion.listaEstados, expresion.lexemas, ex.nombreExpresion);
                }
            }
        }
        crearArchivo();
    }
    
    public void crearArchivo(){
        String rutaArchivoGraficar = "C:/ExpresionesRegulares/Salida.txt";
        try{
            FileWriter archivo = new FileWriter(rutaArchivoGraficar+".txt");
            archivo.write(salida+"\n<SALIDA/>");
            archivo.close();
            
        }catch(IOException e){
            System.out.println("Error escribiendo el archivo de la expresion ");
        }
    }
    
    public void analizar(String entrada, NodoListaEstado listaEstado, String[] listaCaracteres, String nombre){
        int estado = 1;
        boolean aceptacion = false;
        char caracteres[] = entrada.toCharArray();
        int contar = 1;
        NodoListaEstado tmp = obtenerEstado(listaEstado, estado);
        aceptacion = tmp.estado.aceptacion;
        for(char ch : caracteres){
            if(estado != 0){
                if(tmp==null){
                    break;
                }else{
                    int posCar = obtenerPosicionCaracter(ch,listaCaracteres);
                    estado = tmp.estado.transiciones[posCar];
                    tmp = obtenerEstado(listaEstado, estado);
                    aceptacion = tmp.estado.aceptacion;
                }
            }else{
                break;
            }
            contar++;
        }
        generarSalida(estado,aceptacion,entrada,nombre);
    }
    
    public void generarSalida(int estado, boolean aceptacion, String entrada, String nombre){
        salida += "\n\t<EXPRESION>\n\t\t<VALOR>"+entrada+"<VALOR/>\n\t\t<ER>"+nombre+"<ER/>";
        if(aceptacion){
            salida += "\n\t\t<RESULTADO>Cadena Valida<RESULTADO/>";
        }else{
            salida += "\n\t\t<RESULTADO>Cadena Invalida<RESULTADO/>";
        }
        salida += "\n\t<EXPRESION/>";
    }
    
    public NodoListaEstado obtenerEstado(NodoListaEstado nodo, int estado){
        NodoListaEstado estadoTmp = nodo;
        while(estadoTmp!=null){
            if(estadoTmp.estado.numeroEstado == estado){
                return estadoTmp;
            }
            estadoTmp = estadoTmp.siguiente;
        }
        return estadoTmp;
    }
    
    public int obtenerPosicionCaracter(char ch, String[] lexemas){
        int pos = 0;
        for(String aux:lexemas){
            String car = Character.toString(ch);
            if(aux.equals(car)){
                return pos;
            }
            pos++;
        }
        return 0;
    }
}
