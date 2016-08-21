package pl.bus.routes.file;

import pl.bus.routes.entity.BusStop;

import java.io.IOException;
import java.util.List;


public interface DataProvider {

    List<List<BusStop>> fetch() throws IOException;
}
