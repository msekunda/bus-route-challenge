package pl.bus.routes;

import org.junit.Test;
import pl.bus.routes.entity.BusStop;
import pl.bus.routes.file.DataProvider;
import pl.bus.routes.service.BusRoutesService;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BusRoutesTest {

    @Test
    public void shouldFindDirectConnection() throws Exception {
        //given
        List<BusStop> busRoute1 = asList(BusStop.of(0), BusStop.of(1), BusStop.of(2), BusStop.of(3), BusStop.of(4));
        List<BusStop> busRoute2 = asList(BusStop.of(3), BusStop.of(1), BusStop.of(6), BusStop.of(5));
        List<BusStop> busRoute3 = asList(BusStop.of(0), BusStop.of(6), BusStop.of(4));
        DataProvider dataProvider = mock(DataProvider.class);
        when(dataProvider.fetch()).thenReturn(asList(busRoute1, busRoute2, busRoute3));
        BusRoutesService busRoutes = new BusRoutesService(dataProvider);

        //when
        boolean hasDirectConnection = busRoutes.hasDirectConnection(BusStop.of(3), BusStop.of(6));

        //then
        assertThat(hasDirectConnection, is(true));
    }
}
