package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

public class LocalizationServiceImplTest {
    @ParameterizedTest
    @MethodSource("localeByCountry")
    public void testLocaleByCountry(Country country, String expectedLocale) {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actualLocale = localizationService.locale(country);

        Assertions.assertEquals(expectedLocale, actualLocale);
    }

    private static Stream<Arguments> localeByCountry() {
        return Stream.of(
                Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"),
                Arguments.of(Country.BRAZIL, "Welcome")
        );
    }
}
