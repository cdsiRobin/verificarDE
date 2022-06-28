package verificar.controlador;

import java.util.List;
import java.util.TimerTask;
import javax.swing.JTextPane;

import verificar.servicio.ArfafeServi;

public class ConsultarController extends TimerTask {
	
    private MainContro mainContro = null;
    private JTextPane txaLog;
    
	public ConsultarController(JTextPane txaLog) {
		this.txaLog = txaLog;
	}

	@Override
	public void run() {
		ArfafeServi arfafeContro = new ArfafeServi();
		List<String> cias = arfafeContro.listaCias();
		if(!cias.isEmpty()) {
			for(String cia: cias) {				
				mainContro = new MainContro(cia,txaLog);
				mainContro.start();
			}
		}else {
			this.txaLog.setText("No hay Documentos Electrónicos en FACTU.ARFAFE");
		}
	}
	
	public void dejarConsultarBD() {
		mainContro.interrupt();
	}

}
