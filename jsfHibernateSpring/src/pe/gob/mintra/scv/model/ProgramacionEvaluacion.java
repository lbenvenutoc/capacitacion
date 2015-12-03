package pe.gob.mintra.scv.model;

import java.util.Date;

public class ProgramacionEvaluacion {

	private Integer nCodProEva;
	private Date dFinProEva;
	private Date dFfiProEva;
	private Integer nEstProEva;
	private Integer nCanProEva;
	private String vNomCur;
	private String vDesUni;

	public ProgramacionEvaluacion() {
		nCodProEva = -1;
	}

	public Integer getnCodProEva() {
		return nCodProEva;
	}

	public void setnCodProEva(Integer nCodProEva) {
		this.nCodProEva = nCodProEva;
	}

	public Date getdFinProEva() {
		return dFinProEva;
	}

	public void setdFinProEva(Date dFinProEva) {
		this.dFinProEva = dFinProEva;
	}

	public Date getdFfiProEva() {
		return dFfiProEva;
	}

	public void setdFfiProEva(Date dFfiProEva) {
		this.dFfiProEva = dFfiProEva;
	}

	public Integer getnEstProEva() {
		return nEstProEva;
	}

	public void setnEstProEva(Integer nEstProEva) {
		this.nEstProEva = nEstProEva;
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

	public Integer getnCanProEva() {
		return nCanProEva;
	}

	public void setnCanProEva(Integer nCanProEva) {
		this.nCanProEva = nCanProEva;
	}

	

}
