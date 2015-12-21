package pe.gob.mintra.scv.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.dao.CursoDao;
import pe.gob.mintra.scv.dao.ForoDao;
import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.Foro;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.service.ForoService;

@Service("foroService")
public class ForoServiceImpl implements ForoService {

	@Autowired
	private ForoDao foroDao;

	@Override
	public void listarForo(Foro foro, Map<String, Object> outParameters) {
		foroDao.listarForo(foro, outParameters);		
	}

	@Override
	public void insertarForo(Foro foro, Map<String, Object> outParameters) {
		foroDao.insertarForo(foro, outParameters);	
	}

	@Override
	public void actualizarForo(Foro foro, Map<String, Object> outParameters) {
		foroDao.actualizarForo(foro, outParameters);		
	}
	
}
