
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
public class LoginController implements Serializable {
    
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
    
    public String iniciarSesionTrabajador(){
        
        Trabajadores tr;
        String redireccion = "";
        try {
            tr = trabajadoresEJB.iniciarSesion(trabajadores);
            if(tr != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("trabajador", tr);
                
                switch (tr.getRol()) {
                    case "administrador":
                        redireccion = "/trabajadores/admin?faces-redirect=true";
                        break;
                    case "cocinero":
                        redireccion = "/trabajadores/cocinero?faces-redirect=true";
<<<<<<< HEAD
                        break;
                    case "camarero":
                        redireccion = "/trabajadores/camarero?faces-redirect=true";
=======
>>>>>>> cecb6b3168ab7242dc5f50fad99989d5def9373b
                        break;
                    default:
                        redireccion = "/trabajadores/encargado?faces-redirect=true";
                        break;
                }

            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        System.out.println(" Redirección: "+redireccion);
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
