/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.software;

import com.mycompany.model.Clientes;
import com.mycompany.model.Trabajadores;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Adrian
 */
@Named
@ViewScoped 
public class PlantillaController implements Serializable {
    
    public void verificarSesionCliente(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Clientes cl = (Clientes) context.getExternalContext().getSessionMap().get("usuario");
            
            if (cl == null){
                context.getExternalContext().redirect("anonimo.xhtml?faces-redirect=true");
            }
        }catch(IOException e){
            // Log
        }
    }
    
    public void verificarSesionAdministrador(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Trabajadores tr = (Trabajadores) context.getExternalContext().getSessionMap().get("trabajador");
            if (tr == null){
                context.getExternalContext().redirect("./../index.xhtml?faces-redirect=true");
            }else{
                if(!tr.getRol().equals("administrador")){
                    context.getExternalContext().redirect("./../index.xhtml?faces-redirect=true");
                }
            }
        }catch(IOException e){
            // Log
        }
    }
    
    public void verificarSesionEncargado(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Trabajadores tr = (Trabajadores) context.getExternalContext().getSessionMap().get("trabajador");
            if (tr == null){
                context.getExternalContext().redirect("./../index.xhtml?faces-redirect=true");
            }else{
                if(!tr.getRol().equals("encargado")){
                    context.getExternalContext().redirect("./../index.xhtml?faces-redirect=true");
                }
            }
        }catch(IOException e){
            // Log
        }
    }
    
    public void verificarSesionCocinero(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Trabajadores tr = (Trabajadores) context.getExternalContext().getSessionMap().get("trabajador");
            if (tr == null){
                context.getExternalContext().redirect("./../index.xhtml?faces-redirect=true");
            }else{
                if(!tr.getRol().equals("cocinero")){
                    context.getExternalContext().redirect("./../index.xhtml?faces-redirect=true");
                }
            }
        }catch(IOException e){
            // Log
        }
    }
    
    // getters Cliente
    public String devolverNombreUsuario(){
        String usuario = "";
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Clientes cl = (Clientes) context.getExternalContext().getSessionMap().get("usuario");
            
            if (cl != null){
                usuario = cl.getNombre();
            }
        }catch(Exception e){
            // log
        }
        
        return usuario;
    }
    
    public String devolverUsuarioUsuario(){
        String usuario = "";
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Clientes cl = (Clientes) context.getExternalContext().getSessionMap().get("usuario");
            
            if (cl != null){
                usuario = cl.getUsuario();
            }
        }catch(Exception e){
            // log
        }
        
        return usuario;
    }
    
    // getters Trabajador
    public String devolverNombreTrabajador(){
        String nombre = "";
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Trabajadores tr = (Trabajadores) context.getExternalContext().getSessionMap().get("trabajador");
            
            if (tr != null){
                nombre = tr.getNombre();
            }
        }catch(Exception e){
            // log
        }
        
        return nombre;
    }
    
    public String devolverUsuarioTrabajador(){
        String usuario = "";
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Trabajadores tr = (Trabajadores) context.getExternalContext().getSessionMap().get("trabajador");
            
            if (tr != null){
                usuario = tr.getUsuario();
            }
        }catch(Exception e){
            // log
        }
        
        return usuario;
    }
    
    public String devolverRolTrabajador(){
        String rol = "";
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Trabajadores tr = (Trabajadores) context.getExternalContext().getSessionMap().get("trabajador");
            
            if (tr != null){
                rol = tr.getRol();
            }
        }catch(Exception e){
            // log
        }
        
        return rol;
    }
}
