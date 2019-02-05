import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Main {
	public static void main(String[] args) {
		// Crear instancias para almacenar en BD
	
		Paises p1 = new Paises(1, "España");
		Paises p2 = new Paises(2, "Francia");
		Paises p3 = new Paises(3, "Alemania");
		Paises p4 = new Paises(4, "Portugal");
		
		Jugadores j1 = new Jugadores("Maria", "voleibol", "Madrid", 14, p1);
		Jugadores j2 = new Jugadores("Miguel", "tenis", "Madrid", 15, p2);
		Jugadores j3 = new Jugadores("Mario", "baloncesto", "Guadalajara", 15, p3);
		Jugadores j4 = new Jugadores("Alicia", "tenis", "Madrid", 14, p4);
		
		// Abrir BD
		ODB odb = ODBFactory.open("EQUIPOS.DB");
		// Almacenamos objetos
		odb.store(p1);
		odb.store(p2);
		odb.store(p3);
		odb.store(p4);
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		
		odb.close();
	}
}
