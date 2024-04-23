package bankonter.paneles;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class PanelGestionUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final JPanel PanelGestionUsuario = null;
	private JTextField jtfID;
	private JTextField jtfUsuarios;
	private JTextField jtfEmail;
	private JPasswordField passwordField;
	private JComboBox<String> jcbColor;

	/**
	 * Create the panel.
	 */
	public PanelGestionUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinDeUsuarios = new JLabel("Gestión de Usuarios");
		GridBagConstraints gbc_lblGestinDeUsuarios = new GridBagConstraints();
		gbc_lblGestinDeUsuarios.gridwidth = 3;
		gbc_lblGestinDeUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestinDeUsuarios.gridx = 1;
		gbc_lblGestinDeUsuarios.gridy = 1;
		add(lblGestinDeUsuarios, gbc_lblGestinDeUsuarios);
		
		JLabel lblNewLabel = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfID = new JTextField();
		GridBagConstraints gbc_jtfID = new GridBagConstraints();
		gbc_jtfID.gridwidth = 6;
		gbc_jtfID.insets = new Insets(0, 0, 5, 0);
		gbc_jtfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfID.gridx = 1;
		gbc_jtfID.gridy = 2;
		add(jtfID, gbc_jtfID);
		jtfID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfUsuarios = new JTextField();
		GridBagConstraints gbc_jtfUsuarios = new GridBagConstraints();
		gbc_jtfUsuarios.gridwidth = 6;
		gbc_jtfUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuarios.gridx = 1;
		gbc_jtfUsuarios.gridy = 3;
		add(jtfUsuarios, gbc_jtfUsuarios);
		jtfUsuarios.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 6;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
		

		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.gridwidth = 6;
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 5;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Color Preferido:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbColor = new JComboBox();
		GridBagConstraints gbc_jcbColor = new GridBagConstraints();
		gbc_jcbColor.gridwidth = 6;
		gbc_jcbColor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColor.gridx = 1;
		gbc_jcbColor.gridy = 6;
		add(jcbColor, gbc_jcbColor);
		
		jcbColor.addItem("#FF00FF");
        jcbColor.addItem("#9890A5");
        jcbColor.addItem("#765456");
        jcbColor.addItem("#879876");
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 3;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 7;
		add(btnGuardar, gbc_btnGuardar);
		

	}
	//Metodo para cambiar color del Panel
	private void cargarColor(JPanel PanelGestion) {
	    String strColor = jcbColor.getToolTipText(); // Obtener el color en formato hexadecimal desde el JTextField

	    try {
	        Color color = Color.decode(strColor); // Convertir el color hexadecimal a un objeto Color

	        // Establecer el color de fondo del panel
	        PanelGestion.setBackground(color);
	    } catch (NumberFormatException e) {
	        // Manejar la excepción si el color no se puede decodificar correctamente
	        System.err.println("Error al decodificar el color hexadecimal.");
	    }
	}
	public static boolean validarEmail(String email) {
        return email.contains("@") && email.substring(email.indexOf("@")).contains(".");
    }

}
