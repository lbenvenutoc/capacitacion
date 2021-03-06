package pe.gob.mintra.scv.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Opcion;
import pe.gob.mintra.scv.model.Pregunta;
import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface PreguntaService {

	public void listarPreguntas(UnidadAprendizaje unidadAprendisaje,
			Map<String, Object> outParameters);

	public void listarOpciones(Pregunta pregunta,
			Map<String, Object> outParameters);

	public void insertarPregunta(Pregunta pregunta,
			UnidadAprendizaje unidadAprendisaje,
			Map<String, Object> outParameters);

	public void insertarOpcion(Pregunta pregunta, Opcion opcion,
			Map<String, Object> outParameters);

	public void actualizarPregunta(Pregunta pregunta,
			Map<String, Object> outParameters);

	public void eliminarPregunta(Pregunta pregunta,
			Map<String, Object> outParameters);

	public void actualizarOpcion(Pregunta pregunta, Opcion opcion,
			Map<String, Object> outParameters);

	public void eliminarOpcion(Pregunta pregunta, Opcion opcion,
			Map<String, Object> outParameters);

}
