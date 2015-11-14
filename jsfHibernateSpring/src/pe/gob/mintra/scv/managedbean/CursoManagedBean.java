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
    private List<Curso> listaCursos = new ArrayList<Curso>();
    private Curso objCurso = new Curso();
    private Integer codigoCurso;
    private List<SelectItem> listTipoCurso;
    private List<SelectItem> listModalidadPago;

    public CursoManagedBean() {
        logger.info("Inicio - CursoManagedBean");
        cargar();
        logger.debug("Fin - CursoManagedBean");
    }

    public String listarCursos() {
    	String vista="";    	
        logger.info("Listar Cursos");
        listaCursos = cursoService.listarCursos();
        logger.info("se listaron "+listaCursos.size());
        //return "/curso/listaCursos?faces-redirect=true";
        vista="pretty:listarCurso";
        return vista;
        
    }

    public String grabarCurso() {

        try {
            if (objCurso.getCodigoCurso() == -1) {
                logger.info("ENTRA A INSERTAR CURSOS");
                cursoService.grabarCurso(objCurso);
            } else {
                logger.info("ENTRA A ACTUALIZAR CURSOS");
                cursoService.actualizarCurso(objCurso);
            }
        } catch (Exception ex) {
            logger.log(Priority.ERROR, null, ex);
        }



        return listarCursos();
    }

    public String nuevoCurso() {
        objCurso = new Curso();

        return "/curso/registroCursos";
    }

    public String obtenerCurso() {
    	String vista="";
        Curso curso = new Curso();
        curso.setCodigoCurso(codigoCurso);
        objCurso = cursoService.obtenerCurso(curso);
        vista="pretty:obtenerCurso";
        return vista;
    }

    public String eliminarCurso(){
       
        String vista = null;
        
        try {
            Curso curso = new Curso();
            curso.setCodigoCurso(codigoCurso);
            objCurso = cursoService.obtenerCurso(curso);
            cursoService.eliminarCurso(objCurso);
            vista = listarCursos();
            
        }  
       
        catch (Exception ex) {        
        	
            //logger.log(Priority.ERROR, null, ex);                           
            
            vista = "/accesoDenegado";
        }
       
      
     
       return vista;
        





    }

    //Otros Metodos
    private void cargar() {
    	FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
    	 
        listTipoCurso = new ArrayList<SelectItem>();
        listTipoCurso.add(new SelectItem(Constante.TIPOCURSO_CIENCIAS, Constante.TIPOCURSO_CIENCIAS_DESC));
        listTipoCurso.add(new SelectItem(Constante.TIPOCURSO_HUMANIDADES, Constante.TIPOCURSO_HUMANIDADES_DESC));
        listTipoCurso.add(new SelectItem(Constante.TIPOCURSO_POLITICA, Constante.TIPOCURSO_POLITICA_DESC));

        listModalidadPago = new ArrayList<SelectItem>();
        listModalidadPago.add(new SelectItem(Constante.MODPAGO_CONTADO, Constante.MODPAGO_CONTADO_DESC));
        listModalidadPago.add(new SelectItem(Constante.MODPAGO_CREDITO, Constante.MODPAGO_CREDITO_DESC));
    }

    //Metodos Get - Set
    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }      
	
	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public Curso getObjCurso() {
        return objCurso;
    }

    public void setObjCurso(Curso objCurso) {
        this.objCurso = objCurso;
    }

    public List<SelectItem> getListTipoCurso() {
        return listTipoCurso;
    }

    public List<SelectItem> getListModalidadPago() {
        return listModalidadPago;
    }

    public void setListModalidadPago(List<SelectItem> listModalidadPago) {
        this.listModalidadPago = listModalidadPago;
    }
}
