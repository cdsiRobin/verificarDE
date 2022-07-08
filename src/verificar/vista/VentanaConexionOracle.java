package verificar.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import verificar.conexion.Oracle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaConexionOracle extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtSid;
	private JPasswordField txtPassword;
	private JTextField txtPuerto;
	private JTextField textHost;

	public static void main(String[] args) {
		try {
			VentanaConexionOracle dialog = new VentanaConexionOracle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


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
		txtUsuario.setFont(new Font("Dialog", Font.BOLD, 12));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
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
		txtSid.setFont(new Font("Dialog", Font.BOLD, 12));
		txtSid.setHorizontalAlignment(SwingConstants.CENTER);
		txtSid.setBounds(208, 8, 86, 20);
		contentPanel.add(txtSid);
		txtSid.setColumns(10);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(304, 11, 46, 14);
		contentPanel.add(lblPuerto);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Dialog", Font.BOLD, 12));
		txtPassword.setBounds(74, 39, 86, 20);
		contentPanel.add(txtPassword);
		
		txtPuerto = new JTextField();
		txtPuerto.setFont(new Font("Dialog", Font.BOLD, 12));
		txtPuerto.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuerto.setBounds(348, 8, 64, 20);
		contentPanel.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(170, 40, 28, 14);
		contentPanel.add(lblHost);
		
		textHost = new JTextField();
		textHost.setFont(new Font("Dialog", Font.BOLD, 12));
		textHost.setHorizontalAlignment(SwingConstants.CENTER);
		textHost.setBounds(208, 37, 204, 20);
		contentPanel.add(textHost);
		textHost.setColumns(10);
		
		JButton btnTest = new JButton("Test");
		btnTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// EVENTO CLICK DEL TEST
				Oracle oracle = new Oracle();
				oracle.test();
			}
		});
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
		
		this.getOracle();
	}
   
	private void getOracle() {
		Oracle objO = new Oracle();
		txtUsuario.setText(objO.getUsuario());
		txtPassword.setText(objO.getPassword());
		txtPuerto.setText(objO.getPuerto());
		txtSid.setText(objO.getSid());
		textHost.setText(objO.getHost());
	}
}
