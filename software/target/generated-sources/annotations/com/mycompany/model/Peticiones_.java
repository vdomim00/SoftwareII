package com.mycompany.model;

import com.mycompany.model.Trabajadores;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T21:18:18")
@StaticMetamodel(Peticiones.class)
public class Peticiones_ { 

    public static volatile SingularAttribute<Peticiones, String> ingredientes;
    public static volatile SingularAttribute<Peticiones, String> elaboracion;
    public static volatile SingularAttribute<Peticiones, Double> precio;
    public static volatile SingularAttribute<Peticiones, Trabajadores> trabajadores;
    public static volatile SingularAttribute<Peticiones, String> alergenos;
    public static volatile SingularAttribute<Peticiones, String> nombrePlato;
    public static volatile SingularAttribute<Peticiones, Integer> idPeticion;

}