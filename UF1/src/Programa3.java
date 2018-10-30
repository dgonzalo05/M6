import java.io.File;
public class Programa3{
	public static void main (String[] args) {
		String dir = args[0]; // directorio actual
		File f = new File(dir);
		File[] archivos = f.listFiles();
		System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
		for (int i=0; i<archivos.length; i++){
			System.out.printf("Nombre: %s \n", archivos[i]);
		}
	}
}