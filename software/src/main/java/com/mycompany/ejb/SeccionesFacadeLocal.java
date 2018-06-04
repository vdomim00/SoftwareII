/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Secciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author riesp
 */
@Local
public interface SeccionesFacadeLocal {

    void create(Secciones secciones);

    void edit(Secciones secciones);

    void remove(Secciones secciones);

    Secciones find(Object id);

    List<Secciones> findAll();

    List<Secciones> findRange(int[] range);

    int count();
    
}
