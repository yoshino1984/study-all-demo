package other.time.temporal.adjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author wangxin
 * 2020/4/10 11:33
 * @since
 **/
public class MyTemporalAdjusters {
    static TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
        temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            } else if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    );

    public static void main(String[] args) {
        System.out.println(LocalDate.now().with(nextWorkingDay));
    }
}
