
package com.mycompany.model;

import com.mycompany.ejb.PlatosFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PlatosController implements Serializable{
    
    @EJB
    private PlatosFacadeLocal platosEJB;
    
    private Platos platos;
    private List<Platos> listaPlatos;
    
    @PostConstruct
    public void init(){
        platos = new Platos();
        listaPlatos = platosEJB.findAll();
    }
    
    public void registrar(){
        try {
            platosEJB.create(platos);
            listaPlatos = platosEJB.findAll();
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
    
    public List<Platos> getListaPlatos() {
        return listaPlatos;
    }
    
    public void setListaPlatos(List<Platos> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }
}
