package other.time.zone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wangxin
 * 2020/4/19 09:43
 * @since
 **/
public class ZoneDateTImeTest {

    public static ThreadLocal<Long> local = ThreadLocal.withInitial(() -> Thread.currentThread().getId());

    public static void main(String[] args) {
        System.out.println(local.get());
        new Thread(() -> System.out.println(ZoneDateTImeTest.local.get())).start();
        new Thread(() -> System.out.println(ZoneDateTImeTest.local.get())).start();
        //一个时间表示
        String stringDate = "2020-01-02 22:00:00";
        ZoneId timeZoneNY = ZoneId.of("America/New_York");
        ZoneId timeZoneSH = ZoneId.of("Asia/Shanghai");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneNY);

        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        System.out.println(outputFormat.withZone(timeZoneNY).format(dateTime));
        System.out.println(outputFormat.withZone(timeZoneSH).format(dateTime));

    }
}
