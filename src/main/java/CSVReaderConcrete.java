package main.java;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVReaderConcrete implements CSVReaderInterface {
    @Override
    public CSVReader getReader() throws IOException {
        return new CSVReader(new FileReader(StatsFile.FILENAME));
    }
}
