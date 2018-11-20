package RandomAccessFile;
import java.io.*;
public class Modificacion {
	public static void main (String [] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		String inputidStr, inputSalarioStr, apellidos;
		int id, dep, posicion, inputid;
		char apellido[]= new char[10], aux;
		posicion = 0;
		double inputsalario, salario;
		System.out.print("Introduce el identificador: ");
	    inputidStr = reader.readLine();
	    inputid = Integer.parseInt(inputidStr);
	    while (true) {
			try {
				file.seek (posicion);
				id = file.readInt();
				for ( int i =0; i<apellido.length; i++) {
					aux = file.readChar();
					apellido[i]=aux;
				}
				apellidos = new String (apellido);
				dep = file.readInt();
				salario = file.readDouble();
				if (id == inputid) break;
				posicion = posicion + 36;
			}catch(EOFException e) {
				throw new Exception ("El identificador no existe");
			}
	    }
		System.out.print("Introduce el salario: ");
	    inputSalarioStr = reader.readLine();
	    inputsalario = Double.parseDouble(inputSalarioStr);
		
	    while (true) {
			try {
				file.seek (posicion);
				id = file.readInt();
				if (id == inputid) {
					StringBuffer buffer = null;
					file.writeInt (inputid);
					buffer = new StringBuffer (apellidos);
					buffer.setLength(10);
					file.writeChars (buffer.toString());
					Double nuevosalario = salario + inputsalario;
					file.writeDouble (nuevosalario);
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario antiguo: %.2f Salario nuevo: %.2f %n", id,apellidos.trim(), dep, salario, nuevosalario);
					
				}
				posicion = posicion + 36;
			}catch(EOFException e) {break;}
	    }
	    file.close();
	}
}
