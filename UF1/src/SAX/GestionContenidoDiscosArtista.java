package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenidoDiscosArtista extends DefaultHandler{
	int discos = 0;
	String autor;
	boolean existe = false;
	public GestionContenidoDiscosArtista(String autor){
		super();
		this.autor = autor;
	}
	public void endDocument(){
		if (discos == 0) {
			System.out.println("El autor "+autor+" no aparece en el archivo.");
		} else {
			System.out.println("Hay "+discos+" discos");
		}
	}
	public void startElement (String uri, String nombre, String nombreC, Attributes atts) {
		if (nombre.equals("ARTIST")) {
			existe = true;
		}
	}
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		if (existe) {
			String car = new String (ch, inicio, longitud);
			if (car.equals(autor)) {
				discos++;
			}
			existe = false;
		}
	}
}