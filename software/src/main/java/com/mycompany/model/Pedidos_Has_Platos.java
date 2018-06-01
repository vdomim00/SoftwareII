
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos_has_platos")
public class Pedidos_Has_Platos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pedidos_IdVenta;
    
    @Column(name = "Platos_nombrePlato")
    private String platos_NombrePlato;
    
    @Column(name = "cantidad")
    private int cantidad;

    public int getPedidos_IdVenta() {
        return pedidos_IdVenta;
    }

    public void setPedidos_IdVenta(int pedidos_IdVenta) {
        this.pedidos_IdVenta = pedidos_IdVenta;
    }

    public String getPlatos_NombrePlato() {
        return platos_NombrePlato;
    }

    public void setPlatos_NombrePlato(String platos_NombrePlato) {
        this.platos_NombrePlato = platos_NombrePlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
