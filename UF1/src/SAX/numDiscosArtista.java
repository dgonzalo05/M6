package SAX;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class numDiscosArtista {
	public static void main (String [] args)
	throws FileNotFoundException, IOException, SAXException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el nombre del autor: ");
		String autor = read.readLine();
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionContenidoDiscosArtista gestor = new GestionContenidoDiscosArtista(autor);
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource ("discoteca.xml");
		procesadorXML.parse(fileXML);
	}
}
