
package com.mycompany.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "secciones")
public class Secciones implements Serializable{
    
    @Id
    @Column(name = "nombreSeccion")
    private String nombreSeccion;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "nombreZona", name = "zonas_nombreZona")
    private Zonas zonas;

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public Zonas getZonas() {
        return zonas;
    }

    public void setZonas(Zonas zonas) {
        this.zonas = zonas;
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
        final Secciones other = (Secciones) obj;
        if (!Objects.equals(this.nombreSeccion, other.nombreSeccion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Secciones{" + "nombreSeccion=" + nombreSeccion + '}';
    }
    
    
}
