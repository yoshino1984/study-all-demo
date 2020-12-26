package other.time.nonzone;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 日期类（主要使用LocalDateTime、LocalDate、LocalTime实现）
 * todo 视方法情况实现 三种类
 * @author wangxin
 * 2020/3/30 08:40
 * @since
 **/
public class LocalDateTimeUtils {

    /** Date 转化成 LocalDateTime */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /** LocalDateTime 转化成 Date */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * LocalDate转换为传统Date
     * @author lsh
     * @param localDate LocalDate
     * @return 传统Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 传统Date转换为LocalDate
     * @author lsh
     * @param date 传统Date
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /** LocalDate 转换成LocalDateTime 00:00*/
    public static LocalDateTime localDateToLdt(LocalDate date) {
        return localDateToLdt(date, LocalTime.MIN);
    }

    /** LocalDate 转换成LocalDateTime */
    public static LocalDateTime localDateToLdt(LocalDate date, LocalTime time) {
        return LocalDateTime.of(copy(date), copy(time));
    }

    public static LocalDate copy(LocalDate date) {
        return LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }

    public static LocalTime copy(LocalTime time) {
        return LocalTime.of(time.getHour(), time.getMinute(), time.getSecond(), time.getNano());
    }

    public static LocalDateTime copy(LocalDateTime date) {
        return LocalDateTime.of(copy(date.toLocalDate()), copy(date.toLocalTime()));
    }

    /**
     * 获取下一天，日期加1，时间不变
     *
     * @author wangxin
     * @param ldt
     * @return 下一天
     */
    public static LocalDateTime getNextDate(LocalDateTime ldt) {
        return copy(ldt).plusDays(1);
    }

    public static LocalDate getNextDate(LocalDate ld) {
        return ld.plusDays(1);
    }

    /**
     * 获取月份差额 (first - second)
     * @param first
     * @param second
     * @return
     * @see com.hzecool.fdn.utils.date.DateUtils#getDiffMonth(java.util.Date, java.util.Date)
     */
    public static int getDiffMonth(LocalDate first, LocalDate second) {
        int year1 = first.getYear();
        int month1 = first.getMonthValue();
        int year2 = second.getYear();
        int month2 = second.getMonthValue();
        return (year1 * 12 + month1) - (year2 * 12 + month2);
    }

    public static int getDiffMonth(LocalDateTime first, LocalDateTime second) {
        return getDiffMonth(first.toLocalDate(), second.toLocalDate());
    }

    /**
     * 获取日期差额
     *
     * @author qiuxs
     * @param start
     * @param end
     * @return
     */
    public static int getDiffDays(LocalDateTime start, LocalDateTime end) {
        return (int) getDiffDaysLong(start, end);
    }

    public static long getDiffDaysLong(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end).toDays();
    }

    public static long getDiffDaysLong(LocalDate start, LocalDate end) {
        return Duration.between(start.atTime(LocalTime.MIN), end.atTime(LocalTime.MIN)).toDays();
    }

    /**
     * 获取秒数差
     *
     * @author laisf
     * @param start
     * @param end
     * @return
     */
    public static int getDiffSeconds(LocalDateTime start, LocalDateTime end) {
        return (int) getDiffSecondsLong(start, end);
    }

    public static long getDiffSecondsLong(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return duration.get(ChronoUnit.SECONDS);
    }

    /**
     * 获取日期差额
     *
     * @author wangxin
     * @param startTime 毫秒时间戳
     * @param endTime 毫秒时间戳
     * @return
     */
    public static int getDiffDays(long startTime, long endTime) {
        long time = endTime - startTime;
        return new Long(time / (24 * 3600 * 1000)).intValue();
    }

    /**
     * 获取下一个月的日期
     * @param ldt
     * @return
     */
    public static LocalDate getNextMonthDate(LocalDate ldt) {
        return copy(ldt).plusMonths(1);
    }

    /** 获取今年有多少天*/
    public static int getYearDays() {
        return LocalDate.now().isLeapYear() ? 366 : 365;
    }

    /**
     * 获取当前日期在一年中是第几天
     * @param ldt
     * @return
     */
    public static int getDayOfYear(LocalDateTime ldt) {
        return ldt.getDayOfYear();
    }

    /**
     * 获取明年的同一天；不考虑闰年
     * （结果与DateUtils 在 2月29日 转化的情况下稍微有点差异）
     *
     * @author wangxin
     * @param day
     * @return
     * 2016-02-29 next: 2016-02-28
     * 2017-02-29 next: 2017-02-28
     * 2018-02-29 next: 2018-02-28
     * 2019-02-29 next: 2019-02-28
     * 2020-02-29 next: 2020-02-28
     */
    public static String getNextYearDate(String day) {
        String dateFormat = "yyyy-MM-dd";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        try {
            LocalDate ld = LocalDate.parse(day, dateTimeFormatter);
            return ld.plusYears(1).format(dateTimeFormatter);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取明年的同一天；考虑闰年(正常情况下的实现相同)
     */
    public static String getNextYearDateWithLeap(String day) {
        return getNextYearDate(day);
    }


    public static String dateToString(LocalDateTime date) {
        String dateFormat = "yyyy-MM-dd";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        try {
            return dateTimeFormatter.format(date);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static LocalDate stringToDate(String day) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(day, dateTimeFormatter);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前时间是哪一年
     * @param ldt
     * @return
     */
    public static int getYear(LocalDateTime ldt) {
        return ldt.getYear();
    }

    /**
     * 获取还有多少天生日（未对2月29日特殊处理）
     *
     * @param birthday
     * @return
     */
    public static int getBirthRemainDay(LocalDate birthday) {
        // 今天
        LocalDate today = LocalDate.now();
        // 生日
        LocalDate nextBirthday = birthday.withYear(today.getYear());

        if (nextBirthday.isBefore(today)) {
            // 生日已经过了，要算明年的了
            return (int) getDiffDaysLong(today, nextBirthday.withYear(nextBirthday.getYear() + 1));
        } else {
            // 生日还没过
            return (int) getDiffDaysLong(today, nextBirthday);
        }
    }

    public static int getBirthRemainDay(LocalDateTime birthday) {
        return getBirthRemainDay(birthday.toLocalDate());
    }

//    /**
//     * 判断日期格式是否合法
//     *
//     * @author maozj
//     * @param sDateTime
//     * @return
//     */
//    public static boolean isValidDateTime(String sDateTime) {
//        return DateUtils.isValidDateTime(sDateTime);
//    }

    /**
     * 获取两个时间的时间差距 分钟min
     *
     * @param endTime
     * @param beginTime
     * @return long
     * @author wangxin
     */
    public static long getDiffTimeByMin(LocalDateTime endTime, LocalDateTime beginTime) {
        return Duration.between(beginTime, endTime).toMinutes();
    }

//    /**
//     * 获取去年的日期及过往月份（直接封装一层，应该是没什么用的方法）
//     * @return
//     */
//    public static Pair<LocalDateTime, List<String>> getLastYearAndMonths(){
//        Pair<Date, List<String>> dateListPair = DateUtils.getLastYeayAndMonths();
//        return new Pair<>(dateToLocalDateTime(dateListPair.getV1()), dateListPair.getV2());
//    }

    /**
     * 计算指定年月的最后一天日期
     */
    public static LocalDate getLastDayOfMonth(int year, int month) {
        LocalDate ld = LocalDate.of(year, month, 1);
        return ld.withDayOfMonth(ld.lengthOfMonth());
    }

    /**
     * 获取某个日期所在年的第一天
     * @param date
     * @return
     * @author huangjp
     */
    public static LocalDate genYearFirst(LocalDate date){
        return LocalDate.MIN.withYear(date.getYear());
    }

    /**
     * 获取某个日期所在年的最后一天
     * @param date
     * @return
     * @author huangjp
     */
    public static LocalDate genYearLast(LocalDate date){
        return LocalDate.MAX.withYear(date.getYear());
    }

    /**
     * 获取日期所在周的星期日的日期
     */
    public static LocalDate genCurrentSunday(LocalDate date) {
        return genDayThisWeek(date, 7);
    }

    /**
     * 构造上周周日
     */
    public static LocalDate genPreviousSunday(LocalDate date){
        return genCurrentSunday(date).minusWeeks(1L);
    }

    /**
     * 构造去年第一天
     */
    public static LocalDate genLastYearFirst(LocalDate date){
        return LocalDate.MIN.withYear(date.getYear() - 1);
    }

    /**
     * 构造去年最后一天
     */
    public static LocalDate genLastYearLast(LocalDate date){
        return LocalDate.MAX.withYear(date.getYear() - 1);
    }

    /**
     * 构造去年今天
     * @param date
     * @return
     */
    public static LocalDate genLastYearToday(LocalDate date){
        LocalDate ld = copy(date);
        return ld.minusYears(1L);
    }

    /**
     * 构造去年当前日期所在月的第一天
     * @param date
     * @return
     */
    public static LocalDate genLastYearCurMonthFirst(LocalDate date){
        return LocalDate.of(date.getYear() - 1, date.getMonthValue(), 1);
    }

    /**
     * 构造去年当前日期所在月的最后一天
     * @param date
     * @return
     */
    public static LocalDate genLastYearCurMonthLast(LocalDate date){
        return genLastYearLastMonthFirst(date).minusDays(1);
    }

    /**
     * 构造去年当前日期下个月的第一天
     */
    public static LocalDate genLastYearLastMonthFirst(LocalDate date){
        return LocalDate.of(date.getYear() - 1, date.getMonthValue(), 1).plusMonths(1);
    }

    /**
     * 构造上个月的今天
     * @param date
     * @return
     */
    public static LocalDateTime genLastMonthToday(LocalDateTime date){
        return copy(date).minusMonths(1L);
    }

    /**
     * 相差diff个月的今天；保留时分秒
     *
     * @author fengdg
     * @param date
     * @param diff
     * @return
     */
    public static LocalDateTime genDiffMonthToday(LocalDateTime date, int diff){
        return genDiffMonthToday(date, diff, false);
    }

    /**
     * 相差diff个月的今天；
     *
     * @author fengdg
     * @param date
     * @param diff
     * @param clearHms 清空时分秒
     * @return
     */
    public static LocalDateTime genDiffMonthToday(LocalDateTime date, int diff, boolean clearHms){
        if (clearHms) {
            return LocalDateTime.of(copy(date.toLocalDate()).plusMonths(diff), LocalTime.MIN);
        } else {
            return copy(date).plusMonths(diff);
        }
    }

    /**
     * 取指定天的开始时间
     *
     * @param date
     * @return java.other.time.LocalDateTime
     * @author wangxin
     */
    public static LocalDateTime getDateBegin(LocalDateTime date) {
        return LocalDateTime.of(copy(date.toLocalDate()), LocalTime.MIN);
    }

    /**
     * 取指定天的结束时间
     */
    public static LocalDateTime getDateEnd(LocalDateTime date) {
        return LocalDateTime.of(copy(date.toLocalDate()), LocalTime.MAX);
    }

    /**
     * 取指定天的结束时间
     */
    public static LocalDateTime getHourBegin(LocalDateTime date) {
        return getHourBegin(date, 0);
    }

    public static LocalDateTime getHourBegin(LocalDateTime dateTime, int addHour) {
        LocalTime time = LocalTime.MIN.withHour(dateTime.toLocalTime().getHour());
        return LocalDateTime.of(copy(dateTime.toLocalDate()), time).plusHours(addHour);
    }

    /**
     * 取指定小时的结束时间
     */
    public static LocalDateTime getHourEnd(LocalDateTime date) {
        return getHourEnd(date, 0);
    }

    public static LocalDateTime getHourEnd(LocalDateTime ldt, int addHour) {
        LocalTime time = LocalTime.MAX.withHour(ldt.toLocalTime().getHour());
        return LocalDateTime.of(copy(ldt.toLocalDate()), time).plusHours(addHour);
    }

    public static boolean equals(LocalDateTime src, LocalDateTime dest) {
        if (src == null && dest == null) {
            return true;
        } else if (src == null || dest == null) {
            return false;
        } else {
            return src.equals(dest);
        }
    }

    /**
     * 获取指定日期月份的第一天
     */
    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        return copy(date).withDayOfMonth(1);
    }

    public static LocalDateTime getFirstDayOfMonth(LocalDateTime date) {
        return LocalDateTime.of(getFirstDayOfMonth(date.toLocalDate()), LocalTime.MIN);
    }

    /**
     * 构造本周周一
     * @param date
     * @return
     */
    public static LocalDate genThisMonday(LocalDate date){
        return genDayThisWeek(date, 1);
    }

    /**
     * 生成date对应周的某一天
     *
     * @param date date指定某一周
     * @param offset 1-7 分别对应周一到周日
     * @return java.other.time.LocalDate
     * @author wangxin
     */
    private static LocalDate genDayThisWeek(LocalDate date, int offset) {
        return copy(date).with(ChronoField.DAY_OF_WEEK, offset);
    }


    private static String[] weekDaysName = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    /**
     * 根据日期获得星期
     *
     * @param date
     * @return
     */
    public static String getWeekDesc(LocalDate date) {
        return weekDaysName[date.getDayOfWeek().getValue() - 1];
    }

    public static int getCurSecond() {
        return LocalTime.now().getSecond();
    }

    /**********************Quarter************************/
    /**
     * 某个日期上个季度的开始时间
     *
     * @param dateTime
     * @return dateTime 如2019-02-01，则返回2018-10-01 00:00:00
     */
    public static LocalDateTime genLastQuarterStartTime(LocalDateTime dateTime) {
        int monthValue = getLastQuarterYearStartMonth(dateTime.getMonthValue());
        int yearValue = monthValue == 10 ? dateTime.getYear() - 1 : dateTime.getYear();
        LocalDate date = LocalDate.of(yearValue, monthValue, 1);
        return LocalDateTime.of(date, LocalTime.MIN);
    }

    private static int getLastQuarterYearStartMonth(int monthVal) {
        return ((monthVal - 1) / 3 * 3 + 10) % 12;
    }

    /**
     * 某个日期上个季度的结束时间
     *
     * @param dateTime
     * @return Date 如2019-02-01，则返回2018-12-31 23:59:59
     */
    public static LocalDateTime genLastQuarterEndTime(LocalDateTime dateTime) {
        LocalDateTime ldt = genLastQuarterStartTime(dateTime);
        return LocalDateTime.of(ldt.toLocalDate().plusMonths(3).minusDays(1), LocalTime.MAX);
    }
}
