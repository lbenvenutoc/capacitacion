package pe.gob.mintra.scv.service;

import java.util.Map;

import pe.gob.mintra.scv.model.Foro;

public interface ForoService {

	public void listarForo(Foro foro, Map<String, Object> outParameters);

	public void insertarForo(Foro foro, Map<String, Object> outParameters);

	public void actualizarForo(Foro foro, Map<String, Object> outParameters);
	
}
