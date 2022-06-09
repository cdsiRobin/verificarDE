package verificar.servicio;

import verificar.entidad.DocumentoEnti;
import verificar.repositorio.DocumentoRepo;

public class DocumentoServi {
	
	 public DocumentoEnti getDocumento(String noFactu, String direcSfs){
	        DocumentoRepo repo = new DocumentoRepo();
	        return  repo.getDocumento(noFactu, direcSfs);
	 }

}
