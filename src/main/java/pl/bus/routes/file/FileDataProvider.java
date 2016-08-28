package pl.bus.routes.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bus.routes.entity.BusStop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

@Service
public class FileDataProvider implements DataProvider {

    private static final String DELIMITER = " ";
    private final Path path;

    @Autowired
    public FileDataProvider(Path path) {
        this.path = path;
    }

    @Override
    public List<List<BusStop>> fetch() throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            final ArrayList<List<BusStop>> busStops = lines
                    .skip(1)
                    .map(this::toBusRoute)
                    .collect(toCollection(ArrayList::new));
            return busStops;
        }
    }

    private List<BusStop> toBusRoute(String line) {
        final String[] busStops = line.split(DELIMITER);
        final List<BusStop> busStopsList = Stream.of(busStops)
                                                 .skip(1)
                                                 .map(Integer::valueOf)
                                                 .map(BusStop::of)
                                                 .collect(toList());
        return busStopsList;
    }
}
