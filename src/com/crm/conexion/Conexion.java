package com.crm.conexion;

import java.sql.*;

public class Conexion {

	public Connection conexion = null;
	public Statement stmt = null;
	public ResultSet rs = null;

	public void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio_crm", "root", "root");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} // Del try-catch
	} // Del conectar

	public void ver() {
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("select * from cliente;");
			while (rs.next()) {
				System.out.println("ID_cliente: " + rs.getString(1)+ "\tDNI/NIE: " + rs.getString(2) + "\tNombre: " + rs.getString(3) + 
						"\tApellidos: "+ rs.getString(4) + "\tTlfn fijo: " + rs.getString(5)+
						"\tEmail: " + rs.getString(6) + "\tDireccion: " + rs.getString(7) + 
						"\tCiudad: " + rs.getString(8) + "\tCod_postal: " + rs.getString(9) + 
						"\tFecha_alta: " + rs.getString(10)+
						"\tResidente: " + rs.getString(11) + "\tAutonomo: " + rs.getString(12));
			} // Del while
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // Del try-catch
	} // Del ver
} // Del class