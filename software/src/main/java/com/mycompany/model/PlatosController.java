
package com.mycompany.model;

import com.mycompany.ejb.PlatosFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlatosController implements Serializable{
    
    @EJB
    private PlatosFacadeLocal platosEJB;
    
    private Platos platos;
    
    @PostConstruct
    public void init(){
        platos = new Platos();
    }
    
    public void registrar(){
        try {
            platosEJB.create(platos);
        } catch (Exception e) {
            System.out.println("Error al guardar el plato");
        }
    }

    public PlatosFacadeLocal getPlatosEJB() {
        return platosEJB;
    }

    public void setPlatosEJB(PlatosFacadeLocal platosEJB) {
        this.platosEJB = platosEJB;
    }

    public Platos getPlatos() {
        return platos;
    }

    public void setPlatos(Platos platos) {
        this.platos = platos;
    }
    
    
}
