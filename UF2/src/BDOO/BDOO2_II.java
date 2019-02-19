
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
public class BDOO2_II {
	public static void main(String[] args) throws IOException {
		ODB odb= ODBFactory.open("EQUIPOS.DB");
		
		ICriterion criterio = new And()
				.add(Where.gt("edad", 14))
				.add(Where.lt("edad", 20));
		
		CriteriaQuery query = new CriteriaQuery (Jugadores.class, criterio);
		Objects<Jugadores> objects = odb.getObjects(query);
		
		for(Jugadores jugador : objects) {
			System.out.printf("%s, %s, %s, %d, %s, %n", jugador.getNombre(), jugador.getDeporte(), jugador.getCiudad(), jugador.getEdad(), jugador.getPais());
		}
		odb.close();    
	}
}
