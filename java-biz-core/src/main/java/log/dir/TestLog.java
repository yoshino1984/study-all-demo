package log.dir;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wangxin
 * 2021/5/6 22:40
 * @since
 **/
public class TestLog {
    private static final Logger LOGGER = LogManager.getLogger(TestLog.class.getName());

    public static void main(String[] args) {
//        testLog4j();
        testRollingFile();
    }



    private static void testLog4j() {
        try {
            LOGGER.trace("this is trace");
            LOGGER.debug("this is debug");
            LOGGER.info("this is info");
            LOGGER.warn("this is warn");
            LOGGER.error("this is error");
            LOGGER.fatal("this is fatal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testRollingFile() {
        String msg = IntStream.rangeClosed(1,1000).boxed().map(String::valueOf).collect(Collectors.joining("-"));
        for (int i = 0; i < 1000000; i++) {
            String finalMsg = "" + i + ":" + msg;
            LOGGER.info(finalMsg);
        }
    }
}
