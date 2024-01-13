package com.phimes.casaxbase.database.model;

import lombok.Data;

@Data
public class Stoc {
    private Integer idm;
    private String prodId;
    private Double prodStoc;
    private Integer gestiuneId;
    private String denumire;
    private String barcode;
    private Double valinv;
}
