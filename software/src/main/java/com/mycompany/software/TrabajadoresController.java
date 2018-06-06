
package com.mycompany.software;

import com.mycompany.ejb.TrabajadoresFacadeLocal;
import com.mycompany.model.Trabajadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TrabajadoresController implements Serializable{
    
    @EJB
    private TrabajadoresFacadeLocal trabajadoresEJB;
    
    private Trabajadores trabajadores;
    private List<Trabajadores> listaTrabajadores;
    private String usuario;
    private String pass;
    
    @PostConstruct
    public void init(){
        trabajadores = new Trabajadores();
        listaTrabajadores = trabajadoresEJB.findAll();
    }
    
    public String eliminar(){
    
        String redireccion = "";
        
        try {
            Trabajadores tr = trabajadoresEJB.find(usuario);
            trabajadoresEJB.remove(tr);
            redireccion = "/faces/trabajadores/admin.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }
    
    public String modificar(){
        
        String redireccion = "";
        try {
            
            System.out.println("Modificar");
            System.out.println("Modificamos "+trabajadores.getUsuario());
            
            if(trabajadores.getPass().isEmpty()){
                trabajadores.setPass(pass);
            }
            trabajadoresEJB.edit(trabajadores);
            redireccion = "/faces/trabajadores/admin.xhtml?faces-redirect=true";
        } catch (Exception e) {
            
        }
        
        return redireccion;
    }
    
    public void buscarTrabajador(){
    
        try {
            System.out.println("Entra si");
            System.out.println("Usuario: "+usuario);
            Trabajadores tr = trabajadoresEJB.find(usuario);
            System.out.println("Trabajador encontrado: "+tr.getUsuario());
            trabajadores = tr;
            pass = trabajadores.getPass();
            System.out.println("Apellido encontrado: "+tr.getApellidos());
            System.out.println("Pass encontrado: "+tr.getPass());
        } catch (Exception e) {
        }        
    }
    
    public String registrar(){
        
        String redireccion = null;
        try {
            trabajadoresEJB.create(trabajadores);
            redireccion = "/faces/trabajadores/admin.xhtml?faces-redirect=true";
        } catch (Exception e) {
        }
        
        return redireccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public List<Trabajadores> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajadores> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }
    
    
    public TrabajadoresFacadeLocal getTrabajadoresEJB() {
        return trabajadoresEJB;
    }

    public void setTrabajadoresEJB(TrabajadoresFacadeLocal trabajadoresEJB) {
        this.trabajadoresEJB = trabajadoresEJB;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    
}
