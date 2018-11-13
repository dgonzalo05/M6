package FicherosBinarios;

import java.io.IOException;

import java.io.*;

public class Programa1Read {
	
	public static void main (String[] args) throws IOException{
		File fichero = new File ("FicheroDatos.dat");
		FileInputStream filein= new FileInputStream (fichero);
		DataInputStream dataIS = new DataInputStream (filein);
		String noms;
		int anys;
		while (true) {
			try {
				noms = dataIS.readUTF();
				anys = dataIS.readInt();
				System.out.println(noms+" "+anys);
			}catch(IOException e){
				filein.close();
			}
		}
	}
}
