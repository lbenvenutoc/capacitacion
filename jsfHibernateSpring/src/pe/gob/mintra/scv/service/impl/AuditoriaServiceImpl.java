/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mintra.scv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mintra.scv.dao.AuditoriaDao;
import pe.gob.mintra.scv.model.Auditoria;
import pe.gob.mintra.scv.service.AuditoriaService;

/**
 *
 * @author LUIS BENVENUTO
 */
@Service("auditoriaService")
public class AuditoriaServiceImpl implements AuditoriaService{
    
    @Autowired
    private AuditoriaDao daoAuditoria;
    
    @Transactional
    @Override
    public void insertarAuditoria(Auditoria objAuditoria) {
        
         daoAuditoria.insertarAuditoria(objAuditoria);
        
    }
    
    

    public AuditoriaDao getDaoAuditoria() {
        return daoAuditoria;
    }

    public void setDaoAuditoria(AuditoriaDao daoAuditoria) {
        this.daoAuditoria = daoAuditoria;
    }
}
