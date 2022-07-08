package verificar.servicio;

import java.util.List;
import verificar.repositorio.ArfafeRepo;

public class ArfafeServi {
	
	public List<String> listaCias(String f1, String f2){
        ArfafeRepo arfafeRepo = new ArfafeRepo();
        return arfafeRepo.listaCias(f1,f2);
    }

    public List<String> listarDocuElectro(String cia,String f1, String f2){
        ArfafeRepo arfafeRepo = new ArfafeRepo();
        return arfafeRepo.listaDocumentoElectronico(cia,f1,f2);
    }

    public void actuEstadoSunatDocuElec(String cia, String noFactu, String estadoSunat){    	
        ArfafeRepo arfafeRepo = new ArfafeRepo();
        arfafeRepo.actuEstadoSunatDocuElec(cia, this.editarNoFactu(noFactu), this.cambioEstado(estadoSunat.trim()));
    }
    
    private String editarNoFactu(String noFactu) {
    	return noFactu.substring(0, 4)+noFactu.substring(5);
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
				break;
			default:
				resultado = "0";
				break;
		}
    	return resultado;
    }
}
