package BDOO;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class VisualizarPaises {
	public static void main(String[] args) {
		ODB odb = ODBFactory.open("EQUIPOS.DB");
		// recuperamos todos los objetos
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
		System.out.printf("%d Jugadores: %n", objects.size());
	
		int i = 1;
		while (objects.hasNext()) {
			// visualizar los objetos
			Jugadores jug = objects.next();
			System.out.printf("%d: %s, %s, %s, %o %n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad(), jug.getPais());
		}
		// Cerrar BD
		odb.close();
	}
}
