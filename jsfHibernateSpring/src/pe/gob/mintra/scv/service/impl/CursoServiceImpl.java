package pe.gob.mintra.scv.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.dao.CursoDao;
import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.CursoService;

@Service("cursoService")
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoDao cursoDao;

	public void listarCurso(Curso curso, Map<String, Object> outParameters) {

		cursoDao.listarCurso(curso, outParameters);

	}

	@Override
	public void insertarCurso(Curso curso, Map<String, Object> outParameters) {
		cursoDao.insertarCurso(curso, outParameters);

	}

	@Override
	public void actualizarCurso(Curso curso, Map<String, Object> outParameters) {
		cursoDao.actualizarCurso(curso, outParameters);

	}

	@Override
	public void listarUnidad(Curso curso, Map<String, Object> outParameters) {
		cursoDao.listarUnidad(curso, outParameters);

	}

	@Override
	public void insertarUnidad(Curso curso, UnidadAprendizaje unidad,
			Map<String, Object> outParameters) {
		cursoDao.insertarUnidad(curso, unidad, outParameters);

	}

	@Override
	public void actualizarUnidad(UnidadAprendizaje unidad,
			Map<String, Object> outParameters) {
		cursoDao.actualizarUnidad(unidad, outParameters);

	}

}
