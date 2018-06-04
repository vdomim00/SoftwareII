
package com.mycompany.software;

import com.mycompany.ejb.PedidosAProveedoresFacadeLocal;
import com.mycompany.model.PedidosAProveedores;
import com.mycompany.model.Proveedores;
import com.mycompany.model.Trabajadores;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PedidosAProveedoresController implements Serializable{
    
    @EJB
    private PedidosAProveedoresFacadeLocal  pedidosAProveedoresEJB;
    
    private PedidosAProveedores pedidosAProveedores;
    private Proveedores proveedores;
    private Trabajadores trabajadores;
    
    @PostConstruct
    public void init(){
        pedidosAProveedores = new PedidosAProveedores();
        proveedores = new Proveedores();
        trabajadores = new Trabajadores();
    }
    
    public void registrar(){
        try {
            this.pedidosAProveedores.setTrabajadores(trabajadores);
            this.pedidosAProveedores.setProveedores(proveedores);
            pedidosAProveedoresEJB.create(pedidosAProveedores);
        } catch (Exception e) {
        }
    }

    public PedidosAProveedoresFacadeLocal getPedidosAProveedoresEJB() {
        return pedidosAProveedoresEJB;
    }

    public void setPedidosAProveedoresEJB(PedidosAProveedoresFacadeLocal pedidosAProveedoresEJB) {
        this.pedidosAProveedoresEJB = pedidosAProveedoresEJB;
    }

    public PedidosAProveedores getPedidosAProveedores() {
        return pedidosAProveedores;
    }

    public void setPedidosAProveedores(PedidosAProveedores pedidosAProveedores) {
        this.pedidosAProveedores = pedidosAProveedores;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    
}
