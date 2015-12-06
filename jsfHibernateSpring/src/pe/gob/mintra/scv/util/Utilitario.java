package pe.gob.mintra.scv.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

import java.text.ParseException;

public class Utilitario {

	public static void showFacesMessage(String texto, int tipo) {
		switch (tipo) {
		case 1:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, texto,
							"Error"));
			break;
		case 2:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, texto,
							"Fatal"));
			break;
		case 3:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, texto,
							"Informacion"));
			break;
		case 4:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, texto,
							"Advertencia"));
			break;
		default:
			break;
		}
	}

	public static void setearParametro(String nombre, Object valor) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam(nombre, valor);
	}

	static public Date deStringaDate(String sfecha) {
		Date resultado = new Date();
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			resultado = sdf.parse(sfecha);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return resultado;

	}

	static public String deDateaString(Date fecha) {
		String resultado = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		resultado = sdf.format(fecha);

		return resultado;
	}

	public static Date fechaActual() {
		Date fecAct = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			fecAct = sdf.parse(sdf.format(fecAct));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return fecAct;

	}
	
	public static Date parteFecha(Date fecha,String format) {
		Date fecAct = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			fecAct = sdf.parse(sdf.format(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return fecAct;

	}

	public static void refrescarVista() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context
				.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}

}
