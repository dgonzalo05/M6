package SAX;

import org.xml.sax.helpers.DefaultHandler;

class GestionContenidoNumDiscos extends DefaultHandler {
	int discos = 0;
	public GestionContenidoNumDiscos(){
		super();
	}
	public void endElement (String uri, String nombre, String nombreC){
		if (nombre.equals("TITLE")) {
			discos++;
		}
	}
}