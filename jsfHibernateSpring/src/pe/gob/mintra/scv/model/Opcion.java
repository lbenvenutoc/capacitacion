package pe.gob.mintra.scv.model;

import java.io.Serializable;

public class Opcion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3898335952952057325L;

	private Integer codOpc;
	private String desOpc;
	private Integer opcCor;
	private Pregunta pregunta;

	public Opcion() {
		codOpc = -1;
		pregunta = new Pregunta();
	}

	public Integer getCodOpc() {
		return codOpc;
	}

	public void setCodOpc(Integer codOpc) {
		this.codOpc = codOpc;
	}

	public String getDesOpc() {
		return desOpc;
	}

	public void setDesOpc(String desOpc) {
		this.desOpc = desOpc;
	}

	public Integer getOpcCor() {
		return opcCor;
	}

	public void setOpcCor(Integer opcCor) {
		this.opcCor = opcCor;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	

}
