package com.crm.persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class MisConexiones {
	private static Connection con;
	private static PreparedStatement ps;
	@SuppressWarnings("unused")
	private Statement st;
	private static ResultSet rs;
	@SuppressWarnings("unused")
	private String sentencia;
	@SuppressWarnings("unused")
	private String parametro;
	@SuppressWarnings("unused")
	private String parametro2;
	private static ConfigDir atrapo;

	public MisConexiones() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		atrapo = ConfigDir.getInstance();
		if (atrapo.getBooleanProperty("check"))
			Class.forName(atrapo.getProperty("driver")).newInstance();
	}

	public Connection getConexion() throws SQLException {
		return con;
	}

	public Connection dameConexion() throws SQLException {
		con = DriverManager.getConnection(atrapo.getProperty("cadena"), atrapo.getProperty("user"),
				atrapo.getProperty("conex"));
		return con;
	}

	public PreparedStatement damePSSimple(String sentencia) throws SQLException {
		this.sentencia = sentencia;
		ps = dameConexion().prepareStatement(sentencia);
		return ps;
	}

	public ResultSet dameResultSetSimple(String sentencia) throws SQLException {
		this.sentencia = sentencia;
		rs = damePSSimple(sentencia).executeQuery();
		return rs;
	}

	public PreparedStatement damePSSimple2(String sentencia, String d, String n, String a, int t, String m, String dr,
			String c, int cp, Timestamp fa, boolean c1, boolean c2) throws SQLException {
		this.sentencia = sentencia;
		ps = dameConexion().prepareStatement(sentencia);
		ps.setString(1, d);
		ps.setString(2, n);
		ps.setString(3, a);
		ps.setInt(4, t);
		ps.setString(5, m);
		ps.setString(6, dr);
		ps.setString(7, c);
		ps.setInt(8, cp);
		ps.setTimestamp(9, fa);
		ps.setBoolean(10, c1);
		ps.setBoolean(11, c2);
		return ps;
	}

	public PreparedStatement damePSSimple3(String sentencia, String a1, String a2, String n, String d, boolean c1,
			boolean c2, boolean c3, boolean c4, String pf, String dm, String pb, int cp, Timestamp fa,String fn, int vd, int im,
			int pt, String dr,String tv, int cg,boolean c5,String ec,String rb,String vc) throws SQLException {
		this.sentencia = sentencia;
		ps = dameConexion().prepareStatement(sentencia);
		ps.setString(1, a1);
		ps.setString(2, a2);
		ps.setString(3, n);
		ps.setString(4, d);
		ps.setBoolean(5, c1);
		ps.setBoolean(6, c2);
		ps.setBoolean(7, c3);
		ps.setBoolean(8, c4);
		ps.setString(9, pf);
		ps.setString(10, dm);
		ps.setString(11, pb);
		ps.setInt(12, cp);
		ps.setTimestamp(13, fa);
		ps.setString(14, fn);
		ps.setInt(15, vd);
		ps.setInt(16, im);
		ps.setInt(17, pt);
		ps.setString(18, dr);
		ps.setString(19, tv);
		ps.setInt(20, cg);
		ps.setBoolean(21,c5);
		ps.setString(22,ec);
		ps.setString(23,rb);
		ps.setString(24,vc);
		return ps;
	}

	public PreparedStatement actualizarUsuario(String sentencia, String n, String a, int t, String m, String dr,
			String c, int cp, Timestamp fa, boolean c1, boolean c2, int id) throws SQLException {
		this.sentencia = sentencia;
		ps = dameConexion().prepareStatement(sentencia);
		ps.setString(1, n);
		ps.setString(2, a);
		ps.setInt(3, t);
		ps.setString(4, m);
		ps.setString(5, dr);
		ps.setString(6, c);
		ps.setInt(7, cp);
		ps.setTimestamp(8, fa);
		ps.setBoolean(9, c1);
		ps.setBoolean(10, c2);
		ps.setInt(11, id);
		return ps;
	}

	public PreparedStatement Borrar(String sentencia, int id) throws SQLException {
		this.sentencia = sentencia;
		ps = dameConexion().prepareStatement(sentencia);
		ps.setInt(1, id);
		return ps;
	}

	public PreparedStatement insertarUsuario(String sentencia, String[] datos) throws SQLException {
		this.sentencia = sentencia;
		ps = dameConexion().prepareStatement(sentencia);
		ps.setString(1, datos[0]);
		ps.setString(2, datos[1]);
		ps.setInt(3, Integer.parseInt(datos[2]));
		return ps;
	} // Del insertarUsuario

	public PreparedStatement validarUser(String sentencia, String parametro, String parametro2, int parametro3)
			throws SQLException {
		this.sentencia = sentencia;
		this.parametro = parametro;
		this.parametro2 = parametro2;
		ps = dameConexion().prepareStatement(sentencia);
		ps.setString(1, parametro);
		ps.setString(2, parametro2);
		ps.setInt(3, parametro3);
		return ps;
	} // Del validarUser

	public void cierraConexion(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
