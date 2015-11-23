package pe.gob.mintra.scv.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Opcion;
import pe.gob.mintra.scv.model.Pregunta;
import pe.gob.mintra.scv.model.UnidadAprendisaje;

public interface PreguntaDao {

	public void listarPreguntas(
			@Param("unidadAprendisaje") UnidadAprendisaje unidadAprendisaje,
			@Param("outParameters") Map<String, Object> outParameters);

	public void listarOpciones(@Param("pregunta") Pregunta pregunta,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarPregunta(@Param("pregunta") Pregunta pregunta,
			@Param("unidadAprendisaje") UnidadAprendisaje unidadAprendisaje,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarOpcion(@Param("pregunta") Pregunta pregunta,
			@Param("opcion") Opcion opcion,
			@Param("outParameters") Map<String, Object> outParameters);

}
