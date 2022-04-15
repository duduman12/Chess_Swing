package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writter {

    FileWriter file;
    
    public Writter (File fichero) {
        try {
            this.file = new FileWriter(fichero);
        } catch (IOException e) {    
            System.out.println("Problemos");
        }
    }
    /**
     * Escribe en el texto que se le pasa por parametro
     * @texto texto que se pasa por parametro
     */
    public void write (String texto) {
        try {
            file.write(texto);
            System.out.println(texto);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    /**
     * Función para cerra el writer y evitar errores 
     */
    public void closeWriter () {
        try {
            if (null != this.file) {
                file.close();    
            }
        }catch (IOException e) {
            System.out.println("No se pudo cerra el writer");
        }
    }    
}
