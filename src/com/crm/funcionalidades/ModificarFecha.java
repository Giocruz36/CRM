package com.crm.funcionalidades;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.StringTokenizer;

public class ModificarFecha {

	public static String formateoDateAqui(Timestamp alli) {
		String cadena = alli.toString();
		StringTokenizer st = new StringTokenizer(cadena, " ");
		String fecha = st.nextToken();
		String hora = st.nextToken();
		StringTokenizer st2 = new StringTokenizer(fecha, "-");
		String anio = st2.nextToken();
		String mes = st2.nextToken();
		String dia = st2.nextToken();
		String aqui = dia + "/" + mes + "/" + anio + " " + hora;
		return aqui;
	} // Del formateoDateAqui

	public String escribirFecha(String aux) {
		String fechaFinal = "";
		String hora = "";
		StringTokenizer completo = new StringTokenizer(aux, " ");
		String fecha = completo.nextToken().toString();
		StringTokenizer st = new StringTokenizer(fecha, "-/");
		String dia = st.nextToken().toString();
		String mes = st.nextToken().toString();
		String anio = st.nextToken().toString();
		if (!completo.hasMoreTokens()) {
			Calendar actual = Calendar.getInstance();
			int horas = actual.get(Calendar.HOUR_OF_DAY);
			int minutos = actual.get(Calendar.MINUTE);
			int segundos = actual.get(Calendar.SECOND);
			String formatoHora = horas + ":" + minutos + ":" + segundos;
			fechaFinal = anio + "-" + mes + "-" + dia + " " + formatoHora;
		} // Del if
		else {
			hora = completo.nextToken().toString();
			StringTokenizer st2 = new StringTokenizer(hora, ":");
			String horas = st2.nextToken().toString();
			String minutos = st2.nextToken().toString();
			String segundos = st2.nextToken().toString();
			String formatoHora = horas + ":" + minutos + ":" + segundos;
			fechaFinal = anio + "-" + mes + "-" + dia + " " + formatoHora;
		} // Del else
		return fechaFinal;
	} // Del escribirfecha
} // Del class