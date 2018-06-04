
package com.mycompany.software;

import com.mycompany.ejb.PedidosFacadeLocal;
import com.mycompany.model.Clientes;
import com.mycompany.model.Pedidos;
import com.mycompany.model.Platos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PedidosController implements Serializable{
    
    @EJB
    private PedidosFacadeLocal pedidosEJB;
    
    private Clientes clientes;
    private Pedidos pedidos;
    
    @PostConstruct
    public void init(){
        clientes = new Clientes();
        pedidos = new Pedidos();
    }
    
    public void registrar(){
        try {
            pedidosEJB.create(pedidos);
        } catch (Exception e) {
        }
    }

    public PedidosFacadeLocal getPedidosEJB() {
        return pedidosEJB;
    }

    public void setPedidosEJB(PedidosFacadeLocal pedidosEJB) {
        this.pedidosEJB = pedidosEJB;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    
    
}
