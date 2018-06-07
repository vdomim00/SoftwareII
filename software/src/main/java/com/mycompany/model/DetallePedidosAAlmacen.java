
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "detallepedidosaalmacen")
public class DetallePedidosAAlmacen implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;
    
    @ManyToOne
    @JoinColumn(name = "pedidoAlmacen_idPedido", referencedColumnName = "idPedido")
    private PedidosAAlmacen pedidosAAlmacen;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productos_codigoProducto", referencedColumnName = "codigoProducto")
    private Productos productos;
    
    @Column(name = "cantidad")
    private int cantidad;

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public PedidosAAlmacen getPedidosAAlmacen() {
        return pedidosAAlmacen;
    }

    public void setPedidosAAlmacen(PedidosAAlmacen pedidosAAlmacen) {
        this.pedidosAAlmacen = pedidosAAlmacen;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
