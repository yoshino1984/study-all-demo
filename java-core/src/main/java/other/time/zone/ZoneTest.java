package other.time.zone;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * @author wangxin
 * 2020/4/10 11:26
 * @since
 **/
public class ZoneTest {

    @Test
    public void zoneId() {
        System.out.println(ZoneId.systemDefault().getRules());
    }

    @Test
    public void zoneIdCompare2ZoneOffSet() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime zoneOffsetTime = now.withZoneSameInstant(ZoneOffset.UTC);
        System.out.println(zoneOffsetTime);

        ZonedDateTime zoneIdTime = now.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println(zoneIdTime);
    }


    public static void main(String[] args) {
        ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(LocalDateTime.now());
        System.out.println(zoneOffset);
    }
}
