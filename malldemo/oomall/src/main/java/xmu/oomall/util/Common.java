package xmu.oomall.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * @author: Ming Qiu
 * @date: Created in 20:14 2019/11/17
 **/
public class Common {

    private static DateTimeFormatter longFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    public static LocalDateTime DEFAULT_TIME = LocalDateTime.of(2019,11,11,11,11,11,11);

    /**
     * 生成唯一随机数
     * @param length 增加的几位随机数
     * @return
     */
    public static String getRandomNum(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer(longFormatter.format(LocalDateTime.now()));
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
