package pe.gob.mintra.scv.managedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mintra.scv.model.Opcion;
import pe.gob.mintra.scv.model.Pregunta;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.PreguntaService;
import pe.gob.mintra.scv.util.Utilitario;

@Controller
@Scope("session")
public class PreguntaManagedBean {

	@Autowired
	private PreguntaService preguntaService;

	private List<Pregunta> lstPregunta;
	private List<Opcion> lstOpcion;
	private Pregunta objPregunta;
	private Opcion objOpcion;
	private UnidadAprendizaje unidadAprendisaje;
	private List<Opcion> lstOpcionEliminados;

	public PreguntaManagedBean() {
		inicializarPregunta();
		inicializarOpcion();
		unidadAprendisaje = new UnidadAprendizaje();
		unidadAprendisaje.setCodCur(1);
		unidadAprendisaje.setCodUniApr(1);
		lstOpcionEliminados = new ArrayList<Opcion>();
	}

	public void inicializarPregunta() {
		lstPregunta = new ArrayList<Pregunta>();
		objPregunta = new Pregunta();

	}

	public void inicializarOpcion() {
		objOpcion = new Opcion();
	}

	public String administrarPregunta() {
		String vista = null;
		System.out.println("administrarPregunta");

		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		preguntaService.listarPreguntas(unidadAprendisaje, outParameters);
		lstPregunta = (List<Pregunta>) outParameters.get("lstCur");
		objPregunta = new Pregunta();
		lstOpcion = new ArrayList<Opcion>();
		vista = "pretty:administrarPregunta";
		return vista;

	}

	public String mostrarPregunta() {
		System.out.println("mostrarPregunta");
		String vista = null;
		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		if (!objPregunta.getCodPre().equals(-1)) {
			preguntaService.listarOpciones(objPregunta, outParameters);
			lstOpcion = (List<Opcion>) outParameters.get("lstCur");
		} else {
			inicializarPregunta();
			inicializarOpcion();
		}

		vista = "pretty:nuevaPregunta";
		return vista;
	}

	public void mostrarOpcion() {

		if (objOpcion.getCodOpc().equals(-1)) {
			System.out.println("Nuevo");
			objOpcion = new Opcion();
		}
	}

	public void actualizarOpcion() {
		String mensaje = "";
		int tipo = 0;
		boolean opcionTieneErrores = false;
		if (objOpcion.getDesOpc().equals("")
				|| objOpcion.getDesOpc().equals(null)) {
			mensaje = "Ingresar descripción de opción";
			tipo = 1;
			opcionTieneErrores = true;
		} else {
			if (objOpcion.getCodOpc().equals(-1)) {
				lstOpcion.add(objOpcion);
			} else {
				for (Opcion o : lstOpcion) {
					if (o.getCodOpc().equals(objOpcion)) {
						o = objOpcion;
					}
				}
			}

			opcionTieneErrores = false;
		}
		if (opcionTieneErrores == true) {
			Utilitario.showFacesMessage(mensaje, tipo);
		}

		Utilitario.setearParametro("opcionTieneErrores", opcionTieneErrores);

	}

	// @Transactional(rollbackFor = Exception.class)
	public void actualizarPregunta() {
		
		HashMap<String, Object> outParametersPregunta = new HashMap<String, Object>();
		HashMap<String, Object> outParametersOpcion = new HashMap<String, Object>();
		String mensaje = "";
		int tipo = 0;
		try {
			if (objPregunta.getDesPre().equals(null)
					|| objPregunta.getDesPre().equals("")) {
				mensaje = "Ingrese una descripción de pregunta";
				tipo = 1;
			} else if (lstOpcion.size() <= 4) {
				mensaje = "Debe ingresar cinco (5) opciones";
				tipo = 1;
			} else {
				if (objPregunta.getCodPre().equals(-1)) {
					int i = 1;
					preguntaService.insertarPregunta(objPregunta,
							unidadAprendisaje, outParametersPregunta);
					objPregunta.setCodPre((Integer) outParametersPregunta
							.get("codIns"));
					for (Opcion opcion : lstOpcion) {
						System.out.println("SE INSERTO PREGUNTA CON CODIGO: "
								+ objPregunta.getCodPre());
						opcion.setOpcCor(i);
						preguntaService.insertarOpcion(objPregunta, opcion,
								outParametersOpcion);
						System.out.println("Opcion " + i + " "
								+ outParametersOpcion.get("menErr"));
						i++;
					}
				} else {
					int i = 1;
					preguntaService.actualizarPregunta(objPregunta,
							outParametersPregunta);

					for (Opcion opcion : lstOpcion) {
						opcion.setOpcCor(i);
						if (!opcion.getCodOpc().equals(-1)) {
							preguntaService.actualizarOpcion(objPregunta,
									opcion, outParametersOpcion);
						} else {
							preguntaService.insertarOpcion(objPregunta, opcion,
									outParametersOpcion);
						}

						i++;
					}

					for (Opcion opcion : lstOpcionEliminados) {
						preguntaService.eliminarOpcion(objPregunta, opcion,
								outParametersOpcion);
					}

				}
				mensaje = "Pregunta ingresada correctamente";
				tipo = 3;

			}
		} catch (Exception ex) {
			mensaje = "Error genérico";
			tipo = 1;

		}finally{
			Utilitario.showFacesMessage(mensaje, tipo);
		}


	}

	public void quitarOpcion() {
		lstOpcionEliminados.add(objOpcion);
		lstOpcion.remove(objOpcion);
	}

	public void eliminarPregunta() {
		System.out.println("eliminarPregunta");
		HashMap<String, Object> outParameters = new HashMap<String, Object>();
		preguntaService.eliminarPregunta(objPregunta, outParameters);
		administrarPregunta();
	}

	public List<Pregunta> getLstPregunta() {
		return lstPregunta;
	}

	public void setLstPregunta(List<Pregunta> lstPregunta) {
		this.lstPregunta = lstPregunta;
	}

	public Pregunta getObjPregunta() {
		return objPregunta;
	}

	public void setObjPregunta(Pregunta objPregunta) {
		this.objPregunta = objPregunta;
	}

	public List<Opcion> getLstOpcion() {
		return lstOpcion;
	}

	public void setLstOpcion(List<Opcion> lstOpcion) {
		this.lstOpcion = lstOpcion;
	}

	public Opcion getObjOpcion() {
		return objOpcion;
	}

	public void setObjOpcion(Opcion objOpcion) {
		this.objOpcion = objOpcion;
	}

	public UnidadAprendizaje getUnidadAprendisaje() {
		return unidadAprendisaje;
	}

	public void setUnidadAprendisaje(UnidadAprendizaje unidadAprendisaje) {
		this.unidadAprendisaje = unidadAprendisaje;
	}

}
