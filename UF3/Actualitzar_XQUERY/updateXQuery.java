import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import net.xqj.exist.ExistXQDataSource;

public class updateXQuery {
	public static void main(String[] args) {
		try {
			XQDataSource server = new ExistXQDataSource();
			server.setProperty("serverName", "192.168.56.102");
			server.setProperty("port", "8080");
			server.setProperty("user", "admin");
			server.setProperty("password", "austria");
			// Configuramos conexión como hemos hecho en ocasiones anteriores
			XQConnection conn = server.getConnection();
			// Ejecutamos la expresión XQuery: actualiza el apellido del empleado con EMP_NO=7369 a 1009
			XQExpression consulta = conn.createExpression();
			String actual = "update value " +"/EMPLEADOS/EMP_ROW[EMP_NO=7369]/APELLIDO " +"with 'NuevoApellido'";
			consulta.executeCommand(actual);
		}
		catch (XQException e) {e.printStackTrace();
		}
	}
}

