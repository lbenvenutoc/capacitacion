package pe.gob.mintra.scv.model;

import java.io.Serializable;


public class Curso implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6370353372526182828L;

	private Integer codigoCurso;

	private String nombreCurso;

	private String descripcionCurso;

	private String tipoCurso;

	private String modalidadPago;

	private String duracion;

	private String preRequisitos;

	private Integer creditos;

	public Curso() {
		codigoCurso = -1;
	}

	public Integer getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(Integer codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getDescripcionCurso() {
		return descripcionCurso;
	}

	public void setDescripcionCurso(String descripcionCurso) {
		this.descripcionCurso = descripcionCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public String getModalidadPago() {
		return modalidadPago;
	}

	public void setModalidadPago(String modalidadPago) {
		this.modalidadPago = modalidadPago;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(String preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Curso{" + "codigoCurso=" + codigoCurso + ", descripcionCurso="
				+ descripcionCurso + '}';
	}

}
