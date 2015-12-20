package pe.gob.mintra.scv.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.dao.CursoDao;
import pe.gob.mintra.scv.dao.TipoForoDao;
import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.TipoForo;
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.service.TipoForoService;

@Service("tipoForoService")
public class TipoForoServiceImpl implements TipoForoService {

	@Autowired
	private TipoForoDao tipoForoDao;

	@Override
	public void listarTipoForo(TipoForo tipoforo, Map<String, Object> outParameters) {
		tipoForoDao.listarTipoForo(tipoforo, outParameters);		
	}

	@Override
	public void insertarTipoForo(TipoForo tipoforo, Map<String, Object> outParameters) {
		tipoForoDao.insertarTipoForo(tipoforo, outParameters);	
	}

	@Override
	public void actualizarTipoForo(TipoForo tipoforo, Map<String, Object> outParameters) {
		tipoForoDao.actualizarTipoForo(tipoforo, outParameters);		
	}
	
}
