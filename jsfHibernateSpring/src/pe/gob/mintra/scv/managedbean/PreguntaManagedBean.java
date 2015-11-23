package pe.gob.mintra.scv.managedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Opcion;
import pe.gob.mintra.scv.model.Pregunta;
import pe.gob.mintra.scv.model.UnidadAprendisaje;
import pe.gob.mintra.scv.service.PreguntaService;

@Controller
@Scope("session")
public class PreguntaManagedBean {

	@Autowired
	private PreguntaService preguntaService;

	private List<Pregunta> lstPregunta;
	private List<Opcion> lstOpcion;
	private Pregunta objPregunta;
	private Opcion objOpcion;

	public PreguntaManagedBean() {
		inicializarPregunta();
		inicializarOpcion();
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
		UnidadAprendisaje unidadAprendisaje = new UnidadAprendisaje();
		unidadAprendisaje.setCodCur(1);
		unidadAprendisaje.setCodUniApr(1);
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
		if (objOpcion.getCodOpc().equals(-1)) {			
			lstOpcion.add(objOpcion);
		}else{
			for(Opcion o:lstOpcion){
				if(o.getCodOpc().equals(objOpcion)){
					o=objOpcion;
				}
			}
		}
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

}
