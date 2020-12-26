import org.junit.Test;
import other.time.nonzone.LocalDateTimeUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 功能描述: <br>
 * 新增日期: 2019/5/13<br>
 *
 * @author laisf
 * @version 1.0.0
 */

public class LocalDateTimeUtilsTest {

    /**
     * 与DateUtils的对比，确保方法实现基本正确
     */
    @Test
    public void testCompareToDateUtilsBase() {
        testDateUtilsToLdtUtils(10, 5, 9, 3, 12, 5, 38, 45, 0);
    }

    /** 随机生成日期循环单元测试*/
    @Test
    public void testCompareToDateUtilsRandomLoop() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < 1000; i++) {
            int num1 = random.nextInt(1, 12);
            int num2 = random.nextInt(1, 13);
            int year = random.nextInt(1, 20);
            int month = random.nextInt(1, 13);
            int day = random.nextInt(1, 29);
            int hour = random.nextInt(0, 24);
            int min = random.nextInt(0, 60);
            int sec = random.nextInt(0, 60);
            testDateUtilsToLdtUtils(num1, num2, year, month, day, hour, min, sec, i);
        }
    }

    private void testDateUtilsToLdtUtils(int num1, int num2,
                                         int year, int month, int day, int hour, int min, int sec,
                                         int i) {
        String msg = String.format("\n%s--生成的数值：%s, %s, %s, %s, %s, %s, %s, %s ", i, num1, num2,
            year, month, day, hour, min, sec);
        LocalDateTime todayLdt = LocalDateTime.of(2015 + year, month, day, hour, min, sec);
        Date today = LocalDateTimeUtils.localDateTimeToDate(todayLdt);

        LocalDateTime dateTime1 = LocalDateTimeUtils.copy(todayLdt).plusYears(year).plusMonths(month).plusDays(day);
        Date date1 = LocalDateTimeUtils.localDateTimeToDate(dateTime1);

        LocalDateTime dateTime2 = LocalDateTimeUtils.copy(todayLdt).minusYears(year).minusMonths(month).minusDays(day);
        Date date2 = LocalDateTimeUtils.localDateTimeToDate(dateTime2);


//        compareDateTime(msg + "getNextDate", DateUtils.getNextDate(today), LocalDateTimeUtils.getNextDate(todayLdt));
//        compareDateTime(msg + "getNextDate", DateUtils.getNextDate(today), LocalDateTimeUtils.getNextDate(todayLdt.toLocalDate()));
//        Assert.assertEquals(msg + "getDiffMonth", DateUtils.getDiffMonth(today, date1), LocalDateTimeUtils.getDiffMonth(todayLdt, dateTime1));
//        Assert.assertEquals(msg + "getDiffDays", DateUtils.getDiffDays(today, date1), LocalDateTimeUtils.getDiffDays(todayLdt, dateTime1));
//        Assert.assertEquals(msg + "getDiffSeconds", DateUtils.getDiffSeconds(today, date1), LocalDateTimeUtils.getDiffSeconds(todayLdt, dateTime1));
//        compareDateTime(msg + "getNextMonthDate", DateUtils.getNextMonthDate(today), LocalDateTimeUtils.getNextMonthDate(todayLdt.toLocalDate()));
//        Assert.assertEquals(msg + "getYearDays", DateUtils.getYearDays(), LocalDateTimeUtils.getYearDays());
//        Assert.assertEquals(msg + "getDayOfYear", DateUtils.getDayOfYear(today), LocalDateTimeUtils.getDayOfYear(todayLdt));
//        Assert.assertEquals(msg + "dateToString", DateUtils.dateToString(today), LocalDateTimeUtils.dateToString(todayLdt));
//        compareDateTime(msg + "stringToDate", DateUtils.stringToDate(DateUtils.dateToString(today)),
//            LocalDateTimeUtils.stringToDate(LocalDateTimeUtils.dateToString(todayLdt)));
//        Assert.assertEquals(msg + "getYear", DateUtils.getYear(today), LocalDateTimeUtils.getYear(todayLdt));
//        Assert.assertEquals(msg + "getDiffTimeByMin1", DateUtils.getDiffTimeByMin(today, date1), LocalDateTimeUtils.getDiffTimeByMin(todayLdt, dateTime1));
//        Assert.assertEquals(msg + "getDiffTimeByMin2", DateUtils.getDiffTimeByMin(today, date2), LocalDateTimeUtils.getDiffTimeByMin(todayLdt, dateTime2));
//        compareDateTime(msg + "genYearFirst", DateUtils.genYearFirst(today), LocalDateTimeUtils.genYearFirst(todayLdt.toLocalDate()));
//        compareDateTime(msg + "genYearLast", DateUtils.genYearLast(today), LocalDateTimeUtils.genYearLast(todayLdt.toLocalDate()));
//        compareDateTime(msg + "genCurrentSunday", DateUtils.genCurrentSunday(today), LocalDateTimeUtils.genCurrentSunday(todayLdt.toLocalDate()));
//        compareDateTime(msg + "genPreviousSunday", DateUtils.genPreviousSunday(today), LocalDateTimeUtils.genPreviousSunday(todayLdt.toLocalDate()));
//        compareDateTime(msg + "genLastYearFirst", DateUtils.genLastYearFirst(today), LocalDateTimeUtils.genLastYearFirst(todayLdt.toLocalDate()));
//        compareDateTime(msg + "genLastYearLast", DateUtils.genLastYearLast(today), LocalDateTimeUtils.genLastYearLast(todayLdt.toLocalDate()));
//        compareDateTime(msg + "genLastYearCurMonthFirst", DateUtils.genLastYearCurMonthFirst(today), LocalDateTimeUtils.genLastYearCurMonthFirst(todayLdt.toLocalDate()));
//        compareDateTime(msg + "genDiffMonthToday1", DateUtils.genDiffMonthToday(today, num1), LocalDateTimeUtils.genDiffMonthToday(todayLdt, num1));
//        compareDateTime(msg + "genDiffMonthToday2", DateUtils.genDiffMonthToday(today, num1, true), LocalDateTimeUtils.genDiffMonthToday(todayLdt, num1, true));
//        compareDateTime(msg + "getDateBegin", DateUtils.getDateBegin(today), LocalDateTimeUtils.getDateBegin(todayLdt));
//        compareDateTime(msg + "getDateEnd", DateUtils.getDateEnd(today), LocalDateTimeUtils.getDateEnd(todayLdt));
//        compareDateTime(msg + "getHourBegin", DateUtils.getHourBegin(today), LocalDateTimeUtils.getHourBegin(todayLdt));
//        compareDateTime(msg + "getHourBegin", DateUtils.getHourBegin(today, num2), LocalDateTimeUtils.getHourBegin(todayLdt, num2));
//        compareDateTime(msg + "getHourEnd", DateUtils.getHourEnd(today), LocalDateTimeUtils.getHourEnd(todayLdt));
//        compareDateTime(msg + "getHourEnd", DateUtils.getHourEnd(today, num2), LocalDateTimeUtils.getHourEnd(todayLdt, num2));
//        Assert.assertEquals(msg + "equals1", DateUtils.equals(today, today), LocalDateTimeUtils.equals(todayLdt, todayLdt));
//        Assert.assertEquals(msg + "equals2", DateUtils.equals(today, date1), LocalDateTimeUtils.equals(todayLdt, dateTime1));
//        compareDateTime(msg + "getFirstDayOfMonth", DateUtils.getFirstDayOfMonth(today), LocalDateTimeUtils.getFirstDayOfMonth(todayLdt));
//        compareDateTime(msg + "genThisMonday", DateUtils.genThisMonday(today), LocalDateTimeUtils.genThisMonday(todayLdt.toLocalDate()));
//        Assert.assertEquals(msg + "getWeekDesc", DateUtils.getWeekDesc(today), LocalDateTimeUtils.getWeekDesc(todayLdt.toLocalDate()));
//        Assert.assertEquals(msg + "getCurSecond", DateUtils.getCurSecond(), LocalDateTimeUtils.getCurSecond());
//
//        boolean isPrintBlank = false;
//        if (DateUtils.getBirthRemainDay(today) != LocalDateTimeUtils.getBirthRemainDay(todayLdt)) {
//            // 这个方法稍微有点误差
////            System.out.printf(msg + "getBirthRemainDay:%s, ", DateUtils.getBirthRemainDay(today) - LocalDateTimeUtils.getBirthRemainDay(todayLdt));
////            isPrintBlank = true;
//        }
//
//        try {
//            compareDateTime(msg + "genLastMonthToday", DateUtils.genLastMonthToday(today), LocalDateTimeUtils.genLastMonthToday(todayLdt));
//        } catch (Throwable e) {
//            System.out.printf(msg + "genLastMonthToday %s ", todayLdt);
//            isPrintBlank = true;
//        }
//
//        try {
//            compareDateTime(msg + "genLastYearToday", DateUtils.genLastYearToday(today), LocalDateTimeUtils.genLastYearToday(todayLdt.toLocalDate()));
//        } catch (Throwable e) {
//            System.out.printf(msg + "genLastYearToday %s", todayLdt);
//            isPrintBlank = true;
//        }
//
//        try {
//            compareDateTime(msg + "genLastQuarterStartTime", DateUtils.genLastQuarterStartTime(today), LocalDateTimeUtils.genLastQuarterStartTime(todayLdt));
//        } catch (Throwable e) {
//            System.out.printf(msg + "genLastQuarterStartTime %s", todayLdt);
//            isPrintBlank = true;
//        }
//
//        try {
//            compareDateTime(msg + "genLastQuarterEndTime", DateUtils.genLastQuarterEndTime(today), LocalDateTimeUtils.genLastQuarterEndTime(todayLdt));
//        } catch (Throwable e) {
//            System.out.printf(msg + "genLastQuarterEndTime %s", todayLdt);
//            isPrintBlank = true;
//        }
//
//        try {
//            compareDateTime(msg + "genLastYearCurMonthLast", DateUtils.genLastYearCurMonthLast(today), LocalDateTimeUtils.genLastYearCurMonthLast(todayLdt.toLocalDate()));
//        } catch (Throwable e) {
//            System.out.printf(msg + "genLastQuarterEndTime %s", todayLdt);
//            isPrintBlank = true;
//        }
//        if (isPrintBlank) {
//            System.out.println();
//        }
//    }
//
//    private void compareDateTime(String msg, Date date, LocalDateTime dateTime) {
////        System.out.println(date + "  :" + dateTime);
//        // 忽略毫秒级的比较，DateUtils原先实现都没对毫秒做处理
//        Assert.assertEquals(msg, date.getTime()/1000, LocalDateTimeUtils.localDateTimeToDate(dateTime).getTime() / 1000);
//    }
//
//    private void compareDateTime(String msg, Date date, LocalDate localDate) {
////        System.out.println(date + "  :" + localDate);
//        Assert.assertEquals(msg, LocalDateTimeUtils.dateToLocalDate(date), localDate);
//    }
//
//    /** 与DateUtils的对比，确保方法实现基本正确*/
//    @Test
//    public void testGetNextYearDate() {
//        LocalDateTime dateTime = LocalDateTime.now().withYear(2018);
//        for (int i = 0; i < 2000; i++) {
//            String dayStr = LocalDateTimeUtils.dateToString(dateTime.plusDays(i));
//            Assert.assertEquals(DateUtils.getNextYearDate(dayStr), LocalDateTimeUtils.getNextYearDate(dayStr));
//            Assert.assertEquals(DateUtils.getNextYearDateWithLeap(dayStr), LocalDateTimeUtils.getNextYearDateWithLeap(dayStr));
//        }
//    }
//
//    /** 与DateUtils的对比，确保方法实现基本正确*/
//    @Test
//    public void testGetLastYearAndMonths() {
//        Pair<Date, List<String>> datePair = DateUtils.getLastYeayAndMonths();
//        Pair<LocalDateTime, List<String>> ldtPair = LocalDateTimeUtils.getLastYearAndMonths();
//        compareDateTime("", datePair.getV1(), ldtPair.getV1());
//        Assert.assertEquals(datePair.getV2().size(), (ldtPair.getV2()).size());
//        for (int i = 0; i < datePair.getV2().size(); i++) {
//            Assert.assertEquals(datePair.getV2().get(i), (ldtPair.getV2()).get(i));
//        }
//    }
//
//    /** 与DateUtils的对比，确保方法实现基本正确*/
//    @Test
//    public void testEquals() {
//        Pair<Date, List<String>> datePair = DateUtils.getLastYeayAndMonths();
//        Pair<LocalDateTime, List<String>> ldtPair = LocalDateTimeUtils.getLastYearAndMonths();
//        compareDateTime("", datePair.getV1(), ldtPair.getV1());
//        Assert.assertEquals(datePair.getV2().size(), (ldtPair.getV2()).size());
//        for (int i = 0; i < datePair.getV2().size(); i++) {
//            Assert.assertEquals(datePair.getV2().get(i), (ldtPair.getV2()).get(i));
//        }
//    }
//
//    /**
//     * 计算指定年月的最后一天日期（年份过小，DateUtils不准）
//     * 与DateUtils的对比，确保方法实现基本正确
//     */
//    @Test
//    public void testGetLastDayOfMonth() {
//        int year = 1900;
//        int month = 7;
//        for (int i = 0; i < 100; i++) {
//            compareDateTime("" + i, DateUtils.getLastDayOfMonth(year, month), LocalDateTimeUtils.getLastDayOfMonth(year, month));
//        }
    }
}
