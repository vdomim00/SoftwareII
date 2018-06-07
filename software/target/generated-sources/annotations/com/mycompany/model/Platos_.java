package com.mycompany.model;

import com.mycompany.model.Pedidos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T02:31:48")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T21:18:18")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T20:32:59")
>>>>>>> 617039af545db6eb3f16974b791bf2c1449e9ac4
>>>>>>> d2c41c3fdca72ecee07265cdbd795cb1bb27f768
@StaticMetamodel(Platos.class)
public class Platos_ { 

    public static volatile SingularAttribute<Platos, String> ingredientes;
    public static volatile SingularAttribute<Platos, String> elaboracion;
    public static volatile SingularAttribute<Platos, Double> precio;
    public static volatile SingularAttribute<Platos, String> alergenos;
    public static volatile SingularAttribute<Platos, String> nombrePlato;
    public static volatile ListAttribute<Platos, Pedidos> pedidos;

}