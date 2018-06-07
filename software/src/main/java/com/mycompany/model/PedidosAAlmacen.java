
package com.mycompany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidosAAlmacen")
public class PedidosAAlmacen implements Serializable{
    
    @Id
    @Column(name = "idPedido")
    private int idPedido;

    @OneToMany(mappedBy = "pedidosAAlmacen", cascade = CascadeType.ALL)
    private List<DetallePedidosAAlmacen> detallePedidosAAlmacen;

    public List<DetallePedidosAAlmacen> getDetallePedidosAAlmacen() {
        return detallePedidosAAlmacen;
    }

    public void setDetallePedidosAAlmacen(List<DetallePedidosAAlmacen> detallePedidosAAlmacen) {
        this.detallePedidosAAlmacen = detallePedidosAAlmacen;
    }
    
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidosAAlmacen other = (PedidosAAlmacen) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidosAAlmacen{" + "idPedido=" + idPedido + '}';
    }
    
    
}
