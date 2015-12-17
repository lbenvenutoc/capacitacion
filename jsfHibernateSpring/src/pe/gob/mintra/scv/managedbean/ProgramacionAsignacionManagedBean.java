package pe.gob.mintra.scv.managedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Asignacion;
import pe.gob.mintra.scv.model.Evaluacion;
import pe.gob.mintra.scv.model.ProgramacionAsignacion;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.model.UsuarioPorCurso;
import pe.gob.mintra.scv.service.AsignacionService;
import pe.gob.mintra.scv.service.EvaluacionService;

@Controller
@Scope("session")
public class ProgramacionAsignacionManagedBean {

	@Autowired
	private AsignacionService asignacionService;
	@Autowired
	private EvaluacionService evaluacionService;
	private UnidadAprendizaje unidadAprendisaje;
	private List<ProgramacionAsignacion> lstProgAsig;
	private ProgramacionAsignacion objProgramacionAsignacion;
	private List<Asignacion> lstAsig;
	private Asignacion objAsignacion;
	private List<UsuarioPorCurso> lstUsuarioPorCurso;

	public ProgramacionAsignacionManagedBean() {
		unidadAprendisaje = new UnidadAprendizaje();
		unidadAprendisaje.setCodCur(23);
		unidadAprendisaje.setCodUniApr(25);
		inicializarProgramacionAsignacion();
		inicializarAsignacion();
	}

	public void inicializarProgramacionAsignacion() {

		objProgramacionAsignacion = new ProgramacionAsignacion();
		lstProgAsig = new ArrayList<ProgramacionAsignacion>();
	}

	public void inicializarAsignacion() {
		objAsignacion = new Asignacion();
		lstAsig = new ArrayList<Asignacion>();
	}

	public String administrarAsignacion() {
		inicializarProgramacionAsignacion();
		String vista = null;
		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		asignacionService.listarProgramacionAsignacion(unidadAprendisaje,
				outParameters);
		lstProgAsig = (List<ProgramacionAsignacion>) outParameters
				.get("lstProAsi");
		vista = "pretty:administrarAsignacion";
		return vista;
	}

	public String mostrarProgramacionAsignacion() {
		String vista = null;
		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		if (!objProgramacionAsignacion.getnCodProAsi().equals(-1)) {
			asignacionService.listarAsignacion(objProgramacionAsignacion,
					outParameters);
			lstAsig = (List<Asignacion>) outParameters.get("lstAsig");
		} else {
			inicializarProgramacionAsignacion();

		}
		vista = "pretty:programarAsignacion";
		return vista;
	}

	public void generarAsignacion() {
		HashMap<String, Object> outParametersUsuPorCur = new HashMap<String, Object>();

		evaluacionService.listarUsuarioPorCurso(unidadAprendisaje,
				outParametersUsuPorCur);
		lstUsuarioPorCurso = (List<UsuarioPorCurso>) outParametersUsuPorCur
				.get("lstUsuCur");
		Asignacion a = null;
		if (lstUsuarioPorCurso.size() > 0) {

			for (UsuarioPorCurso uc : lstUsuarioPorCurso) {
				a = new Asignacion();
				a.setvDesPer(uc.getvDesPer());
				lstAsig.add(a);
			}

		}
	}

	public List<ProgramacionAsignacion> getLstProgAsig() {
		return lstProgAsig;
	}

	public void setLstProgAsig(List<ProgramacionAsignacion> lstProgAsig) {
		this.lstProgAsig = lstProgAsig;
	}

	public ProgramacionAsignacion getObjProgramacionAsignacion() {
		return objProgramacionAsignacion;
	}

	public void setObjProgramacionAsignacion(
			ProgramacionAsignacion objProgramacionAsignacion) {
		this.objProgramacionAsignacion = objProgramacionAsignacion;
	}

	public List<Asignacion> getLstAsig() {
		return lstAsig;
	}

	public void setLstAsig(List<Asignacion> lstAsig) {
		this.lstAsig = lstAsig;
	}

	public Asignacion getObjAsignacion() {
		return objAsignacion;
	}

	public void setObjAsignacion(Asignacion objAsignacion) {
		this.objAsignacion = objAsignacion;
	}

	public List<UsuarioPorCurso> getLstUsuarioPorCurso() {
		return lstUsuarioPorCurso;
	}

	public void setLstUsuarioPorCurso(List<UsuarioPorCurso> lstUsuarioPorCurso) {
		this.lstUsuarioPorCurso = lstUsuarioPorCurso;
	}

}
