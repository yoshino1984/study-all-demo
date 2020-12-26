package other.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * @author wangxin
 * 2020/4/10 11:24
 * @since
 **/
public class DateTimeFormatterTest {

    static DateTimeFormatter italianFormat = new DateTimeFormatterBuilder()
        .appendText(ChronoField.DAY_OF_MONTH)
        .appendLiteral(". ")
        .appendText(ChronoField.MONTH_OF_YEAR)
        .appendLiteral(" ")
        .appendText(ChronoField.YEAR)
        .parseCaseInsensitive()
        .toFormatter(Locale.ITALIAN);

    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(2014, 3, 18);
//        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
//        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
//        System.out.println(s1);
//        System.out.println(s2);
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        System.out.println(date.format(dtf));
//        LocalDate date1 = LocalDate.parse(date.format(dtf), dtf);
//        System.out.println(date1);
//        System.out.println(date1.format(italianFormat));


        LocalDate startDate = LocalDate.now();
        DateTimeFormatter yearMonthPattern = DateTimeFormatter.ofPattern("yyyy-MM");

        for (int i = 0; i < 12; i++) {
            System.out.println(startDate.minusMonths(i).format(yearMonthPattern));
        }
        System.out.println(yearMonthPattern.format(startDate));


    }

}
