/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mintra.scv.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.gob.mintra.scv.dao.AuditoriaDao;
import pe.gob.mintra.scv.model.Auditoria;

/**
 *
 * @author LUIS BENVENUTO
 */
@Repository("auditoriaDao")
public class AuditoriaDaoImpl implements AuditoriaDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void insertarAuditoria(Auditoria objAuditoria) {
       sessionFactory.getCurrentSession().save(objAuditoria);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
}
