package pe.gob.mintra.scv.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Propiedad {

	@Value("${agnd.subirarchivo.silabo.extension}")
	private String silaboExtension;

	@Value("${agnd.subirarchivo.silabo.tamanoarchivo}")
	private String silaboTamanio;

	@Value("${agnd.subirarchivo.silabo.ruta}")
	private String silaboRuta;

	@Value("${agnd.subirarchivo.silabo.identificador}")
	private String silaboIdentificador;

	public String getSilaboExtension() {
		return silaboExtension;
	}

	public void setSilaboExtension(String silaboExtension) {
		this.silaboExtension = silaboExtension;
	}

	public String getSilaboTamanio() {
		return silaboTamanio;
	}

	public void setSilaboTamanio(String silaboTamanio) {
		this.silaboTamanio = silaboTamanio;
	}

	public String getSilaboRuta() {
		return silaboRuta;
	}

	public void setSilaboRuta(String silaboRuta) {
		this.silaboRuta = silaboRuta;
	}

	public String getSilaboIdentificador() {
		return silaboIdentificador;
	}

	public void setSilaboIdentificador(String silaboIdentificador) {
		this.silaboIdentificador = silaboIdentificador;
	}

}
