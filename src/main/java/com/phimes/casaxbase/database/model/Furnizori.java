package com.phimes.casaxbase.database.model;

public class Furnizori {
    private String cod;
    private String denumire;
    private String codFiscal;
    private String analitic;
    private Integer zs;
    private String judet;
    private String adresa;
    private String banca;
    private String contBanca;
    private String filiala;
    private Boolean isCmlv;
    private String grupa;
    private String tipTert;
    private String tara;
    private String email;
    private String tel;
    private Boolean isTva;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getCodFiscal() {
        return codFiscal;
    }

    public void setCodFiscal(String codFiscal) {
        this.codFiscal = codFiscal;
    }

    public String getAnalitic() {
        return analitic;
    }

    public void setAnalitic(String analitic) {
        this.analitic = analitic;
    }

    public Integer getZs() {
        return zs;
    }

    public void setZs(Integer zs) {
        this.zs = zs;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBanca() {
        return banca;
    }

    public void setBanca(String banca) {
        this.banca = banca;
    }

    public String getContBanca() {
        return contBanca;
    }

    public void setContBanca(String contBanca) {
        this.contBanca = contBanca;
    }

    public String getFiliala() {
        return filiala;
    }

    public void setFiliala(String filiala) {
        this.filiala = filiala;
    }

    public Boolean getCmlv() {
        return isCmlv;
    }

    public void setCmlv(Boolean cmlv) {
        isCmlv = cmlv;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getTipTert() {
        return tipTert;
    }

    public void setTipTert(String tipTert) {
        this.tipTert = tipTert;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getTva() {
        return isTva;
    }

    public void setTva(Boolean tva) {
        isTva = tva;
    }

    @Override
    public String toString() {
        return "Furnizori{" +
                "cod='" + cod + '\'' +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}
