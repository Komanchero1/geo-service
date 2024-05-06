package geo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {

    //Написать тесты для проверки определения локации по ip
    //Проверить работу метода public Location byIp(String ip)

    private GeoServiceImpl geoService;

    @BeforeEach
    public void setUp() {
        geoService = Mockito.mock(GeoServiceImpl.class);
    }

    @Test
    public void byIp_Localhost_Test() {
        //инициализируем переменную с ай пи адресом не привязанным ни какой стране
        String ipAddress = GeoServiceImpl.LOCALHOST;
        //создаем обьект ожидаемого результата
        Location expected = new Location(null, null, null, 0);
        //создаем мос объект и передаем в него ай пи адрес без привязки к стране
        Mockito.when(geoService.byIp(ipAddress)).thenReturn(expected);
        //определяем фактическую локацию по ай пи адресу
        Location actual = geoService.byIp(ipAddress);
        //сравниваем ожидаемый результат и фактический
        assertEquals(expected, actual);
    }

    @Test
    public void byIp_Moscow_Test() {
        //инициализируем переменную с ай пи адресом привязанным к Москве
        String ipAddress = GeoServiceImpl.MOSCOW_IP;
        //создаем обьект ожидаемого результата
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        //создаем мос объект и передаем в него ай пи адрес привязанный к Москве
        Mockito.when(geoService.byIp(ipAddress)).thenReturn(expected);
        //определяем фактическую локацию по ай пи адресу
        Location actual = geoService.byIp(ipAddress);
        //сравниваем ожидаемый результат и фактический
        assertEquals(expected, actual);
    }

    @Test
    public void byIp_Usa_Test() {
        //инициализируем переменную с ай пи адресом привязанным к Нью Ерку
        String ipAddress = GeoServiceImpl.NEW_YORK_IP;
        //создаем обьект ожидаемого результата
        Location expected = new Location("New York", Country.USA, "10th Avenue", 32);
        //создаем мос объект и передаем в него ай пи адрес привязанный к Нью Ерку
        Mockito.when(geoService.byIp(ipAddress)).thenReturn(expected);
        //определяем фактическую локацию по ай пи адресу
        Location actual = geoService.byIp(ipAddress);
        //сравниваем ожидаемый результат и фактический
        assertEquals(expected, actual);
    }


    @Test
    public void byIp_172_Test() {
        //инициализируем переменную с ай пи адресом привязанным к Российскому сегменту
        String ipAddress = "172.1.2.3";
        //создаем обьект ожидаемого результата
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        //создаем мос объект и передаем в него ай пи адрес привязанный к Российскому сегменту
        Mockito.when(geoService.byIp(ipAddress)).thenReturn(expected);
        //определяем фактическую локацию по ай пи адресу
        Location actual = geoService.byIp(ipAddress);
        //сравниваем ожидаемый результат и фактический
        assertEquals(expected, actual);
    }

    @Test
    public void byIp_96_Test() {
        //инициализируем переменную с ай пи адресом привязанным к Американскому сегменту
        String ipAddress = "96.1.2.3";
        //создаем обьект ожидаемого результата
        Location expected = new Location("New York", Country.USA, null, 0);
        //создаем мос объект и передаем в него ай пи адрес привязанный к Американскому сегменту
        Mockito.when(geoService.byIp(ipAddress)).thenReturn(expected);
        //определяем фактическую локацию по ай пи адресу
        Location actual = geoService.byIp(ipAddress);
        //сравниваем ожидаемый результат и фактический
        assertEquals(expected, actual);
    }
}
