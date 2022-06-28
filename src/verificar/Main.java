package verificar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import verificar.controlador.ConsultarController;
import verificar.vista.VentanaConexionOracle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;


public class Main {

	private JFrame frmVerificacinDeDe;
	private JLabel lblDocumento;
	private String iconoDocu = "/verificar/iconos/documento.png";
	private ConsultarController consultarContro = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmVerificacinDeDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frmVerificacinDeDe = new JFrame();
		frmVerificacinDeDe.setTitle("Verificación");
		frmVerificacinDeDe.getContentPane().setBackground(Color.WHITE);
		frmVerificacinDeDe.getContentPane().setLayout(null);
		
		JPanel pPrincipal = new JPanel();
		pPrincipal.setBackground(Color.WHITE);
		pPrincipal.setBounds(0, 0, 358, 271);
		frmVerificacinDeDe.getContentPane().add(pPrincipal);
		pPrincipal.setLayout(null);
		
		JPanel pEstado = new JPanel();
		pEstado.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pEstado.setBackground(Color.PINK);
		pEstado.setBounds(10, 11, 147, 52);
		pPrincipal.add(pEstado);
		pEstado.setLayout(null);
		
		JLabel lblEstado = new JLabel("APAGADO");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEstado.setBounds(10, 11, 127, 30);
		pEstado.add(lblEstado);			
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 74, 338, 2);
		pPrincipal.add(separator);
		
		JPanel pVistaEnvio = new JPanel();
		pVistaEnvio.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pVistaEnvio.setBackground(Color.WHITE);
		pVistaEnvio.setBounds(10, 85, 338, 175);
		pPrincipal.add(pVistaEnvio);
		pVistaEnvio.setLayout(null);
		
		JLabel lblBdSqlite = new JLabel();
		lblBdSqlite.setToolTipText("Configuración tnsname Oracle");
		lblBdSqlite.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VentanaConexionOracle vCOracle = new VentanaConexionOracle();
				vCOracle.setVisible(true);
			}
		});
		lblBdSqlite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBdSqlite.setHorizontalAlignment(SwingConstants.CENTER);
		lblBdSqlite.setBounds(10, 11, 37, 42);
		ImageIcon imagen1= new ImageIcon(Main.class.getResource("/verificar/iconos/BdSqlite.png"));
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(lblBdSqlite.getWidth(), lblBdSqlite.getHeight(), Image.SCALE_DEFAULT));
		lblBdSqlite.setIcon(icono1);
		pVistaEnvio.add(lblBdSqlite);
		
		lblDocumento = new JLabel();
		lblDocumento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocumento.setBounds(10, 64, 37, 42);
		ImageIcon imagen2= new ImageIcon(Main.class.getResource(iconoDocu));
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(lblDocumento.getWidth(), lblDocumento.getHeight(), Image.SCALE_DEFAULT));
		lblDocumento.setIcon(icono2);
		pVistaEnvio.add(lblDocumento);
		
		JLabel lblEmpresa = new JLabel();

		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setBounds(10, 122, 37, 42);
		ImageIcon imagen3= new ImageIcon(Main.class.getResource("/verificar/iconos/empresa.png"));
		Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(lblEmpresa.getWidth(), lblEmpresa.getHeight(), Image.SCALE_DEFAULT));
		lblEmpresa.setIcon(icono3);
		pVistaEnvio.add(lblEmpresa);
		
		JPanel pLog = new JPanel();
		pLog.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pLog.setBackground(Color.WHITE);
		pLog.setBounds(57, 11, 271, 153);
		pVistaEnvio.add(pLog);
		pLog.setLayout(null);
		
		JScrollPane scpLog = new JScrollPane();
		scpLog.setBounds(0, 0, 271, 153);
		pLog.add(scpLog);
		
		JTextPane txaLog = new JTextPane();       
		scpLog.setViewportView(txaLog);
		
		JButton btnIniciar = new JButton();
		// EVENTO CLICK DEL BOTON INICIAR
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/*Path path = Paths.get("");
				String directoryName = path.toAbsolutePath().toString();
				" . Nombre de la PC : "+directoryName*/
				txaLog.setText("INICIAR");
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de Iniciar?");
				if (respuesta == 0) {
					//JOptionPane.showMessageDialog(null, "respuesta : "+respuesta);
					txaLog.setText("INICIAR..");
					iconoDocu = "/verificar/iconos/envioDocumento.gif";
					cambiarIconoDocumento(pVistaEnvio, lblDocumento, iconoDocu);
					cambiarColorTextoAlerta(pPrincipal, pEstado, lblEstado, "INICIADO", 1);
					txaLog.setText("INICIANDO....");
					Timer timer = new Timer();					
					consultarContro = new ConsultarController(txaLog);					
					// cada 5min
					timer.schedule(consultarContro,0,50000);					
				}
			}
		});
		
		btnIniciar.setToolTipText("Iniciar");
		btnIniciar.setIcon(new ImageIcon(Main.class.getResource("/verificar/iconos/play.png")));
		btnIniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnIniciar.setActionCommand("");
		btnIniciar.setBounds(259, 11, 89, 52);
		pPrincipal.add(btnIniciar);
		
		JButton btnApagar = new JButton();
		btnApagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de calcelar?");				
				if (respuesta == 0) {
				    iconoDocu = "/verificar/iconos/documento.png";
					cambiarIconoDocumento(pVistaEnvio, lblDocumento, iconoDocu);
					cambiarColorTextoAlerta(pPrincipal, pEstado, lblEstado, "APAGADO", 0);
					consultarContro.cancel();
					consultarContro.dejarConsultarBD();
				}
			}
		});
		
		btnApagar.setToolTipText("Cancelar");
		btnApagar.setIcon(new ImageIcon(Main.class.getResource("/verificar/iconos/stop.png")));
		btnApagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApagar.setAlignmentX(0.5f);
		btnApagar.setActionCommand("");
		btnApagar.setBounds(167, 11, 89, 52);
		pPrincipal.add(btnApagar);
		
		frmVerificacinDeDe.setBounds(100, 100, 374, 310);
		frmVerificacinDeDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void cambiarIconoDocumento(JPanel vistaEnvio, JLabel documento, String iconoDocmento ) {
		documento.setHorizontalAlignment(SwingConstants.CENTER);
		documento.setBounds(10, 64, 37, 42);
		ImageIcon imagen2= new ImageIcon(Main.class.getResource(iconoDocmento));
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(documento.getWidth(), documento.getHeight(), Image.SCALE_DEFAULT));
		lblDocumento.setIcon(icono2);
		vistaEnvio.add(documento);
	}
	
	private void cambiarColorTextoAlerta(JPanel pPrincipal, JPanel pEstado, JLabel lblEstado, String nombre, int color) {
	   // pEstado = new JPanel();
		pEstado.setBorder(new LineBorder(Color.LIGHT_GRAY));
		if (color == 0) {
			pEstado.setBackground(Color.PINK);
		} else {
			pEstado.setBackground(Color.GREEN);
		}
		  
		pEstado.setBounds(10, 11, 147, 52);
		pPrincipal.add(pEstado);
		pEstado.setLayout(null);
		
		//lblEstado = new JLabel(nombre);
		lblEstado.setText(nombre);
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEstado.setBounds(10, 11, 127, 30);
		pEstado.add(lblEstado);	
	}
}
