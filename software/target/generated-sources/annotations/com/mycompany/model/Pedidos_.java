package com.mycompany.model;

import com.mycompany.model.Clientes;
import com.mycompany.model.Pedidos_has_platos;
import com.mycompany.model.Platos;
import java.util.Date;
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
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile ListAttribute<Pedidos, Pedidos_has_platos> pedidos_has_platos;
    public static volatile SingularAttribute<Pedidos, String> estado;
    public static volatile SingularAttribute<Pedidos, Double> valor;
    public static volatile SingularAttribute<Pedidos, String> observaciones;
    public static volatile SingularAttribute<Pedidos, String> nombrePlatos;
    public static volatile SingularAttribute<Pedidos, Integer> idPedido;
    public static volatile SingularAttribute<Pedidos, Clientes> clientes;
    public static volatile ListAttribute<Pedidos, Platos> platos;
    public static volatile SingularAttribute<Pedidos, Date> fechaVenta;

}