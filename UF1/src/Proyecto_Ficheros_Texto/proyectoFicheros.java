package Proyecto_Ficheros_Texto;

import java.io.*;
import java.util.*;
public class proyectoFicheros {

    public static String treure_coma(String campo){
        String no_coma = "";
        for (int lletra = 0; lletra < campo.length(); lletra++){
            if (campo.charAt(lletra) != ','){
                no_coma += campo.charAt(lletra);
            }
        }
        return no_coma;
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader etiquetes = null;
        BufferedReader dades = null;
        BufferedWriter xml = null;
        BufferedWriter log = null;
        int con = 1;
        int valor;
        String linea, etiqueta;
        String salt = "\n";
        String sep = "\t";
        String[] datos;
        try{
            etiquetes = OpenFile.r("file1.txt");
            dades = OpenFile.r("file2.txt");
            xml = OpenFile.w("file3.txt");
            log = OpenFile.a("fitxer_log.log");

            xml.write("<doc>"+salt);
            
            while((linea=dades.readLine())!=null){
                datos = linea.split(sep);
                for (int i = 0; i < datos.length; i++){
                	etiqueta = etiquetes.readLine();
                    xml.write(sep+"<elem nr=\""+con+"\">"+salt);
                    while((linea=dades.readLine())!=null){
                    	xml.write(sep+sep+"<"+etiqueta+">"+linea.charAt(i)+"</"+etiqueta+">");
                    }

                    xml.write(salt+sep+"</elem>"+salt);
                    con++;
                }
            }
            xml.write("</doc>");
        }catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
        	etiquetes.close();
        	xml.close();
        	log.close();
        }
    }
}