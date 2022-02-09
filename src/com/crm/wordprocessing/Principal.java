package com.crm.wordprocessing;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.crm.persistencias.ConfigDir;
import com.crm.persistencias.MisConexiones;

public class Principal {
	public ArrayList consultarNivel() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ArrayList niveles = new ArrayList();
		MisConexiones mc = null;
		mc = new MisConexiones();
		ResultSet rs;
		try {
			rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta11"));
			while (rs.next()) {
				String str1 = rs.getString("activemp");
				
				boolean alq = rs.getBoolean("alquileres");
				String str2 = new Boolean(alq).toString();
				
				String str3=  rs.getString("antiguedad");
				String str4 = rs.getString("ape1");
				String str5 = rs.getString("ape2");
				
				boolean au = rs.getBoolean("autonomo");
				String str6 = new Boolean(au).toString();	
				
				int cg = rs.getInt("cargas");
				String str7 = new Integer(cg).toString();
				
				int cgo = rs.getInt("cargasotrosbienes");
				String str8 = new Integer(cgo).toString();
				
				int cgv = rs.getInt("cargasotvivi");
				String str9 = new Integer(cgv).toString();
				
				boolean ctp = rs.getBoolean("contratpriv");
				String str10 = new Boolean(ctp).toString();
				
				int cp = rs.getInt("codpost");
				String str11 = new Integer(cp).toString();
				
				int crt = rs.getInt("impcto");
				String str12 = new Integer(crt).toString();
				
				String str13 = rs.getString("diremp");
				String str14 = rs.getString("dirvivi");
				String str15 = rs.getString("dni_nie");
				String str16 = rs.getString("domicilio");
				
				boolean esc = rs.getBoolean("escrit");
				String str17 = new Boolean(esc).toString();
				
				String str18 = rs.getString("estadocivil");
				
				Timestamp fcn = rs.getTimestamp("fecha_nac");
				String str19 = fcn.toString();
				
				boolean fj = rs.getBoolean("fijo");
				String str20 = new Boolean(fj).toString();
				
				int inf = rs.getInt("ingmesfi");
				String str21 = new Integer(inf).toString();
				
				String str22 = rs.getString("finalidad");
				
				int gsta = rs.getInt("gastos_alq");
				String str23 = new Integer(gsta).toString();
				
				int gsth = rs.getInt("gastos_hip");
				String str24 = new Integer(gsth).toString();
				
				String str25 = rs.getString("nombre");
				String str26 = rs.getString("nomemp");
				
				boolean nv = rs.getBoolean("nueva");
				String str27 = new Boolean(nv).toString();
				
				boolean ot = rs.getBoolean("otro");
				String str28 = new Boolean(ot).toString();
				
				int otb = rs.getInt("otrobienes");
				String str29 = new Integer(otb).toString();
				
				boolean otp = rs.getBoolean("ot");
				String str30 = new Boolean(otp).toString();
				
				boolean pd = rs.getBoolean("padres");
				String str31 = new Boolean(pd).toString();
				
				int plt = rs.getInt("plazoTot");
				String str32 = new Integer(plt).toString();
				
				String str33 = rs.getString("poblacion");
				String str34 = rs.getString("puesto");
				String str35 = rs.getString("profesion");
				
				boolean pop = rs.getBoolean("prop");
				String str36 = new Boolean(pop).toString();
				
				String str37 = rs.getString("regbienes");
				
				int tel = rs.getInt("tel");
				String str38 = new Integer(tel).toString();
				
				boolean tem = rs.getBoolean("temporal");
				String str39 = new Boolean(tem).toString();
				
				int vd = rs.getInt("valadq");
				String str40 = new Integer(vd).toString();
				
				int vlv = rs.getInt("valorotvivi");
				String str41 = new Integer(vlv).toString();
				
				int igv = rs.getInt("ingmesvar");
				String str42 = new Integer(igv).toString();
				
				String str43 = rs.getString("tipovivi");
				
				WordProcessing.createNewDocumentFromTemplate("credHipo.dotx");
				WordProcessing.typeTextAtBookmark("activemp", str1);
				WordProcessing.typeTextAtBookmark("activemp_conyu", str1);
				WordProcessing.typeTextAtBookmark("alquiler",str2);
				WordProcessing.typeTextAtBookmark("alquiler_conyu", str2);
				WordProcessing.typeTextAtBookmark("antig", "5");
				WordProcessing.typeTextAtBookmark("antiguo", str3);
				WordProcessing.typeTextAtBookmark("antiguo_conyu", str3);
				WordProcessing.typeTextAtBookmark("ape1", str4);
				WordProcessing.typeTextAtBookmark("ape1_conyu", str4);
				WordProcessing.typeTextAtBookmark("ape2", str5);
				WordProcessing.typeTextAtBookmark("ape2_conyu", str5);
				WordProcessing.typeTextAtBookmark("aut", str6);
				WordProcessing.typeTextAtBookmark("aut_conyu", str6);
				WordProcessing.typeTextAtBookmark("cargas", str7);
				WordProcessing.typeTextAtBookmark("cargasotrosbi", str8);
				WordProcessing.typeTextAtBookmark("cargasotrosbi_conyu", str8);
				WordProcessing.typeTextAtBookmark("cargasvivi", str9);
				WordProcessing.typeTextAtBookmark("cargasvivi_conyu", str9);
				WordProcessing.typeTextAtBookmark("contratpriv", str10);
				WordProcessing.typeTextAtBookmark("contratpriv_conyu", str10); 
				WordProcessing.typeTextAtBookmark("cp_conyu", str11);
				WordProcessing.typeTextAtBookmark("credito", str12);
				WordProcessing.typeTextAtBookmark("diremp", str13);
				WordProcessing.typeTextAtBookmark("diremp_conyu", str13);
				WordProcessing.typeTextAtBookmark("dirviv", str14);
				WordProcessing.typeTextAtBookmark("dni_nie", str15);
				WordProcessing.typeTextAtBookmark("dni_nie_conyu", str15);
				WordProcessing.typeTextAtBookmark("dom", str16);
				WordProcessing.typeTextAtBookmark("dom_conyu", str16);
				WordProcessing.typeTextAtBookmark("escritura", str17);
				WordProcessing.typeTextAtBookmark("escritura_conyu", str17);
				WordProcessing.typeTextAtBookmark("estadcivil", str18);
				WordProcessing.typeTextAtBookmark("estadcivil_conyu", str18);
				WordProcessing.typeTextAtBookmark("fechan", str19);
				WordProcessing.typeTextAtBookmark("fechan_conyu", str19);
				WordProcessing.typeTextAtBookmark("fijo", str20);
				WordProcessing.typeTextAtBookmark("fijo_conyu", str20);
				WordProcessing.typeTextAtBookmark("fijosmen", str21);
				WordProcessing.typeTextAtBookmark("fijosmen_conyu", str21);
				WordProcessing.typeTextAtBookmark("fin", str22);
				WordProcessing.typeTextAtBookmark("gastosalq", str23);
				WordProcessing.typeTextAtBookmark("gastosalq_conyu", str23);
				WordProcessing.typeTextAtBookmark("gastoshipo", str24);
				WordProcessing.typeTextAtBookmark("gastoshipo_conyu", str24);
				WordProcessing.typeTextAtBookmark("nombrecli", str25);
				WordProcessing.typeTextAtBookmark("nombrecli_conyu", str25);
				WordProcessing.typeTextAtBookmark("nomemp", str26);
				WordProcessing.typeTextAtBookmark("nomemp_conyu", str26);
				WordProcessing.typeTextAtBookmark("nueva", str27);
				WordProcessing.typeTextAtBookmark("otros", str28);
				WordProcessing.typeTextAtBookmark("otros_conyu", str28);
				WordProcessing.typeTextAtBookmark("otrosbipat", str29);
				WordProcessing.typeTextAtBookmark("otrosbipat_conyu", str29);
				WordProcessing.typeTextAtBookmark("otrosmas", str30);
				WordProcessing.typeTextAtBookmark("otrosmas_conyu", str30);
				WordProcessing.typeTextAtBookmark("otrospat", "56");
				WordProcessing.typeTextAtBookmark("otrospres", "57");
				WordProcessing.typeTextAtBookmark("otrospres_conyu", "58");
				WordProcessing.typeTextAtBookmark("padres", str31);
				WordProcessing.typeTextAtBookmark("padres_conyu", str31);
				WordProcessing.typeTextAtBookmark("plazotot", str32);
				WordProcessing.typeTextAtBookmark("pob", str33);
				WordProcessing.typeTextAtBookmark("pob_conyu", str33);
				WordProcessing.typeTextAtBookmark("posicion", str34);
				WordProcessing.typeTextAtBookmark("posicion_conyu", str34);
				WordProcessing.typeTextAtBookmark("prof", str35);
				WordProcessing.typeTextAtBookmark("prof_conyu", str35);
				WordProcessing.typeTextAtBookmark("propiedad", str36);
				WordProcessing.typeTextAtBookmark("propiedad_conyu", str36);
				WordProcessing.typeTextAtBookmark("regimen", str37);
				WordProcessing.typeTextAtBookmark("regimen_conyu", str37);
				WordProcessing.typeTextAtBookmark("telemp", str38);
				WordProcessing.typeTextAtBookmark("telemp_conyu", str38);
				WordProcessing.typeTextAtBookmark("tipo", str43);
				WordProcessing.typeTextAtBookmark("valad", str40);
				WordProcessing.typeTextAtBookmark("valorvivi", str41);
				WordProcessing.typeTextAtBookmark("valorvivi_conyu", str41);
				WordProcessing.typeTextAtBookmark("varmen",str42);
				WordProcessing.typeTextAtBookmark("varmen_conyu", str42);
				WordProcessing.typeTextAtBookmark("cp", str11);
				WordProcessing.typeTextAtBookmark("temp", str39);
				WordProcessing.typeTextAtBookmark("temp_conyu", str39);
				WordProcessing.exec();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return niveles;
	}

	

}
