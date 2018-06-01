
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "platos_has_productos")
public class Platos_Has_Productos implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "Platos_nombrePlato")
    private String platos_NombrePlato;
    
    @Column(name = "Productos_codigoProducto")
    private String productos_CodigoProductos;

    public String getPlatos_NombrePlato() {
        return platos_NombrePlato;
    }

    public void setPlatos_NombrePlato(String platos_NombrePlato) {
        this.platos_NombrePlato = platos_NombrePlato;
    }

    public String getProductos_CodigoProductos() {
        return productos_CodigoProductos;
    }

    public void setProductos_CodigoProductos(String productos_CodigoProductos) {
        this.productos_CodigoProductos = productos_CodigoProductos;
    }
    
    
}
