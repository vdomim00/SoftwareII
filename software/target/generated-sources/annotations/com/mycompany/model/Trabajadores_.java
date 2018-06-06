package com.mycompany.model;

import com.mycompany.model.PedidosAProveedores;
import com.mycompany.model.Peticiones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T20:32:59")
@StaticMetamodel(Trabajadores.class)
public class Trabajadores_ { 

    public static volatile SingularAttribute<Trabajadores, String> apellidos;
    public static volatile ListAttribute<Trabajadores, Peticiones> listaPeticiones;
    public static volatile SingularAttribute<Trabajadores, String> numeroSS;
    public static volatile SingularAttribute<Trabajadores, String> pass;
    public static volatile ListAttribute<Trabajadores, PedidosAProveedores> listaPedidosAProveedores;
    public static volatile SingularAttribute<Trabajadores, String> usuario;
    public static volatile SingularAttribute<Trabajadores, String> numeroCuenta;
    public static volatile SingularAttribute<Trabajadores, String> nombre;
    public static volatile SingularAttribute<Trabajadores, String> DNI;
    public static volatile SingularAttribute<Trabajadores, String> email;
    public static volatile SingularAttribute<Trabajadores, String> rol;

}