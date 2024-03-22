package test.java;


import com.opencsv.CSVReader;
import main.java.CSVReaderInterface;
import main.java.StatsFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StatsFileTest {

    @Test
    public void testNumGames() throws Exception {
        // using dependency injection
        CSVReaderInterface csvri = mock(CSVReaderInterface.class);
        CSVReader csvReaderMock = mock(CSVReader.class);
        when(csvri.getReader()).thenReturn(csvReaderMock);
        when(csvReaderMock.readNext()).thenReturn(
                new String[]{"2024-03-01T20:10:29.110278500","3"},
                new String[]{"2024-03-01T20:15:28.750793100", "3"},
                new String[]{"2024-03-01T20:56:09.088002200", "9"},
                new String[]{"2024-03-01T21:02:13.347392500","1"},
                new String[]{"2024-03-01T21:06:40.860330300","10"},
                new String[]{"2024-03-01T21:35:52.413820800","13"},
                new String[]{"2024-03-01T21:38:37.771960700","7"},
                new String[] {"2024-03-01T21:40:31.854307700","9"},
                null
        );
        StatsFile stats = new StatsFile(csvri);
        assertEquals(2, stats.numGames(3));
        assertEquals(0, stats.numGames(5));
    }

    @Test
    public void testMaxNumGuesses() throws Exception {
        // using dependency injection
        CSVReaderInterface csvri = mock(CSVReaderInterface.class);
        CSVReader csvReaderMock = mock(CSVReader.class);
        when(csvri.getReader()).thenReturn(csvReaderMock);
        when(csvReaderMock.readNext()).thenReturn(
                new String[]{"2024-03-01T20:10:29.110278500","3"},
                new String[]{"2024-03-01T21:35:52.413820800","13"},
                new String[] {"2024-03-01T21:40:31.854307700","9"},
                null
        );
        StatsFile stats = new StatsFile(csvri);
        assertEquals(13, stats.maxNumGuesses());
    }
}
