import java.io.*;
public class Programa6{
	public static void main(String[] args){
		try {
			File f = new File("NuevoDir");
			File[] archivos = f.listFiles();
			for (int i=0; i<archivos.length; i++){
				archivos[i].delete();
			}
			f.delete();
		}catch (Exception e) {
			System.out.println("El directorio no existe");
		}
	}
}