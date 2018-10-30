import java.io.File;
public class Programa5{
	public static void main (String[] args) {
		String dir = args[0]; // directorio actual
		File archivo = new File(dir);
		if (archivo.exists()) {
			System.out.printf("Nombre: %s \n", archivo.getName());
			System.out.printf("Ruta Relativa: %s \n", archivo.getPath());
			System.out.printf("Ruta Absoluta: %s \n", archivo.getAbsolutePath());
			System.out.printf("Es pot escriure? %b \n", archivo.canWrite());
			System.out.printf("Es pot llegir? %b \n", archivo.canRead());
			System.out.printf("Tamany: %d bytes \n", archivo.length());
		} else {
			System.out.println("El fitxer no existeix!");
		}
	}
}