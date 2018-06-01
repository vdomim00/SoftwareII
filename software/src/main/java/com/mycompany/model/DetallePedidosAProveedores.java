
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detallepedidosaproveedores")
public class DetallePedidosAProveedores implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productos_CodigoProducto;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pedidosAProveedores_idPedidoAProveedor;
    
    @Column(name = "cantidad")
    private int cantidad;

    public String getProductos_CodigoProducto() {
        return productos_CodigoProducto;
    }

    public void setProductos_CodigoProducto(String productos_CodigoProducto) {
        this.productos_CodigoProducto = productos_CodigoProducto;
    }

    public int getPedidosAProveedores_idPedidoAProveedor() {
        return pedidosAProveedores_idPedidoAProveedor;
    }

    public void setPedidosAProveedores_idPedidoAProveedor(int pedidosAProveedores_idPedidoAProveedor) {
        this.pedidosAProveedores_idPedidoAProveedor = pedidosAProveedores_idPedidoAProveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
