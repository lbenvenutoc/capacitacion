package pe.gob.mintra.scv.managedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Asignacion;
import pe.gob.mintra.scv.model.ProgramacionAsignacion;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.model.UsuarioPorCurso;
import pe.gob.mintra.scv.service.AsignacionService;
import pe.gob.mintra.scv.service.EvaluacionService;
import pe.gob.mintra.scv.util.Utilitario;

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
	private List<Asignacion> lstAsigQuitar;
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
		lstAsigQuitar = new ArrayList<Asignacion>();
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
			lstAsig = (List<Asignacion>) outParameters.get("lstAsi");
		} else {
			inicializarProgramacionAsignacion();
			inicializarAsignacion();

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
				a.setnCodUsu(uc.getnCodUsu());
				a.setnCodPer(uc.getnCodPer());
				a.setvDesPer(uc.getvDesPer());
				if (!objProgramacionAsignacion.getnCodProAsi().equals(-1)) {
					a.setnCodProAsi(objProgramacionAsignacion.getnCodProAsi());
				}
				lstAsig.add(a);
			}

		}
	}

	public void quitarAsignacion() {
		lstAsigQuitar.add(objAsignacion);
		lstAsig.remove(objAsignacion);
	}

	public void actualizarProgramacionAsignacion() {
		HashMap<String, Object> outParametersProgAsig = new HashMap<String, Object>();
		HashMap<String, Object> outParametersAsig = new HashMap<String, Object>();
		String mensaje = "";
		int tipo = 0;

		try {

			if (objProgramacionAsignacion.getvDesProAsi().equals(null)
					|| objProgramacionAsignacion.getvDesProAsi().equals("")) {
				mensaje = "Ingrese la descripción de la programación de la asignación";
				tipo = 1;
			} else if (objProgramacionAsignacion.getdFinProAsi().after(
					objProgramacionAsignacion.getdFfiProAsi())) {
				mensaje = "La fecha final no puede ser menor que la fecha  de inicio";
				tipo = 1;
			} else if(lstAsig.isEmpty()){
				mensaje = "Debe generar las asignaciones para dicha programación";
				tipo = 1;
			}
			else {
				if (objProgramacionAsignacion.getnCodProAsi().equals(-1)) {
					objProgramacionAsignacion.setnCodCur(unidadAprendisaje
							.getCodCur());
					objProgramacionAsignacion.setnCodUniApr(unidadAprendisaje
							.getCodUniApr());
					asignacionService.insertarProgramacionAsignacion(
							objProgramacionAsignacion, unidadAprendisaje,
							outParametersProgAsig);

					System.out.println(outParametersProgAsig.get("menErr"));

					objProgramacionAsignacion
							.setnCodProAsi((Integer) outParametersProgAsig
									.get("codProAsi"));

					for (Asignacion asig : lstAsig) {
						asig.setnCodProAsi(objProgramacionAsignacion
								.getnCodProAsi());

						asignacionService.insertarAsignacion(asig,
								outParametersAsig);

					}

				} else {
					asignacionService.actualizarProgramacionAsignacion(
							objProgramacionAsignacion, outParametersProgAsig);

					for (Asignacion asigQuitar : lstAsigQuitar) {

						asignacionService.eliminarAsignacion(asigQuitar,
								outParametersAsig);

					}
					for (Asignacion asigInsertar : lstAsig) {

						asignacionService.insertarAsignacion(asigInsertar,
								outParametersAsig);

					}

				}

				mensaje = "Programación de asignación registrada correctamente";
				tipo = 3;

			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			mensaje = "Error genérico";
			tipo = 1;

		} finally {
			Utilitario.showFacesMessage(mensaje, tipo);
		}

	}

	public String eliminarProgramacionAsignacion() {
		String vista = null;
		HashMap<String, Object> outParametersProgAsig = new HashMap<String, Object>();
		asignacionService.eliminarProgramacionAsignacion(
				objProgramacionAsignacion, outParametersProgAsig);
		vista = administrarAsignacion();
		return vista;

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
