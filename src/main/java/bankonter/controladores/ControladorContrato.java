package bankonter.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import bankonter.entities.Contrato;


public class ControladorContrato extends Controlador{
	
	private static ControladorContrato controller = null;

	public ControladorContrato() {
		super(Contrato.class, "Bankonter");
	}
	public static ControladorContrato getControlador() {
		if (controller == null) {
			controller = new ControladorContrato();
		}
		return controller;
	}
	public static String[] getTitulosColumnas() {
		return new String[] { "Id", "Descripcion", "Saldo", "Limite", "TipoContrato", "Usuario", "Fecha de Firma"};
	}
	public List<Contrato> findAllContratos() {
		List<Contrato> entities = new ArrayList<Contrato>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNativeQuery("SELECT * FROM contrato", Contrato.class);
			entities = (List<Contrato>) q.getResultList();
		} catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Contrato> contratos = ControladorContrato.getControlador().findAllContratos();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[contratos.size()][7];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < contratos.size(); i++) {
			Contrato contrato = contratos.get(i);
			datos[i][0] = contrato.getId();
			datos[i][1] = contrato.getDescripcion();
			datos[i][2] = contrato.getSaldo();
			datos[i][3] = contrato.getLimite();
			datos[i][4] = contrato.getTipoContrato();
			datos[i][5] = contrato.getUsuario();
			datos[i][6] = contrato.getFechaFirma();

		}

		return datos;
	}
}
