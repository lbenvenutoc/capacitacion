package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class Evaluacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -886448986386937316L;
	private Integer nCodEva;
	private Integer nCodProEva;
	private String vDesEva;
	private Integer vEstEva;
	private String vDesPer;

	public Evaluacion() {
		nCodEva = -1;
	}

	public Integer getnCodEva() {
		return nCodEva;
	}

	public void setnCodEva(Integer nCodEva) {
		this.nCodEva = nCodEva;
	}

	public String getvDesEva() {
		return vDesEva;
	}

	public void setvDesEva(String vDesEva) {
		this.vDesEva = vDesEva;
	}

	public Integer getvEstEva() {
		return vEstEva;
	}

	public void setvEstEva(Integer vEstEva) {
		this.vEstEva = vEstEva;
	}

	public String getvDesPer() {
		return vDesPer;
	}

	public void setvDesPer(String vDesPer) {
		this.vDesPer = vDesPer;
	}

	public Integer getnCodProEva() {
		return nCodProEva;
	}

	public void setnCodProEva(Integer nCodProEva) {
		this.nCodProEva = nCodProEva;
	}

}
