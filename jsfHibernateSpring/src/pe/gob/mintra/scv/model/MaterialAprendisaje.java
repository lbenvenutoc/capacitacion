package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class MaterialAprendisaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2206466282145121671L;

	private Integer nCodInd;
	private Integer nCodCur;
	private Integer nCodUniApr;
	private String vRutMatApr;
	private Integer nEstMatApr;
	
	public Integer getnCodInd() {
		return nCodInd;
	}
	public void setnCodInd(Integer nCodInd) {
		this.nCodInd = nCodInd;
	}
	public Integer getnCodCur() {
		return nCodCur;
	}
	public void setnCodCur(Integer nCodCur) {
		this.nCodCur = nCodCur;
	}
	public Integer getnCodUniApr() {
		return nCodUniApr;
	}
	public void setnCodUniApr(Integer nCodUniApr) {
		this.nCodUniApr = nCodUniApr;
	}
	public String getvRutMatApr() {
		return vRutMatApr;
	}
	public void setvRutMatApr(String vRutMatApr) {
		this.vRutMatApr = vRutMatApr;
	}
	public Integer getnEstMatApr() {
		return nEstMatApr;
	}
	public void setnEstMatApr(Integer nEstMatApr) {
		this.nEstMatApr = nEstMatApr;
	}
	
	

}
