
package pe.gob.mintra.scv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mintra.scv.dao.CursoDao;
import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.service.CursoService;

@Service("cursoService")
public class CursoServiceImpl implements CursoService{
    
    @Autowired
    private CursoDao cursoDao;
    
	
    
    
    
}
