package Proyecto_Ficheros_Texto;

import java.io.*;
import java.util.*;
public class proyectoFicheros {
    
	public static void main(String[] args) throws IOException {
		// Definimos todas las variables
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader etiquetes = null;
        BufferedReader dades = null;
        BufferedWriter xml = null;
        int con = 1;
        String linea, etiqueta;
        ArrayList<String> etiquetas = new ArrayList<String>();
        String salt = "\n";
        String tab = "\t";
        String sep = ",";
        String[] datos;
        try{
        	// Abrimos ficheros
            etiquetes = OpenFile.r("file1.csv");
            dades = OpenFile.r("file2.csv");
            xml = OpenFile.w("file3.xml");
            
            // Las etiquetas hola y adios (0) y (1)
            etiquetas.add(etiquetes.readLine());
            etiquetas.add(etiquetes.readLine());
            
            xml.write("<doc>"+salt);
            
            while((linea=dades.readLine())!=null){
                datos = linea.split(sep);
                xml.write(tab+"<elem nr=\""+con+"\">"+salt);
                for (int i = 0; i < datos.length; i++){
                	if (etiquetas.size() > i) {
                		etiqueta = etiquetas.get(i);
                	} else {etiqueta = "altre";}
                    xml.write(tab+tab+"<"+etiqueta+">"+datos[i]+"</"+etiqueta+">"+salt);
                }
                xml.write(tab+"</elem>"+salt);
                con++;
            }
            xml.write("</doc>");
        }catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
        	etiquetes.close();
        	dades.close();
        	xml.close();
        }
    }
}