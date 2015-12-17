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
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.model.UsuarioPorCurso;
import pe.gob.mintra.scv.model.UsuarioPorEvaluacion;
import pe.gob.mintra.scv.service.EvaluacionService;
import pe.gob.mintra.scv.service.PreguntaService;
import pe.gob.mintra.scv.util.Utilitario;

@Controller
@Scope("session")
public class ProgramacionEvaluacionManagedBean {

	@Autowired
	private EvaluacionService evaluacionService;
	@Autowired
	private PreguntaService preguntaService;

	private List<ProgramacionEvaluacion> lstProgEval;
	private List<Evaluacion> lstEvalQuitar;
	private UnidadAprendizaje unidadAprendisaje;
	private ProgramacionEvaluacion objProgramacionEvaluacion;
	private Evaluacion objEvaluacion;
	private List<Evaluacion> lstEval;
	private List<Pregunta> lstPregunta;
	private List<Opcion> lstOpcion;
	private List<UsuarioPorCurso> lstUsuarioPorCurso;

	public ProgramacionEvaluacionManagedBean() {
		unidadAprendisaje = new UnidadAprendizaje();
		unidadAprendisaje.setCodCur(23);
		unidadAprendisaje.setCodUniApr(25);
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

		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		if (!objProgramacionEvaluacion.getnCodProEva().equals(-1)) {
			evaluacionService.listarEvaluacion(objProgramacionEvaluacion,
					outParameters);
			lstEval = (List<Evaluacion>) outParameters.get("lstEva");
		} else {
			inicializarProgramacionEvaluacion();

		}
		vista = "pretty:programarEvaluacion";
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

	public void actualizarProgramacionEvaluacion() {
		System.out.println("actualizarProgramacionEvaluacion");
		HashMap<String, Object> outParametersProgramacion = new HashMap<String, Object>();
		HashMap<String, Object> outParametersEvaluacion = new HashMap<String, Object>();
		HashMap<String, Object> outParametersPregunta = new HashMap<String, Object>();
		HashMap<String, Object> outParametersOpcion = new HashMap<String, Object>();
		HashMap<String, Object> outParametersUsuEva = new HashMap<String, Object>();
		HashMap<String, Object> outParametersDetEva = new HashMap<String, Object>();
		String mensaje = "";
		int tipo = 0;

		try {

			if (objProgramacionEvaluacion.getdFinProEva().equals(null)
					|| objProgramacionEvaluacion.getdFinProEva().equals("")) {
				mensaje = "Ingrese una fecha y hora de inicio de la programación";
				tipo = 1;
			} else if (objProgramacionEvaluacion.getdFfiProEva().equals(null)
					|| objProgramacionEvaluacion.getdFfiProEva().equals("")) {
				mensaje = "Ingrese una fecha y hora de fin de la programación";
				tipo = 1;
			} else if (Utilitario.parteFecha(
					objProgramacionEvaluacion.getdFinProEva(), "dd/MM/yyyy")
					.before(Utilitario.fechaActual())) {
				mensaje = "La fecha de inicio no puede ser menor que la fecha actual";
				tipo = 1;
			} else if (!Utilitario.parteFecha(
					objProgramacionEvaluacion.getdFinProEva(), "dd/MM/yyyy")
					.equals(Utilitario.parteFecha(
							objProgramacionEvaluacion.getdFfiProEva(),
							"dd/MM/yyyy"))) {
				mensaje = "El día del examen debe ser el mismo tanto en fecha de inicio como en fecha final";
				tipo = 1;
			} else if (Utilitario.parteFecha(
					objProgramacionEvaluacion.getdFinProEva(), "hh/mm/ss")
					.equals(Utilitario.parteFecha(
							objProgramacionEvaluacion.getdFfiProEva(),
							"hh/mm/ss"))) {

				mensaje = "La hora inicio del examen no puede ser igual que la hora final del examen";
				tipo = 1;

			} else if (Utilitario.parteFecha(
					objProgramacionEvaluacion.getdFinProEva(), "hh/mm/ss")
					.after(Utilitario.parteFecha(
							objProgramacionEvaluacion.getdFfiProEva(),
							"hh/mm/ss"))) {

				mensaje = "La hora inicio del examen no puede ser mayor que la hora final del examen";
				tipo = 1;

			} else if (lstEval.size() <= 0) {
				mensaje = "Por favor debe generar las evaluaciones para los participantes";
				tipo = 1;
			} else {

				System.out.println("PASO VALIDACIONES");

				objProgramacionEvaluacion.setnCodUniApr(unidadAprendisaje
						.getCodUniApr());
				objProgramacionEvaluacion.setnCodCur(unidadAprendisaje
						.getCodCur());

				if (!objProgramacionEvaluacion.getnCodProEva().equals(-1)) {
					System.out.println("ACTUALIZA");
					evaluacionService.actualizarProgramacionEvaluacion(
							objProgramacionEvaluacion,
							outParametersProgramacion);
					for (Evaluacion eval : lstEvalQuitar) {
						evaluacionService.eliminarEvaluacion(eval,
								outParametersEvaluacion);

						System.out.println(outParametersEvaluacion
								.get("menErr"));
					}

				} else {
					evaluacionService.insertarProgramacionEvaluacion(
							unidadAprendisaje, objProgramacionEvaluacion,
							outParametersProgramacion);
					objProgramacionEvaluacion
							.setnCodProEva((Integer) outParametersProgramacion
									.get("codProEva"));

					preguntaService.listarPreguntas(unidadAprendisaje,
							outParametersPregunta);
					lstPregunta = (List<Pregunta>) outParametersPregunta
							.get("lstCur");
					Random random = new Random();
					int tamanoListaPregunta = 0;
					tamanoListaPregunta = lstPregunta.size();

					UsuarioPorEvaluacion usuarioEvaluacion = null;
					UsuarioPorCurso usuarioPorCurso = null;
					DetalleEvaluacion detalleEvaluacion = null;
					int i = 0;
					for (Evaluacion eval : lstEval) {
						eval.setnCodProEva(objProgramacionEvaluacion
								.getnCodProEva());
						eval.setvDesEva("Evaluacion de Java " + i);
						evaluacionService.insertarEvaluacion(eval,
								outParametersEvaluacion);
						eval.setnCodEva((Integer) outParametersEvaluacion
								.get("nCodEva"));
						usuarioPorCurso = new UsuarioPorCurso();
						usuarioPorCurso = lstUsuarioPorCurso.get(i);

						usuarioEvaluacion = new UsuarioPorEvaluacion();
						usuarioEvaluacion.setnCodEva(eval.getnCodEva());
						usuarioEvaluacion.setnCodPer(usuarioPorCurso
								.getnCodPer());
						usuarioEvaluacion
								.setnCodProEva(objProgramacionEvaluacion
										.getnCodProEva());
						usuarioEvaluacion.setnCodUsu(usuarioPorCurso
								.getnCodUsu());
						evaluacionService.insertarUsuarioPorEvaluacion(
								usuarioEvaluacion, outParametersUsuEva);

						detalleEvaluacion = new DetalleEvaluacion();
						detalleEvaluacion.setnCodEva(eval.getnCodEva());
						detalleEvaluacion
								.setnCodProEva(objProgramacionEvaluacion
										.getnCodProEva());

						if (tamanoListaPregunta > 0) {

							for (int j = 0; j < 10; j++) { // 10 PREGUNTAS
															// ALEATORIAS
															// POR ALUMNO PARA
															// EXAMEN
								Pregunta preg = lstPregunta.get(random
										.nextInt(tamanoListaPregunta));

								preguntaService.listarOpciones(preg,
										outParametersOpcion);
								lstOpcion = (List<Opcion>) outParametersOpcion
										.get("lstCur");

								for (Opcion o : lstOpcion) {
									detalleEvaluacion.setnCodPre(preg
											.getCodPre());
									detalleEvaluacion.setnCodOpc(o.getCodOpc());
								}

							}

						}

						evaluacionService.insertarDetalleEvaluacion(
								detalleEvaluacion, outParametersDetEva);

						i++;

					}

				}

				mensaje = "Programación de evaluación registrada correctamente";
				tipo = 3;

			}

		} catch (Exception ex) {
			mensaje = "Error genérico";
			tipo = 1;

		} finally {
			Utilitario.showFacesMessage(mensaje, tipo);
		}

	}

	public void quitarEvaluacion() {
		lstEvalQuitar.add(objEvaluacion);
		lstEval.remove(objEvaluacion);
	}

	public String eliminarProgramacionEvaluacion() {
		String vista = null;
		HashMap<String, Object> outParametersProgramacion = new HashMap<String, Object>();
		evaluacionService.eliminarProgramacionEvaluacion(
				objProgramacionEvaluacion, outParametersProgramacion);
		vista = programarEvaluacion();
		return vista;

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
