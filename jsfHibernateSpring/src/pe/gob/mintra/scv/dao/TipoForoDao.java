package pe.gob.mintra.scv.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.TipoForo;
import pe.gob.mintra.scv.model.UnidadAprendizaje;

public interface TipoForoDao {

	public void listarTipoForo(@Param("tipoforo") TipoForo curso,
			@Param("outParameters") Map<String, Object> outParameters);

	public void insertarTipoForo(@Param("tipoforo") TipoForo curso,
			@Param("outParameters") Map<String, Object> outParameters);

	public void actualizarTipoForo(@Param("tipoforo") TipoForo curso,
			@Param("outParameters") Map<String, Object> outParameters);	

}
