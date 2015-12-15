
package pe.gob.mintra.scv.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import pe.gob.mintra.scv.model.Curso;



public interface CursoDao {
	
	public void listarCurso(
			@Param("curso") Curso curso,
			@Param("outParameters") Map<String, Object> outParameters);
	
	public void insertarCurso(
			@Param("curso") Curso curso,
			@Param("outParameters") Map<String, Object> outParameters);
    
  
    
}
