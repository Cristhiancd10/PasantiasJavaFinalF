package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Servicio;

@Stateless
public class ClienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Cliente cli) {
		if (this.read(cli.getId())!=null) {
			this.update(cli);
		}else 
			this.create(cli);
		
	}
	
	public void create(Cliente cli) {
		em.persist(cli);
		
	}
	
	public Cliente read(int id) {
		return em.find(Cliente.class, id);
	}
	
	public Cliente read3(int id) {
		String jpql = "SELECT cli FROM Cliente cli   WHERE cli.id = :a";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("a", id);
		Cliente cli = (Cliente) q.getSingleResult();
				
		return cli;

	}
	
	public void update(Cliente cli) {
		em.merge(cli);
		
	}
	
	public void update1(Cliente cliente) {
		String jpql = "UPDATE Cliente  c SET c.nombre= :nombre, c.apellido= :apellido, c.email= :email,"
				+ "c.direccionPrincipal= :direccionPrincipal,"
				+ "c.direccionSecundaria= :direccionSecundaria, "
				+ "c.direccionReferencia= :direccionReferencia,"
				+ "c.latitud= :latitud, c.longitud= :longitud WHERE c.id= :id";
		Query q = em.createQuery(jpql);
		q.setParameter("nombre", cliente.getNombre());
		q.setParameter("apellido", cliente.getApellido());
		q.setParameter("email", cliente.getEmail());
//		q.setParameter("convencional", cliente.getConvencional());
//		q.setParameter("celular", cliente.getCelular());
		q.setParameter("direccionPrincipal", cliente.getDireccionPrincipal());
		q.setParameter("direccionSecundaria", cliente.getDireccionSecundaria());
		q.setParameter("direccionReferencia", cliente.getDireccionReferencia());
		q.setParameter("latitud", cliente.getLatitud());
		q.setParameter("longitud", cliente.getLongitud());
		q.setParameter("id", cliente.getId());
		int d=q.executeUpdate();
		System.out.println("vale vrg "+d);
		
//		int id_cliente = cliente.getId();
//		String jpqlServico = "UPDATE  Servicio  SET ser_ip =  '"+cliente.getServicio().get(0).getIp()+"' where cliservicio_fk = "+ id_cliente +"";
//		q = em.createNativeQuery(jpqlServico);
//		int ipd = q.executeUpdate();
//		System.out.println("Ip actualizada "+ipd);
		
	}
	
	public void delete(int id) {
		Cliente cli = read(id);
		em.remove(cli);
	}
	
	public List<Cliente> getCliente() {
		String jpql = "SELECT cliente FROM Cliente cliente ";
		Query q = em.createQuery(jpql, Cliente.class);
		List<Cliente> clientes = q.getResultList();
		for (Cliente cliente : clientes) {
			//agregue esto
			cliente.getServicio().size();
			List<Servicio> servicios = cliente.getServicio();
			for (Servicio servicio : servicios) {
				servicio = null;

			}
		}
		return clientes;
	}

	
	public Cliente buscarCedula(String cedula) {
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.cedula = :cedula";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("cedula", cedula);
		Cliente clien = (Cliente) q.getSingleResult();
		clien.getCedula();
		clien.getNombre();
		System.out.println(clien.getCedula());
		System.out.println(clien.getNombre());
		
		for (int i = 0; i < clien.getServicio().size(); i++) {
			System.out.println("Celular " );
			System.out.println("Convencional " );
//			clien.getServicio().get(i).getIp();
//			clien.getServicio().get(i).getPassword();
//			clien.getServicio().get(i).getPlan();

		}

		return clien;
	}
	
	public Cliente buscarNombre(String nombre) {
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.nombre = :nombre";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("nombre", nombre);
		Cliente clien = (Cliente) q.getSingleResult();
		clien.getCedula();
		clien.getNombre();
		System.out.println(clien.getCedula());
		System.out.println(clien.getNombre());
		
		for (int i = 0; i < clien.getServicio().size(); i++) {
			System.out.println("Celular " );
			System.out.println("Convencional " );
//			clien.getServicio().get(i).getIp();
//			clien.getServicio().get(i).getPassword();
//			clien.getServicio().get(i).getPlan();

		}

		return clien;
	}


}
