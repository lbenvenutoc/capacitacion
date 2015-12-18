package pe.gob.mintra.scv.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.dao.AsignacionDao;
import pe.gob.mintra.scv.model.Asignacion;
import pe.gob.mintra.scv.model.ProgramacionAsignacion;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.AsignacionService;

@Service("asignacionService")
public class AsignacionServiceImpl implements AsignacionService {

	@Autowired
	private AsignacionDao asignacionDao;

	@Override
	public void listarProgramacionAsignacion(
			UnidadAprendizaje unidadAprendisaje,
			Map<String, Object> outParameters) {
		asignacionDao.listarProgramacionAsignacion(unidadAprendisaje,
				outParameters);

	}

	@Override
	public void actualizarProgramacionAsignacion(
			ProgramacionAsignacion programacionAsignacion,
			Map<String, Object> outParameters) {
		asignacionDao.actualizarProgramacionAsignacion(programacionAsignacion,
				outParameters);

	}

	@Override
	public void insertarProgramacionAsignacion(
			ProgramacionAsignacion programacionAsignacion,
			UnidadAprendizaje unidadAprendisaje,
			Map<String, Object> outParameters) {
		asignacionDao.insertarProgramacionAsignacion(programacionAsignacion,
				unidadAprendisaje, outParameters);

	}

	@Override
	public void eliminarProgramacionAsignacion(
			ProgramacionAsignacion programacionAsignacion,
			Map<String, Object> outParameters) {
		asignacionDao.eliminarProgramacionAsignacion(programacionAsignacion,
				outParameters);

	}

	@Override
	public void listarAsignacion(ProgramacionAsignacion programacionAsignacion,
			Map<String, Object> outParameters) {
		asignacionDao.listarAsignacion(programacionAsignacion, outParameters);

	}

	@Override
	public void insertarAsignacion(Asignacion asignacion,
			Map<String, Object> outParameters) {
		asignacionDao.insertarAsignacion(asignacion, outParameters);

	}

	@Override
	public void eliminarAsignacion(Asignacion asignacion,
			Map<String, Object> outParameters) {
		asignacionDao.eliminarAsignacion(asignacion, outParameters);

	}

}
