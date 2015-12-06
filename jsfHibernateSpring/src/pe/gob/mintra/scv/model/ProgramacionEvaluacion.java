package pe.gob.mintra.scv.model;

import java.io.Serializable;
import java.util.Date;

import pe.gob.mintra.scv.util.Utilitario;

public class ProgramacionEvaluacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1648678569824579047L;
	private Integer nCodProEva;
	private Date dFinProEva;
	private Date dFfiProEva;
	private Integer nEstProEva;
	private Integer nCanProEva;
	private String vNomCur;
	private String vDesUni;
	private Integer nCodUniApr;
	private Integer nCodCur;

	public ProgramacionEvaluacion() {
		nCodProEva = -1;
		dFinProEva = Utilitario.fechaActual();
		dFfiProEva = Utilitario.fechaActual();
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

	public Integer getnCodUniApr() {
		return nCodUniApr;
	}

	public void setnCodUniApr(Integer nCodUniApr) {
		this.nCodUniApr = nCodUniApr;
	}

	public Integer getnCodCur() {
		return nCodCur;
	}

	public void setnCodCur(Integer nCodCur) {
		this.nCodCur = nCodCur;
	}

}
