package com.phimes.casaxbase;

import com.phimes.casaxbase.database.model.StocUpdateRequest;
import com.phimes.casaxbase.database.service.PosRetailService;
import com.phimes.casaxbase.database.service.PosRetailServiceImpl;
import com.phimes.casaxbase.help.CsvParser;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class LoadcsvController {
    @FXML
    private TextArea csvTextArea;

    private PosRetailService posRetailService = PosRetailServiceImpl.getInstance();

    @SneakyThrows
    @FXML
    public void loadCSVFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            List<StocUpdateRequest> stocUpdateRequests = CsvParser.parseCsv(selectedFile);
            posRetailService.updateStocValues(stocUpdateRequests);
        }
    }
}
