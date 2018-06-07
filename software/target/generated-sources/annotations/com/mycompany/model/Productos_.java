package com.mycompany.model;

import com.mycompany.model.Platos;
import com.mycompany.model.Secciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T02:31:48")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Double> precio;
    public static volatile SingularAttribute<Productos, Integer> cantidad;
    public static volatile SingularAttribute<Productos, String> codigoProducto;
    public static volatile SingularAttribute<Productos, Secciones> secciones;
    public static volatile ListAttribute<Productos, Platos> platos;

}