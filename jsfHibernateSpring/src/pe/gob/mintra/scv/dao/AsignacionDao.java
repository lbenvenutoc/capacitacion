package pe.gob.mintra.scv.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Asignacion;
import pe.gob.mintra.scv.model.ProgramacionAsignacion;
import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface AsignacionDao {

	public void listarProgramacionAsignacion(
			@Param("unidadAprendisaje") UnidadAprendizaje unidadAprendisaje,
			@Param("outParameters") Map<String, Object> outParameters);

	public void actualizarProgramacionAsignacion(
			@Param("programacionAsignacion") ProgramacionAsignacion programacionAsignacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarProgramacionAsignacion(			
			@Param("programacionAsignacion") ProgramacionAsignacion programacionAsignacion,
			@Param("unidadAprendisaje") UnidadAprendizaje unidadAprendisaje,
			@Param("outParameters") Map<String, Object> outParameters);

	public void eliminarProgramacionAsignacion(
			@Param("programacionAsignacion") ProgramacionAsignacion programacionAsignacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void listarAsignacion(
			@Param("programacionAsignacion") ProgramacionAsignacion programacionAsignacion,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarAsignacion(@Param("asignacion") Asignacion asignacion,
			@Param("outParameters") Map<String, Object> outParameters);
	
	public void eliminarAsignacion(
			@Param("asignacion") Asignacion asignacion,
			@Param("outParameters") Map<String, Object> outParameters);

}
