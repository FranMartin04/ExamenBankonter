package bankonter.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario {
	
	@Id
	private int id;
	private String nombreUsuario;
	private String password;
	private String email;
	private String colorPreferido;
	public Usuario() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getColorPreferido() {
		return colorPreferido;
	}
	public void setColorPreferido(String colorPreferido) {
		this.colorPreferido = colorPreferido;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	@Override
	public String toString() {
		return nombreUsuario;
	}
	
	
	
}
