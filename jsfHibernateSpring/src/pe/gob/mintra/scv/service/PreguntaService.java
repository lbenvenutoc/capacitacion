package pe.gob.mintra.scv.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Opcion;
import pe.gob.mintra.scv.model.Pregunta;
import pe.gob.mintra.scv.model.UnidadAprendisaje;

public interface PreguntaService {

	public void listarPreguntas(UnidadAprendisaje unidadAprendisaje,
			Map<String, Object> outParameters);

	public void listarOpciones(Pregunta pregunta,
			Map<String, Object> outParameters);

	public void insertarPregunta(Pregunta pregunta,UnidadAprendisaje unidadAprendisaje,
			Map<String, Object> outParameters);

	public void insertarOpcion(Pregunta pregunta, Opcion opcion,
			Map<String, Object> outParameters);

}
