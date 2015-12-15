/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mintra.scv.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.Pregunta;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.util.Constante;

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
		HashMap<String, Object> outParametersUnidad = new HashMap<String, Object>();
		cursoService.listarUnidad(objCurso, outParametersUnidad);
		lstUnidad = (List<UnidadAprendizaje>) outParametersUnidad.get("lstUni");

		if (!lstUnidad.isEmpty()) {
			muestraUnidad = true;
		} else {
			muestraUnidad = false;
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
			muestraUnidad = true;
			// vista = buscarCurso();
		} else {
			cursoService.actualizarCurso(objCurso, outParametersCurso);
			// vista = mostrarCurso();
		}

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
		String vista = null;
		vista = "pretty:mostrarAdministrarUnidad";
		return vista;
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

}
