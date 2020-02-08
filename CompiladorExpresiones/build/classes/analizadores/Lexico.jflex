package analizadores;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import compiladorexpresiones.*;
import clases.Token;
%% 

%{
    public void agregarError(String lexema, String tipo){
        String linea, columna;
        linea = Integer.toString(yyline);
        columna = Integer.toString(yycolumn);
        //compiladorExpresiones.CompiladorExpresiones.listaErrores.add(new Token(lexema, tipo, linea, columna));

    }
    public ArrayList<Token> listaTokens = CompiladorExpresiones.tokens;
    public void agregarToken(int num, String lexema, String tipo){
        listaTokens.add(new Token(num, lexema, tipo, Integer.toString(yyline), Integer.toString(yycolumn)));
    }
%}

%cupsym sym
%class Lexico
%cup
%public
%unicode
%line 
%column
%char
%full
%8bit

comentario = ["/"]["/"][^\r\n]*[\n|\r|\r\n|\n\r]?
comentarioMulti = "<!" "!"+ ">" | "<!" [^!] ~"!>"
espacios = [ |\r|\t|\n|\f]*
identificador = [A-Za-zñÑ]("_"|[A-Za-zñÑ]|[0-9])*
conjunto = ([^~]|"\\n"|"\\'"|"\\\”")~([^~]|"\\n"|"\\'"|"\\\”")
num = [0-9]+
pipe = [\263]
cadena = [\"][^\"]*[\"]

%%

"=" {agregarToken(1,yytext(), "Igual"); 
    return new Symbol(sym.igual,yyline,yychar,yytext());}
"{" {agregarToken(1,yytext(), "Llave Abre"); 
    return new Symbol(sym.llavea,yyline,yychar, yytext());}
"}" {agregarToken(1,yytext(), "Llave Cierra"); 
    return new Symbol(sym.llavec,yyline,yychar, yytext());}
":" {agregarToken(1,yytext(), "Dos puntos"); 
    return new Symbol(sym.dospuntos,yyline,yychar, yytext());}
";" {agregarToken(1,yytext(), "Punto y Coma"); 
    return new Symbol(sym.puntocoma,yyline,yychar, yytext());}
"," {agregarToken(1,yytext(), "Coma"); 
    return new Symbol(sym.coma,yyline,yychar, yytext());}
"%" {agregarToken(1,yytext(), "Porcentaje"); 
    return new Symbol(sym.porcentaje,yyline,yychar, yytext());}
"-" {agregarToken(1,yytext(), "Guion"); 
    return new Symbol(sym.guion,yyline,yychar, yytext());}
">" {agregarToken(1,yytext(), "Mayor que"); 
    return new Symbol(sym.flecha,yyline,yychar, yytext());}
"~" {agregarToken(1,yytext(), "Curva"); 
    return new Symbol(sym.colocho,yyline,yychar, yytext());}
"." {agregarToken(1,yytext(), "Punto"); 
    return new Symbol(sym.punto,yyline,yychar, yytext());}

"*" {agregarToken(1,yytext(), "Kleen"); 
    return new Symbol(sym.asterisco,yyline,yychar, yytext());}
"+" {agregarToken(1,yytext(), "Mas"); 
    return new Symbol(sym.mas,yyline,yychar, yytext());}
"?" {agregarToken(1,yytext(), "Anulable"); 
    return new Symbol(sym.interrogacion,yyline,yychar, yytext());}

\n {yychar=1;}

"CONJ" {agregarToken(1,yytext(), "Reservada Conjunto"); 
    return new Symbol(sym.conj,yyline,yychar, yytext());}

{comentario} {}
{comentarioMulti} {}
{espacios} {}
{pipe} {agregarToken(1,yytext(), "Barra"); 
    return new Symbol(sym.bor,yyline,yychar, yytext());}
/*{conjunto} {agregarToken(1,yytext(), "Conjunto"); 
    return new Symbol(sym.conjuntoDec,yyline,yychar, yytext());}*/
{identificador} {agregarToken(1,yytext(), "Identificador"); 
    return new Symbol(sym.identificador,yyline,yychar, yytext());}
{num} {agregarToken(1,yytext(), "Numero"); 
    return new Symbol(sym.num,yyline,yychar, yytext());}
{cadena} {agregarToken(1,yytext(), "Cadena"); 
    return new Symbol(sym.cadena,yyline,yychar, yytext());}


. {
    System.out.println("Error lexico "+ yytext() +" linea No: "+ yyline+ " columna: " +yychar); 
    agregarError(yytext(), "No se reconoce");
}