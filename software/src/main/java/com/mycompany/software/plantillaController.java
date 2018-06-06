/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.software;

import com.mycompany.model.Clientes;
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
public class plantillaController implements Serializable {
    
    public void verificarSesion(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Clientes cl = (Clientes) context.getExternalContext().getSessionMap().get("usuario");
            
            if (cl == null){
                context.getExternalContext().redirect("anonimo.xhtml");
            }
        }catch(IOException e){
            // log
        }
    }
    
    public String devolverUsuario(){
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
}
