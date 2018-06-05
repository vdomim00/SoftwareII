/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Trabajadores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author riesp
 */
@Stateless
public class TrabajadoresFacade extends AbstractFacade<Trabajadores> implements TrabajadoresFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_software_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajadoresFacade() {
        super(Trabajadores.class);
    }
 
    @Override
    public Trabajadores iniciarSesion(Trabajadores tr){
        
        Trabajadores trabajadores = null;
        String consulta;
        
        try {
            consulta = "FROM Trabajadores t WHERE t.usuario = ?1 and t.pass = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, tr.getUsuario());
            query.setParameter(2, tr.getPass());
            
            List<Trabajadores> lista =  query.getResultList();
            
            if(!lista.isEmpty()){
                trabajadores = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        
        return trabajadores;
    }
}
