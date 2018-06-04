
package com.mycompany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "platos")
public class Platos implements Serializable{

    @Id
    @Column(name = "nombrePlato")
    private String nombrePlato;
    
    @Column(name = "ingredientes")
    private String ingredientes;
    
    @Column(name = "elaboracion")
    private String elaboracion;
    
    @Column(name = "alergenos")
    private String alergenos;
    
    @Column(name = "precio")
    private double precio;
    
    @ManyToMany
    @JoinTable(
        name = "pedidos_has_platos",
        joinColumns = @JoinColumn(name = "pedidos_idVenta", referencedColumnName = "idPedido"),
        inverseJoinColumns = @JoinColumn(name = "platos_nombrePlato", referencedColumnName = "nombrePlato"))
    private List<Pedidos> pedidos;

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    
    
    
    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public String getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String alergenos) {
        this.alergenos = alergenos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Platos other = (Platos) obj;
        if (!Objects.equals(this.nombrePlato, other.nombrePlato)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Platos{" + "nombrePlato=" + nombrePlato + '}';
    }
    
    
}
