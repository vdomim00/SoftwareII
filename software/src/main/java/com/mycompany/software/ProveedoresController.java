
package com.mycompany.software;

import com.mycompany.ejb.ProveedoresFacadeLocal;
import com.mycompany.model.Platos;
import com.mycompany.model.Proveedores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private List<Proveedores> listaProveedores;
    private String CIF;
    
    @PostConstruct
    public void init(){
        proveedores = new Proveedores();
        listaProveedores = proveedoresEJB.findAll();
    }
    
    public String eliminar(){
        
        String redireccion = "";
        
        try {
            System.out.println("Entra si");
            System.out.println("CIF: "+CIF);
            Proveedores pr = proveedoresEJB.find(CIF);
            proveedoresEJB.remove(pr);
            redireccion = "/faces/trabajadores/admin.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public String modificar(){
    
        String redireccion = "";
        try {
            proveedoresEJB.edit(proveedores);
            redireccion = "/faces/trabajadores/admin.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public void buscarProveedor(){
    
        try {
            Proveedores pr = proveedoresEJB.find(CIF);
            proveedores = pr;
            
        } catch (Exception e) {
        }
    }
    
    public String registrar(){
        
        String redireccion = "";
        
        try {
            proveedoresEJB.create(proveedores);
            redireccion = "/faces/trabajadores/admin.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }

    public List<Proveedores> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedores> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
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
