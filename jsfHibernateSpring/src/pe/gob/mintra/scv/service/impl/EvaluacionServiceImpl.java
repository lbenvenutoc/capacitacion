package pe.gob.mintra.scv.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.dao.EvaluacionDao;
import pe.gob.mintra.scv.model.DetalleEvaluacion;
import pe.gob.mintra.scv.model.Evaluacion;
import pe.gob.mintra.scv.model.ProgramacionEvaluacion;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.model.UsuarioPorEvaluacion;
import pe.gob.mintra.scv.service.EvaluacionService;

@Service("evaluacionService")
public class EvaluacionServiceImpl implements EvaluacionService {

	@Autowired
	private EvaluacionDao evaluacionDao;

	@Override
	public void listarProgramacionEvaluacion(
			UnidadAprendizaje unidadAprendisaje,
			Map<String, Object> outParameters) {
		evaluacionDao.listarProgramacionEvaluacion(unidadAprendisaje,
				outParameters);

	}

	@Override
	public void listarEvaluacion(ProgramacionEvaluacion programacionEvaluacion,
			Map<String, Object> outParameters) {
		evaluacionDao.listarEvaluacion(programacionEvaluacion, outParameters);

	}

	@Override
	public void actualizarProgramacionEvaluacion(
			ProgramacionEvaluacion programacionEvaluacion,
			Map<String, Object> outParameters) {
		evaluacionDao.actualizarProgramacionEvaluacion(programacionEvaluacion,
				outParameters);

	}

	@Override
	public void eliminarEvaluacion(Evaluacion evaluacion,
			Map<String, Object> outParameters) {
		evaluacionDao.eliminarEvaluacion(evaluacion, outParameters);

	}

	@Override
	public void insertarEvaluacion(Evaluacion evaluacion,
			Map<String, Object> outParameters) {
		evaluacionDao.insertarEvaluacion(evaluacion, outParameters);

	}

	@Override
	public void insertarProgramacionEvaluacion(
			UnidadAprendizaje unidadAprendisaje,
			ProgramacionEvaluacion programacionEvaluacion,
			Map<String, Object> outParameters) {
		evaluacionDao.insertarProgramacionEvaluacion(unidadAprendisaje,
				programacionEvaluacion, outParameters);

	}

	@Override
	public void listarUsuarioPorCurso(UnidadAprendizaje unidadAprendisaje,
			Map<String, Object> outParameters) {
		evaluacionDao.listarUsuarioPorCurso(unidadAprendisaje, outParameters);

	}

	@Override
	public void insertarUsuarioPorEvaluacion(
			UsuarioPorEvaluacion usuarioEvaluacion,
			Map<String, Object> outParameters) {
		evaluacionDao.insertarUsuarioPorEvaluacion(usuarioEvaluacion,
				outParameters);

	}

	@Override
	public void insertarDetalleEvaluacion(DetalleEvaluacion detalleEvaluacion,
			Map<String, Object> outParameters) {
		evaluacionDao.insertarDetalleEvaluacion(detalleEvaluacion,
				outParameters);

	}

	@Override
	public void eliminarProgramacionEvaluacion(
			ProgramacionEvaluacion programacionEvaluacion,
			Map<String, Object> outParameters) {
		evaluacionDao.eliminarProgramacionEvaluacion(programacionEvaluacion, outParameters);
		
	}

}
