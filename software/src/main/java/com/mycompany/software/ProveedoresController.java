
package com.mycompany.software;

import com.mycompany.ejb.ProveedoresFacadeLocal;
import com.mycompany.model.Proveedores;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ProveedoresController implements Serializable{
    
    @EJB
    private ProveedoresFacadeLocal proveedoresEJB;
    
    private Proveedores proveedores;
    
    @PostConstruct
    public void init(){
        proveedores = new Proveedores();
    }
    
    public void registrar(){
        try {
            proveedoresEJB.create(proveedores);
        } catch (Exception e) {
        }
    }

    public ProveedoresFacadeLocal getProveedoresEJB() {
        return proveedoresEJB;
    }

    public void setProveedoresEJB(ProveedoresFacadeLocal proveedoresEJB) {
        this.proveedoresEJB = proveedoresEJB;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }
    
    
}
