package main.java;

import com.opencsv.CSVReader;

import java.io.IOException;

public interface CSVReaderInterface {
    CSVReader getReader() throws IOException;
}
