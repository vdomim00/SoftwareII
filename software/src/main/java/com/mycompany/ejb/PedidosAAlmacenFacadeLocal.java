/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.PedidosAAlmacen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface PedidosAAlmacenFacadeLocal {

    void create(PedidosAAlmacen pedidosAAlmacen);

    void edit(PedidosAAlmacen pedidosAAlmacen);

    void remove(PedidosAAlmacen pedidosAAlmacen);

    PedidosAAlmacen find(Object id);

    List<PedidosAAlmacen> findAll();

    List<PedidosAAlmacen> findRange(int[] range);

    int count();
    
}
