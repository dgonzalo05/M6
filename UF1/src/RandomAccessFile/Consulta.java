package RandomAccessFile;
import java.io.*;
public class Consulta {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "r");
		String inputidStr;
		int id, dep ,posicion, inputid;
		Double salario;
		char apellido[]= new char[10], aux;
		posicion = 0;
		
		System.out.print("Introduce el identificador: ");
	    inputidStr = reader.readLine();
	    inputid = Integer.parseInt(inputidStr);
	    while (true) {
			file.seek (posicion);
			id = file.readInt();
			for ( int i =0; i<apellido.length; i++) {
				aux = file.readChar();
				apellido[i]=aux;
			}
			String apellidos = new String (apellido);
			dep = file.readInt();
			salario = file.readDouble();
			if (id == inputid) {
				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id,apellidos.trim(), dep, salario);
				break;
			}
			posicion = posicion + 36;
			if (file.getFilePointer() == file.length()) {
				System.out.printf("El identificador no existe");
				break;
			}
	    }
		file.close();
	}
}