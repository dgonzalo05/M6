package ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.namespace.QName;
//import javax.xml.xquery.;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class tipo_depart {
	public static void main(String[] args) {
		String depart = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Introduce el tipo de departamento: ");
			depart = br.readLine();
		}catch(IOException e) {
			System.out.println("departamento inválido" + e.getMessage());
		}
		try {
			
			XQDataSource server = new ExistXQDataSource();
			server.setProperty("serverName", "192.168.56.102");
			server.setProperty("port", "8080");
			server.setProperty("user", "admin");
			server.setProperty("password", "austria");
			XQConnection conn = server.getConnection();
			XQPreparedExpression consulta;
			XQResultSequence resultado;
			
			consulta = conn.prepareExpression("declare variable $x as xs:string external;"+"/universidad/departamento[@tipo=$x]");
			consulta.bindString(new QName("x"),depart,null);
			resultado=consulta.executeQuery();
			if(resultado.next() == false){
				System.out.println("No hay departamentos con éste tipo");
			}
			while(resultado.next())
			{
				System.out.println("Element E2: " + resultado.getItemAsString(null));
			}
			conn.close();
		} catch (XQException ex) {
			System.out.println("Error al operar" + ex.getMessage());
		}
	}
}