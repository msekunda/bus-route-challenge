package pl.bus.routes;

import org.junit.Test;
import pl.bus.routes.entity.BusStop;
import pl.bus.routes.file.FileDataProvider;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class FileDataProviderTest {


    @Test
    public void shouldGetBusRoutesFromFile() throws Exception {
        //given
        List<BusStop> busRoute1 = asList(BusStop.of(0), BusStop.of(1), BusStop.of(2), BusStop.of(3), BusStop.of(4));
        List<BusStop> busRoute2 = asList(BusStop.of(3), BusStop.of(1), BusStop.of(6), BusStop.of(5));
        List<BusStop> busRoute3 = asList(BusStop.of(0), BusStop.of(6), BusStop.of(4));
        List<List<BusStop>> busRoutes = asList(busRoute1, busRoute2, busRoute3);
        Path path = Paths.get("src/test/resources/data.txt");
        FileDataProvider fileDataProvider = new FileDataProvider(path);
        //when
        List<List<BusStop>> busRoutesFromFile = fileDataProvider.fetch();
        //then
        assertThat(busRoutesFromFile, equalTo(busRoutes));
    }
}