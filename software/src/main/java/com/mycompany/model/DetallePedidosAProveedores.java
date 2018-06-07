
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallepedidosaproveedores")
public class DetallePedidosAProveedores implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle_pedidosAProveedores;
    
    @ManyToOne
    @JoinColumn(name = "productos_codigoProducto", referencedColumnName = "codigoProducto")
    private Productos productos;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "pedidosAProveedores_idPedidoAProveedor", referencedColumnName = "idPedidoAProveedor")
    private PedidosAProveedores pedidosAProveedores;

    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "estado")
    private String estado;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    public int getIdDetalle_pedidosAProveedores() {
        return idDetalle_pedidosAProveedores;
    }

    public void setIdDetalle_pedidosAProveedores(int idDetalle_pedidosAProveedores) {
        this.idDetalle_pedidosAProveedores = idDetalle_pedidosAProveedores;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public PedidosAProveedores getPedidosAProveedores() {
        return pedidosAProveedores;
    }

    public void setPedidosAProveedores(PedidosAProveedores pedidosAProveedores) {
        this.pedidosAProveedores = pedidosAProveedores;
    }


    
}
