package astronet.ec.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Servicio.class)
public abstract class Servicio_ {

	public static volatile SingularAttribute<Servicio, Cliente> cliente;
	public static volatile SingularAttribute<Servicio, String> tipoServicio;
	public static volatile SingularAttribute<Servicio, String> numeroContrato;
	public static volatile SingularAttribute<Servicio, String> fechaContrato;
	public static volatile SingularAttribute<Servicio, String> routerVendido;
	public static volatile SingularAttribute<Servicio, String> observaciones;
	public static volatile SingularAttribute<Servicio, Integer> id;

}

