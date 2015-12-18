package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class Asignacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 851705795248230765L;

	private Integer nCodAsi;
	private Integer nCodUsu;
	private Integer nCodPer;
	private Integer nCodProAsi;
	private String vDesAsi;
	private String vRutAsi;
	private Double nCalAsi;
	private String vDesPer;

	public Asignacion() {
		nCodAsi = -1;
		vDesAsi = "";
		vRutAsi = "";
		nCalAsi = 0.0;
	}

	public Integer getnCodAsi() {
		return nCodAsi;
	}

	public void setnCodAsi(Integer nCodAsi) {
		this.nCodAsi = nCodAsi;
	}

	public Integer getnCodUsu() {
		return nCodUsu;
	}

	public void setnCodUsu(Integer nCodUsu) {
		this.nCodUsu = nCodUsu;
	}

	public Integer getnCodPer() {
		return nCodPer;
	}

	public void setnCodPer(Integer nCodPer) {
		this.nCodPer = nCodPer;
	}

	public Integer getnCodProAsi() {
		return nCodProAsi;
	}

	public void setnCodProAsi(Integer nCodProAsi) {
		this.nCodProAsi = nCodProAsi;
	}

	public String getvDesAsi() {
		return vDesAsi;
	}

	public void setvDesAsi(String vDesAsi) {
		this.vDesAsi = vDesAsi;
	}

	public String getvRutAsi() {
		return vRutAsi;
	}

	public void setvRutAsi(String vRutAsi) {
		this.vRutAsi = vRutAsi;
	}

	public Double getnCalAsi() {
		return nCalAsi;
	}

	public void setnCalAsi(Double nCalAsi) {
		this.nCalAsi = nCalAsi;
	}

	public String getvDesPer() {
		return vDesPer;
	}

	public void setvDesPer(String vDesPer) {
		this.vDesPer = vDesPer;
	}

}
