package pe.gob.mintra.scv.service;

import java.util.Map;

import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface UnidApreService {

	public void listarUnidApre(UnidadAprendizaje unidApre, Map<String, Object> outParameters);

	public void insertarUnidApre(UnidadAprendizaje unidApre, Map<String, Object> outParameters);

	public void actualizarUnidApre(UnidadAprendizaje unidApre, Map<String, Object> outParameters);
	
}
