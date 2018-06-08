package com.mycompany.model;

import com.mycompany.model.PedidosAProveedores;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-08T16:46:42")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> CIF;
    public static volatile SingularAttribute<Proveedores, String> direccion;
    public static volatile ListAttribute<Proveedores, PedidosAProveedores> listaPedidosAProveedores;
    public static volatile SingularAttribute<Proveedores, Integer> telefono;
    public static volatile SingularAttribute<Proveedores, String> fax;
    public static volatile SingularAttribute<Proveedores, String> nombreEmpresa;
    public static volatile SingularAttribute<Proveedores, String> email;
    public static volatile SingularAttribute<Proveedores, String> URL;

}