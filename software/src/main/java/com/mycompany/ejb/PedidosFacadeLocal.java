/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Pedidos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface PedidosFacadeLocal {

    void create(Pedidos pedidos);

    void edit(Pedidos pedidos);

    void remove(Pedidos pedidos);

    Pedidos find(Object id);

    List<Pedidos> findAll();

    List<Pedidos> findRange(int[] range);

    int count();
    
}
