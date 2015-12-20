package pe.gob.mintra.scv.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Curso;
import pe.gob.mintra.scv.model.TipoForo;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.service.TipoForoService;

@Controller
@Scope("session")
public class TipoForoManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TipoForoService tipoForoService;
	
	private TipoForo tipoForo;
	private TipoForo objTipoForo;
	private List<TipoForo> lstTipoForo;
	

	public TipoForo getObjTipoForo() {
		return objTipoForo;
	}

	public void setObjTipoForo(TipoForo objTipoForo) {
		this.objTipoForo = objTipoForo;
	}

	public TipoForo getTipoForo() {
		return tipoForo;
	}

	public void setTipoForo(TipoForo tipoForo) {
		this.tipoForo = tipoForo;
	}

	public List<TipoForo> getLstTipoForo() {
		return lstTipoForo;
	}

	public void setLstTipoForo(List<TipoForo> lstTipoForo) {
		this.lstTipoForo = lstTipoForo;
	}

	public TipoForoManagedBean() {
		objTipoForo = new TipoForo();
	}

	//REDIRECCIONES
	
	public String listar() {
		String vista = null;
		objTipoForo = new TipoForo();
		lstTipoForo = null;
		vista = "pretty:listarTipoForo";
		return vista;
	}

	public String prepareCrear() {
		objTipoForo = new TipoForo();
		String vista = null;
		vista = "pretty:crearTipoForo";
		return vista;
	}
	
	public String prepareEditar(TipoForo tf) {
		try {
			String vista = null;
			objTipoForo=tf;
			vista = "pretty:editarTipoForo";
			return vista;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String prepareVer(TipoForo tf) {
		String vista = null;
		objTipoForo=tf;
		vista = "pretty:verTipoForo";
		return vista;
	}
	
	//METODOS
	public void buscar() {
		HashMap<String, Object> outParametersTipoForo = new HashMap<String, Object>();
		tipoForoService.listarTipoForo(objTipoForo, outParametersTipoForo);
		lstTipoForo = (List<TipoForo>) outParametersTipoForo.get("lstCur");		
		objTipoForo = new TipoForo();
	}
	
	public String crear(){
		HashMap<String, Object> outParametersTipoForo = new HashMap<String, Object>();
		tipoForoService.insertarTipoForo(objTipoForo, outParametersTipoForo);
		objTipoForo.setnCodTipoForo((Integer) outParametersTipoForo.get("nCodTipoForo"));
		return listar();
	}
	
	public String editar(){
		HashMap<String, Object> outParametersTipoForo = new HashMap<String, Object>();
		tipoForoService.actualizarTipoForo(objTipoForo, outParametersTipoForo);
		return listar();
	}

}
