
package com.mycompany.software;

import com.mycompany.ejb.PeticionesFacadeLocal;
import com.mycompany.model.Peticiones;
import com.mycompany.model.Trabajadores;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PeticionesController implements Serializable{
    
    @EJB
    private PeticionesFacadeLocal peticionesEJB;
    
    private Peticiones peticiones;
    private Trabajadores trabajadores;
    
    @PostConstruct
    public void init(){
        peticiones = new Peticiones();
        trabajadores = new Trabajadores();
    }
    
    public void registrar(){
        try {
            this.peticiones.setTrabajadores(trabajadores);
            peticionesEJB.create(peticiones);
        } catch (Exception e) {
        }
    }

    public PeticionesFacadeLocal getPeticionesEJB() {
        return peticionesEJB;
    }

    public void setPeticionesEJB(PeticionesFacadeLocal peticionesEJB) {
        this.peticionesEJB = peticionesEJB;
    }

    public Peticiones getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(Peticiones peticiones) {
        this.peticiones = peticiones;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    
}
