package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class UnidadAprendisaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3236290877235270795L;
	private Integer codCur;
	private Integer codUniApr;

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

}
