
package com.mycompany.software;

import com.mycompany.ejb.PedidosAAlmacenFacadeLocal;
import com.mycompany.ejb.ProductosFacadeLocal;
import com.mycompany.model.DetallePedidosAAlmacen;
import com.mycompany.model.DetallePedidosAAlmacenFacadeLocal;
import com.mycompany.model.PedidosAAlmacen;
import com.mycompany.model.Productos;
import com.sun.javafx.geom.transform.BaseTransform;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PedidosAAlmacenController implements Serializable{
    
    @EJB
    private PedidosAAlmacenFacadeLocal pedidosAAlmacenEJB;
    
    @EJB
    private ProductosFacadeLocal productosEJB;
    
    @EJB
    private DetallePedidosAAlmacenFacadeLocal detallePedidosAAlmacenEJB;
    
    private DetallePedidosAAlmacen detallePedidosAAlmacen;
    private PedidosAAlmacen pedidosAAlmacen;
    private Productos productos;
    private List<Productos> listaProductos;
    private List<PedidosAAlmacen> listaPedidosAAlmacen;
    private String idProducto;
    private int idPedido;
    private List<Integer> cantidad;
    private Integer cant;
    
    @PostConstruct
    public void init(){
        pedidosAAlmacen = new PedidosAAlmacen();
        productos = new Productos();
        listaProductos = new ArrayList<Productos>();
        detallePedidosAAlmacen = new DetallePedidosAAlmacen();
        listaPedidosAAlmacen = new ArrayList<PedidosAAlmacen>();
        cantidad = new ArrayList<Integer>();
    }
    
    public void añadirProducto(){
        
        System.out.println("Añadimos "+idProducto);
        productos = productosEJB.find(idProducto);
        System.out.println("Encontramos el producto "+productos.getCodigoProducto());
        listaProductos.add(productos);
        
        cantidad.add(cant);
        
        System.out.println("Lista actual:");
        
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println("Producto "+i+" : "+listaProductos.get(i).getCodigoProducto());
            System.out.println("Cantidad "+i+" : "+cantidad.get(i));
        }
    }
    
    public String hacerPedido(){
        
        String redireccion = "";
        
        listaPedidosAAlmacen = pedidosAAlmacenEJB.findAll();
        idPedido = listaPedidosAAlmacen.size();
        System.out.println("IdPedido: "+idPedido);
        pedidosAAlmacen.setIdPedido(idPedido);
        pedidosAAlmacenEJB.create(pedidosAAlmacen);
        pedidosAAlmacen = pedidosAAlmacenEJB.find(pedidosAAlmacen.getIdPedido());
        
        for (int i = 0; i < listaProductos.size(); i++) {
            
            detallePedidosAAlmacen.setCantidad(cantidad.get(i));
            detallePedidosAAlmacen.setPedidosAAlmacen(pedidosAAlmacen);
            detallePedidosAAlmacen.setProductos(listaProductos.get(i));
            
            detallePedidosAAlmacenEJB.create(detallePedidosAAlmacen);
        }
        
        return redireccion = "/faces/trabajadores/cocinero.xhtml?faces-redirect=true";
    }
    
    public void registrar(){
        try {
            pedidosAAlmacenEJB.create(pedidosAAlmacen);
        } catch (Exception e) {
        }
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    
    public ProductosFacadeLocal getProductosEJB() {
        return productosEJB;
    }

    public void setProductosEJB(ProductosFacadeLocal productosEJB) {
        this.productosEJB = productosEJB;
    }

    public DetallePedidosAAlmacenFacadeLocal getDetallePedidosAAlmacenEJB() {
        return detallePedidosAAlmacenEJB;
    }

    public void setDetallePedidosAAlmacenEJB(DetallePedidosAAlmacenFacadeLocal detallePedidosAAlmacenEJB) {
        this.detallePedidosAAlmacenEJB = detallePedidosAAlmacenEJB;
    }

    public DetallePedidosAAlmacen getDetallePedidosAAlmacen() {
        return detallePedidosAAlmacen;
    }

    public void setDetallePedidosAAlmacen(DetallePedidosAAlmacen detallePedidosAAlmacen) {
        this.detallePedidosAAlmacen = detallePedidosAAlmacen;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<PedidosAAlmacen> getListaPedidosAAlmacen() {
        return listaPedidosAAlmacen;
    }

    public void setListaPedidosAAlmacen(List<PedidosAAlmacen> listaPedidosAAlmacen) {
        this.listaPedidosAAlmacen = listaPedidosAAlmacen;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(List<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    
    public PedidosAAlmacenFacadeLocal getPedidosAAlmacenEJB() {
        return pedidosAAlmacenEJB;
    }

    public void setPedidosAAlmacenEJB(PedidosAAlmacenFacadeLocal pedidosAAlmacenEJB) {
        this.pedidosAAlmacenEJB = pedidosAAlmacenEJB;
    }

    public PedidosAAlmacen getPedidosAAlmacen() {
        return pedidosAAlmacen;
    }

    public void setPedidosAAlmacen(PedidosAAlmacen pedidosAAlmacen) {
        this.pedidosAAlmacen = pedidosAAlmacen;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
