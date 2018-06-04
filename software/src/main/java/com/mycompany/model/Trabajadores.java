
package com.mycompany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trabajadores")
public class Trabajadores implements Serializable{
    
    @Id
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "pass")
    private String pass;
    
    @Column(name = "DNI")
    private String DNI;
    
    @Column(name = "numeroSS")
    private String numeroSS;
    
    @Column(name = "numeroCuenta")
    private String numeroCuenta;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "rol")
    private String rol;

    @OneToMany(mappedBy = "trabajadores", cascade = CascadeType.ALL)
    private List<Peticiones> listaPeticiones = new ArrayList<Peticiones>();
    
    @OneToMany(mappedBy = "trabajadores", cascade = CascadeType.ALL)
    private List<PedidosAProveedores> listaPedidosAProveedores = new ArrayList<PedidosAProveedores>();

    public List<PedidosAProveedores> getListaPedidosAProveedores() {
        return listaPedidosAProveedores;
    }

    public void setListaPedidosAProveedores(List<PedidosAProveedores> listaPedidosAProveedores) {
        this.listaPedidosAProveedores = listaPedidosAProveedores;
    }

    
    public List<Peticiones> getListaPeticiones() {
        return listaPeticiones;
    }

    public void setListaPeticiones(List<Peticiones> listaPeticiones) {
        this.listaPeticiones = listaPeticiones;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        final Trabajadores other = (Trabajadores) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trabajadores{" + "usuario=" + usuario + '}';
    }
    
    
}
