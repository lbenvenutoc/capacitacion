package pe.gob.mintra.scv.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.Foro;
import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface UnidApreDao {

	public void listarUnidApre(@Param("unidapre") UnidadAprendizaje unidapre,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarUnidApre(@Param("unidapre") UnidadAprendizaje unidapre,
			@Param("outParameters") Map<String, Object> outParameters);

	public void actualizarUnidApre(@Param("unidapre") UnidadAprendizaje unidapre,
			@Param("outParameters") Map<String, Object> outParameters);	

}
