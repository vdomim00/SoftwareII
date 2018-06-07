package com.mycompany.model;

import com.mycompany.model.Almacenes;
import com.mycompany.model.Secciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T18:36:02")
@StaticMetamodel(Zonas.class)
public class Zonas_ { 

    public static volatile SingularAttribute<Zonas, Almacenes> almacenes;
    public static volatile ListAttribute<Zonas, Secciones> listaSecciones;
    public static volatile SingularAttribute<Zonas, String> nombreZona;

}