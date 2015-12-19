package pe.gob.mintra.scv.model;

import java.io.Serializable;
import java.util.Date;

public class TipoForo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6370353372526182828L;

	private Integer nCodTipoForo;
	private String vDesTipoForo;
	
	public TipoForo() {
		nCodTipoForo = -1;
		vDesTipoForo = "";
	}
	
	public Integer getnCodTipoForo() {
		return nCodTipoForo;
	}
	public void setnCodTipoForo(Integer nCodTipoForo) {
		this.nCodTipoForo = nCodTipoForo;
	}
	public String getvDesTipoForo() {
		return vDesTipoForo;
	}
	public void setvDesTipoForo(String vDesTipoForo) {
		this.vDesTipoForo = vDesTipoForo;
	}
		
}
