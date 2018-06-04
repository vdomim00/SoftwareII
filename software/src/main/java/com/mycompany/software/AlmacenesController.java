
package com.mycompany.software;

import com.mycompany.ejb.AlmacenesFacadeLocal;
import com.mycompany.model.Almacenes;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AlmacenesController implements Serializable{
    
    @EJB
    private AlmacenesFacadeLocal almacenesEJB;
    
    private Almacenes almacenes;
    
    @PostConstruct
    public void init(){
        almacenes = new Almacenes();
    }
    
    public void registrar(){
        try {
            almacenesEJB.create(almacenes);
        } catch (Exception e) {
        }
    }

    public AlmacenesFacadeLocal getAlmacenesEJB() {
        return almacenesEJB;
    }

    public void setAlmacenesEJB(AlmacenesFacadeLocal almacenesEJB) {
        this.almacenesEJB = almacenesEJB;
    }

    public Almacenes getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(Almacenes almacenes) {
        this.almacenes = almacenes;
    }
    
    
}
