SET JFLEX_HOME= C:\libs\jflex-1.7.0
cd F:\Universidad\USAC\2019\1 Semestre\Compiladores 1\Lab\CompiladorExpresiones\src\analizadores
java -jar %JFLEX_HOME%\jflex-1.7.0.jar --encoding utf-8 Lexico.jflex
pause

SET CUP_HOME= C:\libs\CUP
cd F:\Universidad\USAC\2019\1 Semestre\Compiladores 1\Lab\CompiladorExpresiones\src\analizadores
java -jar %CUP_HOME%\java-cup-11b.jar Sintactico.cup
pause
