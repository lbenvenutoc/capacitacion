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
	// @ManagedProperty(value="#{cursoService}")

	@Autowired
	private CursoService cursoService;

	private List<Curso> lstCurso;
	private Curso objCurso;
	private Curso objCursoParam;

	private UnidadAprendizaje objUnidad;
	private List<UnidadAprendizaje> lstUnidad;

	public boolean muestraUnidad = false;

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

		if (objCurso.isEstaHabilitado()) {
			objCurso.setnEstCur(1);
		} else {
			objCurso.setnEstCur(0);
		}

		if (objCurso.getnCodCur().equals(-1)) {
			cursoService.insertarCurso(objCurso, outParametersCurso);
			objCurso.setnCodCur((Integer) outParametersCurso.get("nCodCur"));

		} else {
			cursoService.actualizarCurso(objCurso, outParametersCurso);

		}

		muestraUnidad = true;

		vista = mostrarCurso();
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
		HashMap<String, Object> outParametersUnidad = new HashMap<String, Object>();

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
			cursoService.actualizarUnidad(objUnidad, outParametersUnidad);
			System.out.println(outParametersUnidad.get("menErr"));
		}

		cursoService.listarUnidad(objCurso, outParametersUnidad);
		lstUnidad = (List<UnidadAprendizaje>) outParametersUnidad.get("lstUni");

		vista = mostrarAdministracionUnidad();

		return vista;
	}

	public void subirSilabo(FileUploadEvent event) {

		String nombreArchivo = "";
		nombreArchivo = objCurso.getnCodCur()
				+ propiedad.getSilaboIdentificador();
		nombreArchivo += "." + propiedad.getSilaboExtension();

		try {
			Utilitario.copiarArchivo(nombreArchivo, event.getFile()
					.getInputstream(), propiedad.getSilaboRuta());
		} catch (IOException e) {

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

}
