/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Pedidos_has_platos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adrian
 */
@Stateless
public class Pedidos_has_platosFacade extends AbstractFacade<Pedidos_has_platos> implements Pedidos_has_platosFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_software_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Pedidos_has_platosFacade() {
        super(Pedidos_has_platos.class);
    }
    
}
