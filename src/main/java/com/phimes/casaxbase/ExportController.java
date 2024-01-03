package com.phimes.casaxbase;

import com.phimes.casaxbase.database.service.PosRetailService;
import com.phimes.casaxbase.database.service.PosRetailServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import com.linuxense.javadbf.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExportController {
    @FXML
    private Label label;

    @FXML
    private DatePicker datePickerBefore;

    @FXML
    protected void onHelloButtonClick() {
        List<DBFField> columnFilds = new ArrayList<>();
        try(DBFReader reader = new DBFReader(ExportController.class.getResourceAsStream("CASA.DBF"))){
            // get the field count if you want for some reasons like the following

            int numberOfFields = reader.getFieldCount();

            // use this count to fetch all field information
            // if required

            for (int i = 0; i < numberOfFields; i++) {

                DBFField field = reader.getField(i);
                columnFilds.add(field);
            }
            columnFilds.stream().forEach(item->{
                DBFRow row;

                while ((row = reader.nextRow()) != null) {
                }

            });
        }

        PosRetailService posRetailService = PosRetailServiceImpl.getInstance();
        LocalDate localDate = datePickerBefore.getValue();
        Date date = Date.valueOf(localDate);
        String furnString = posRetailService.getFurnizori(date).stream().map(Object::toString).collect(Collectors.joining(";"));
        label.setText(furnString);
    }
}