
package com.mycompany.software;

import com.mycompany.ejb.ClientesFacadeLocal;
import com.mycompany.model.Clientes;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ClientesController implements Serializable{
    
    @EJB
    private ClientesFacadeLocal clientesEJB;
    
    private Clientes clientes;
    
    @PostConstruct
    public void init(){
        clientes = new Clientes();
    }
    
    public void registrar(){
        try {
            clientesEJB.create(clientes);
        } catch (Exception e) {
        }
    }

    public ClientesFacadeLocal getClientesEJB() {
        return clientesEJB;
    }

    public void setClientesEJB(ClientesFacadeLocal clientesEJB) {
        this.clientesEJB = clientesEJB;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    
    
}
