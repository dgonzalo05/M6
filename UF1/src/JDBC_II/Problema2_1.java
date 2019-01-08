package JDBC_II;

import java.sql.*;
public class Problema2_1 {
	public static void main (String[] args){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.56.10/ejemplo","austria","password");
			String dep = args[0];
			String increment = args[1];
			String sql = String.format("UPDATE emple SET salario = salario + %s where dept_no = %s", increment, dep);
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("Filas afectadas: %d %n", filas);
			sentencia.close();
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}

