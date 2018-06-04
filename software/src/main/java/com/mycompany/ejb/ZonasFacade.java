/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Zonas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author riesp
 */
@Stateless
public class ZonasFacade extends AbstractFacade<Zonas> implements ZonasFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_software_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZonasFacade() {
        super(Zonas.class);
    }
    
}
