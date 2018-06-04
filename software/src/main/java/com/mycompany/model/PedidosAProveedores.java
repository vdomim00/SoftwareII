
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
@Table(name = "pedidosaproveedores")
public class PedidosAProveedores implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedidoAProveedor;
    
    @Column(name = "coste")
    private double coste;
    
    @Column(name = "estado")
    private String estado;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "CIF", name = "proveedores_CIF")
    private Proveedores proveedores;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "usuario", name = "trabajadores_usuario")
    private Trabajadores trabajadores;

    public int getIdPedidoAProveedor() {
        return idPedidoAProveedor;
    }

    public void setIdPedidoAProveedor(int idPedidoAProveedor) {
        this.idPedidoAProveedor = idPedidoAProveedor;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final PedidosAProveedores other = (PedidosAProveedores) obj;
        if (this.idPedidoAProveedor != other.idPedidoAProveedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidosAProveedores{" + "idPedidoAProveedor=" + idPedidoAProveedor + '}';
    }
    
    
}
