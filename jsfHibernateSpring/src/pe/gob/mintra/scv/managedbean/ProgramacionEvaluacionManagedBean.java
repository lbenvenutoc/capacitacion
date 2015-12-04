package pe.gob.mintra.scv.managedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.DetalleEvaluacion;
import pe.gob.mintra.scv.model.Evaluacion;
import pe.gob.mintra.scv.model.Opcion;
import pe.gob.mintra.scv.model.Pregunta;
import pe.gob.mintra.scv.model.ProgramacionEvaluacion;
import pe.gob.mintra.scv.model.UnidadAprendisaje;
import pe.gob.mintra.scv.model.UsuarioPorCurso;
import pe.gob.mintra.scv.model.UsuarioPorEvaluacion;
import pe.gob.mintra.scv.service.EvaluacionService;
import pe.gob.mintra.scv.service.PreguntaService;

@Controller
@Scope("session")
public class ProgramacionEvaluacionManagedBean {

	@Autowired
	private EvaluacionService evaluacionService;
	@Autowired
	private PreguntaService preguntaService;

	private List<ProgramacionEvaluacion> lstProgEval;
	private List<Evaluacion> lstEvalQuitar;
	private UnidadAprendisaje unidadAprendisaje;
	private ProgramacionEvaluacion objProgramacionEvaluacion;
	private Evaluacion objEvaluacion;
	private List<Evaluacion> lstEval;
	private List<Pregunta> lstPregunta;
	private List<Opcion> lstOpcion;
	private List<UsuarioPorCurso> lstUsuarioPorCurso;

	public ProgramacionEvaluacionManagedBean() {
		unidadAprendisaje = new UnidadAprendisaje();
		unidadAprendisaje.setCodCur(1);
		unidadAprendisaje.setCodUniApr(1);
		inicializarProgramacionEvaluacion();
		lstPregunta = new ArrayList<Pregunta>();
		lstOpcion = new ArrayList<Opcion>();
		lstUsuarioPorCurso = new ArrayList<UsuarioPorCurso>();
	}

	public void inicializarProgramacionEvaluacion() {
		lstProgEval = new ArrayList<ProgramacionEvaluacion>();
		objProgramacionEvaluacion = new ProgramacionEvaluacion();
		lstEval = new ArrayList<Evaluacion>();
		objEvaluacion = new Evaluacion();
		lstEvalQuitar = new ArrayList<Evaluacion>();
	}

	public String programarEvaluacion() {
		inicializarProgramacionEvaluacion();
		String vista = null;
		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		evaluacionService.listarProgramacionEvaluacion(unidadAprendisaje,
				outParameters);
		lstProgEval = (List<ProgramacionEvaluacion>) outParameters
				.get("lstProEva");
		vista = "pretty:administrarEvaluacion";
		return vista;
	}

	public String mostrarProgramacionEvaluacion() {
		String vista = null;
		vista = "pretty:programarEvaluacion";
		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		evaluacionService.listarEvaluacion(objProgramacionEvaluacion,
				outParameters);
		lstEval = (List<Evaluacion>) outParameters.get("lstEva");
		return vista;
	}

	public String rendirEvaluacion() {
		String vista = null;
		vista = "pretty:rendirEvaluacion";
		return vista;
	}

	public void generarEvaluacion() {
		HashMap<String, Object> outParametersUsuPorCur = new HashMap<String, Object>();

		evaluacionService.listarUsuarioPorCurso(unidadAprendisaje,
				outParametersUsuPorCur);
		lstUsuarioPorCurso = (List<UsuarioPorCurso>) outParametersUsuPorCur
				.get("lstUsuCur");
		Evaluacion e = null;
		if (lstUsuarioPorCurso.size() > 0) {

			for (UsuarioPorCurso uc : lstUsuarioPorCurso) {
				e = new Evaluacion();
				e.setvDesPer(uc.getvDesPer());
				lstEval.add(e);
			}

		}
	}

	public String actualizarProgramacionEvaluacion() {
		String vista = null;
		HashMap<String, Object> outParametersProgramacion = new HashMap<String, Object>();
		HashMap<String, Object> outParametersEvaluacion = new HashMap<String, Object>();
		HashMap<String, Object> outParametersPregunta = new HashMap<String, Object>();
		HashMap<String, Object> outParametersOpcion = new HashMap<String, Object>();
		HashMap<String, Object> outParametersUsuEva = new HashMap<String, Object>();
		HashMap<String, Object> outParametersDetEva = new HashMap<String, Object>();

		objProgramacionEvaluacion.setnCodUniApr(unidadAprendisaje
				.getCodUniApr());
		objProgramacionEvaluacion.setnCodCur(unidadAprendisaje.getCodCur());

		if (!objProgramacionEvaluacion.getnCodProEva().equals(-1)) {
			evaluacionService.actualizarProgramacionEvaluacion(
					objProgramacionEvaluacion, outParametersProgramacion);
			for (Evaluacion eval : lstEvalQuitar) {
				evaluacionService.eliminarEvaluacion(eval,
						outParametersEvaluacion);
			}

		} else {
			evaluacionService.insertarProgramacionEvaluacion(unidadAprendisaje,
					objProgramacionEvaluacion, outParametersProgramacion);
			objProgramacionEvaluacion
					.setnCodProEva((Integer) outParametersProgramacion
							.get("codProEva"));

			preguntaService.listarPreguntas(unidadAprendisaje,
					outParametersPregunta);
			lstPregunta = (List<Pregunta>) outParametersPregunta.get("lstCur");
			Random random = new Random();
			int tamanoListaPregunta = 0;
			tamanoListaPregunta = lstPregunta.size();

			UsuarioPorEvaluacion usuarioEvaluacion = null;
			UsuarioPorCurso usuarioPorCurso = null;
			DetalleEvaluacion detalleEvaluacion = null;
			int i = 0;
			for (Evaluacion eval : lstEval) {
				eval.setnCodProEva(objProgramacionEvaluacion.getnCodProEva());
				eval.setvDesEva("Evaluacion de Java " + i);
				evaluacionService.insertarEvaluacion(eval,
						outParametersEvaluacion);
				eval.setnCodEva((Integer) outParametersEvaluacion
						.get("nCodEva"));
				usuarioPorCurso = new UsuarioPorCurso();
				usuarioPorCurso = lstUsuarioPorCurso.get(i);

				usuarioEvaluacion = new UsuarioPorEvaluacion();
				usuarioEvaluacion.setnCodEva(eval.getnCodEva());
				usuarioEvaluacion.setnCodPer(usuarioPorCurso.getnCodPer());
				usuarioEvaluacion.setnCodProEva(objProgramacionEvaluacion
						.getnCodProEva());
				usuarioEvaluacion.setnCodUsu(usuarioPorCurso.getnCodUsu());
				evaluacionService.insertarUsuarioPorEvaluacion(
						usuarioEvaluacion, outParametersUsuEva);

				detalleEvaluacion = new DetalleEvaluacion();
				detalleEvaluacion.setnCodEva(eval.getnCodEva());
				detalleEvaluacion.setnCodProEva(objProgramacionEvaluacion
						.getnCodProEva());

				if (tamanoListaPregunta > 0) {

					for (int j = 0; j < 10; j++) { // 10 PREGUNTAS ALEATORIAS
													// POR ALUMNO PARA EXAMEN
						Pregunta preg = lstPregunta.get(random
								.nextInt(tamanoListaPregunta));

						preguntaService.listarOpciones(preg,
								outParametersOpcion);
						lstOpcion = (List<Opcion>) outParametersOpcion
								.get("lstCur");

						for (Opcion o : lstOpcion) {
							detalleEvaluacion.setnCodPre(preg.getCodPre());
							detalleEvaluacion.setnCodOpc(o.getCodOpc());
						}

					}

				}

				evaluacionService.insertarDetalleEvaluacion(detalleEvaluacion,
						outParametersDetEva);

				i++;

			}

		}

		return vista;
	}

	public void quitarEvaluacion() {
		lstEvalQuitar.add(objEvaluacion);
		lstEval.remove(objEvaluacion);
	}

	public void eliminarProgramacionEvaluacion() {
		HashMap<String, Object> outParametersProgramacion = new HashMap<String, Object>();
		evaluacionService.eliminarProgramacionEvaluacion(
				objProgramacionEvaluacion, outParametersProgramacion);

	}

	public List<ProgramacionEvaluacion> getLstProgEval() {
		return lstProgEval;
	}

	public void setLstProgEval(List<ProgramacionEvaluacion> lstProgEval) {
		this.lstProgEval = lstProgEval;
	}

	public ProgramacionEvaluacion getObjProgramacionEvaluacion() {
		return objProgramacionEvaluacion;
	}

	public void setObjProgramacionEvaluacion(
			ProgramacionEvaluacion objProgramacionEvaluacion) {
		this.objProgramacionEvaluacion = objProgramacionEvaluacion;
	}

	public List<Evaluacion> getLstEval() {
		return lstEval;
	}

	public void setLstEval(List<Evaluacion> lstEval) {
		this.lstEval = lstEval;
	}

	public Evaluacion getObjEvaluacion() {
		return objEvaluacion;
	}

	public void setObjEvaluacion(Evaluacion objEvaluacion) {
		this.objEvaluacion = objEvaluacion;
	}

}
