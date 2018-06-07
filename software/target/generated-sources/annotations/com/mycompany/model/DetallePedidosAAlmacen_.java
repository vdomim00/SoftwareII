package com.mycompany.model;

import com.mycompany.model.PedidosAAlmacen;
import com.mycompany.model.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-07T15:16:13")
@StaticMetamodel(DetallePedidosAAlmacen.class)
public class DetallePedidosAAlmacen_ { 

    public static volatile SingularAttribute<DetallePedidosAAlmacen, Integer> idDetalle;
    public static volatile SingularAttribute<DetallePedidosAAlmacen, PedidosAAlmacen> pedidosAAlmacen;
    public static volatile SingularAttribute<DetallePedidosAAlmacen, Integer> cantidad;
    public static volatile SingularAttribute<DetallePedidosAAlmacen, Productos> productos;

}