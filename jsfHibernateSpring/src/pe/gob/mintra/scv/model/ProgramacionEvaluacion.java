package pe.gob.mintra.scv.model;

import java.util.Date;

public class ProgramacionEvaluacion {

	private Integer nCodProEva;
	private Date dFinProEva;
	private Date dFfiProEva;
	private Integer nEstProEva;

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

}
