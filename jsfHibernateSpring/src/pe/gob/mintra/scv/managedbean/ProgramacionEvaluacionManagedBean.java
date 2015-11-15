package pe.gob.mintra.scv.managedbean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.ProgramacionEvaluacion;

@Controller
@Scope("session")
public class ProgramacionEvaluacionManagedBean {

	private List<ProgramacionEvaluacion> lstProgEval;

	public ProgramacionEvaluacionManagedBean() {
		lstProgEval = new ArrayList<ProgramacionEvaluacion>();
	}

	public String programarEvaluacion() {
		String vista = null;
		vista = "pretty:administrarEvaluacion";
		return vista;
	}

	public String mostrarProgramacionEvaluacion() {
		String vista = null;
		vista = "pretty:programarEvaluacion";
		return vista;
	}

	public String rendirEvaluacion() {
		String vista = null;
		vista = "pretty:rendirEvaluacion";
		return vista;
	}

	public List<ProgramacionEvaluacion> getLstProgEval() {
		return lstProgEval;
	}

	public void setLstProgEval(List<ProgramacionEvaluacion> lstProgEval) {
		this.lstProgEval = lstProgEval;
	}

}
