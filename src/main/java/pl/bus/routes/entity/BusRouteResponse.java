package pl.bus.routes.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class BusRouteResponse {
    @JsonProperty(value = "dep_sid")
    private final int departureId;
    @JsonProperty(value = "arr_sid")
    private final int arrivalId;
    @JsonProperty(value = "direct_bus_route")
    private final boolean directBusRoute;
}
