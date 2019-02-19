
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
public class BDOO2_III {
	public static void main(String[] args) throws IOException {
		ODB odb= ODBFactory.open("EQUIPOS.DB");
		
		CriteriaQuery query = new CriteriaQuery (Jugadores.class);
		Objects<Jugadores> objects = odb.getObjects(query);
		
		for(Jugadores jugador : objects) {
			jugador.setEdad(jugador.getEdad()+1);
			System.out.printf("%s, %d, %n", jugador.getNombre(), jugador.getEdad());
			odb.store(jugador);
		}
		odb.commit();
		odb.close();    
	}
}
