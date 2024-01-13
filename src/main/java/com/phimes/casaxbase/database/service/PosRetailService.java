package com.phimes.casaxbase.database.service;

import com.phimes.casaxbase.database.model.Furnizori;
import com.phimes.casaxbase.database.model.Stoc;
import com.phimes.casaxbase.database.model.StocUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface PosRetailService {
    Optional<Stoc> findByIdAndProdId(Integer idm, String prodId);
    List<Furnizori> getFurnizori(java.sql.Date x);
    void updateStocValues(List<StocUpdateRequest> stocUpdateRequests);
    int saveAndFlush(Stoc stocEntity);
}
