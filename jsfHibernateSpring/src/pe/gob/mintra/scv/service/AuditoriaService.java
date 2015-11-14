/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mintra.scv.service;

import org.springframework.stereotype.Service;

import pe.gob.mintra.scv.model.Auditoria;

/**
 *
 * @author LUIS BENVENUTO
 */
@Service("auditoriaService")
public interface AuditoriaService {

    public void insertarAuditoria(Auditoria objAuditoria);
}
