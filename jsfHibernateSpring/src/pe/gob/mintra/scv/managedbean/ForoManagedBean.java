package pe.gob.mintra.scv.managedbean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class ForoManagedBean implements Serializable {

	public ForoManagedBean() {
	}
	
	public String listarCursos() {
        
        return "/foro/listaForo";
    }
	
public String prepareCrear() {
        
        return "/foro/CrearForo";
    }

}
