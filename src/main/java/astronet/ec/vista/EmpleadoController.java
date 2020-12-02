package astronet.ec.vista;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;
import astronet.ec.on.EmpleadoON;
import astronet.ec.util.SessionUtils;

@ManagedBean(name = "login")
@SessionScoped
public class EmpleadoController {

	@Inject
	private EmpleadoON empon;



	private String nombre;
	private int id;

	private Empleado empleado;
	private Instalacion instalacion;
	private Registro registro;

	@PostConstruct
	public void init() {
		empleado = new Empleado();
		instalacion = new Instalacion();
		registro = new Registro();
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public String getNombre() {
		nombre = empleado.getNombre();
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	


	/*
	 * Metodo de inciar sesion
	 */
	public String login() {
		String direccion=null;
		String departamento1 = "Radio";
		String departamento2 = "FibraAdm";
		String departamento3 = "Tecnico Radio";
		String departamento4 = "Tecnico Fibra";
		String departamento5 = "Contabilidad";
		try {
			empleado = empon.login(empleado.getEmail(), empleado.getPassword());
			if (empleado != null) {
				if (empleado.getDepartamento().equals(departamento1) || empleado.getDepartamento().equals(departamento2)) {
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("username", empleado);
					registro = new Registro();
					instalacion = new Instalacion();
					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
					id = empleado.getId();
					System.out.println("Login saliendo datos " + id);
					registro.setIdEmpleadoTemp(id);
					instalacion.setCodigoEmpTemp(id);
					System.out.println("Tiene permisos de todo");

					direccion= "callcenter";
				} if (empleado.getDepartamento().equals(departamento3)
						|| empleado.getDepartamento().equals(departamento4)
						|| empleado.getDepartamento().equals(departamento5)) {
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("username", empleado);
					registro = new Registro();
					instalacion = new Instalacion();
					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
					id = empleado.getId();
					System.out.println("Login saliendo datos " + id);
					registro.setIdEmpleadoTemp(id);
					instalacion.setCodigoEmpTemp(id);
					System.out.println("permisos solo de tecnico");
					

					direccion= "callcenter";
				}
			} 

		}catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
		}
		
		
		return direccion;
	}

	public String logout() {

		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index.xhtml";

	}

}
