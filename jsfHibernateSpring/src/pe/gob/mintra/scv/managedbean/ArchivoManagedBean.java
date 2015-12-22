package pe.gob.mintra.scv.managedbean;

import java.io.IOException;
import java.util.HashMap;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.ProgramacionAsignacion;
import pe.gob.mintra.scv.service.AsignacionService;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.util.Propiedad;
import pe.gob.mintra.scv.util.Utilitario;

@Controller
@Scope("session")
public class ArchivoManagedBean {

	private String tipoDocumentoSubir;
	private Curso objCurso;
	private ProgramacionAsignacion objAdmAsig;

	@Autowired
	private Propiedad propiedad;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private AsignacionService asignacionService;

	public ArchivoManagedBean() {

	}

	public void subirArchivo(FileUploadEvent event) {

		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		String nombreArchivo = "";
		String identificador = "";
		String extension = "";
		String ruta = "";
		Integer codigoDocumento = 0;
		try {

			if (tipoDocumentoSubir.equals("SIL")) {
				identificador = propiedad.getSilaboIdentificador();
				extension = propiedad.getSilaboExtension();
				ruta = propiedad.getSilaboRuta();
				codigoDocumento = objCurso.getnCodCur();
			} else if (tipoDocumentoSubir.equals("PRE")) {
				identificador = propiedad.getPresentacionIdentificador();
				extension = propiedad.getPresentacionExtension();
				ruta = propiedad.getPresentacionRuta();
				codigoDocumento = objCurso.getnCodCur();
			} else if (tipoDocumentoSubir.equals("CRO")) {
				identificador = propiedad.getCronogramaIdentificador();
				extension = propiedad.getCronogramaExtension();
				ruta = propiedad.getCronogramaRuta();
				codigoDocumento = objCurso.getnCodCur();
			} else if (tipoDocumentoSubir.equals("ASIG")) {
				identificador = propiedad.getAsignacionIdentificador();
				extension = propiedad.getAsignacionExtension();
				ruta = propiedad.getAsignacionRuta();
				codigoDocumento = objAdmAsig.getnCodProAsi();
			}

			nombreArchivo = codigoDocumento + identificador + "." + extension;

			if (tipoDocumentoSubir.equals("SIL")) {
				objCurso.setvRutSil(nombreArchivo);
				cursoService.actualizarCurso(objCurso, outParameters);
			} else if (tipoDocumentoSubir.equals("PRE")) {
				objCurso.setvRutPres(nombreArchivo);
				cursoService.actualizarCurso(objCurso, outParameters);
			} else if (tipoDocumentoSubir.equals("CRO")) {
				objCurso.setvRutCro(nombreArchivo);
				cursoService.actualizarCurso(objCurso, outParameters);
			} else if (tipoDocumentoSubir.equals("ASIG")) {
				objAdmAsig.setvRutProAsi(nombreArchivo);
				asignacionService.actualizarProgramacionAsignacion(objAdmAsig,
						outParameters);
			}

			Utilitario.copiarArchivo(nombreArchivo, event.getFile()
					.getInputstream(), ruta);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void mostrarArchivo() {
		String ruta = "";
		String extension = "";
		String nombreArchivo = "";
		try {
			if (tipoDocumentoSubir.equals("SIL")) {
				extension = propiedad.getSilaboExtension();
				ruta = propiedad.getSilaboRuta();
				nombreArchivo = objCurso.getvRutSil();
			} else if (tipoDocumentoSubir.equals("PRE")) {
				extension = propiedad.getPresentacionExtension();
				ruta = propiedad.getPresentacionRuta();
				nombreArchivo = objCurso.getvRutPres();
			} else if (tipoDocumentoSubir.equals("CRO")) {
				extension = propiedad.getCronogramaExtension();
				ruta = propiedad.getCronogramaRuta();
				nombreArchivo = objCurso.getvRutCro();
			} else if (tipoDocumentoSubir.equals("ASIG")) {
				extension = propiedad.getAsignacionExtension();
				ruta = propiedad.getAsignacionRuta();
				nombreArchivo = objAdmAsig.getvRutProAsi();
			}
			Utilitario.mostrarArchivo(ruta, nombreArchivo, extension);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public Curso getObjCurso() {
		return objCurso;
	}

	public void setObjCurso(Curso objCurso) {
		this.objCurso = objCurso;
	}

	public String getTipoDocumentoSubir() {
		return tipoDocumentoSubir;
	}

	public void setTipoDocumentoSubir(String tipoDocumentoSubir) {
		this.tipoDocumentoSubir = tipoDocumentoSubir;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public ProgramacionAsignacion getObjAdmAsig() {
		return objAdmAsig;
	}

	public void setObjAdmAsig(ProgramacionAsignacion objAdmAsig) {
		this.objAdmAsig = objAdmAsig;
	}

}
