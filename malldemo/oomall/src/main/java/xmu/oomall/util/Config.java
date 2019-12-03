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

    /**
     * redis缓存失效时间，单位分钟
     */
    @Value("${oomall.redisexpiretime}")
    private Integer redisExpireTime;

    /**
     * 预提库存数量
     */
    @Value("${oomall.predeductQty}")
    private Integer preDeductQty;

    public Integer getMaxPayTime(){
        return this.maxPayTime;
    }

    public Integer getRedisExpireTime() {
        return redisExpireTime;
    }

    public Integer getPreDeductQty() {
        return preDeductQty;
    }
}
