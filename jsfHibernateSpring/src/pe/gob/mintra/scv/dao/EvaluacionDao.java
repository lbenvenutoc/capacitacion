package pe.gob.mintra.scv.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.DetalleEvaluacion;
import pe.gob.mintra.scv.model.Evaluacion;
import pe.gob.mintra.scv.model.ProgramacionEvaluacion;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.model.UsuarioPorEvaluacion;

public interface EvaluacionDao {

	public void listarProgramacionEvaluacion(
			@Param("unidadAprendisaje") UnidadAprendizaje unidadAprendisaje,
			@Param("outParameters") Map<String, Object> outParameters);

	public void listarEvaluacion(
			@Param("programacionEvaluacion") ProgramacionEvaluacion programacionEvaluacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void actualizarProgramacionEvaluacion(
			@Param("programacionEvaluacion") ProgramacionEvaluacion programacionEvaluacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void eliminarEvaluacion(@Param("evaluacion") Evaluacion evaluacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarEvaluacion(@Param("evaluacion") Evaluacion evaluacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarProgramacionEvaluacion(
			@Param("unidadAprendisaje") UnidadAprendizaje unidadAprendisaje,
			@Param("programacionEvaluacion") ProgramacionEvaluacion programacionEvaluacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void listarUsuarioPorCurso(
			@Param("unidadAprendisaje") UnidadAprendizaje unidadAprendisaje,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarUsuarioPorEvaluacion(
			@Param("usuarioEvaluacion") UsuarioPorEvaluacion usuarioEvaluacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarDetalleEvaluacion(
			@Param("detalleEvaluacion") DetalleEvaluacion detalleEvaluacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void eliminarProgramacionEvaluacion(
			@Param("programacionEvaluacion") ProgramacionEvaluacion programacionEvaluacion,
			@Param("outParameters") Map<String, Object> outParameters);

}
