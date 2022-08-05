
package projeto_linguagens_programacao;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Ficheiro {
    
    public static BufferedReader fr;
    public static BufferedWriter fw;
    
    public static void abreFicheiro (String nomeFicheiro) throws IOException{
        File f = new File ("projeto.csv");
    }
    
    public static void abreLeitura( String nomeFicheiro ) throws IOException {
        fr = new BufferedReader( new FileReader( nomeFicheiro ) );
    }
    
    public static void abreEscrita( String nomeFicheiro ) throws IOException {
        fw = new BufferedWriter( new FileWriter( nomeFicheiro ) );
    }
    
    public static void fechaEscrita() throws IOException {
        fw.close();
    }
    
    public String leLinha() throws IOException{
        return fr.readLine();
    }
    
     public static void escreveValores( String linha, String coluna ) throws IOException{
        fw.write(linha);
        fw.write (",");
        fw.write(coluna);
        
    }
}


    

