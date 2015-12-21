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
import pe.gob.mintra.scv.model.UnidadAprendizaje;
import pe.gob.mintra.scv.service.CursoService;
import pe.gob.mintra.scv.service.TipoForoService;

@Controller
@Scope("session")
public class UnidApreManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TipoForoService tipoForoService;
	
	private UnidadAprendizaje unidApre;
	private UnidadAprendizaje objUnidApre;
	private List<UnidadAprendizaje> lstUnidApre;

	public UnidadAprendizaje getUnidApre() {
		return unidApre;
	}

	public void setUnidApre(UnidadAprendizaje unidApre) {
		this.unidApre = unidApre;
	}

	public UnidadAprendizaje getObjUnidApre() {
		return objUnidApre;
	}

	public void setObjUnidApre(UnidadAprendizaje objUnidApre) {
		this.objUnidApre = objUnidApre;
	}

	public List<UnidadAprendizaje> getLstUnidApre() {
		return lstUnidApre;
	}

	public void setLstUnidApre(List<UnidadAprendizaje> lstUnidApre) {
		this.lstUnidApre = lstUnidApre;
	}

	public UnidApreManagedBean() {
		objUnidApre = new UnidadAprendizaje();
	}

	//REDIRECCIONES
	
	public String listar() {
		String vista = null;
		objUnidApre = new UnidadAprendizaje();
		lstUnidApre = null;
		vista = "pretty:listarTipoForo";
		return vista;
	}

	public String prepareCrear() {
		objUnidApre = new UnidadAprendizaje();
		String vista = null;
		vista = "pretty:crearTipoForo";
		return vista;
	}
	
	public String prepareEditar(UnidadAprendizaje tf) {
		try {
			String vista = null;
			objUnidApre=tf;
			vista = "pretty:editarTipoForo";
			return vista;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String prepareVer(UnidadAprendizaje tf) {
		String vista = null;
		objUnidApre=tf;
		vista = "pretty:verTipoForo";
		return vista;
	}
	
	//METODOS
	public void buscar() {
		/*HashMap<String, Object> outParametersTipoForo = new HashMap<String, Object>();
		tipoForoService.listarTipoForo(objTipoForo, outParametersTipoForo);
		lstTipoForo = (List<TipoForo>) outParametersTipoForo.get("lstCur");		
		objTipoForo = new TipoForo();*/
	}
	
	public String crear(){
		/*HashMap<String, Object> outParametersTipoForo = new HashMap<String, Object>();
		tipoForoService.insertarTipoForo(objTipoForo, outParametersTipoForo);
		objTipoForo.setnCodTipoForo((Integer) outParametersTipoForo.get("nCodTipoForo"));*/
		return listar();
	}
	
	public String editar(){
		/*HashMap<String, Object> outParametersTipoForo = new HashMap<String, Object>();
		tipoForoService.actualizarTipoForo(objTipoForo, outParametersTipoForo);*/
		return listar();
	}

}
