package pe.gob.mintra.scv.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.dao.CursoDao;
import pe.gob.mintra.scv.dao.ForoDao;
import pe.gob.mintra.scv.dao.UnidApreDao;
import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.Foro;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.service.ForoService;
import pe.gob.mintra.scv.service.UnidApreService;

@Service("UnidApreService")
public class UnidApreServiceImpl implements UnidApreService {

	@Autowired
	private UnidApreDao unidApreDao;

	@Override
	public void listarUnidApre(UnidadAprendizaje unidApre, Map<String, Object> outParameters) {
		unidApreDao.listarUnidApre(unidApre, outParameters);		
	}

	@Override
	public void insertarUnidApre(UnidadAprendizaje unidApre, Map<String, Object> outParameters) {
		unidApreDao.insertarUnidApre(unidApre, outParameters);	
	}

	@Override
	public void actualizarUnidApre(UnidadAprendizaje unidApre, Map<String, Object> outParameters) {
		unidApreDao.actualizarUnidApre(unidApre, outParameters);		
	}
	
}
