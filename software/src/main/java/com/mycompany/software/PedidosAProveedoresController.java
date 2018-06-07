
package com.mycompany.software;

import com.mycompany.ejb.DetallePedidosAProveedoresFacadeLocal;
import com.mycompany.ejb.PedidosAProveedoresFacadeLocal;
import com.mycompany.ejb.ProductosFacadeLocal;
import com.mycompany.ejb.ProveedoresFacadeLocal;
import com.mycompany.ejb.TrabajadoresFacadeLocal;
import com.mycompany.model.DetallePedidosAAlmacen;
import com.mycompany.model.DetallePedidosAProveedores;
import com.mycompany.model.PedidosAProveedores;
import com.mycompany.model.Productos;
import com.mycompany.model.Proveedores;
import com.mycompany.model.Trabajadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PedidosAProveedoresController implements Serializable{
    
    @EJB
    private PedidosAProveedoresFacadeLocal  pedidosAProveedoresEJB;
    
    @EJB
    private ProductosFacadeLocal productosEJB;
    
    @EJB
    private TrabajadoresFacadeLocal trabajadoresEJB;
    
    @EJB
    private ProveedoresFacadeLocal proveedoresEJB;
    
    @EJB
    private DetallePedidosAProveedoresFacadeLocal detallePedidosAProveedoresEJB;
    
    private String idProducto;
    private String idPoveedor;
    private int idPedido;
    private PedidosAProveedores pedidosAProveedores;
    private DetallePedidosAProveedores detallePedidosAProveedores;
    private Proveedores proveedores;
    private Trabajadores trabajadores;
    private List<Integer> cantidad;
    private List<Productos> listaProductos;
    private List<PedidosAProveedores> listaPedidosAProveedores;
    private Integer cant;
    private Productos productos;
    private double suma;
    
    
    @PostConstruct
    public void init(){
        pedidosAProveedores = new PedidosAProveedores();
        proveedores = new Proveedores();
        trabajadores = new Trabajadores();
        cantidad = new ArrayList<Integer>();
        listaProductos = new ArrayList<Productos>();
        productos = new Productos();
        detallePedidosAProveedores = new DetallePedidosAProveedores();
        listaPedidosAProveedores = new ArrayList<PedidosAProveedores>();
        suma = 0;
    }
    
    public void añadir(){
    
        try {
            productos = productosEJB.find(idProducto);
            listaProductos.add(productos);
            cantidad.add(cant);
            
            for (int i = 0; i < listaProductos.size(); i++) {
                System.out.println("Producto "+i+" : "+listaProductos.get(i).getCodigoProducto());
                System.out.println("Cantidad "+i+" : "+cantidad.get(i));
            }
        } catch (Exception e) {
        }
    }
    
    public void registrar(){
        try {
            this.pedidosAProveedores.setTrabajadores(trabajadores);
            this.pedidosAProveedores.setProveedores(proveedores);
            pedidosAProveedoresEJB.create(pedidosAProveedores);
        } catch (Exception e) {
        }
    }

    public String hacerPedido(){
        
        String redireccion = "";
        
        try {
            listaPedidosAProveedores = pedidosAProveedoresEJB.findAll();
            idPedido = listaPedidosAProveedores.size();
            
            pedidosAProveedores.setIdPedidoAProveedor(idPedido);
            
            for (int i = 0; i < cantidad.size(); i++) {
                suma = suma + cantidad.get(0);
            }
            pedidosAProveedores.setCoste(suma);
            pedidosAProveedores.setEstado("pendiente");
            proveedores = proveedoresEJB.find(idPoveedor);
            pedidosAProveedores.setProveedores(proveedores);
            trabajadores = trabajadoresEJB.find("enc");
            pedidosAProveedores.setTrabajadores(trabajadores);
            pedidosAProveedoresEJB.create(pedidosAProveedores);
            pedidosAProveedores = pedidosAProveedoresEJB.find(pedidosAProveedores.getIdPedidoAProveedor());
            
            for (int i = 0; i < listaProductos.size(); i++) {
            
                detallePedidosAProveedores.setCantidad(cantidad.get(i));
                detallePedidosAProveedores.setPedidosAProveedores(pedidosAProveedores);
                detallePedidosAProveedores.setProductos(listaProductos.get(i));
                detallePedidosAProveedores.setEstado("pendiente");
                proveedores = proveedoresEJB.find(idPoveedor);

                detallePedidosAProveedoresEJB.create(detallePedidosAProveedores);
                
                redireccion = "/faces/trabajadores/encargado.xhtml?faces-redirect=true";
        }
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    public ProductosFacadeLocal getProductosEJB() {
        return productosEJB;
    }

    public void setProductosEJB(ProductosFacadeLocal productosEJB) {
        this.productosEJB = productosEJB;
    }

    public DetallePedidosAProveedoresFacadeLocal getDetallePedidosAProveedoresEJB() {
        return detallePedidosAProveedoresEJB;
    }

    public void setDetallePedidosAProveedoresEJB(DetallePedidosAProveedoresFacadeLocal detallePedidosAProveedoresEJB) {
        this.detallePedidosAProveedoresEJB = detallePedidosAProveedoresEJB;
    }


    public List<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(List<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    
    public String getIdPoveedor() {
        return idPoveedor;
    }

    public void setIdPoveedor(String idPoveedor) {
        this.idPoveedor = idPoveedor;
    }

    
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    
    public PedidosAProveedoresFacadeLocal getPedidosAProveedoresEJB() {
        return pedidosAProveedoresEJB;
    }

    public void setPedidosAProveedoresEJB(PedidosAProveedoresFacadeLocal pedidosAProveedoresEJB) {
        this.pedidosAProveedoresEJB = pedidosAProveedoresEJB;
    }

    public PedidosAProveedores getPedidosAProveedores() {
        return pedidosAProveedores;
    }

    public void setPedidosAProveedores(PedidosAProveedores pedidosAProveedores) {
        this.pedidosAProveedores = pedidosAProveedores;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    
}
