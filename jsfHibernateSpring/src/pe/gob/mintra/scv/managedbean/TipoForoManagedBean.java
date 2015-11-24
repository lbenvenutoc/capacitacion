package pe.gob.mintra.scv.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class TipoForoManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Map<String, String>> lst = new ArrayList<Map<String, String>>();

	
	

	public List<Map<String, String>> getLst() {
		return lst;
	}

	public void setLst(List<Map<String, String>> lst) {
		this.lst = lst;
	}

	public TipoForoManagedBean() {
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("desc", "Foro para presentacion de participantes del modulo 5");
		mapa.put("tipo", "Foro de Presentacion");
		mapa.put("fini", "11/10/2015");
		mapa.put("ffin", "12/12/2015");
		mapa.put("activo", "activo");
		lst.add(mapa);
	}

	public String listarTipoForo() {
		String vista = null;
		vista = "pretty:listarTipoForo";
		return vista;
	}

	public String prepareCrear() {
		String vista = null;
		vista = "pretty:crearTipoForo";
		return vista;
	}
	
	public String prepareEditar() {
		String vista = null;
		vista = "pretty:editarTipoForo";
		return vista;
	}
	
	public String verTipoForo() {
		String vista = null;
		vista = "pretty:verTipoForo";
		return vista;
	}

}
