package pe.gob.mintra.scv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mintra.scv.dao.UsuarioDao;
import pe.gob.mintra.scv.model.Usuario;
import pe.gob.mintra.scv.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    

    
    /*
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioDao.listarUsuario();
    }
    */
    
    @Transactional(readOnly = true)
    @Override
    public Usuario obtenerUsuario(Usuario objUsuario){
        return usuarioDao.obtenerUsuario(objUsuario);
    }
    
    
}
