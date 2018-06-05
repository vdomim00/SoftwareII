/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Clientes;
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
public class ClientesFacade extends AbstractFacade<Clientes> implements ClientesFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_software_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }
    
    @Override
    public Clientes iniciarSesion(Clientes cl){
        
        Clientes clientes = null;
        String consulta;
        
        try {
            consulta = "FROM clientes c WHERE c.usuario = ?1 and c.pass = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, cl.getUsuario());
            query.setParameter(2, cl.getPass());
            
            List<Clientes> lista =  query.getResultList();
            
            if(!lista.isEmpty()){
                clientes = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        
        return clientes;
    }
    
}
