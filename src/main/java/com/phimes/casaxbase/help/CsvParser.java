package com.phimes.casaxbase.help;

import com.phimes.casaxbase.database.model.StocUpdateRequest;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<StocUpdateRequest> parseCsv(BufferedReader reader) throws IOException {
        List<StocUpdateRequest> stocUpdateRequests = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] line;
            // Skip the header if it exists
            csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                StocUpdateRequest request = new StocUpdateRequest(Integer.parseInt(line[0]), line[1], Double.parseDouble(line[2]));
                stocUpdateRequests.add(request);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return stocUpdateRequests;
    }

    public static List<StocUpdateRequest> parseCsv(File selectedFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
            return parseCsv(reader);
        }
    }
}
