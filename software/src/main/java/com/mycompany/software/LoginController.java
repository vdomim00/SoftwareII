
package com.mycompany.software;

import com.mycompany.ejb.TrabajadoresFacadeLocal;
import com.mycompany.model.Trabajadores;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginController implements Serializable{
    
    @EJB
    private TrabajadoresFacadeLocal trabajadoresEJB;
    
    private Trabajadores trabajadores;
    
    @PostConstruct
    public void init(){
        trabajadores = new Trabajadores();
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
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
                }
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        
        return redireccion;
    }
    
}
