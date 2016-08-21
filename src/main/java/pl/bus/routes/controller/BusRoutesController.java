package pl.bus.routes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bus.routes.entity.BusRouteResponse;
import pl.bus.routes.entity.BusStop;
import pl.bus.routes.service.BusRoutesService;

@RestController
public class BusRoutesController {

    private final BusRoutesService busRoutesService;

    @Autowired
    public BusRoutesController(BusRoutesService busRoutesService) {
        this.busRoutesService = busRoutesService;
    }

    @RequestMapping("/rest/provider/goeurobus/direct/{departure}/{arrival}")
    public BusRouteResponse checkDirectConnection(@PathVariable("departure") Integer departure, @PathVariable("arrival") Integer arrival) {
        boolean isDirectConnection = busRoutesService.hasDirectConnection(BusStop.of(departure), BusStop.of(arrival));
        return new BusRouteResponse(departure, arrival, isDirectConnection);
    }
}
