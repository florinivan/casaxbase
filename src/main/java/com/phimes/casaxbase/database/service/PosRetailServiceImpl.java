package com.phimes.casaxbase.database.service;


import com.phimes.casaxbase.database.DbService;
import com.phimes.casaxbase.database.DbServiceImpl;
import com.phimes.casaxbase.database.model.Furnizori;
import com.phimes.casaxbase.database.model.Stoc;
import com.phimes.casaxbase.database.model.StocUpdateRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Stoc> findByIdAndProdId(Integer idm, String prodId) {
        try (PreparedStatement stmt1 = dbService.getConnection().prepareStatement(
                "SELECT * FROM STOC WHERE IDM>=? AND PROD_ID<= ?")) {
            stmt1.setInt(1, idm);
            stmt1.setString(2, prodId);
            try (ResultSet resultSet = stmt1.executeQuery()) {
                while (resultSet.next()) {
                    Stoc stoc = new Stoc();
                    stoc.setIdm(resultSet.getInt("IDM"));
                    stoc.setProdId(resultSet.getString("PROD_ID"));
                    stoc.setProdStoc(resultSet.getDouble("PRODSTOC"));
                    stoc.setGestiuneId(resultSet.getInt("GESTIUNE_ID"));
                    stoc.setDenumire(resultSet.getString("DENUMIRE"));
                    stoc.setBarcode(resultSet.getString("BARCODE"));
                    stoc.setValinv(resultSet.getDouble("VALINV"));
                    return Optional.of(stoc);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
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

    @Override
    public void updateStocValues(List<StocUpdateRequest> stocUpdateRequests) {
        for (StocUpdateRequest request : stocUpdateRequests) {
            Stoc stocEntity = findByIdAndProdId(request.idm(), request.prodId())
                            .orElseThrow(() -> new RuntimeException("Stoc entry not found"));

            stocEntity.setValinv(request.valinv());
            saveAndFlush(stocEntity);
        }
    }

    @Override
    public int saveAndFlush(Stoc stocEntity) {
        String sql = "UPDATE STOC SET VALINV = ? WHERE IDM = ? AND PROD_ID = ?";
        try (var preparedStatement = dbService.getConnection().prepareStatement(sql)) {
            preparedStatement.setDouble(5, stocEntity.getValinv());
            preparedStatement.setInt(6, stocEntity.getIdm());
            preparedStatement.setString(7, stocEntity.getProdId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Stoc saved successfully.");
            } else {
                System.out.println("Failed to save Stoc.");
            }
            return rowsAffected;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
