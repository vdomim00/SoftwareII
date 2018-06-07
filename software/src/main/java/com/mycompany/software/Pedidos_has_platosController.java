/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.software;

import com.mycompany.ejb.Pedidos_has_platosFacadeLocal;
import com.mycompany.model.Pedidos;
import com.mycompany.model.Pedidos_has_platos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
/**
 *
 * @author Adrian
 */
@Named
@ViewScoped
public class Pedidos_has_platosController implements Serializable {
    @EJB
    private Pedidos_has_platosFacadeLocal pedidos_has_platosEJB;
    
    private Pedidos_has_platos pedidos_has_platos;
    private Pedidos pedidos;
    
    private int cantidadLocal = 0;
    private Pedidos_has_platos pedidos_has_platosLocal;
    private List<Pedidos_has_platos> pedidos_has_platosListLocal;
    
    @PostConstruct
    public void init(){
        pedidos_has_platos = new Pedidos_has_platos();
        pedidos = new Pedidos();
        pedidos_has_platosLocal = new Pedidos_has_platos();
    }
    
    public void vaciarListaLocal(){
        pedidos_has_platosListLocal.clear();
    }
    
    public void anadirAListaLocal(){
        pedidos_has_platosListLocal.add(pedidos_has_platosLocal);
    }
    
    public void registrarListaLocal(){
        int i = 0;
        for (i = 0; i < pedidos_has_platosListLocal.size(); i++){
            registrarDeLista(pedidos_has_platosListLocal.get(i));
        }
        vaciarListaLocal();
    }
    
    public void registrarDeLista (Pedidos_has_platos pedidos_has_platos){
        try {
            pedidos_has_platosEJB.create(pedidos_has_platos);
        } catch (Exception e) {
        }
    }
    
    public void registrar(){
        try {
            pedidos_has_platosEJB.create(pedidos_has_platos);
        } catch (Exception e) {
        }
    }

    public Pedidos_has_platosFacadeLocal getPedidos_has_platosEJB() {
        return pedidos_has_platosEJB;
    }

    public void setPedidos_has_platosEJB(Pedidos_has_platosFacadeLocal pedidos_has_platosEJB) {
        this.pedidos_has_platosEJB = pedidos_has_platosEJB;
    }
    
    public Pedidos_has_platos getPedidos_hasPlatos() {
        return pedidos_has_platos;
    }

    public void setPedidos_has_platos(Pedidos_has_platos pedidos_has_platos) {
        this.pedidos_has_platos = pedidos_has_platos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Pedidos_has_platos getPedidos_has_platosLocal() {
        return pedidos_has_platosLocal;
    }

    public void setPedidos_has_platosLocal(Pedidos_has_platos pedidos_has_platosLocal) {
        this.pedidos_has_platosLocal = pedidos_has_platosLocal;
    }

    public List<Pedidos_has_platos> getPedidos_has_platosListLocal() {
        return pedidos_has_platosListLocal;
    }

    public void setPedidos_has_platosListLocal(List<Pedidos_has_platos> pedidos_has_platosListLocal) {
        this.pedidos_has_platosListLocal = pedidos_has_platosListLocal;
    }

    public int getCantidadLocal() {
        return cantidadLocal;
    }

    public void setCantidadLocal(int cantidadLocal) {
        this.cantidadLocal = cantidadLocal;
    }
    
    
}
