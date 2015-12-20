package pe.gob.mintra.scv.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Foro;
import pe.gob.mintra.scv.model.TipoForo;
import pe.gob.mintra.scv.service.ForoService;
import pe.gob.mintra.scv.service.TipoForoService;

@Controller
@Scope("session")
public class ForoManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ForoService foroService;
	@Autowired
	private TipoForoService tipoForoService;
	
	private Foro foro;
	private Foro objForo;
	private List<Foro> lstForo;
	private List<TipoForo> lstTipoForo;
	
	private String textoBienvenida;	

	public List<TipoForo> getLstTipoForo() {
		return lstTipoForo;
	}

	public void setLstTipoForo(List<TipoForo> lstTipoForo) {
		this.lstTipoForo = lstTipoForo;
	}

	public ForoService getForoService() {
		return foroService;
	}

	public void setForoService(ForoService foroService) {
		this.foroService = foroService;
	}

	public Foro getForo() {
		return foro;
	}

	public void setForo(Foro foro) {
		this.foro = foro;
	}

	public Foro getObjForo() {
		return objForo;
	}

	public void setObjForo(Foro objForo) {
		this.objForo = objForo;
	}

	public List<Foro> getLstForo() {
		return lstForo;
	}

	public void setLstForo(List<Foro> lstForo) {
		this.lstForo = lstForo;
	}

	public String getTextoBienvenida() {
		textoBienvenida = "Aprovechemos la oportunidad para realizar una breve presentacion personal" +
				" de acuerdo a las siguientes instrucciones:";
		return textoBienvenida;
	}

	public void setTextoBienvenida(String textoBienvenida) {
		this.textoBienvenida = textoBienvenida;
	}

	public ForoManagedBean() {
		objForo = new Foro();
	}

	public String listar() {
		String vista = null;
		vista = "pretty:listarForo";
		return vista;
	}

	public String prepareCrear() {
		try {
			String vista = null;
			vista = "pretty:crearForo";
			HashMap<String, Object> outParameters = new HashMap<String, Object>();
			TipoForo tfp = new TipoForo();
			tfp.setvDesTipoForo("F");
			tipoForoService.listarTipoForo(tfp, outParameters);
			lstTipoForo = (List<TipoForo>) outParameters.get("lstCur");		
			return vista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String prepareEditar(Foro f) {
		String vista = null;
		vista = "pretty:editarForo";
		return vista;
	}
	
	
	
	public String prepareVer(Foro f) {
		String vista = null;
		vista = "pretty:verForo";
		return vista;
	}
	
	//METODOS
	public void buscar() {
		HashMap<String, Object> outParametersForo = new HashMap<String, Object>();
		foroService.listarForo(objForo, outParametersForo);
		lstForo = (List<Foro>) outParametersForo.get("lstCur");		
		objForo = new Foro();
	}
	
	public String crear(){
		HashMap<String, Object> outParametersForo = new HashMap<String, Object>();
		objForo.setnEstForo(1);
		foroService.insertarForo(objForo, outParametersForo);
		objForo.setnCodForo((Integer) outParametersForo.get("nCodForo"));
		return listar();
	}
	
	public String editar(){
		HashMap<String, Object> outParametersForo = new HashMap<String, Object>();
		foroService.actualizarForo(objForo, outParametersForo);
		return listar();
	}

	public String usuarioXForo() {
		String vista = null;
		vista = "pretty:usuarioXForo";
		return vista;
	}
	
	public String mostrarForo() {
		String vista = null;
		vista = "pretty:mostrarForo";
		return vista;
	}

}
