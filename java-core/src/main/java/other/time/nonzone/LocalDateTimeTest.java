package other.time.nonzone;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * LocalDate LocalTime LocalDateTime 测试用
 *
 * @author wangxin
 * 2020/4/10 11:19
 * @since
 **/
public class LocalDateTimeTest {
    @Test
    public void test() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        LocalDate date1 = date.with(ChronoField.MONTH_OF_YEAR, 9);
        LocalDate date2 = date1.plusYears(2).minusDays(10);
        date.withYear(2011);

        System.out.println(date);
        System.out.println(date1);
        System.out.println(date2);

    }
}
