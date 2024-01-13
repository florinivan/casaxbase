package com.phimes.casaxbase.database.model;

import lombok.Data;

@Data
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
}
