package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class UsuarioPorEvaluacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444628422804319698L;

	private Integer nCodPer;
	private Integer nCodEva;
	private Integer nCodUsu;
	private Integer nCodProEva;

	public Integer getnCodPer() {
		return nCodPer;
	}

	public void setnCodPer(Integer nCodPer) {
		this.nCodPer = nCodPer;
	}

	public Integer getnCodEva() {
		return nCodEva;
	}

	public void setnCodEva(Integer nCodEva) {
		this.nCodEva = nCodEva;
	}

	public Integer getnCodUsu() {
		return nCodUsu;
	}

	public void setnCodUsu(Integer nCodUsu) {
		this.nCodUsu = nCodUsu;
	}

	public Integer getnCodProEva() {
		return nCodProEva;
	}

	public void setnCodProEva(Integer nCodProEva) {
		this.nCodProEva = nCodProEva;
	}

}
