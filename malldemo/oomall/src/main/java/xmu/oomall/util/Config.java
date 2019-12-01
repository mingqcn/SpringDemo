package xmu.oomall.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置信息
 * @author Ming Qiu
 * @date Created in 20:14 2019/11/17
 */
@Component
public class Config {

    /**
     * 最大付款间隔,，单位分钟
     */
    @Value("${oomall.maxpaytime}")
    private Integer maxPayTime;


    public Integer getMaxPayTime(){
        return this.maxPayTime;
    }
}
