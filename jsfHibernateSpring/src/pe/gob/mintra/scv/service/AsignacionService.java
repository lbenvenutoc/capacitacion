package pe.gob.mintra.scv.service;

import java.util.Map;

import pe.gob.mintra.scv.model.ProgramacionAsignacion;
import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface AsignacionService {
	
	

	public void listarProgramacionAsignacion(
			UnidadAprendizaje unidadAprendisaje,
			Map<String, Object> outParameters);

	public void actualizarProgramacionAsignacion(
			ProgramacionAsignacion programacionAsignacion,
			Map<String, Object> outParameters);

	public void insertarProgramacionAsignacion(
			UnidadAprendizaje unidadAprendisaje,
			ProgramacionAsignacion programacionAsignacion,
			Map<String, Object> outParameters);

	public void eliminarProgramacionAsignacion(
			ProgramacionAsignacion programacionAsignacion,
			Map<String, Object> outParameters);
	
	public void listarAsignacion(
			ProgramacionAsignacion programacionAsignacion,
			Map<String, Object> outParameters);

}
