package com.phimes.casaxbase.database.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
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
}
