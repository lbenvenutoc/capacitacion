package pe.gob.mintra.scv.service;

import java.util.Map;

import pe.gob.mintra.scv.model.Evaluacion;
import pe.gob.mintra.scv.model.ProgramacionEvaluacion;
import pe.gob.mintra.scv.model.UnidadAprendisaje;

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

}
