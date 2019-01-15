package JDBC_II;
import java.sql.*;
public class Problema1_3 {
	public static void main (String [] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo","austria","password");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			resul = dbmd.getPrimaryKeys("ejemplo", null, "depart");
			while (resul.next()){
				String p_key = resul.getString("COLUMN_NAME");
				System.out.printf("Nombre columna P_Key: %s", p_key);
			}
			resul = dbmd.getExportedKeys("ejemplo", null, "depart");
			while (resul.next()){
				String f_key = resul.getString("FKCOLUMN_NAME");
				System.out.printf("\nNombre columna F_Key: %s", f_key);
			}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
