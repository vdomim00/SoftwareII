package com.mycompany.model;

import com.mycompany.model.Proveedores;
import com.mycompany.model.Trabajadores;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-04T23:23:46")
@StaticMetamodel(PedidosAProveedores.class)
public class PedidosAProveedores_ { 

    public static volatile SingularAttribute<PedidosAProveedores, Proveedores> proveedores;
    public static volatile SingularAttribute<PedidosAProveedores, String> estado;
    public static volatile SingularAttribute<PedidosAProveedores, Trabajadores> trabajadores;
    public static volatile SingularAttribute<PedidosAProveedores, Integer> idPedidoAProveedor;
    public static volatile SingularAttribute<PedidosAProveedores, Double> coste;

}