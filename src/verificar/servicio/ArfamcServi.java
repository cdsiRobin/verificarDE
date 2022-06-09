package verificar.servicio;

import java.util.List;

import verificar.entidad.Arfamc;
import verificar.repositorio.ArfamcRepo;

public class ArfamcServi {
	
	   public List<Arfamc> listaEmpresas() {
	        ArfamcRepo arfamcRepo = new ArfamcRepo();
	        return arfamcRepo.listaCompania();
	    }
	    
	    public Arfamc getEmpresas(String cia) {
	        ArfamcRepo arfamcRepo = new ArfamcRepo();
	        return arfamcRepo.getCompania(cia);
	    }

}
