package com.crm.pojos;

import java.sql.Timestamp;

public class Encargos {
	private String receptor;
	private Timestamp fecha;
	private int expediente;
	private String cliente1;
	private String dni_nie;
	private String asunto;
	private String domicilio;
	private String cliente2;
	private String dni_nie2;
	
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public int getExpediente() {
		return expediente;
	}
	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}
	public String getCliente1() {
		return cliente1;
	}
	public void setCliente1(String cliente1) {
		this.cliente1 = cliente1;
	}
	public String getDni_nie() {
		return dni_nie;
	}
	public void setDni_nie(String dni_nie) {
		this.dni_nie = dni_nie;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getCliente2() {
		return cliente2;
	}
	public void setCliente2(String cliente2) {
		this.cliente2 = cliente2;
	}
	public String getDni_nie2() {
		return dni_nie2;
	}
	public void setDni_nie2(String dni_nie2) {
		this.dni_nie2 = dni_nie2;
	}
	
	
	
}
