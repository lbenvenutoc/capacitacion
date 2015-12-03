package pe.gob.mintra.scv.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.dao.PreguntaDao;
import pe.gob.mintra.scv.model.Opcion;
import pe.gob.mintra.scv.model.Pregunta;
import pe.gob.mintra.scv.model.UnidadAprendisaje;
import pe.gob.mintra.scv.service.PreguntaService;

@Service("preguntaService")
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	private PreguntaDao preguntaDao;

	@Override
	public void listarPreguntas(UnidadAprendisaje unidadAprendisaje,
			Map<String, Object> outParameters) {
		preguntaDao.listarPreguntas(unidadAprendisaje, outParameters);

	}

	@Override
	public void listarOpciones(Pregunta pregunta,
			Map<String, Object> outParameters) {
		preguntaDao.listarOpciones(pregunta, outParameters);

	}

	@Override
	public void insertarPregunta(Pregunta pregunta,
			UnidadAprendisaje unidadAprendisaje,
			Map<String, Object> outParameters) {
		preguntaDao
				.insertarPregunta(pregunta, unidadAprendisaje, outParameters);

	}

	@Override
	public void insertarOpcion(Pregunta pregunta, Opcion opcion,
			Map<String, Object> outParameters) {
		preguntaDao.insertarOpcion(pregunta, opcion, outParameters);

	}

	@Override
	public void actualizarPregunta(Pregunta pregunta,
			Map<String, Object> outParameters) {
		preguntaDao.actualizarPregunta(pregunta, outParameters);

	}

	@Override
	public void actualizarOpcion(Pregunta pregunta, Opcion opcion,
			Map<String, Object> outParameters) {
		preguntaDao.actualizarOpcion(pregunta, opcion, outParameters);

	}

	@Override
	public void eliminarOpcion(Pregunta pregunta, Opcion opcion,
			Map<String, Object> outParameters) {
		preguntaDao.eliminarOpcion(pregunta, opcion, outParameters);

	}

	@Override
	public void eliminarPregunta(Pregunta pregunta,
			Map<String, Object> outParameters) {
		preguntaDao.eliminarPregunta(pregunta, outParameters);

	}

}
