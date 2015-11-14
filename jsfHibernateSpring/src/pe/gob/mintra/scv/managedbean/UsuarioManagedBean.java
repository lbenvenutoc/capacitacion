package pe.gob.mintra.scv.managedbean;




import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import pe.gob.mintra.scv.model.Usuario;
import pe.gob.mintra.scv.service.UsuarioService;

@Controller
@Scope("session")
public class UsuarioManagedBean implements Serializable{

    private String v_codusu;
    private String v_passusu;
    private String v_locale;
    
    @Autowired
    @Qualifier("authenticationManager")
    //@Qualifier("org.springframework.security.authenticationManager")
    private AuthenticationManager authenticationManager;
    
    
    @Autowired    
    private UsuarioService servicioUsuario;
    
    public UsuarioManagedBean() {
        v_locale="es";
    }
    
    public void setearLocale(){
        System.out.println("IDIOMA SELECCIONADO");
        System.out.println(v_locale);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(v_locale));
    }

    public String ejecutarLogin(){
        String vista = null;
        
        try {
            /*Authentication request = new UsernamePasswordAuthenticationToken(
                    v_codusu, v_passusu);
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);*/
            vista = "/index?faces-redirect=true";
        } catch (AuthenticationException  e) {
        	//System.out.println("Entra a la excepcion de login "+e.getMessage());
        	
        	FacesMessage facesMsg = new FacesMessage(
    	    FacesMessage.SEVERITY_ERROR, "Usuario o password ingresados no son correctos", "login.failed") ;
    	    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    	            
            //e.printStackTrace();
            vista = "/login";
        }
        
      
       
        return vista;

    }

    public String getV_codusu() {
        return v_codusu;
    }

    public void setV_codusu(String v_codusu) {
        this.v_codusu = v_codusu;
    }

    public String getV_passusu() {
        return v_passusu;
    }

    public void setV_passusu(String v_passusu) {
        this.v_passusu = v_passusu;
    }
    
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    

    public UsuarioService getServicioUsuario() {
        return servicioUsuario;
    }

    public void setServicioUsuario(UsuarioService servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    public String getV_locale() {
        return v_locale;
    }

    public void setV_locale(String v_locale) {
        this.v_locale = v_locale;
    }
    
    
    
    
}
