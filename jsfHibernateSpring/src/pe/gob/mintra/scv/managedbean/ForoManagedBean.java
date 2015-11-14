package pe.gob.mintra.scv.managedbean;

import java.io.Serializable;

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
