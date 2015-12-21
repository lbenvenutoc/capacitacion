package pe.gob.mintra.scv.model;

import java.io.Serializable;
import java.util.Date;

public class Foro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6370353372526182828L;

	private Integer nCodForo;
	private String vDesForo;
	private Integer nCodTipForo;
	private Date dFechaIni;
	private Date dFechaFin;
	private Integer nEstForo;
	
	public Foro() {
		nCodForo = -1;
		vDesForo = "";
		nEstForo = 1;
	}

	public Integer getnCodForo() {
		return nCodForo;
	}

	public void setnCodForo(Integer nCodForo) {
		this.nCodForo = nCodForo;
	}

	public String getvDesForo() {
		return vDesForo;
	}

	public void setvDesForo(String vDesForo) {
		this.vDesForo = vDesForo;
	}

	public Integer getnCodTipForo() {
		return nCodTipForo;
	}

	public void setnCodTipForo(Integer nCodTipForo) {
		this.nCodTipForo = nCodTipForo;
	}

	public Date getdFechaIni() {
		return dFechaIni;
	}

	public void setdFechaIni(Date dFechaIni) {
		this.dFechaIni = dFechaIni;
	}

	public Date getdFechaFin() {
		return dFechaFin;
	}

	public void setdFechaFin(Date dFechaFin) {
		this.dFechaFin = dFechaFin;
	}

	public Integer getnEstForo() {
		return nEstForo;
	}

	public void setnEstForo(Integer nEstForo) {
		this.nEstForo = nEstForo;
	}
	
	
		
}
