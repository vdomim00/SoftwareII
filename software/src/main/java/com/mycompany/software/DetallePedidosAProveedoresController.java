
package com.mycompany.software;

import com.mycompany.ejb.DetallePedidosAProveedoresFacadeLocal;
import com.mycompany.model.DetallePedidosAProveedores;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DetallePedidosAProveedoresController implements Serializable{
    
    @EJB
    private DetallePedidosAProveedoresFacadeLocal detallePedidosAProveedoresEJB;
    
    private DetallePedidosAProveedores detallePedidosAProveedores;
    
    @PostConstruct
    public void init(){
        detallePedidosAProveedores = new DetallePedidosAProveedores();
    }
    
    public void registrar(){
        try {
            detallePedidosAProveedoresEJB.create(detallePedidosAProveedores);
        } catch (Exception e) {
        }
    }
}
