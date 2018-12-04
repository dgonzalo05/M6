package SAX;
import java.io.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class numDiscos {
	public static void main (String [] args)
	throws FileNotFoundException, IOException, SAXException {
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionContenidoNumDiscos gestor = new GestionContenidoNumDiscos();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource ("discoteca.xml");
		procesadorXML.parse(fileXML);
		System.out.println("Hay "+gestor.discos+" discos");
	}
}