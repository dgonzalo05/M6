package JDBC_II;
import java.sql.*;
public class Problema1_2 {
	public static void main (String [] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo","austria","password");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			resul = dbmd.getColumns(null, "ejemplo", "depart", null);
			while (resul.next()){
				String nom = resul.getString("COLUMN_NAME");
				String tipus = resul.getString("TYPE_NAME");
				String tamany = resul.getString("COLUMN_SIZE");
				String nul = resul.getString("IS_NULLABLE");
				System.out.printf("Nombre: %s, Tipo: %s, Tamaño: %s, NULL: %s %n", nom,tipus,tamany, nul);
			}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
