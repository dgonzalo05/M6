
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
public class BDOO2_I {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ODB odb= ODBFactory.open("EQUIPOS.DB");
		System.out.println("Nombre del jugador: ");
		String nombre = br.readLine();
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("nombre",nombre));
		
		Objects<Jugadores> objetos = odb.getObjects(query);
		
		for(Jugadores jugador : objetos) {
			System.out.printf("%s, %s, %s, %d, %s, %n", jugador.getNombre(), jugador.getDeporte(), jugador.getCiudad(), jugador.getEdad(), jugador.getPais());
		}
		odb.close();    
	}
}
