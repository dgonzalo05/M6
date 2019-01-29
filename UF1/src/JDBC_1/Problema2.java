package JDBC_1;

import java.sql.*;

public class Problema2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo", "austria","password");
			Statement stmt = conexion.createStatement();
			String sql = "SELECT * from emple join depart using(dept_no) where salario = (select MAX(salario) from emple);";
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