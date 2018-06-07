
package com.mycompany.model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "valor")
    private double valor;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaVenta")
    private Date fechaVenta;
    
    @Column(name = "nombrePlatos")
    private String nombrePlatos;
    
    @Column(name = "observaciones")
    private String observaciones;
    

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "usuario", name = "clientes_usuario")
    private Clientes clientes = new Clientes();
    
    @OneToMany(mappedBy = "pedidos")
    private List<Pedidos_has_platos> pedidos_has_platos = new ArrayList<Pedidos_has_platos>();
    
<<<<<<< HEAD
    @ManyToMany(mappedBy = "pedidos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
=======
    public List<Pedidos_has_platos> getPedidos_has_platos() {
        return pedidos_has_platos;
    }

    public void setPedidos_has_platos(List<Pedidos_has_platos> pedidos_has_platos) {
        this.pedidos_has_platos = pedidos_has_platos;
    }
    
    // Borrar
    @ManyToMany(mappedBy = "pedidos")
>>>>>>> d2c41c3fdca72ecee07265cdbd795cb1bb27f768
    private List<Platos> platos = new ArrayList<Platos>();

    public List<Platos> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Platos> platos) {
        this.platos = platos;
    }
    
    //
    
    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombrePlatos() {
        return nombrePlatos;
    }

    public void setNombrePlatos(String nombrePlatos) {
        this.nombrePlatos = nombrePlatos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        final Pedidos other = (Pedidos) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "idPedido=" + idPedido + '}';
    }
    
    
}
