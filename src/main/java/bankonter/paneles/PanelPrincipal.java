package bankonter.paneles;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.DefaultTableModel;

import bankonter.controladores.ControladorContrato;
import bankonter.controladores.ControladorUsuario;
import bankonter.entities.Contrato;
import bankonter.entities.Usuario;


import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


public class PanelPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfid;
	private JTextField tfsaldo;
	private JTextField tflimite;
	private JTextField tffirma;
	private JTextField tfdescripcion;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = ControladorContrato.getDatosDeTabla();
	private String titulosEnTabla[] = ControladorContrato.getTitulosColumnas();

	private JComboBox<Usuario> jcbusuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PanelPrincipal() {
		JFrame frame = new JFrame("Gestion de Contratos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(806, 535);

        // Crear los componentes que irán dentro del SplitPane
        JPanel panelSuperior = new JPanel(new BorderLayout());

        JPanel panelInferior = new JPanel();

        // Crear el JSplitPane y configurarlo
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelSuperior, panelInferior);
        
        this.dtm = getDefaultTableModelNoEditable();
        JTable jTable = new JTable(dtm);
        
        dtm = getDefaultTableModelNoEditable();
        jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable.getSelectedRow();
                    if (selectedRow != -1) { // Asegurarse de que se ha seleccionado una fila
                        // Obtener los datos de la fila seleccionada
                        String id = jTable.getValueAt(selectedRow, 0).toString();
                        String descripcion = (String) jTable.getValueAt(selectedRow, 1);
                        String saldo = jTable.getValueAt(selectedRow, 2).toString();
                        String limite = jTable.getValueAt(selectedRow, 3).toString(); 
                        String tipoContrato = (String) jTable.getValueAt(selectedRow, 4);
                        String usuario = (String) jTable.getValueAt(selectedRow, 5);
                        String fechafirma = jTable.getValueAt(selectedRow, 6).toString(); 
                                    
                        tfid.setText(id);
                        tfdescripcion.setText(descripcion);
                        tfsaldo.setText(saldo);
                        tflimite.setText(limite);
                        tffirma.setText(fechafirma);
                        
                    }
                }
            }

        });
        
        JScrollPane scrollTable = new JScrollPane(jTable);
        panelSuperior.add(scrollTable, BorderLayout.CENTER);
        GridBagLayout gbl_panelInferior = new GridBagLayout();
        gbl_panelInferior.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelInferior.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panelInferior.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panelInferior.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelInferior.setLayout(gbl_panelInferior);
        
        JLabel lblNewLabel = new JLabel("ID:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        panelInferior.add(lblNewLabel, gbc_lblNewLabel);
        
        tfid = new JTextField();
        GridBagConstraints gbc_tfid = new GridBagConstraints();
        gbc_tfid.gridwidth = 13;
        gbc_tfid.insets = new Insets(0, 0, 5, 0);
        gbc_tfid.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfid.gridx = 2;
        gbc_tfid.gridy = 0;
        panelInferior.add(tfid, gbc_tfid);
        tfid.setColumns(10);
        
        JLabel lblPrimerApellido = new JLabel("Tipo de contrato:");
        GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
        gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
        gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrimerApellido.gridx = 1;
        gbc_lblPrimerApellido.gridy = 1;
        panelInferior.add(lblPrimerApellido, gbc_lblPrimerApellido);
        
        JRadioButton rdbtnCuentaBancaria = new JRadioButton("Cuenta Bancaria");
        GridBagConstraints gbc_rdbtnCuentaBancaria = new GridBagConstraints();
        gbc_rdbtnCuentaBancaria.gridwidth = 6;
        gbc_rdbtnCuentaBancaria.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnCuentaBancaria.gridx = 2;
        gbc_rdbtnCuentaBancaria.gridy = 1;
        panelInferior.add(rdbtnCuentaBancaria, gbc_rdbtnCuentaBancaria);
        
        JRadioButton rdbtnCredito = new JRadioButton("Tarjeta De Crédito");
        GridBagConstraints gbc_rdbtnCredito = new GridBagConstraints();
        gbc_rdbtnCredito.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnCredito.gridx = 8;
        gbc_rdbtnCredito.gridy = 1;
        panelInferior.add(rdbtnCredito, gbc_rdbtnCredito);
        
        JRadioButton rdbtnTarjetaDbito = new JRadioButton("Tarjeta Débito");
        GridBagConstraints gbc_rdbtnTarjetaDbito = new GridBagConstraints();
        gbc_rdbtnTarjetaDbito.gridwidth = 4;
        gbc_rdbtnTarjetaDbito.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnTarjetaDbito.gridx = 4;
        gbc_rdbtnTarjetaDbito.gridy = 2;
        panelInferior.add(rdbtnTarjetaDbito, gbc_rdbtnTarjetaDbito);
        
        JRadioButton rdbtnPrestamo = new JRadioButton("Préstamo");
        GridBagConstraints gbc_rdbtnPrestamo = new GridBagConstraints();
        gbc_rdbtnPrestamo.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnPrestamo.gridx = 8;
        gbc_rdbtnPrestamo.gridy = 2;
        panelInferior.add(rdbtnPrestamo, gbc_rdbtnPrestamo);
        

		

        
        JLabel lblNewLabel_1 = new JLabel("Descripcion:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 3;
        panelInferior.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        tfdescripcion = new JTextField();
        GridBagConstraints gbc_tfdescripcion = new GridBagConstraints();
        gbc_tfdescripcion.gridwidth = 13;
        gbc_tfdescripcion.insets = new Insets(0, 0, 5, 0);
        gbc_tfdescripcion.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfdescripcion.gridx = 2;
        gbc_tfdescripcion.gridy = 3;
        panelInferior.add(tfdescripcion, gbc_tfdescripcion);
        tfdescripcion.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Usuario:");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 4;
        panelInferior.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        jcbusuario = new JComboBox();
        GridBagConstraints gbc_jcbusuario = new GridBagConstraints();
        gbc_jcbusuario.gridwidth = 12;
        gbc_jcbusuario.insets = new Insets(0, 0, 5, 5);
        gbc_jcbusuario.fill = GridBagConstraints.HORIZONTAL;
        gbc_jcbusuario.gridx = 2;
        gbc_jcbusuario.gridy = 4;
        panelInferior.add(jcbusuario, gbc_jcbusuario);
        
        
        JButton btnGestionarUsuario = new JButton("Gestionar Usuario");
        btnGestionarUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle("Título");
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(new PanelGestionUsuario());
				// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
				dialogo.setModal(true);
				// Centro el di�logo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
						(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
				// Muestro el di�logo en pantalla
				dialogo.setVisible(true);
        	}
        });
        GridBagConstraints gbc_btnGestionarUsuario = new GridBagConstraints();
        gbc_btnGestionarUsuario.insets = new Insets(0, 0, 5, 0);
        gbc_btnGestionarUsuario.gridx = 14;
        gbc_btnGestionarUsuario.gridy = 4;
        panelInferior.add(btnGestionarUsuario, gbc_btnGestionarUsuario);
        
        JLabel lblNewLabel_3 = new JLabel("Saldo(€):");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 5;
        panelInferior.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        tfsaldo = new JTextField();
        GridBagConstraints gbc_tfsaldo = new GridBagConstraints();
        gbc_tfsaldo.gridwidth = 13;
        gbc_tfsaldo.insets = new Insets(0, 0, 5, 0);
        gbc_tfsaldo.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfsaldo.gridx = 2;
        gbc_tfsaldo.gridy = 5;
        panelInferior.add(tfsaldo, gbc_tfsaldo);
        tfsaldo.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Limite(€):");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 1;
        gbc_lblNewLabel_4.gridy = 6;
        panelInferior.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        tflimite = new JTextField();
        GridBagConstraints gbc_tflimite = new GridBagConstraints();
        gbc_tflimite.gridwidth = 13;
        gbc_tflimite.insets = new Insets(0, 0, 5, 0);
        gbc_tflimite.fill = GridBagConstraints.HORIZONTAL;
        gbc_tflimite.gridx = 2;
        gbc_tflimite.gridy = 6;
        panelInferior.add(tflimite, gbc_tflimite);
        tflimite.setColumns(10);
        

        
        JLabel lblNewLabel_5 = new JLabel("Fecha de firma:");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 1;
        gbc_lblNewLabel_5.gridy = 7;
        panelInferior.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        tffirma = new JTextField();
        GridBagConstraints gbc_tffirma = new GridBagConstraints();
        gbc_tffirma.gridwidth = 13;
        gbc_tffirma.insets = new Insets(0, 0, 5, 0);
        gbc_tffirma.fill = GridBagConstraints.HORIZONTAL;
        gbc_tffirma.gridx = 2;
        gbc_tffirma.gridy = 7;
        panelInferior.add(tffirma, gbc_tffirma);
        tffirma.setColumns(10);
                JButton btnGuardar = new JButton("Guardar");
                btnGuardar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		guardar();
                	}
                });
        GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
        gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
        gbc_btnGuardar.gridx = 7;
        gbc_btnGuardar.gridy = 8;
        panelInferior.add(btnGuardar, gbc_btnGuardar);
        
        

        


        splitPane.setResizeWeight(0.5); // Configuracion de la distribución inicial de tamaño entre los componentes

        // Añadir el JSplitPane al frame y hacerlo visible
        frame.getContentPane().add(splitPane);
        frame.setVisible(true);
        
        cargarUsarios();
    }
	private void cargarUsarios() {
		List<Usuario> lista = ControladorUsuario.getControlador().findAllUsuarios();

		for (Usuario c : lista) {
			this.jcbusuario.addItem(c);
		}
	}
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}
	public static boolean validarDescripcion(String descripcion) {
        if (descripcion.length() < 6) {
            JOptionPane.showMessageDialog(null, "La descripción debe tener al menos 4 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	public static boolean validarSaldoYLimite(String saldo,String limite) {
        try {
            Float.parseFloat(saldo);  
            Float.parseFloat(limite);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El saldo y el limite deben ser  números decimales válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
	private void guardar() {
		validarDescripcion(tfdescripcion.getText());
		validarSaldoYLimite(tfsaldo.getText(),tflimite.getText());
}

}


