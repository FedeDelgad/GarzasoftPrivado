package bean;

public class beancliente {

    private int idcliente;
    private String nombrecli;
    private String apellidocli;
    private String telefonocli;
    private String correocli;
    private String clavecli;
    private String ingresocli;
    private String condicioncli = "nuevo";
    private String eliminacli = "activo";
    private String dnicli;
    private String sexocli;

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombrecli() {
        return nombrecli;
    }

    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }

    public String getApellidocli() {
        return apellidocli;
    }

    public void setApellidocli(String apellidocli) {
        this.apellidocli = apellidocli;
    }

    public String getTelefonocli() {
        return telefonocli;
    }

    public void setTelefonocli(String telefonocli) {
        this.telefonocli = telefonocli;
    }

    public String getCorreocli() {
        return correocli;
    }

    public void setCorreocli(String correocli) {
        this.correocli = correocli;
    }

    public String getClavecli() {
        return clavecli;
    }

    public void setClavecli(String clavecli) {
        this.clavecli = clavecli;
    }

    public String getIngresocli() {
        return ingresocli;
    }

    public void setIngresocli(String ingresocli) {
        this.ingresocli = ingresocli;
    }

    public String getCondicioncli() {
        return condicioncli;
    }

    public void setCondicioncli(String condicioncli) {
        this.condicioncli = "nuevo";
    }

    public String getEliminacli() {
        return eliminacli;
    }

    public void setEliminacli(String eliminacli) {
        this.eliminacli = "activo";
    }

    public String getDnicli() {
        return dnicli;
    }

    public void setDnicli(String dnicli) {
        this.dnicli = dnicli;
    }

    public String getSexocli() {
        return sexocli;
    }

    public void setSexocli(String sexocli) {
        this.sexocli = sexocli;
    }
}
