package verificar.controlador;

import java.util.List;
import java.util.TimerTask;
import javax.swing.JTextPane;

import verificar.servicio.ArfafeServi;

public class ConsultarController extends TimerTask {
	
    private MainContro mainContro;
    private JTextPane txaLog;
    
	public ConsultarController(JTextPane txaLog) {
		this.txaLog = txaLog;
	}

	@Override
	public void run() {
		this.txaLog.setText("");
		ArfafeServi arfafeContro = new ArfafeServi();
		List<String> cias = arfafeContro.listaCias();									
		for(String cia: cias) {
			mainContro = new MainContro(cia,txaLog);
			mainContro.start();
		}
	}
	
	public void dejarConsultarBD() {
		mainContro.interrupt();
	}

}
