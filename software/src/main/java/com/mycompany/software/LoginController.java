
package com.mycompany.software;

import com.mycompany.ejb.TrabajadoresFacadeLocal;
import com.mycompany.model.Trabajadores;
import com.mycompany.ejb.ClientesFacadeLocal;
import com.mycompany.model.Clientes;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
@ViewScoped
public class LoginController implements Serializable{
    
    @EJB
    private TrabajadoresFacadeLocal trabajadoresEJB;
    
    @EJB
    private ClientesFacadeLocal clientesEJB;
    
    private Trabajadores trabajadores;
    
    private Clientes clientes;
    
    @PostConstruct
    public void init(){
        trabajadores = new Trabajadores();
        clientes = new Clientes();
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }
    
    public Clientes getClientes() {
        return clientes;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    
    public String iniciarSesion(){
        
        Trabajadores tr;
        String redireccion = null;
        
        try {
            tr = trabajadoresEJB.iniciarSesion(trabajadores);
            if(tr != null){
                if(tr.getRol().equals("administrador")){
                    redireccion = "trabajadores/admin?faces-redirect=true"; 
                }else if(tr.getRol().equals("cocinero")){
                    redireccion = "trabajadores/cocinero?faces-redirect=true"; 
                }else if(tr.getRol().equals("encargado")){
                    redireccion = "trabajadores/encargado?faces-redirect=true"; 
                }
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        
        return redireccion;
    }
    
    public String iniciarSesionCliente(){
        
        Clientes cl;
        String redireccion = null;
        
        try {
            cl = clientesEJB.iniciarSesion(clientes);
            if(cl != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", cl);
                redireccion="/faces/clientes/registrado?faces-redirect=true";                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        
        return redireccion;
    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
