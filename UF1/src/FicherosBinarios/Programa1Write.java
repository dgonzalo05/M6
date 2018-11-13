package FicherosBinarios;

import java.io.IOException;

import java.io.*;

public class Programa1Write {

	public static void main (String[] args) throws IOException{
		File fichero = new File ("FicheroDatos.dat");
		FileOutputStream fileout = new FileOutputStream (fichero);
		DataOutputStream dataOS = new DataOutputStream (fileout);
		String[] noms = {"Dani","Marc","Epumer"};
		int[] anys = {20,20,21};
		int i;
		for (i=0; i < noms.length; i++) {
			dataOS.writeUTF(noms[i]);
			dataOS.writeInt(anys[i]);
		}
		fileout.close();
	}
}
