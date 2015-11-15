package pe.gob.mintra.scv.managedbean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class PreguntaManagedBean {

	public PreguntaManagedBean() {

	}

	public String administrarPregunta() {
		String vista = null;
		vista="pretty:administrarPregunta";
		return vista;

	}
	
	public String mostrarPregunta(){
		System.out.println("mostrarPregunta");
		String vista = null;
		vista="pretty:nuevaPregunta";
		return vista;
	}

}
