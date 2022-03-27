/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akinatoranimales;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author dayan
 */
public class Archivos {
    public static String cargar(String ruta) throws IOException {
        File archivo = new File(ruta);
        return Files.readString(Paths.get(archivo.toURI()), Charset.forName("UTF-8"));
    }
    
    public static void guardar(String ruta, String contenidos) throws IOException {
        File archivo = new File(ruta);
        Files.writeString(Paths.get(archivo.toURI()), contenidos, Charset.forName("UTF-8"));
    }
}
