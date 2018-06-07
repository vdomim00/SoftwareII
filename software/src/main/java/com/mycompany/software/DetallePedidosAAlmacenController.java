
package com.mycompany.software;

import com.mycompany.model.DetallePedidosAAlmacen;
import com.mycompany.model.DetallePedidosAAlmacenFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DetallePedidosAAlmacenController implements Serializable{
    
    @EJB
    private DetallePedidosAAlmacenFacadeLocal detallePedidosAAlmacenEJB;
    
    private DetallePedidosAAlmacen detallePedidosAAlmacen;
    
    @PostConstruct
    public void init(){
        detallePedidosAAlmacen = new DetallePedidosAAlmacen();
    }
    
    public void registrar(){
        
        try {
            detallePedidosAAlmacenEJB.create(detallePedidosAAlmacen);
        } catch (Exception e) {
        }
    }

    public DetallePedidosAAlmacenFacadeLocal getDetallePedidosAAlmacenEJB() {
        return detallePedidosAAlmacenEJB;
    }

    public void setDetallePedidosAAlmacenEJB(DetallePedidosAAlmacenFacadeLocal detallePedidosAAlmacenEJB) {
        this.detallePedidosAAlmacenEJB = detallePedidosAAlmacenEJB;
    }

    
    public DetallePedidosAAlmacen getDetallePedidosAAlmacen() {
        return detallePedidosAAlmacen;
    }

    public void setDetallePedidosAAlmacen(DetallePedidosAAlmacen detallePedidosAAlmacen) {
        this.detallePedidosAAlmacen = detallePedidosAAlmacen;
    }
    
    
}
