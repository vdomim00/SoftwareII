
package com.mycompany.software;

import com.mycompany.ejb.PedidosAAlmacenFacadeLocal;
import com.mycompany.model.PedidosAAlmacen;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PedidosAAlmacenController implements Serializable{
    
    @EJB
    private PedidosAAlmacenFacadeLocal pedidosAAlmacenEJB;
    
    private PedidosAAlmacen pedidosAAlmacen;
    
    @PostConstruct
    public void init(){
        pedidosAAlmacen = new PedidosAAlmacen();
    }
    
    public void registrar(){
        try {
            pedidosAAlmacenEJB.create(pedidosAAlmacen);
        } catch (Exception e) {
        }
    }

    public PedidosAAlmacenFacadeLocal getPedidosAAlmacenEJB() {
        return pedidosAAlmacenEJB;
    }

    public void setPedidosAAlmacenEJB(PedidosAAlmacenFacadeLocal pedidosAAlmacenEJB) {
        this.pedidosAAlmacenEJB = pedidosAAlmacenEJB;
    }

    public PedidosAAlmacen getPedidosAAlmacen() {
        return pedidosAAlmacen;
    }

    public void setPedidosAAlmacen(PedidosAAlmacen pedidosAAlmacen) {
        this.pedidosAAlmacen = pedidosAAlmacen;
    }
    
    
}
