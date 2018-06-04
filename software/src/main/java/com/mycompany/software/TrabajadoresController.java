
package com.mycompany.software;

import com.mycompany.ejb.TrabajadoresFacadeLocal;
import com.mycompany.model.Trabajadores;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TrabajadoresController implements Serializable{
    
    @EJB
    private TrabajadoresFacadeLocal trabajadoresEJB;
    
    private Trabajadores trabajadores;
    
    @PostConstruct
    public void init(){
        trabajadores = new Trabajadores();
    }
    
    public void registrar(){
        try {
            trabajadoresEJB.create(trabajadores);
        } catch (Exception e) {
        }
    }

    public TrabajadoresFacadeLocal getTrabajadoresEJB() {
        return trabajadoresEJB;
    }

    public void setTrabajadoresEJB(TrabajadoresFacadeLocal trabajadoresEJB) {
        this.trabajadoresEJB = trabajadoresEJB;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    
}
