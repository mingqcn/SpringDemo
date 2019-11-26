package xmu.oomall.util;

/**
 * 配置信息
 * @author Ming Qiu
 * @date Created in 20:14 2019/11/17
 */
public class Config {

    private static Config instance = null;

    public synchronized  static Config getInstance() {
        if (instance == null){
            instance = new Config();
        }
        return instance;
    }

    /**
     * 获得最长付款时间
     * @return 付款时间，单位分钟
     */
    public Integer getMaxPayTime(){
        return 30;
    }
}
