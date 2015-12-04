package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class DetalleEvaluacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4418118730895247737L;

	private Integer nCodEva;
	private Integer nCodProEva;
	private Integer nCodPre;
	private Integer nCodOpc;

	public Integer getnCodEva() {
		return nCodEva;
	}

	public void setnCodEva(Integer nCodEva) {
		this.nCodEva = nCodEva;
	}

	public Integer getnCodProEva() {
		return nCodProEva;
	}

	public void setnCodProEva(Integer nCodProEva) {
		this.nCodProEva = nCodProEva;
	}

	public Integer getnCodPre() {
		return nCodPre;
	}

	public void setnCodPre(Integer nCodPre) {
		this.nCodPre = nCodPre;
	}

	public Integer getnCodOpc() {
		return nCodOpc;
	}

	public void setnCodOpc(Integer nCodOpc) {
		this.nCodOpc = nCodOpc;
	}

}
