
package com.mycompany.software;

import com.mycompany.ejb.PeticionesFacadeLocal;
import com.mycompany.ejb.PlatosFacadeLocal;
import com.mycompany.ejb.TrabajadoresFacadeLocal;
import com.mycompany.model.Peticiones;
import com.mycompany.model.Platos;
import com.mycompany.model.Trabajadores;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PeticionesController implements Serializable{
    
    @EJB
    private PeticionesFacadeLocal peticionesEJB;
    
    @EJB
    private PlatosFacadeLocal platosEJB;
    
    @EJB
    private TrabajadoresFacadeLocal trabajadoresEJB;
    
    private Peticiones peticiones;
    private Trabajadores trabajadores;
    private List<Peticiones> listaPeticiones;
    private int idPeticion;
    
    @PostConstruct
    public void init(){
        peticiones = new Peticiones();
        trabajadores = new Trabajadores();
        listaPeticiones = peticionesEJB.findAll();
    }

    public PlatosFacadeLocal getPlatosEJB() {
        return platosEJB;
    }

    public void setPlatosEJB(PlatosFacadeLocal platosEJB) {
        this.platosEJB = platosEJB;
    }

    public TrabajadoresFacadeLocal getTrabajadoresEJB() {
        return trabajadoresEJB;
    }

    public void setTrabajadoresEJB(TrabajadoresFacadeLocal trabajadoresEJB) {
        this.trabajadoresEJB = trabajadoresEJB;
    }
        
    public String validar(){
    
        String redireccion = "";
        try {
            Platos platos = new Platos();
            platos.setNombrePlato(peticiones.getNombrePlato());
            platos.setIngredientes(peticiones.getIngredientes());
            platos.setElaboracion(peticiones.getElaboracion());
            platos.setAlergenos(peticiones.getAlergenos());
            platos.setPrecio(peticiones.getPrecio());
            
            platosEJB.create(platos);
            
            peticionesEJB.remove(peticiones);
            
            redireccion = "/faces/trabajadores/admin.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public String modificar(){
    
        String redireccion = "";
        
        try {
            peticionesEJB.edit(peticiones);
            redireccion = "/faces/trabajadores/cocinero.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public String eliminar(){
    
        String redireccion = "";
        
        try {
            Peticiones pt = peticionesEJB.find(idPeticion);
            peticionesEJB.remove(pt);
            redireccion = "/faces/trabajadores/cocinero.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public void buscarPeticion(){
    
        try {
            Peticiones pt = peticionesEJB.find(idPeticion);
            peticiones = pt;
        } catch (Exception e) {
        }
    }
    
    public String registrar(){
        
        String redireccion = "";
        
        System.out.println("Entra");
        try {
            trabajadores = trabajadoresEJB.find("asd");
            peticiones.setTrabajadores(trabajadores);
            this.peticiones.setTrabajadores(trabajadores);
            peticionesEJB.create(peticiones);
            redireccion = "/faces/trabajadores/cocinero.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public List<Peticiones> getListaPeticiones() {
        return listaPeticiones;
    }

    public void setListaPeticiones(List<Peticiones> listaPeticiones) {
        this.listaPeticiones = listaPeticiones;
    }

    public int getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(int idPeticion) {
        this.idPeticion = idPeticion;
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
