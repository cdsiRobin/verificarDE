package verificar.controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import verificar.servicio.ArfafeServi;

public class ConsultarController extends TimerTask {
	
    private MainContro mainContro = null;
    private JTextPane txaLog;
    private JTextField txtFechaHasta;
    private String fecha1;
    private String fecha2;
    
	public ConsultarController(JTextPane txaLog,String f1, String f2,JTextField txtFechaHasta) {
		this.txaLog        = txaLog;
		this.txtFechaHasta = txtFechaHasta;
		this.fecha1        = f1;
		this.fecha2        = f2;
	}

	@Override
	public void run() {
		this.txtFechaHasta.setText(this.getFechaActual(1));
		ArfafeServi arfafeContro = new ArfafeServi();
		List<String> cias = arfafeContro.listaCias(this.fecha1, this.fecha2);
		if(!cias.isEmpty()) {
			for(String cia: cias) {				
				mainContro = new MainContro(cia,txaLog,this.fecha1,this.fecha2);
				mainContro.start();
			}
		}else {
			this.txaLog.setText("No hay Documentos Electrónicos en FACTU.ARFAFE");
		}
	}
	
	public void dejarConsultarBD() {
		mainContro.interrupt();
	}
	
	private String getFechaActual(int dias) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendario = Calendar.getInstance();
		calendario.add(Calendar.DAY_OF_YEAR, dias);
		Date fecha = calendario.getTime();
		String fechaActual = sdf.format(fecha);
		return fechaActual;
	}

}
