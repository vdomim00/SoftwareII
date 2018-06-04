package com.mycompany.model;

import com.mycompany.model.Pedidos;
import com.mycompany.model.Platos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-04T23:23:46")
@StaticMetamodel(Platos.class)
public class Platos_ { 

    public static volatile SingularAttribute<Platos, String> ingredientes;
    public static volatile SingularAttribute<Platos, String> elaboracion;
    public static volatile SingularAttribute<Platos, Double> precio;
    public static volatile SingularAttribute<Platos, String> alergenos;
    public static volatile SingularAttribute<Platos, String> nombrePlato;
    public static volatile ListAttribute<Platos, Pedidos> pedidos;
    public static volatile SingularAttribute<Platos, Platos> platos;

}