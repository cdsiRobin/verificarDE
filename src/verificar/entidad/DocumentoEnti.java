package verificar.entidad;

public class DocumentoEnti {
	
    private String TIP_DOCU;
    private String NUM_DOCU;
    private String IND_SITU;

    public DocumentoEnti() {
    }

    public DocumentoEnti(String TIP_DOCU, String NUM_DOCU, String IND_SITU) {
        this.TIP_DOCU = TIP_DOCU;
        this.NUM_DOCU = NUM_DOCU;
        this.IND_SITU = IND_SITU;
    }

    public String getTIP_DOCU() {
        return TIP_DOCU;
    }

    public void setTIP_DOCU(String TIP_DOCU) {
        this.TIP_DOCU = TIP_DOCU;
    }

    public String getNUM_DOCU() {
        return NUM_DOCU;
    }

    public void setNUM_DOCU(String NUM_DOCU) {
        this.NUM_DOCU = NUM_DOCU;
    }

    public String getIND_SITU() {
        return IND_SITU;
    }

    public void setIND_SITU(String IND_SITU) {
        this.IND_SITU = IND_SITU;
    }
}
