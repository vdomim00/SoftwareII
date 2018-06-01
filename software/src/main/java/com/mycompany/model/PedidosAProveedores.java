
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "padidosaproveedores")
public class PedidosAProveedores implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedidoAProveedor;
    
    @Column(name = "coste")
    private double coste;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "Proveedores_CIF")
    private String proveedores_CIF;
    
    @Column(name = "Trabajadores_usuario")
    private String trabajadores_Usuario;

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

    public String getProveedores_CIF() {
        return proveedores_CIF;
    }

    public void setProveedores_CIF(String proveedores_CIF) {
        this.proveedores_CIF = proveedores_CIF;
    }

    public String getTrabajadores_Usuario() {
        return trabajadores_Usuario;
    }

    public void setTrabajadores_Usuario(String trabajadores_Usuario) {
        this.trabajadores_Usuario = trabajadores_Usuario;
    }
    
    
}
