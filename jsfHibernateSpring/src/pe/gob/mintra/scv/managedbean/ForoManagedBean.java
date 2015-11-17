package pe.gob.mintra.scv.managedbean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class ForoManagedBean implements Serializable {

	public ForoManagedBean() {
	}

	public String listarForo() {
		String vista = null;
		vista = "pretty:listarForo";
		return vista;
		//return "/aplicacion/foro/listaForo";
	}

	public String prepareCrear() {
		String vista = null;
		vista = "pretty:crearForo";
		return vista;
		//return "/aplicacion/foro/CrearForo";
	}

}
