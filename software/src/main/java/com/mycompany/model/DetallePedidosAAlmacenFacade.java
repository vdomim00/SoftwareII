/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author riesp
 */
@Stateless
public class DetallePedidosAAlmacenFacade extends AbstractFacade<DetallePedidosAAlmacen> implements DetallePedidosAAlmacenFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_software_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallePedidosAAlmacenFacade() {
        super(DetallePedidosAAlmacen.class);
    }
    
}