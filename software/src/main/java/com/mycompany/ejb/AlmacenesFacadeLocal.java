/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Almacenes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface AlmacenesFacadeLocal {

    void create(Almacenes almacenes);

    void edit(Almacenes almacenes);

    void remove(Almacenes almacenes);

    Almacenes find(Object id);

    List<Almacenes> findAll();

    List<Almacenes> findRange(int[] range);

    int count();
    
}
