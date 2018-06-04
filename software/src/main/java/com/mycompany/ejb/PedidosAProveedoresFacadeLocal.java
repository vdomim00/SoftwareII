/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.PedidosAProveedores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface PedidosAProveedoresFacadeLocal {

    void create(PedidosAProveedores pedidosAProveedores);

    void edit(PedidosAProveedores pedidosAProveedores);

    void remove(PedidosAProveedores pedidosAProveedores);

    PedidosAProveedores find(Object id);

    List<PedidosAProveedores> findAll();

    List<PedidosAProveedores> findRange(int[] range);

    int count();
    
}
