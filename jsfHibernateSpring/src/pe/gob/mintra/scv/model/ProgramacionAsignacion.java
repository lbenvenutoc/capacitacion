package pe.gob.mintra.scv.model;

import java.io.Serializable;
import java.util.Date;

import pe.gob.mintra.scv.util.Utilitario;

public class ProgramacionAsignacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5616233657159949995L;

	private Integer nCodProAsi;
	private Integer nCodUsu;
	private Integer nCodUniApr;
	private Date dFinProAsi;
	private Date dFfiProAsi;
	private Integer nEstProAsi;
	private String vDesProAsi;
	private String vRutProAsi;
	private String vNomCur;
	private String vDesUni;
	private Integer nCanAsi;

	public ProgramacionAsignacion() {
		nCodProAsi = -1;
		dFinProAsi = Utilitario.fechaActual();
		dFfiProAsi = Utilitario.fechaActual();
	}

	public Integer getnCodProAsi() {
		return nCodProAsi;
	}

	public void setnCodProAsi(Integer nCodProAsi) {
		this.nCodProAsi = nCodProAsi;
	}

	public Date getdFinProAsi() {
		return dFinProAsi;
	}

	public void setdFinProAsi(Date dFinProAsi) {
		this.dFinProAsi = dFinProAsi;
	}

	public Date getdFfiProAsi() {
		return dFfiProAsi;
	}

	public void setdFfiProAsi(Date dFfiProAsi) {
		this.dFfiProAsi = dFfiProAsi;
	}

	public Integer getnEstProAsi() {
		return nEstProAsi;
	}

	public void setnEstProAsi(Integer nEstProAsi) {
		this.nEstProAsi = nEstProAsi;
	}

	public String getvDesProAsi() {
		return vDesProAsi;
	}

	public void setvDesProAsi(String vDesProAsi) {
		this.vDesProAsi = vDesProAsi;
	}

	public String getvRutProAsi() {
		return vRutProAsi;
	}

	public void setvRutProAsi(String vRutProAsi) {
		this.vRutProAsi = vRutProAsi;
	}

	public String getvNomCur() {
		return vNomCur;
	}

	public void setvNomCur(String vNomCur) {
		this.vNomCur = vNomCur;
	}

	public String getvDesUni() {
		return vDesUni;
	}

	public void setvDesUni(String vDesUni) {
		this.vDesUni = vDesUni;
	}

	public Integer getnCodUsu() {
		return nCodUsu;
	}

	public void setnCodUsu(Integer nCodUsu) {
		this.nCodUsu = nCodUsu;
	}

	public Integer getnCodUniApr() {
		return nCodUniApr;
	}

	public void setnCodUniApr(Integer nCodUniApr) {
		this.nCodUniApr = nCodUniApr;
	}

	public Integer getnCanAsi() {
		return nCanAsi;
	}

	public void setnCanAsi(Integer nCanAsi) {
		this.nCanAsi = nCanAsi;
	}
	
	

}
