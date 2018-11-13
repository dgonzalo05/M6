package FicherosBinarios;

import java.io.IOException;

import java.io.*;

public class Programa1 {

	public static void main (String[] args) throws IOException{
		File fichero = new File ("FicheroDatos.dat");
		FileOutputStream fileout = new FileOutputStream (fichero);
		FileInputStream filein= new FileInputStream (fichero);
		DataInputStream dataIS = new DataInputStream (filein);
		String[] noms = {"Dani","Marc","Epumer"};
		String[] anys = {"20","20","21"};
		int i;
		for (i=1; i<100; i++) {
			fileout.write(i);
			fileout.close();
			while ((i=filein.read()) != -1) {
			System.out.println(i);
			filein.close();
			}
		}
	}
}
