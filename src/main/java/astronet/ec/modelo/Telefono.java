package testjpa.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Telefono {

		@Id
		private int codigo;
		private String numero;
		
		@OneToOne
		@JoinColumn(name="tipo_telefono")
		private TipoTelefono tipo;
		
		@OneToOne
		@JoinColumn(name="per_codigo")
		private Persona persona;
		
		@Transient
		private int idTipo;
		
		@Transient
		private int idPersonaTemp;
		
		
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public TipoTelefono getTipo() {
			return tipo;
		}
		public void setTipo(TipoTelefono tipo) {
			this.tipo = tipo;
		}
		
				
		public Persona getPersona() {
			return persona;
		}
		public void setPersona(Persona persona) {
			this.persona = persona;
		}
	
		//temporales
		public int getIdTipo() {
			return idTipo;
		}
		public void setIdTipo(int idTipo) {
			this.idTipo = idTipo;
		}
		
		public int getIdPersonaTemp() {
			return idPersonaTemp;
		}
		public void setIdPersonaTemp(int idPersonaTemp) {
			this.idPersonaTemp = idPersonaTemp;
		}
		
		@Override
		public String toString() {
			return "Telefono [codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", idTipo=" + idTipo + "]";
		}
		
		
		
		
}
