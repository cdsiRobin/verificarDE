package verificar.controlador;

import java.util.List;
import javax.swing.JTextPane;

import verificar.entidad.Arfamc;
import verificar.entidad.DocumentoEnti;
import verificar.servicio.ArfafeServi;
import verificar.servicio.ArfamcServi;
import verificar.servicio.DocumentoServi;

public class MainContro extends Thread  {
	
	private String cia;
	private JTextPane txaLog;
	
	public MainContro(String cia, JTextPane txaLog) {
		this.cia = cia;
		this.txaLog = txaLog;
	}

	@Override
	public void run() {
		try {
			ArfafeServi arfafeContro  = new ArfafeServi();
			ArfamcServi arfamcContro  = new ArfamcServi();
			
			Arfamc arfamc = arfamcContro.getEmpresas(this.getCia());
			
			if (arfamc.getDirecSfs() != null || arfamc.getDirecSfs() != "") {
				
				String razonSocial = arfamc.getCia()+"-"+arfamc.getNombre()+"\n";
				this.verTexto(razonSocial);
				List<String> documentos = arfafeContro.listarDocuElectro(this.getCia());
				
				for(String documento: documentos) {
					DocumentoServi docuContro = new DocumentoServi();
					DocumentoEnti docuEnti = docuContro.getDocumento(documento, arfamc.getDirecSfs());
					if(docuEnti != null) {
						if(docuEnti.getIND_SITU() != null || docuEnti.getIND_SITU() != "") {
							arfafeContro.actuEstadoSunatDocuElec(arfamc.getCia(), docuEnti.getNUM_DOCU(), docuEnti.getIND_SITU());				
							String texto = arfamc.getCia()+"-"+docuEnti.getNUM_DOCU()+" ESTADO SFS "+docuEnti.getIND_SITU()+", ESTADO ISANEG ERP :"+this.cambioEstado(docuEnti.getIND_SITU())+"\n";
							this.verTexto(texto);
						}						
					}else {
						String texto = arfamc.getCia()+"_"+documento+" no existe en la BD SQLITE.\n";
						this.verTexto(texto);
					}
				}
				
			}else {
				String texto = arfamc.getCia()+"-"+arfamc.getNombre()+" : "+" no tiene Directorio de SFS en la tabla factu.arfamc. \n";
				this.verTexto(texto);
			}
			
		}catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
	}
	
	private void verTexto(String texto) {
		this.txaLog.setText( this.txaLog.getText()+"\n"+texto );
	}
	
	private String cambioEstado(String estadoSunat) {
    	String resultado = "";
    	switch (estadoSunat) {
			case "04":
				resultado = "3";
				break;
			case "03":
				resultado = "2";
				break;
			case "12":
				resultado = "3";
				break;
			case "05":
				resultado = "1";
				break;
			case "11":
				resultado = "2";
			default:
				resultado = "0";
				break;
		}
    	return resultado;
    }

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}
	
}
