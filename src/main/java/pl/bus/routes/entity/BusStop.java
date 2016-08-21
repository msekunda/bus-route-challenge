package pl.bus.routes.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BusStop {

    private final int number;

    private BusStop(final int number) {
        this.number = number;
    }

    public static BusStop of(int i) {
        return new BusStop(i);
    }
}
