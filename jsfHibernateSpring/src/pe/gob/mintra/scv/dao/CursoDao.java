
package pe.gob.mintra.scv.dao;

import java.util.List;

import pe.gob.mintra.scv.model.Curso;


public interface CursoDao {
    
    public List<Curso> listarCursos();
    public Curso obtenerCurso(Curso objCurso);
    public void grabarCurso(Curso objCurso);
    public void actualizarCurso(Curso objCurso);
    public void eliminarCurso(Curso objCurso);
    
}
