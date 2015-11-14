/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mintra.scv.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mintra.scv.dao.UsuarioDao;
import pe.gob.mintra.scv.model.Usuario;

/**
 *
 * @author francisco
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private SessionFactory sessionFactory;
    
   
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Usuario obtenerUsuario(Usuario objUsuario) {
        Usuario usuario = null;
        Query q=sessionFactory.getCurrentSession().createQuery("select u from Usuario u join fetch u.lstRol where u.nombre=:nombre");
        q.setParameter("nombre", objUsuario.getNombre());
        usuario=(Usuario) q.uniqueResult();
        return usuario;
    }
}
