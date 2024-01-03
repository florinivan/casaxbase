package com.phimes.casaxbase.database.service;


import com.phimes.casaxbase.database.DbService;
import com.phimes.casaxbase.database.DbServiceImpl;
import com.phimes.casaxbase.database.model.Furnizori;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PosRetailServiceImpl implements PosRetailService {
    private static PosRetailService INSTANCE;
    private DbService dbService;

    public PosRetailServiceImpl() {
        this.dbService = DbServiceImpl.getInstance();
    }

    public static PosRetailService getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PosRetailServiceImpl();
        }
        return INSTANCE;
    }
    @Override
    public List<Furnizori> getFurnizori(java.sql.Date x) {

        List<Furnizori> furnizori = new ArrayList<>();
        try (PreparedStatement stmt1 = dbService.getConnection().prepareStatement(
                "SELECT DISTINCT FURNIZOR FROM RECEPTIE WHERE DATA_ADD>=? AND DATA_ADD<= ?")) {
            stmt1.setDate(1, x);
            stmt1.setDate(2, x);
            try (ResultSet rs = stmt1.executeQuery()) {
                while (rs.next()) {
                    int num = rs.getInt(1);
                    if(num>0){
                        try (PreparedStatement stmt2 = dbService.getConnection().prepareStatement(
                                String.format("SELECT NUMEFIRMA,CUI,CIF, STRADA, NUMAR, BLOC, SCARA, APARTAMENT, LOCALITATE, JUDET,IBAN, BANCA, TEL, EMAIL,ADRESA_CORESPONDENTA FROM DISTRIBUITORI WHERE ID=%d", num))) {
                            //stmt1.setString(1, String.valueOf(num));
                            try (ResultSet rs1 = stmt2.executeQuery()) {
                                while (rs1.next()) {
                                    Furnizori newFur = new Furnizori();
                                    newFur.setCod(String.valueOf(num));
                                    newFur.setDenumire(rs1.getString(1));
                                    furnizori.add(newFur);
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return furnizori;
    }
}
