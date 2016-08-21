package pl.bus.routes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bus.routes.entity.BusStop;
import pl.bus.routes.file.DataProvider;

import java.io.IOException;
import java.util.List;

@Service
public class BusRoutesService {

    private final DataProvider dataProvider;

    @Autowired
    public BusRoutesService(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public boolean hasDirectConnection(BusStop departure, BusStop arrival) {
        try {
            return dataProvider.fetch().stream()
                               .anyMatch(x -> matchBusStops(x, departure, arrival));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean matchBusStops(List<BusStop> busStops, BusStop departure, BusStop arrival) {
        return busStops.contains(arrival) && busStops.contains(departure);
    }
}
