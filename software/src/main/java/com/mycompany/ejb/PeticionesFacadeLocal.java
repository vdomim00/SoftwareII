/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Peticiones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface PeticionesFacadeLocal {

    void create(Peticiones peticiones);

    void edit(Peticiones peticiones);

    void remove(Peticiones peticiones);

    Peticiones find(Object id);

    List<Peticiones> findAll();

    List<Peticiones> findRange(int[] range);

    int count();
    
}
