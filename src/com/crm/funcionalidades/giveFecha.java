package com.crm.funcionalidades;

import java.sql.Timestamp;
import java.util.StringTokenizer;

public class giveFecha {
	public String formateoDateAqui (Timestamp alli) {
		String cadena = alli.toString();
		StringTokenizer st = new StringTokenizer(cadena, " ");
		String fecha = st.nextToken();
		String hora=st.nextToken();
		StringTokenizer st2 = new StringTokenizer(fecha, "-");
		String anio=st2.nextToken();
		String mes=st2.nextToken();
		String dia=st2.nextToken();	
		
		
		String aqui = dia + "/" + mes+ "/" + anio + " " + hora;
		
		return aqui;
	}
}
