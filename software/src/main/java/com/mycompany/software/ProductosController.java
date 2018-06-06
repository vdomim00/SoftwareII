
package com.mycompany.software;

import com.mycompany.ejb.ProductosFacadeLocal;
import com.mycompany.ejb.SeccionesFacadeLocal;
import com.mycompany.model.Productos;
import com.mycompany.model.Secciones;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ProductosController implements Serializable{
    
    @EJB
    private ProductosFacadeLocal productosEJB;
    
    @EJB
    private SeccionesFacadeLocal seccionesEJB;
    
    private Productos productos;
    private Secciones secciones;
    private List<Secciones> listaSecciones;
    private List<Productos> listaProductos;
    private String seccion;
    private String idProducto;
    
    @PostConstruct
    public void init(){
        productos = new Productos();
        secciones = new Secciones();
        listaSecciones = seccionesEJB.findAll();
        listaProductos = productosEJB.findAll();
    }
    
    public String modificar(){
    
        String redireccion = "";
        
        try {
            productosEJB.edit(productos);
            redireccion = "/faces/trabajadores/encargado.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public void buscarProducto(){
    
        try {
            Productos pr = productosEJB.find(idProducto);
            productos = pr;
        } catch (Exception e) {
        }
    }
    
    public String eliminar(){
        
        String redireccion = "";
        
        try {
            Productos pr = productosEJB.find(idProducto);
            productosEJB.remove(pr);
            redireccion = "/faces/trabajadores/encargado.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public String registrar(){
        
        String redireccion = "";
        
        try {
            System.out.println("Seccion: "+seccion);
            secciones = seccionesEJB.find(seccion);
            this.productos.setSecciones(secciones);
            productosEJB.create(productos);
            redireccion = "/faces/trabajadores/encargado.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    
    public Secciones getSecciones() {
        return secciones;
    }

    public void setSecciones(Secciones secciones) {
        this.secciones = secciones;
    }

    public SeccionesFacadeLocal getSeccionesEJB() {
        return seccionesEJB;
    }

    public void setSeccionesEJB(SeccionesFacadeLocal seccionesEJB) {
        this.seccionesEJB = seccionesEJB;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public List<Secciones> getListaSecciones() {
        return listaSecciones;
    }

    public void setListaSecciones(List<Secciones> listaSecciones) {
        this.listaSecciones = listaSecciones;
    }

   
    public ProductosFacadeLocal getProductosEJB() {
        return productosEJB;
    }

    public void setProductosEJB(ProductosFacadeLocal productosEJB) {
        this.productosEJB = productosEJB;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
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
        final ProductosController other = (ProductosController) obj;
        if (!Objects.equals(this.productosEJB, other.productosEJB)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductosController{" + "productosEJB=" + productosEJB + '}';
    }
    
    
}
