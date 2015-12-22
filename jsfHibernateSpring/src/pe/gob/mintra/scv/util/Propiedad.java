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

	@Value("${agnd.subirarchivo.presentacion.extension}")
	private String presentacionExtension;

	@Value("${agnd.subirarchivo.presentacion.tamanoarchivo}")
	private String presentacionTamanio;

	@Value("${agnd.subirarchivo.presentacion.ruta}")
	private String presentacionRuta;

	@Value("${agnd.subirarchivo.presentacion.identificador}")
	private String presentacionIdentificador;

	@Value("${agnd.subirarchivo.cronograma.extension}")
	private String cronogramaExtension;

	@Value("${agnd.subirarchivo.cronograma.tamanoarchivo}")
	private String cronogramaTamanio;

	@Value("${agnd.subirarchivo.cronograma.ruta}")
	private String cronogramaRuta;

	@Value("${agnd.subirarchivo.cronograma.identificador}")
	private String cronogramaIdentificador;

	@Value("${agnd.subirarchivo.asignacion.extension}")
	private String asignacionExtension;

	@Value("${agnd.subirarchivo.asignacion.tamanoarchivo}")
	private String asignacionTamanio;

	@Value("${agnd.subirarchivo.asignacion.ruta}")
	private String asignacionRuta;

	@Value("${agnd.subirarchivo.asignacion.identificador}")
	private String asignacionIdentificador;

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

	public String getPresentacionExtension() {
		return presentacionExtension;
	}

	public void setPresentacionExtension(String presentacionExtension) {
		this.presentacionExtension = presentacionExtension;
	}

	public String getPresentacionTamanio() {
		return presentacionTamanio;
	}

	public void setPresentacionTamanio(String presentacionTamanio) {
		this.presentacionTamanio = presentacionTamanio;
	}

	public String getPresentacionRuta() {
		return presentacionRuta;
	}

	public void setPresentacionRuta(String presentacionRuta) {
		this.presentacionRuta = presentacionRuta;
	}

	public String getPresentacionIdentificador() {
		return presentacionIdentificador;
	}

	public void setPresentacionIdentificador(String presentacionIdentificador) {
		this.presentacionIdentificador = presentacionIdentificador;
	}

	public String getCronogramaExtension() {
		return cronogramaExtension;
	}

	public void setCronogramaExtension(String cronogramaExtension) {
		this.cronogramaExtension = cronogramaExtension;
	}

	public String getCronogramaTamanio() {
		return cronogramaTamanio;
	}

	public void setCronogramaTamanio(String cronogramaTamanio) {
		this.cronogramaTamanio = cronogramaTamanio;
	}

	public String getCronogramaRuta() {
		return cronogramaRuta;
	}

	public void setCronogramaRuta(String cronogramaRuta) {
		this.cronogramaRuta = cronogramaRuta;
	}

	public String getCronogramaIdentificador() {
		return cronogramaIdentificador;
	}

	public void setCronogramaIdentificador(String cronogramaIdentificador) {
		this.cronogramaIdentificador = cronogramaIdentificador;
	}

	public String getAsignacionExtension() {
		return asignacionExtension;
	}

	public void setAsignacionExtension(String asignacionExtension) {
		this.asignacionExtension = asignacionExtension;
	}

	public String getAsignacionTamanio() {
		return asignacionTamanio;
	}

	public void setAsignacionTamanio(String asignacionTamanio) {
		this.asignacionTamanio = asignacionTamanio;
	}
	
	public String getAsignacionRuta() {
		return asignacionRuta;
	}

	public void setAsignacionRuta(String asignacionRuta) {
		this.asignacionRuta = asignacionRuta;
	}

	public String getAsignacionIdentificador() {
		return asignacionIdentificador;
	}

	public void setAsignacionIdentificador(String asignacionIdentificador) {
		this.asignacionIdentificador = asignacionIdentificador;
	}

}
