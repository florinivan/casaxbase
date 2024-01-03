package com.phimes.casaxbase.database.model;

import java.math.BigDecimal;
import java.util.Date;

public class Intrari {

    private Integer nrNir;
    private String nrIntrare;
    private String gestiune;
    private String denGest;
    private String cod;
    private Date date;
    private Date scadent;
    private Character tip;
    private String codArt;
    private String denArt;
    private String um;
    private BigDecimal cantitate;

    private String den_tip;
    private BigDecimal tvaArt;
    private BigDecimal valoare;
    private BigDecimal tva;
    private BigDecimal pretVanz;
    private String cont;
    private String grupa;

    public Integer getNrNir() {
        return nrNir;
    }

    public void setNrNir(Integer nrNir) {
        this.nrNir = nrNir;
    }

    public String getNrIntrare() {
        return nrIntrare;
    }

    public void setNrIntrare(String nrIntrare) {
        this.nrIntrare = nrIntrare;
    }

    public String getGestiune() {
        return gestiune;
    }

    public void setGestiune(String gestiune) {
        this.gestiune = gestiune;
    }

    public String getDenGest() {
        return denGest;
    }

    public void setDenGest(String denGest) {
        this.denGest = denGest;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getScadent() {
        return scadent;
    }

    public void setScadent(Date scadent) {
        this.scadent = scadent;
    }

    public Character getTip() {
        return tip;
    }

    public void setTip(Character tip) {
        this.tip = tip;
    }

    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public String getDenArt() {
        return denArt;
    }

    public void setDenArt(String denArt) {
        this.denArt = denArt;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public BigDecimal getCantitate() {
        return cantitate;
    }

    public void setCantitate(BigDecimal cantitate) {
        this.cantitate = cantitate;
    }

    public String getDen_tip() {
        return den_tip;
    }

    public void setDen_tip(String den_tip) {
        this.den_tip = den_tip;
    }

    public BigDecimal getTvaArt() {
        return tvaArt;
    }

    public void setTvaArt(BigDecimal tvaArt) {
        this.tvaArt = tvaArt;
    }

    public BigDecimal getValoare() {
        return valoare;
    }

    public void setValoare(BigDecimal valoare) {
        this.valoare = valoare;
    }

    public BigDecimal getTva() {
        return tva;
    }

    public void setTva(BigDecimal tva) {
        this.tva = tva;
    }

    public BigDecimal getPretVanz() {
        return pretVanz;
    }

    public void setPretVanz(BigDecimal pretVanz) {
        this.pretVanz = pretVanz;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }
}
