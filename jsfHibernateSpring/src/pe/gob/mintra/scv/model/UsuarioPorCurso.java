package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class UsuarioPorCurso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1756513345308790649L;
	private Integer nCodUsu;
	private Integer nCodCur;
	private Integer nCodPer;
	private String vDesPer;

	public Integer getnCodUsu() {
		return nCodUsu;
	}

	public void setnCodUsu(Integer nCodUsu) {
		this.nCodUsu = nCodUsu;
	}

	public Integer getnCodCur() {
		return nCodCur;
	}

	public void setnCodCur(Integer nCodCur) {
		this.nCodCur = nCodCur;
	}

	public Integer getnCodPer() {
		return nCodPer;
	}

	public void setnCodPer(Integer nCodPer) {
		this.nCodPer = nCodPer;
	}

	public String getvDesPer() {
		return vDesPer;
	}

	public void setvDesPer(String vDesPer) {
		this.vDesPer = vDesPer;
	}
	

}
