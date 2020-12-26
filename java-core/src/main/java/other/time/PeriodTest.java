package other.time;

import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author wangxin
 * 2020/4/10 11:18
 * @since
 **/
public class PeriodTest {

    public static void main(String[] args) {
        Period period = Period.of(1,1,1);
        System.out.println(period);
        System.out.println(period.getUnits());
        System.out.println(period.get(ChronoUnit.DAYS));
    }
}
