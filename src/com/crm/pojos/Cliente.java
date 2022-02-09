package com.crm.pojos;

import java.sql.Timestamp;

public class Cliente {
	private int Id_cliente;
	private String Dni_nie;
	private String Nombre;
	private String Apellidos;
	private int Telefono_fijo;
	private String Email;
	private String Direccion_vivienda;
	private String Ciudad;
	private int CP;
	private Timestamp Fecha_alta;
	private Boolean residente;
	private Boolean autonomo;

	public int getId_cliente() {
		return Id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		Id_cliente = id_cliente;
	}

	public String getDni_nie() {
		return Dni_nie;
	}

	public void setDni_nie(String dni_nie) {
		Dni_nie = dni_nie;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getTelefono_fijo() {
		return Telefono_fijo;
	}

	public void setTelefono_fijo(int telefono_fijo) {
		Telefono_fijo = telefono_fijo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDireccion_vivienda() {
		return Direccion_vivienda;
	}

	public void setDireccion_vivienda(String direccion_vivienda) {
		Direccion_vivienda = direccion_vivienda;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}

	public Timestamp getFecha_alta() {
		return Fecha_alta;
	}

	public void setFecha_alta(Timestamp fecha_alta) {
		Fecha_alta = fecha_alta;
	}

	public Boolean getResidente() {
		return residente;
	}

	public void setResidente(Boolean residente) {
		this.residente = residente;
	}

	public Boolean getAutonomo() {
		return autonomo;
	}

	public void setAutonomo(Boolean autonomo) {
		this.autonomo = autonomo;
	}

}
