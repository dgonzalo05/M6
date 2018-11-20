package RandomAccessFile;
import java.io.*;
public class Inserccion {
	public static void main (String [] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		String inputidStr, inputDepStr, inputApellido, inputSalarioStr;
		int id, posicion, inputid, inputdep;
		posicion = 0;
		double inputsalario;
		System.out.print("Introduce el identificador: ");
	    inputidStr = reader.readLine();
	    inputid = Integer.parseInt(inputidStr);
	    while (true) {
			try {
				file.seek (posicion);
				id = file.readInt();
				if (id == inputid) {
					throw new Exception ("El identificador ya existe");
				}
				posicion = posicion + 36;
			}catch(EOFException e) {break;}
	    }
		System.out.print("Introduce el apellido: ");
	    inputApellido = reader.readLine();
		System.out.print("Introduce el departamento: ");
	    inputDepStr = reader.readLine();
	    inputdep = Integer.parseInt(inputDepStr);
		System.out.print("Introduce el salario: ");
	    inputSalarioStr = reader.readLine();
	    inputsalario = Double.parseDouble(inputSalarioStr);
		
		StringBuffer buffer = null;
		file.writeInt (inputid);
		buffer = new StringBuffer (inputApellido);
		buffer.setLength(10);
		file.writeChars (buffer.toString());
		file.writeInt(inputdep);
		file.writeDouble (inputsalario);
		file.close();
	}
}
