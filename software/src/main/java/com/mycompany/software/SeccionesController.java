
package com.mycompany.software;

import com.mycompany.ejb.SeccionesFacadeLocal;
import com.mycompany.model.Secciones;
import com.mycompany.model.Zonas;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class SeccionesController implements Serializable{
    
    @EJB
    private SeccionesFacadeLocal seccionesEJB;
    
    private Secciones secciones;
    private Zonas zonas;
    
    @PostConstruct
    public void init(){
        secciones = new Secciones();
        zonas = new Zonas();
    }
    
    public void registrar(){
        try {
            this.secciones.setZonas(zonas);
            seccionesEJB.create(secciones);
        } catch (Exception e) {
        }
    }

    public SeccionesFacadeLocal getSeccionesEJB() {
        return seccionesEJB;
    }

    public void setSeccionesEJB(SeccionesFacadeLocal seccionesEJB) {
        this.seccionesEJB = seccionesEJB;
    }

    public Secciones getSecciones() {
        return secciones;
    }

    public void setSecciones(Secciones secciones) {
        this.secciones = secciones;
    }

    public Zonas getZonas() {
        return zonas;
    }

    public void setZonas(Zonas zonas) {
        this.zonas = zonas;
    }
    
    
    
}
