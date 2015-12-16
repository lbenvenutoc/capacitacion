package pe.gob.mintra.scv.service;

import java.util.Map;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface CursoService {

	public void listarCurso(Curso curso, Map<String, Object> outParameters);

	public void insertarCurso(Curso curso, Map<String, Object> outParameters);

	public void actualizarCurso(Curso curso, Map<String, Object> outParameters);

	public void listarUnidad(Curso curso, Map<String, Object> outParameters);

	public void insertarUnidad(Curso curso, UnidadAprendizaje unidad,
			Map<String, Object> outParameters);

	public void actualizarUnidad(UnidadAprendizaje unidad,
			Map<String, Object> outParameters);

}
