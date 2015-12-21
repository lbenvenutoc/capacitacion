package pe.gob.mintra.scv.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.Foro;
import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface ForoDao {

	public void listarForo(@Param("foro") Foro foro,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarForo(@Param("foro") Foro foro,
			@Param("outParameters") Map<String, Object> outParameters);

	public void actualizarForo(@Param("foro") Foro foro,
			@Param("outParameters") Map<String, Object> outParameters);	

}
