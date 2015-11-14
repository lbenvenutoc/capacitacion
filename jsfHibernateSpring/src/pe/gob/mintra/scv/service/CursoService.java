package pe.gob.mintra.scv.service;

import java.util.List;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.model.Curso;



public interface CursoService {

    public List<Curso> listarCursos();

    public void grabarCurso(Curso objCurso);

    public Curso obtenerCurso(Curso objCurso);

    public void actualizarCurso(Curso objCurso);

    public void eliminarCurso(Curso objCurso);
    
}
