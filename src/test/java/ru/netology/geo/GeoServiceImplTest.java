package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

public class GeoServiceImplTest {

    @ParameterizedTest
    @MethodSource("locationByIp")
    public void testLocationByIp(String ip, Location expectedLocation) {
        GeoService geoService = new GeoServiceImpl();
        Location actualLocation = geoService.byIp(ip);

        Assertions.assertEquals(expectedLocation, actualLocation);
    }

    private static Stream<Arguments> locationByIp() {
        return Stream.of(
                Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32))
        );
    }

    @Test
    public void testCountryByIp() {
        Country expected = Country.RUSSIA;

        GeoService geoService = new GeoServiceImpl();
        Location actualLocation = geoService.byIp("172.10.20.30");
        Country actual = actualLocation.getCountry();

        Assertions.assertEquals(expected, actual);
    }
}
