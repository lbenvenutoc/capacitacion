package pe.gob.mintra.scv.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.util.Propiedad;
import pe.gob.mintra.scv.util.Utilitario;

/**
 * 
 * @author LUIS BENVENUTO
 */
@Controller
@Scope("session")
public class CursoManagedBean implements Serializable {

	private static Logger logger = Logger.getLogger(CursoManagedBean.class);
	
	@Autowired
	private CursoService cursoService;

	private List<Curso> lstCurso;
	private Curso objCurso;
	private Curso objCursoParam;

	private UnidadAprendizaje objUnidad;
	private List<UnidadAprendizaje> lstUnidad;

	public boolean muestraUnidad = false;
	private String tipoDocumentoSubir;

	@Autowired
	private Propiedad propiedad;

	public CursoManagedBean() {
		inicializarCurso();
	}

	public void inicializarCurso() {

		objCurso = new Curso();
		objCursoParam = new Curso();
		lstCurso = new ArrayList<Curso>();

		objUnidad = new UnidadAprendizaje();
		lstUnidad = new ArrayList<UnidadAprendizaje>();
		tipoDocumentoSubir = "";
	}

	public String mostrarAdministrarCurso() {
		String vista = null;
		inicializarCurso();
		vista = "pretty:mostrarAdministrarCurso";
		return vista;
	}

	public String mostrarCurso() {
		String vista = null;

		if (objCurso.getnCodCur().equals(-1)) {
			muestraUnidad = false;
		} else {

			muestraUnidad = true;

		}

		vista = "pretty:mostrarCurso";
		return vista;
	}

	public String grabarCurso() {
		HashMap<String, Object> outParametersCurso = new HashMap<String, Object>();
		String vista = null;
		String mensaje = "";
		int tipo = 0;

		try {

			if (objCurso.getvNomCur().equals(null)
					|| objCurso.getvNomCur().equals("")) {
				mensaje = "Ingrese el nombre de curso";
				tipo = 1;
			} else if (objCurso.getvDesCur().equals(null)
					|| objCurso.getvDesCur().equals("")) {
				mensaje = "Ingrese la descripcion de curso";
				tipo = 1;
			} else if (objCurso.getdFecIniCur().after(objCurso.getdFecFinCur())) {
				mensaje = "La fecha final no puede ser mayor que la fecha inicial";
				tipo = 1;
			} else {

				if (objCurso.isEstaHabilitado()) {
					objCurso.setnEstCur(1);
				} else {
					objCurso.setnEstCur(0);
				}

				if (objCurso.getnCodCur().equals(-1)) {
					cursoService.insertarCurso(objCurso, outParametersCurso);
					objCurso.setnCodCur((Integer) outParametersCurso
							.get("nCodCur"));

				} else {
					cursoService.actualizarCurso(objCurso, outParametersCurso);

				}

				muestraUnidad = true;

				vista = mostrarCurso();

				mensaje = "Curso registrado correctamente";
				tipo = 3;

			}

		} catch (Exception e) {
			mensaje = "Error genérico";
			tipo = 1;
		} finally {
			Utilitario.showFacesMessage(mensaje, tipo);
		}

		return vista;

	}

	public String buscarCurso() {
		String vista = null;
		HashMap<String, Object> outParametersCurso = new HashMap<String, Object>();
		cursoService.listarCurso(objCursoParam, outParametersCurso);
		lstCurso = (List<Curso>) outParametersCurso.get("lstCur");
		for (Curso c : lstCurso) {
			if (c.getnEstCur() == 1) {
				c.setEstaHabilitado(true);
			} else {
				c.setEstaHabilitado(false);
			}
		}
		objCurso = new Curso();
		vista = "pretty:mostrarAdministrarCurso";
		return vista;

	}

	public String mostrarAdministracionUnidad() {
		objUnidad = new UnidadAprendizaje();
		HashMap<String, Object> outParametersUnidad = new HashMap<String, Object>();
		String vista = null;
		cursoService.listarUnidad(objCurso, outParametersUnidad);
		lstUnidad = (List<UnidadAprendizaje>) outParametersUnidad.get("lstUni");
		vista = "pretty:mostrarAdministrarUnidad";
		return vista;
	}

	public String mostrarUnidad() {
		String vista = null;

		if (!objUnidad.getCodUniApr().equals(-1)) {
			if (objUnidad.getEstUniApr() == 1) {
				objUnidad.setEstaActivado(true);
			} else {
				objUnidad.setEstaActivado(false);
			}
			objUnidad.setCodCur(objCurso.getnCodCur());

		} else {
			objUnidad = new UnidadAprendizaje();
		}

		vista = "pretty:mostrarUnidad";
		return vista;
	}

	public String grabarUnidad() {
		String vista = null;
		String mensaje = "";
		int tipo = 0;
		HashMap<String, Object> outParametersUnidad = new HashMap<String, Object>();

		try {

			if (objUnidad.getDesUni().equals(null)
					|| objUnidad.getDesUni().equals("")) {
				mensaje = "Ingrese la descripción de la unidad";
				tipo = 1;

			} else {
				if (objUnidad.isEstaActivado()) {
					objUnidad.setEstUniApr(1);
				} else {
					objUnidad.setEstUniApr(0);
				}

				if (objUnidad.getCodUniApr().equals(-1)) {
					cursoService.insertarUnidad(objCurso, objUnidad,
							outParametersUnidad);

					System.out.println(outParametersUnidad.get("menErr"));

				} else {
					cursoService.actualizarUnidad(objUnidad,
							outParametersUnidad);
					System.out.println(outParametersUnidad.get("menErr"));
				}

				
				vista = mostrarUnidad();

				mensaje = "Unidad registrada correctamente";
				tipo = 3;

			}

		} catch (Exception e) {
			mensaje = "Error genérico";
			tipo = 1;

		} finally {
			Utilitario.showFacesMessage(mensaje, tipo);
		}

		return vista;
	}

	public void subirArchivo(FileUploadEvent event) {

		HashMap<String, Object> outParametersCurso = new HashMap<String, Object>();
		String nombreArchivo = "";
		String identificador = "";
		String extension = "";
		String ruta = "";

		try {

			if (tipoDocumentoSubir.equals("SIL")) {
				identificador = propiedad.getSilaboIdentificador();
				extension = propiedad.getSilaboExtension();
				ruta = propiedad.getSilaboRuta();
			} else if (tipoDocumentoSubir.equals("PRE")) {
				identificador = propiedad.getPresentacionIdentificador();
				extension = propiedad.getPresentacionExtension();
				ruta = propiedad.getPresentacionRuta();
			} else {
				identificador = propiedad.getCronogramaIdentificador();
				extension = propiedad.getCronogramaExtension();
				ruta = propiedad.getCronogramaRuta();
			}

			nombreArchivo = objCurso.getnCodCur() + identificador + "."
					+ extension;

			if (tipoDocumentoSubir.equals("SIL")) {
				objCurso.setvRutSil(nombreArchivo);
			} else if (tipoDocumentoSubir.equals("PRE")) {
				objCurso.setvRutPres(nombreArchivo);
			} else {
				objCurso.setvRutCro(nombreArchivo);
			}

			cursoService.actualizarCurso(objCurso, outParametersCurso);

			Utilitario.copiarArchivo(nombreArchivo, event.getFile()
					.getInputstream(), ruta);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		buscarCurso();

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
			} else {
				extension = propiedad.getCronogramaExtension();
				ruta = propiedad.getCronogramaRuta();
				nombreArchivo = objCurso.getvRutCro();
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

	public List<Curso> getLstCurso() {
		return lstCurso;
	}

	public void setLstCurso(List<Curso> lstCurso) {
		this.lstCurso = lstCurso;
	}

	public Curso getObjCursoParam() {
		return objCursoParam;
	}

	public void setObjCursoParam(Curso objCursoParam) {
		this.objCursoParam = objCursoParam;
	}

	public UnidadAprendizaje getObjUnidad() {
		return objUnidad;
	}

	public void setObjUnidad(UnidadAprendizaje objUnidad) {
		this.objUnidad = objUnidad;
	}

	public List<UnidadAprendizaje> getLstUnidad() {
		return lstUnidad;
	}

	public void setLstUnidad(List<UnidadAprendizaje> lstUnidad) {
		this.lstUnidad = lstUnidad;
	}

	public boolean isMuestraUnidad() {
		return muestraUnidad;
	}

	public void setMuestraUnidad(boolean muestraUnidad) {
		this.muestraUnidad = muestraUnidad;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public String getTipoDocumentoSubir() {
		return tipoDocumentoSubir;
	}

	public void setTipoDocumentoSubir(String tipoDocumentoSubir) {
		this.tipoDocumentoSubir = tipoDocumentoSubir;
	}

}
