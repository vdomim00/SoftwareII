package com.mycompany.model;

import com.mycompany.model.Productos;
import com.mycompany.model.Zonas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T18:36:02")
@StaticMetamodel(Secciones.class)
public class Secciones_ { 

    public static volatile SingularAttribute<Secciones, Zonas> zonas;
    public static volatile ListAttribute<Secciones, Productos> listaProductos;
    public static volatile SingularAttribute<Secciones, String> nombreSeccion;

}