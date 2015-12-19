package pe.gob.mintra.scv.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Propiedad {

	@Value("${agnd.subirarchivo.extension}")
	private String extension;

	@Value("${agnd.subirarchivo.tamanoarchivo}")
	private String tamanio;

	@Value("${agnd.subirarchivo.mensaje}")
	private String mensaje;

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
