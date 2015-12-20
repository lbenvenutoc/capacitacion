package pe.gob.mintra.scv.service;

import java.util.Map;

import pe.gob.mintra.scv.model.TipoForo;

public interface TipoForoService {

	public void listarTipoForo(TipoForo curso, Map<String, Object> outParameters);

	public void insertarTipoForo(TipoForo curso, Map<String, Object> outParameters);

	public void actualizarTipoForo(TipoForo curso, Map<String, Object> outParameters);
	
}
