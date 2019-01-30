package JDBC_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Problema3 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce una localidad");
		String localidad = reader.readLine();
		try {
			//Realiza un programa que busque los departamentos de una localidad.  
			//departamentos asociados a dicha localidad y los empleados de dicho departamentos.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo", "austria","password");
			Statement stmt = conexion.createStatement();
			String sql = "SELECT * from depart join emple using(dept_no) where depart.loc = '"+localidad+"';";
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				System.out.printf("%s,%n", result.getString("apellido"));
				System.out.printf("%s,%n", result.getString("oficio"));
				System.out.printf("%d,%n \n", result.getInt("salario"));
			}
			result.close();
			stmt.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}