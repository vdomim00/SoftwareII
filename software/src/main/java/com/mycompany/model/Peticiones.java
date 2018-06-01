
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peticiones")
public class Peticiones implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPeticion;
    
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
    
    @Column(name = "Trabajadores_usuario")
    private String trabajadores_usuario;

    public int getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(int idPeticion) {
        this.idPeticion = idPeticion;
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

    public String getTrabajadores_usuario() {
        return trabajadores_usuario;
    }

    public void setTrabajadores_usuario(String trabajadores_usuario) {
        this.trabajadores_usuario = trabajadores_usuario;
    }
    
    
}
