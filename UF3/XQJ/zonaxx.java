package ll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
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

public class zonaxx {
	public static void main(String[] args) throws IOException {
		String inputNum = "";
		int num = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Introduce el número de la zona: ");
			inputNum = br.readLine();
			num = Integer.parseInt(inputNum);
		} catch (IOException e) {
			System.out.println("Número de zona inválida" + e.getMessage());
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

			/*
			 * Ejecutamos la siguiente consulta: “Devuelve todos los datos de los empleados
			 * del departamento 10 pero organizados según la estructura de los datos en el
			 * documento empleados.xml”
			 */
			consulta = conn.prepareExpression(
					"declare variable $x as xs:int external; " + 
					"for $prod in /productos/produc[cod_zona=$x] " + 
					"let $nombre_zona:=/zonas/zona[cod_zona = $prod/cod_zona]/nombre " + 
					"let $director:=/zonas/zona[cod_zona = $prod/cod_zona]/director " + 
					"return " + 
					"    <produc> " + 
					"        <cod_prod>{data($prod/cod_prod)}</cod_prod> " + 
					"        <denominación>{data($prod/denominacion)}</denominación> " + 
					"        <precio>{data($prod/precio)}</precio> " + 
					"        <nombre_zona>{data($nombre_zona)}</nombre_zona> " + 
					"        <director>{data($director)}</director> " + 
					"        <stock>{data($prod/stock_actual) - data($prod/stock_minimo)}</stock> " + 
					"    </produc>"
					);
			consulta.bindInt(new QName("x"), num, null);
			resultado = consulta.executeQuery();
			/* Escribimos los datos de la consulta en un fichero xml */
			BufferedWriter writer = new BufferedWriter(new FileWriter("zona"+num));
			/* Cabecera XML */
			writer.write("<?xml version='1.0' encoding='UTF-8'?>");
			writer.newLine();
			//cod_prod denominación precio nombre_zona director stock
			while (resultado.next()) {
				String cad = resultado.getItemAsString(null);
				writer.write(cad);
				writer.newLine();
			}
			conn.close();
			writer.close();
		} catch (XQException ex) {
			System.out.println("Error al operar" + ex.getMessage());
		}
	}
}