package verificar.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaConexionOracle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtSid;
	private JPasswordField txtPassword;
	private JTextField txtPuerto;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaConexionOracle dialog = new VentanaConexionOracle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaConexionOracle() {
		setBounds(100, 100, 450, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 11, 54, 14);
		contentPanel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(74, 8, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 40, 64, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblSid = new JLabel("SID");
		lblSid.setBounds(170, 11, 28, 14);
		contentPanel.add(lblSid);
		
		txtSid = new JTextField();
		txtSid.setBounds(208, 8, 86, 20);
		contentPanel.add(txtSid);
		txtSid.setColumns(10);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(304, 11, 46, 14);
		contentPanel.add(lblPuerto);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(74, 39, 86, 20);
		contentPanel.add(txtPassword);
		
		txtPuerto = new JTextField();
		txtPuerto.setBounds(348, 8, 64, 20);
		contentPanel.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(170, 40, 28, 14);
		contentPanel.add(lblHost);
		
		textField = new JTextField();
		textField.setBounds(208, 37, 204, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnTest = new JButton("Test");
		btnTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTest.setBounds(10, 77, 402, 32);
		contentPanel.add(btnTest);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCerrar = new JButton("CERRAR");
				btnCerrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						dispose();
					}
				});
				btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
}
