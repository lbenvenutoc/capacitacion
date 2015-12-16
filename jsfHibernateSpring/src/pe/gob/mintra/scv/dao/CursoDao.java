package pe.gob.mintra.scv.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface CursoDao {

	public void listarCurso(@Param("curso") Curso curso,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarCurso(@Param("curso") Curso curso,
			@Param("outParameters") Map<String, Object> outParameters);

	public void actualizarCurso(@Param("curso") Curso curso,
			@Param("outParameters") Map<String, Object> outParameters);

	public void listarUnidad(@Param("curso") Curso curso,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarUnidad(@Param("curso") Curso curso,
			@Param("unidad") UnidadAprendizaje unidad,
			@Param("outParameters") Map<String, Object> outParameters);

	public void actualizarUnidad(@Param("unidad") UnidadAprendizaje unidad,
			@Param("outParameters") Map<String, Object> outParameters);

}
