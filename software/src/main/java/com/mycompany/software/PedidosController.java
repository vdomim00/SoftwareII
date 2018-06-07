
package com.mycompany.software;

import com.mycompany.ejb.PedidosFacadeLocal;
import com.mycompany.ejb.ProductosFacadeLocal;
import com.mycompany.model.Clientes;
import com.mycompany.model.Pedidos;
import com.mycompany.model.Productos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PedidosController implements Serializable{
    
    @EJB
    private PedidosFacadeLocal pedidosEJB;
    
    @EJB
    private ProductosFacadeLocal productosEJB;
    
    private Clientes clientes;
    private Pedidos pedidos;
    private Productos productos;
    private List<Pedidos> listaPedidos;
    private List<Pedidos> listaPedidosPendientes;
    String idPedido;
    String ingredientes;
    int cantidadLocal;
    
    
    
    @PostConstruct
    public void init(){
        clientes = new Clientes();
        pedidos = new Pedidos();
        productos = new Productos();
        listaPedidos = pedidosEJB.findAll();
        listaPedidosPendientes = pedidosEJB.findAll();
    }
    
    public void registrar(){
        try {
            pedidosEJB.create(pedidos);
        } catch (Exception e) {
        }
    }
    
    public String eliminarPedido(){
    
        String redireccion = "";
        
        try {
            Pedidos pd = pedidosEJB.find(idPedido);
            pedidosEJB.remove(pd);
            redireccion = "/faces/trabajadores/cocinero.xhtml?faces-redirect=true";
            listaPedidos.clear();
            listaPedidos = pedidosEJB.findAll();
            cargarListaPedidosPendientes();
        } catch (Exception e) {
            // Log
        }
        
        return redireccion;
    }
    
    public void cargarListaPedidosPendientes(){
        int i;
        
        listaPedidosPendientes.clear();
        for (i = 0; i < listaPedidos.size(); i++){
            if (listaPedidos.get(i).getEstado().equals("pendiente")){
                listaPedidosPendientes.add(listaPedidos.get(i));
            }
        }
    }
    
    public void cargarPedido(){
        try {
            Pedidos pd = pedidosEJB.find(idPedido);
            if (pd != null){
                pedidos = pd;
                System.out.println("Pedido cargado con id = "+pedidos.getIdPedido());
                listaPedidos.clear();
                listaPedidos = pedidosEJB.findAll();
                cargarListaPedidosPendientes();
            }
            else{
                
            }
        } catch (Exception e) {
            // Log
        }
    }
    
    public String validarPedidoPendiente(){
        String redireccion = "";
        try {
            pedidos.setEstado("confirmado");
            pedidosEJB.edit(pedidos);
            redireccion = "/faces/trabajadores/cocinero.xhtml?faces-redirect=true";
            listaPedidos.clear();
            listaPedidos = pedidosEJB.findAll();
            cargarListaPedidosPendientes();
        } catch (Exception e) {
            // Log
        }
        return redireccion;
    }
    
    public String realizarPedidoCliente(){
        String redireccion = "";
        try {
            pedidos.setEstado("pendiente");
            pedidos.setNombrePlatos(ingredientes);
            pedidos.setValor(calcularPrecioPedidoCliente(ingredientes));
            
            Clientes cl = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if(cl == null){
                clientes.setUsuario("anonimo");
                pedidos.setClientes(clientes);
            }else{
                pedidos.setClientes(cl);
            }

            pedidosEJB.create(pedidos);
            redireccion = "/faces/clientes/registrado.xhtml?faces-redirect=true";
        } catch (Exception e) {
            // Log
        }
        return redireccion;
    }
    
    public int calcularPrecioPedidoCliente(String ingredientes){
        int precioFinal = 0;
        int i = 0;
        String[] misIngredientes = ingredientes.split(", ");
        
        for(i = 0; i < misIngredientes.length; i++){
            productos = productosEJB.find(misIngredientes[i]);
            precioFinal += productos.getPrecio();
        }
        
        return precioFinal;
    }
    
    public void leerIngrediente(String ingrediente){
        this.ingredientes = ingrediente;
    }
    
    public void vaciarIngredientes(){
        this.ingredientes = "";
    }
    
    public void sumarIngredienteLocal(String ingrediente){
        int i;
        
        for (i = 0; i < cantidadLocal; i++){
            ingredientes = ingredientes.concat(", ").concat(ingrediente);
        }
        cantidadLocal = 0;
    }

    public int getCantidadLocal() {
        return cantidadLocal;
    }

    public void setCantidadLocal(int cantidadLocal) {
        this.cantidadLocal = cantidadLocal;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Pedidos> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedidos> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<Pedidos> getListaPedidosPendientes() {
        return listaPedidosPendientes;
    }

    public void setListaPedidosPendientes(List<Pedidos> listaPedidosPendientes) {
        this.listaPedidosPendientes = listaPedidosPendientes;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
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
