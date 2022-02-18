package com.crm.pojos;

import java.sql.Timestamp;

public class Hipoteca {
	private int id,codpost, valadq, impcto, plazoTot, cargas;
	private String ape1, ape2, Nombre, dni_nie, profesion, domicilio, poblacion, finalidad, dir_vivi, tipo_vivi, nueva,
			estadocivil, regbienes, vinculo;
	private Boolean fijo, temporal, autonomo, otro;
	private Timestamp Fecha_nac;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDni_nie() {
		return dni_nie;
	}

	public void setDni_nie(String dni_nie) {
		this.dni_nie = dni_nie;
	}

	public Boolean getFijo() {
		return fijo;
	}

	public void setFijo(Boolean fijo) {
		this.fijo = fijo;
	}

	public Boolean getTemporal() {
		return temporal;
	}

	public void setTemporal(Boolean temporal) {
		this.temporal = temporal;
	}

	public Boolean getAutonomo() {
		return autonomo;
	}

	public void setAutonomo(Boolean autonomo) {
		this.autonomo = autonomo;
	}

	public Boolean getOtro() {
		return otro;
	}

	public void setOtro(Boolean otro) {
		this.otro = otro;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCodpost() {
		return codpost;
	}

	public void setCodpost(int codpost) {
		this.codpost = codpost;
	}

	public Timestamp getFecha_nac() {
		return Fecha_nac;
	}

	public void setFecha_nac(Timestamp fecha_nac) {
		Fecha_nac = fecha_nac;
	}

	public String getfinalidad() {
		return finalidad;
	}

	public void setfinalidad(String finalidad) {
		this.finalidad = finalidad;
	}

	public int getValadq() {
		return valadq;
	}

	public void setValadq(int valadq) {
		this.valadq = valadq;
	}

	public int getImpcto() {
		return impcto;
	}

	public void setImpcto(int impcto) {
		this.impcto = impcto;
	}

	public int getPlazoTot() {
		return plazoTot;
	}

	public void setPlazoTot(int plazoTot) {
		this.plazoTot = plazoTot;
	}

	public String getDir_vivi() {
		return dir_vivi;
	}

	public void setDir_vivi(String dir_vivi) {
		this.dir_vivi = dir_vivi;
	}

	public String getTipo_vivi() {
		return tipo_vivi;
	}

	public void setTipo_vivi(String tipo_vivi) {
		this.tipo_vivi = tipo_vivi;
	}

	public int getCargas() {
		return cargas;
	}

	public void setCargas(int cargas) {
		this.cargas = cargas;
	}

	public String getNueva() {
		return nueva;
	}

	public void setNueva(String nueva) {
		this.nueva = nueva;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getRegbienes() {
		return regbienes;
	}

	public void setRegbienes(String regbienes) {
		this.regbienes = regbienes;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

}
