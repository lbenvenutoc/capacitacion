package pe.gob.mintra.scv.service;

import java.util.Map;
import pe.gob.mintra.scv.model.DetalleEvaluacion;
import pe.gob.mintra.scv.model.Evaluacion;
import pe.gob.mintra.scv.model.ProgramacionEvaluacion;
import pe.gob.mintra.scv.model.UnidadAprendisaje;
import pe.gob.mintra.scv.model.UsuarioPorEvaluacion;

public interface EvaluacionService {

	public void listarProgramacionEvaluacion(
			UnidadAprendisaje unidadAprendisaje,
			Map<String, Object> outParameters);

	public void listarEvaluacion(ProgramacionEvaluacion programacionEvaluacion,
			Map<String, Object> outParameters);

	public void actualizarProgramacionEvaluacion(
			ProgramacionEvaluacion programacionEvaluacion,
			Map<String, Object> outParameters);

	public void eliminarEvaluacion(Evaluacion evaluacion,
			Map<String, Object> outParameters);

	public void insertarEvaluacion(Evaluacion evaluacion,
			Map<String, Object> outParameters);

	public void insertarProgramacionEvaluacion(
			UnidadAprendisaje unidadAprendisaje,
			ProgramacionEvaluacion programacionEvaluacion,
			Map<String, Object> outParameters);

	public void listarUsuarioPorCurso(UnidadAprendisaje unidadAprendisaje,
			Map<String, Object> outParameters);

	public void insertarUsuarioPorEvaluacion(
			UsuarioPorEvaluacion usuarioEvaluacion,
			Map<String, Object> outParameters);

	public void insertarDetalleEvaluacion(DetalleEvaluacion detalleEvaluacion,
			Map<String, Object> outParameters);

	public void eliminarProgramacionEvaluacion(
			ProgramacionEvaluacion programacionEvaluacion,
			Map<String, Object> outParameters);

}
