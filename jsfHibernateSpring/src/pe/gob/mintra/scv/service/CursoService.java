package pe.gob.mintra.scv.service;

import java.util.Map;

import pe.gob.mintra.scv.model.Curso;


public interface CursoService {

	public void listarCurso(Curso curso, Map<String, Object> outParameters);
	public void insertarCurso(
			Curso curso,
			Map<String, Object> outParameters);
    

}
