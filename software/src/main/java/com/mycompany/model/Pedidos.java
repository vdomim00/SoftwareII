
package com.mycompany.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Column(name = "Clientes_usuario")
    private String clientes_usuario;

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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getClientes_usuario() {
        return clientes_usuario;
    }

    public void setClientes_usuario(String clientes_usuario) {
        this.clientes_usuario = clientes_usuario;
    }
    
    
}
