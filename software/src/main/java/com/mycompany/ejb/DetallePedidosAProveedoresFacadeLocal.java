/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.DetallePedidosAProveedores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface DetallePedidosAProveedoresFacadeLocal {

    void create(DetallePedidosAProveedores detallePedidosAProveedores);

    void edit(DetallePedidosAProveedores detallePedidosAProveedores);

    void remove(DetallePedidosAProveedores detallePedidosAProveedores);

    DetallePedidosAProveedores find(Object id);

    List<DetallePedidosAProveedores> findAll();

    List<DetallePedidosAProveedores> findRange(int[] range);

    int count();
    
}
