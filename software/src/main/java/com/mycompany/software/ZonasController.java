
package com.mycompany.software;

import com.mycompany.ejb.ZonasFacadeLocal;
import com.mycompany.model.Almacenes;
import com.mycompany.model.Zonas;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ZonasController implements Serializable{
    
    @EJB
    private ZonasFacadeLocal zonasEJB;
    
    private Zonas zonas;
    private Almacenes almacenes;
    
    @PostConstruct
    public void init(){
        zonas = new Zonas();
        almacenes = new Almacenes();
    }
    
    public void registrar(){
        try {
            this.zonas.setAlmacenes(almacenes);
            zonasEJB.create(zonas);
        } catch (Exception e) {
        }
    }

    public ZonasFacadeLocal getZonasEJB() {
        return zonasEJB;
    }

    public void setZonasEJB(ZonasFacadeLocal zonasEJB) {
        this.zonasEJB = zonasEJB;
    }

    public Zonas getZonas() {
        return zonas;
    }

    public void setZonas(Zonas zonas) {
        this.zonas = zonas;
    }

    public Almacenes getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(Almacenes almacenes) {
        this.almacenes = almacenes;
    }
    
    
}
