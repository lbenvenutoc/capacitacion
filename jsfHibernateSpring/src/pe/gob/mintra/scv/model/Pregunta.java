package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class Pregunta implements Serializable {

	private static final long serialVersionUID = 771438939535744090L;

	private Integer codPre;
	private String desPre;

	public Pregunta() {
		codPre = -1;
	}

	public Integer getCodPre() {
		return codPre;
	}

	public void setCodPre(Integer codPre) {
		this.codPre = codPre;
	}

	public String getDesPre() {
		return desPre;
	}

	public void setDesPre(String desPre) {
		this.desPre = desPre;
	}

}
