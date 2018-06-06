/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Pedidos_has_platos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Adrian
 */
@Local
public interface Pedidos_has_platosFacadeLocal {

    void create(Pedidos_has_platos pedidos_has_platos);

    void edit(Pedidos_has_platos pedidos_has_platos);

    void remove(Pedidos_has_platos pedidos_has_platos);

    Pedidos_has_platos find(Object id);

    List<Pedidos_has_platos> findAll();

    List<Pedidos_has_platos> findRange(int[] range);

    int count();
    
}
