package bankonter.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import bankonter.entities.Contrato;
import bankonter.entities.Entidad;
import bankonter.entities.Usuario;



public class ControladorUsuario extends Controlador {
	
	private static ControladorUsuario controller = null;
	
	public ControladorUsuario() {
		super(Usuario.class, "Bankonter");
	}

	public static ControladorUsuario getControlador() {
		if (controller == null) {
			controller = new ControladorUsuario();
		}
		return controller;
	}
	public List<Usuario> findAllUsuarios() {
		List<Usuario> entities = new ArrayList<Usuario>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNativeQuery("SELECT * FROM bankonter.usuario;", Usuario.class);
			entities = (List<Usuario>) q.getResultList();
		} catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
}

