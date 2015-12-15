package pe.gob.mintra.scv.model;

import java.io.Serializable;
import java.util.Date;

public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6370353372526182828L;

	private Integer nCodCur;
	private String vNomCur;
	private String vRutPres;
	private String vRutSil;
	private String vRutCro;
	private Date dFecIniCur;
	private Date dFecFinCur;
	private Integer nEstCur;

	public Curso() {
		nCodCur = -1;
		vRutPres = "";
		vRutSil = "";
		vRutCro = "";
	}

	public Integer getnCodCur() {
		return nCodCur;
	}

	public void setnCodCur(Integer nCodCur) {
		this.nCodCur = nCodCur;
	}

	public String getvNomCur() {
		return vNomCur;
	}

	public void setvNomCur(String vNomCur) {
		this.vNomCur = vNomCur;
	}

	public String getvRutPres() {
		return vRutPres;
	}

	public void setvRutPres(String vRutPres) {
		this.vRutPres = vRutPres;
	}

	public String getvRutSil() {
		return vRutSil;
	}

	public void setvRutSil(String vRutSil) {
		this.vRutSil = vRutSil;
	}

	public String getvRutCro() {
		return vRutCro;
	}

	public void setvRutCro(String vRutCro) {
		this.vRutCro = vRutCro;
	}

	public Date getdFecIniCur() {
		return dFecIniCur;
	}

	public void setdFecIniCur(Date dFecIniCur) {
		this.dFecIniCur = dFecIniCur;
	}

	public Date getdFecFinCur() {
		return dFecFinCur;
	}

	public void setdFecFinCur(Date dFecFinCur) {
		this.dFecFinCur = dFecFinCur;
	}

	public Integer getnEstCur() {
		return nEstCur;
	}

	public void setnEstCur(Integer nEstCur) {
		this.nEstCur = nEstCur;
	}

}
