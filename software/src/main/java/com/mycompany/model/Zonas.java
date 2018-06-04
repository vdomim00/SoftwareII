
package com.mycompany.model;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zonas")
public class Zonas {
    
    @Id
    @Column(name = "nombreZona")
    private String nombreZona;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "idAlmacen", name = "almacen_idAlmacen")
    private Almacenes almacenes;

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public Almacenes getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(Almacenes almacenes) {
        this.almacenes = almacenes;
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
        final Zonas other = (Zonas) obj;
        if (!Objects.equals(this.nombreZona, other.nombreZona)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zonas{" + "nombreZona=" + nombreZona + '}';
    }
    
    
}
