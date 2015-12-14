/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mintra.scv.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.util.Constante;

/**
 *
 * @author LUIS BENVENUTO
 */
@Controller
@Scope("session")
public class CursoManagedBean implements Serializable {

    private static Logger logger = Logger.getLogger(CursoManagedBean.class);
    //@ManagedProperty(value="#{cursoService}")
    
    @Autowired
    private CursoService cursoService;
    
    
    
    
}
