package verificar.entidad;

public class Arfamc {
	
    private String cia;
    private String ruc;
    private String direcSfs;
    private String nombre;

    public Arfamc() {
    }

    public Arfamc(String cia, String ruc, String direcSfs, String nombre) {
        this.cia      = cia;
        this.ruc      = ruc;
        this.direcSfs = direcSfs;
        this.nombre   = nombre;
    }

    public String getCia() {
        return cia;
    }

    public void setCia(String cia) {
        this.cia = cia;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDirecSfs() {
        return direcSfs;
    }

    public void setDirecSfs(String direcSfs) {
        this.direcSfs = direcSfs;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
        
}
