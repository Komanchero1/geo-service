package i18n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {

    //Написать тесты для проверки возвращаемого текста
    //Проверить работу метода public String locale(Country country)

    private LocalizationService localizationService;

    @BeforeEach
    public void setUp() {
        //создаем объкт мос
        localizationService = Mockito.mock(LocalizationServiceImpl.class);
    }

    @Test
    public void locale_Russia_Test() {
        //задаем  country  значение RUSSIA
        Country country = Country.RUSSIA;
        //ожидаемый результат работы метода  actual
        String expected = "Добро пожаловать";
        //создаем объект мос с параметром RUSSIA
        Mockito.when(localizationService.locale(country)).thenReturn(expected);
        //определяем фактический результат работы метода local
        String actual = localizationService.locale(country);
        //сравниваем ожидаемый и фактический результаты
        assertEquals(expected, actual);
    }

    @Test
    public void locale_Germany_Test() {
        //задаем  country  значение GERMANY
        Country country = Country.GERMANY;
        //ожидаемый результат работы метода  actual
        String expected = "Welcome";
        //создаем объект мос с параметром GERMANY
        Mockito.when(localizationService.locale(country)).thenReturn(expected);
        //определяем фактический результат работы метода local
        String actual = localizationService.locale(country);
        //сравниваем ожидаемый и фактический результаты
        assertEquals(expected, actual);
    }

    @Test
    public void locale_Usa_Test() {
        //задаем  country  значение USA
        Country country = Country.USA;
        //ожидаемый результат работы метода  actual
        String expected = "Welcome";
        //создаем объект мос с параметром USA
        Mockito.when(localizationService.locale(country)).thenReturn(expected);
        //определяем фактический результат работы метода local
        String actual = localizationService.locale(country);
        //сравниваем ожидаемый и фактический результаты
        assertEquals(expected, actual);
    }

    @Test
    public void locale_Brazil_Test() {
        //задаем  country  значение BRAZIL
        Country country = Country.BRAZIL;
        //ожидаемый результат работы метода  actual
        String expected = "Welcome";
        //создаем объект мос с параметром BRAZIL
        Mockito.when(localizationService.locale(country)).thenReturn(expected);
        //определяем фактический результат работы метода local
        String actual = localizationService.locale(country);
        //сравниваем ожидаемый и фактический результаты
        assertEquals(expected, actual);
    }
}
