package com.mycompany.model;

import com.mycompany.model.PedidosAProveedores;
import com.mycompany.model.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-08T16:46:42")
@StaticMetamodel(DetallePedidosAProveedores.class)
public class DetallePedidosAProveedores_ { 

    public static volatile SingularAttribute<DetallePedidosAProveedores, String> estado;
    public static volatile SingularAttribute<DetallePedidosAProveedores, Integer> idDetalle_pedidosAProveedores;
    public static volatile SingularAttribute<DetallePedidosAProveedores, Integer> cantidad;
    public static volatile SingularAttribute<DetallePedidosAProveedores, PedidosAProveedores> pedidosAProveedores;
    public static volatile SingularAttribute<DetallePedidosAProveedores, Productos> productos;

}