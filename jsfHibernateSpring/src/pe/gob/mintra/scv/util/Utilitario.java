package pe.gob.mintra.scv.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

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

	public static Date parteFecha(Date fecha, String format) {
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

	public static void copiarArchivo(String fileName, InputStream in,
			String destination) {

		try {
			ExternalContext ec = FacesContext.getCurrentInstance()
					.getExternalContext();
			String filePath = ec.getRealPath("/");
			System.out.print("RUTA---> " + filePath);
			OutputStream out = new FileOutputStream(new File(destination
					+ fileName));

			int read = 0;

			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {

				out.write(bytes, 0, read);

			}

			in.close();

			out.flush();

			out.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

	}

	public static void mostrarArchivo(String rutaCadena, String nombreArchivo,
			String tipo) throws Exception {
		// Prepare.
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String ruta = servletContext.getRealPath(rutaCadena);
		File file = new File(rutaCadena, nombreArchivo);
		BufferedInputStream input = null;
		BufferedOutputStream output = null;

		try {

			input = new BufferedInputStream(new FileInputStream(file), 1024);

			response.reset();
			response.setHeader("Content-Type", "application/" + tipo);
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ nombreArchivo + "\"");
			output = new BufferedOutputStream(response.getOutputStream(), 1024);

			byte[] buffer = new byte[1024];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}

			output.flush();
		} finally {

			close(output);
			close(input);
		}

		facesContext.responseComplete();

	}

	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
