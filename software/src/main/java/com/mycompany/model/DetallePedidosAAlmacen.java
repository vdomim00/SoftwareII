
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detallepedidosaalmacen")
public class DetallePedidosAAlmacen implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pedidoAlmacen_idPedido;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productos_codigoProducto;
    
    @Column(name = "cantidad")
    private int cantidad;

    public int getPedidoAlmacen_idPedido() {
        return pedidoAlmacen_idPedido;
    }

    public void setPedidoAlmacen_idPedido(int pedidoAlmacen_idPedido) {
        this.pedidoAlmacen_idPedido = pedidoAlmacen_idPedido;
    }

    public String getProductos_codigoProducto() {
        return productos_codigoProducto;
    }

    public void setProductos_codigoProducto(String productos_codigoProducto) {
        this.productos_codigoProducto = productos_codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
