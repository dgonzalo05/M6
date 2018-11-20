package RandomAccessFile;

import java.io.*;
public class Borrado {
	public static void main (String [] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		String inputidStr;
		int id, posicion, inputid;
		posicion = 0;
		System.out.print("Introduce el identificador: ");
	    inputidStr = reader.readLine();
	    inputid = Integer.parseInt(inputidStr);
	    while (true) {
			try {
				file.seek (posicion);
				id = file.readInt();
				if (id == inputid) break;
				posicion = posicion + 36;
			}catch(EOFException e) {
				throw new Exception ("El identificador no existe");
			}
	    }
		
	    while (true) {
			try {
				file.seek (posicion);
				id = file.readInt();
				if (id == inputid) {
					file.writeInt (-1);
					file.writeChars ("-1");
					file.writeInt (0);
					file.writeDouble (0);
				}
				posicion = posicion + 36;
			}catch(EOFException e) {break;}
	    }
	    file.close();
	}
}
