package sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class MessageSenderImplTtst {

    //Поверить, что MessageSenderImpl всегда отправляет только
    // русский текст, если ip относится к российскому сегменту адресов. 172
    //Поверить, что MessageSenderImpl всегда отправляет только английский
    // текст, если ip относится к американскому сегменту адресов 96.

    @Mock
    private GeoService geoService; // создаем moc объект для интерфейса geoService

    @Mock
    private LocalizationService localizationService; // создаем moc объект для интерфейса localizationService
    private MessageSenderImpl messageSender; //объявляем тестируемый  объект

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); //инициализируем мос объекты
        //создаем экземпляр messageSender  с использованием мок объектов
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    public void send_Russian_Test() {
        String ipAddress = "172.0.32.11"; // задаем айпи адрес для русскоязычного сегмента
        Map<String, String> headers = new HashMap<String, String>();
        //создаем хедер с айпи адресом
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAddress);
//имитируем поведение  geoServise
        when(geoService.byIp(ipAddress))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        //имитируем поведение localizationService
        when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
// получаем фактический результат
        String result = messageSender.send(headers);
//сравниваем фактический и ожидаемый результат
        assertEquals("Добро пожаловать", result);
    }

    @Test
    public void send_England_Test() {
        //задаем айпи адрес для англоязычного сегмента
        String ipAddress = "96.44.18149";
        // создаем мапу для хранения адресов
        Map<String, String> headers = new HashMap<String, String>();
        //создаем хейдер
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAddress);
        //имитируем поведение  geoServise
        when(geoService.byIp(ipAddress))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        //имитируем поведение localizationService
        when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        // получаем фактический результат
        String result = messageSender.send(headers);
        //сравниваем фактический и ожидаемый результат
        assertEquals("Welcome", result);

    }

}
