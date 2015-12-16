package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class UnidadAprendizaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3236290877235270795L;
	private Integer codCur;
	private Integer codUniApr;
	private Integer estUniApr;
	private boolean estaActivado;

	private String desUni;

	public UnidadAprendizaje() {
		codUniApr = -1;
		estaActivado = true;
	}

	public Integer getCodCur() {
		return codCur;
	}

	public void setCodCur(Integer codCur) {
		this.codCur = codCur;
	}

	public Integer getCodUniApr() {
		return codUniApr;
	}

	public void setCodUniApr(Integer codUniApr) {
		this.codUniApr = codUniApr;
	}

	public boolean isEstaActivado() {
		return estaActivado;
	}

	public void setEstaActivado(boolean estaActivado) {
		this.estaActivado = estaActivado;
	}

	public String getDesUni() {
		return desUni;
	}

	public void setDesUni(String desUni) {
		this.desUni = desUni;
	}

	public Integer getEstUniApr() {
		return estUniApr;
	}

	public void setEstUniApr(Integer estUniApr) {
		this.estUniApr = estUniApr;
	}
	

}
