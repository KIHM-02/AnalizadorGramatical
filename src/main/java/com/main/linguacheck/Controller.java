package com.main.linguacheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Logger;

/**
 *
 * @author monte
 */
public class Controller 
{
    public void writeInFile(String input) throws IOException
    {
        System.out.println("La linea escrita es: "+input);
        File fichero = new File("fichero.txt");
        PrintWriter writer;
        
        try{
            writer = new PrintWriter(fichero);
            writer.print(input);
            writer.close();
            
        }catch(FileNotFoundException er){
            Logger.getLogger("There was an error: "+er);
        }
    }
    
    public String readFromFile() throws FileNotFoundException, IOException
    {
        Reader reader = new BufferedReader(new FileReader("fichero.txt"));
        Lexer lexer = new Lexer(reader);
        StringBuilder resultado = new StringBuilder();
        String token;
        
        while((token = lexer.yylex()) != null){
            resultado.append(token);
            System.out.println("--> El resultado es "+token);
            
            if(token.contains("ERROR"))
            {
                resultado.setLength(0); //Limpia el Builder
                resultado.append(token);
                System.out.println("Se limpio el builder...");
                break;
            }
        }
        
        return resultado.toString();
    }
}
