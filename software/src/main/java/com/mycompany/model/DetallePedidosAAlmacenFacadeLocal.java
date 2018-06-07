/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface DetallePedidosAAlmacenFacadeLocal {

    void create(DetallePedidosAAlmacen detallePedidosAAlmacen);

    void edit(DetallePedidosAAlmacen detallePedidosAAlmacen);

    void remove(DetallePedidosAAlmacen detallePedidosAAlmacen);

    DetallePedidosAAlmacen find(Object id);

    List<DetallePedidosAAlmacen> findAll();

    List<DetallePedidosAAlmacen> findRange(int[] range);

    int count();
    
}
