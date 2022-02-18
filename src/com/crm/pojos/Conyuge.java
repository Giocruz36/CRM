package com.crm.pojos;

import java.sql.Date;

public class Conyuge {
	// Personales e Hipoteca
	private String ape1, ape2, Nombre, dni_nie, profesion, domicilio, poblacion, finalidad, dir_vivi, tipo_vivi, nueva,
	estadocivil, regbienes, vinculo;
	private Date FechaNacim;
	private int idHipo, codpost, valadq, impcto, plazotl, cargas;
	private Boolean fijo, temporal, autonomo, otro;
	// DatosEco
	private int ingmesfi, ingmesva, gastos_alq, gastos_hip, otros_eco, valorotvivi, cargasotvivi, otrobienes,
			cargasotrosbienes,idEco;
	private Boolean prop, escrit, contratpriv, ot_eco,padres,alquileres;
	//DatosProfe
	private String nomemp,activemp,puesto,diremp,comentarios;
	private int tel,idProf;
	private float antig;
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
	public String getFinalidad() {
		return finalidad;
	}
	public void setFinalidad(String finalidad) {
		this.finalidad = finalidad;
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
	public Date getFechaNacim() {
		return FechaNacim;
	}
	public void setFechaNacim(Date fechaNacim) {
		FechaNacim = fechaNacim;
	}
	public int getIdHipo() {
		return idHipo;
	}
	public void setIdHipo(int idHipo) {
		this.idHipo = idHipo;
	}
	public int getCodpost() {
		return codpost;
	}
	public void setCodpost(int codpost) {
		this.codpost = codpost;
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
	public int getPlazotl() {
		return plazotl;
	}
	public void setPlazotl(int plazotl) {
		this.plazotl = plazotl;
	}
	public int getCargas() {
		return cargas;
	}
	public void setCargas(int cargas) {
		this.cargas = cargas;
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
	public int getIngmesfi() {
		return ingmesfi;
	}
	public void setIngmesfi(int ingmesfi) {
		this.ingmesfi = ingmesfi;
	}
	public int getIngmesva() {
		return ingmesva;
	}
	public void setIngmesva(int ingmesva) {
		this.ingmesva = ingmesva;
	}
	public int getGastos_alq() {
		return gastos_alq;
	}
	public void setGastos_alq(int gastos_alq) {
		this.gastos_alq = gastos_alq;
	}
	public int getGastos_hip() {
		return gastos_hip;
	}
	public void setGastos_hip(int gastos_hip) {
		this.gastos_hip = gastos_hip;
	}
	public int getOtros_eco() {
		return otros_eco;
	}
	public void setOtros_eco(int otros_eco) {
		this.otros_eco = otros_eco;
	}
	public int getValorotvivi() {
		return valorotvivi;
	}
	public void setValorotvivi(int valorotvivi) {
		this.valorotvivi = valorotvivi;
	}
	public int getCargasotvivi() {
		return cargasotvivi;
	}
	public void setCargasotvivi(int cargasotvivi) {
		this.cargasotvivi = cargasotvivi;
	}
	public int getOtrobienes() {
		return otrobienes;
	}
	public void setOtrobienes(int otrobienes) {
		this.otrobienes = otrobienes;
	}
	public int getCargasotrosbienes() {
		return cargasotrosbienes;
	}
	public void setCargasotrosbienes(int cargasotrosbienes) {
		this.cargasotrosbienes = cargasotrosbienes;
	}
	public int getIdEco() {
		return idEco;
	}
	public void setIdEco(int idEco) {
		this.idEco = idEco;
	}
	public Boolean getProp() {
		return prop;
	}
	public void setProp(Boolean prop) {
		this.prop = prop;
	}
	public Boolean getEscrit() {
		return escrit;
	}
	public void setEscrit(Boolean escrit) {
		this.escrit = escrit;
	}
	public Boolean getContratpriv() {
		return contratpriv;
	}
	public void setContratpriv(Boolean contratpriv) {
		this.contratpriv = contratpriv;
	}
	public Boolean getOt_eco() {
		return ot_eco;
	}
	public void setOt_eco(Boolean ot_eco) {
		this.ot_eco = ot_eco;
	}
	public Boolean getPadres() {
		return padres;
	}
	public void setPadres(Boolean padres) {
		this.padres = padres;
	}
	public Boolean getAlquileres() {
		return alquileres;
	}
	public void setAlquileres(Boolean alquileres) {
		this.alquileres = alquileres;
	}
	public String getNomemp() {
		return nomemp;
	}
	public void setNomemp(String nomemp) {
		this.nomemp = nomemp;
	}
	public String getActivemp() {
		return activemp;
	}
	public void setActivemp(String activemp) {
		this.activemp = activemp;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getDiremp() {
		return diremp;
	}
	public void setDiremp(String diremp) {
		this.diremp = diremp;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getIdProf() {
		return idProf;
	}
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	public float getAntig() {
		return antig;
	}
	public void setAntig(float antig) {
		this.antig = antig;
	}
	
	
}
