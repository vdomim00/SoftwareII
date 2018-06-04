/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Trabajadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface TrabajadoresFacadeLocal {

    void create(Trabajadores trabajadores);

    void edit(Trabajadores trabajadores);

    void remove(Trabajadores trabajadores);

    Trabajadores find(Object id);

    List<Trabajadores> findAll();

    List<Trabajadores> findRange(int[] range);

    int count();
    
}
