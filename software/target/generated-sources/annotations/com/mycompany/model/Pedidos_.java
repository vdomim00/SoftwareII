package com.mycompany.model;

import com.mycompany.model.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T18:36:02")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, String> estado;
    public static volatile SingularAttribute<Pedidos, Double> valor;
    public static volatile SingularAttribute<Pedidos, String> observaciones;
    public static volatile SingularAttribute<Pedidos, String> nombrePlatos;
    public static volatile SingularAttribute<Pedidos, Integer> idPedido;
    public static volatile SingularAttribute<Pedidos, Clientes> clientes;
    public static volatile SingularAttribute<Pedidos, Date> fechaVenta;

}