package com.mycompany.model;

import com.mycompany.model.Pedidos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T21:18:18")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> apellidos;
    public static volatile ListAttribute<Clientes, Pedidos> listaPedidos;
    public static volatile SingularAttribute<Clientes, String> pass;
    public static volatile SingularAttribute<Clientes, String> usuario;
    public static volatile SingularAttribute<Clientes, String> telefono;
    public static volatile SingularAttribute<Clientes, String> nombre;
    public static volatile SingularAttribute<Clientes, String> DNI;
    public static volatile SingularAttribute<Clientes, String> email;

}