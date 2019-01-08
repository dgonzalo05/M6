package JDBC_II;
import java.sql.*;
public class Problema1_4{
	public static void main (String [] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo","austria","password");
			DatabaseMetaData dbmd = conexion.getMetaData();
			Statement stmt = conexion.createStatement();
			ResultSet resul = stmt.executeQuery("SELECT * FROM depart");
		    ResultSetMetaData rsmd = resul.getMetaData();
		    int numberOfColumns = rsmd.getColumnCount();
		    System.out.printf("Numero de Columnas: "+numberOfColumns);
		    for(int i = 1; i <= numberOfColumns; i++) {
		    	System.out.printf("\nTipo de columna: "+rsmd.getColumnTypeName(i));
		    }
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
