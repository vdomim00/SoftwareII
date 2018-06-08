
package com.mycompany.software;

import com.mycompany.ejb.ClientesFacadeLocal;
import com.mycompany.ejb.PedidosFacadeLocal;
import com.mycompany.ejb.PlatosFacadeLocal;
import com.mycompany.ejb.ProductosFacadeLocal;
import com.mycompany.model.Clientes;
import com.mycompany.model.Pedidos;
import com.mycompany.model.Platos;
import com.mycompany.model.Productos;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PedidosController implements Serializable{
    
    @EJB
    private PedidosFacadeLocal pedidosEJB;
    
    @EJB
    private ProductosFacadeLocal productosEJB;
    
    @EJB
    private PlatosFacadeLocal platosEJB;
    
    @EJB
    private ClientesFacadeLocal clientesEJB;
    
    private Platos platos;
    private Clientes clientes;
    private Pedidos pedidos;
    private Productos productos;
    private List<Pedidos> listaPedidos;
    private List<Pedidos> listaPedidosPendientes;
    private String idPedido;
    private String ingredientes;
    private String cantidadLocal;
    private List<String> listaCantidad;
    private List<String> listaPlatos;
    
    
    
    @PostConstruct
    public void init(){
        clientes = new Clientes();
        pedidos = new Pedidos();
        productos = new Productos();
        listaPedidos = pedidosEJB.findAll();
        listaPedidosPendientes = pedidosEJB.findAll();
        idPedido = "";
        ingredientes = "";
        cantidadLocal = "";
        listaCantidad = new ArrayList<>();
        listaPlatos = new ArrayList<>();
        listaPedidos = new ArrayList<Pedidos>();
        listaPedidosPendientes = new ArrayList<Pedidos>();
    }
    
    public void cantidadLocalChanged(ValueChangeEvent e){
        cantidadLocal = e.getNewValue().toString();
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
        listaPedidos = pedidosEJB.findAll();
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
                cargarPlatosYCantidades();
            }
            else{
                
            }
        } catch (Exception e) {
            // Log
        }
    }
    
    public void cargarPlatosYCantidades(){
        try {
            listaPlatos.clear();
            listaCantidad.clear();
            String ing = pedidos.getNombrePlatos();
            String[] plaCan = ing.split(" ");
            String[] unPlaCan;

            for (int i = 0; i < plaCan.length; i++){
                unPlaCan = plaCan[i].split("\\.");
                listaPlatos.add(unPlaCan[0]);
                listaCantidad.add(unPlaCan[1]);
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
        System.out.println(" Realizar Pedido Cliente()");
        try {
            pedidos.setEstado("pendiente");
            pedidos.setNombrePlatos(ingredientes);
            pedidos.setValor(calcularPrecioPedidoCliente());
            System.out.println("  **2");
            
            Clientes cl = (Clientes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if(cl == null){
                clientes = clientesEJB.find("anonimo");
                pedidos.setClientes(clientes);
            }else{
                pedidos.setClientes(cl);
            }
            pedidos.setObservaciones("");
            //pedidos.setFechaVenta(Date.from(Instant.MIN));
            System.out.println("  **3");
            pedidosEJB.create(pedidos);
            System.out.println("Pedidos: ");
            System.out.println(" *Estado: "+pedidos.getEstado());
            System.out.println(" *NombrePlatos: "+pedidos.getNombrePlatos());
            System.out.println(" *Valor: "+pedidos.getValor());
            System.out.println(" *Clientes: "+pedidos.getClientes().getUsuario());    
            
            redireccion = "/faces/clientes/registrado.xhtml?faces-redirect=true";
        } catch (Exception e) {
            // Log
            System.out.println("Excepción");
        }
        return redireccion;
    }
    
    public int calcularPrecioPedidoCliente(){
        int precioFinal = 0;
        int i = 0;
        
        for(i = 0; i < listaPlatos.size(); i++){
            if (Integer.valueOf(listaCantidad.get(i)) >= 0){
                platos = platosEJB.find(listaPlatos.get(i));
                precioFinal += platos.getPrecio()*Integer.valueOf(listaCantidad.get(i));
            }
        }
        
        return precioFinal;
    }
    
    public String vaciarIngredientes(){
        this.ingredientes = "";
        return "/faces/clientes/registrado.xhtml?faces-redirect=true";
    }
    
    public void sumarIngredienteLocal(String ingrediente){
        System.out.println("Ingredientes antes: "+ingredientes);
        System.out.println("Cantidad: "+cantidadLocal);
        System.out.println("Ingrediente añadido: "+ingrediente);
        
        ingredientes = ingredientes.concat(ingrediente).concat(".").concat(cantidadLocal).concat(" ");
        listaPlatos.add(ingrediente);
        listaCantidad.add(cantidadLocal);
        System.out.println("Ingredientes después: "+ingredientes);
    }

    public ProductosFacadeLocal getProductosEJB() {
        return productosEJB;
    }

    public void setProductosEJB(ProductosFacadeLocal productosEJB) {
        this.productosEJB = productosEJB;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public List<String> getListaCantidad() {
        return listaCantidad;
    }

    public void setListaCantidad(List<String> listaCantidad) {
        this.listaCantidad = listaCantidad;
    }

    public List<String> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(List<String> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public String getCantidadLocal() {
        return cantidadLocal;
    }

    public void setCantidadLocal(String cantidadLocal) {
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
