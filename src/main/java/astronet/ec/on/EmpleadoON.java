package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.EmpleadoDAO;
import astronet.ec.modelo.Empleado;

@Stateless
public class EmpleadoON {
	
	@Inject
	private EmpleadoDAO empdao;
	
	public void guardar(Empleado emp) {
		empdao.save(emp);
	}
	
	public Empleado getEmpleado(int id) {
		Empleado aux = empdao.read3(id);
		System.out.println("Prueba: " + " " + empdao.read3(id));
		return aux;
	}
	
	public void borrar(int codigo) throws Exception {
		try {
			empdao.delete(codigo);
		}catch(Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}
		
	}
	
	public List<Empleado> getEmpleado() {
		return empdao.getEmpleado();
	}
	
	public Empleado login(String email, String password) {
		return empdao.login(email, password);
	}
	
	public List<Empleado> getListadoEmpleado() {
		return empdao.tecnicoDepartamento();
	}

}