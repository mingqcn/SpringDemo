package xmu.oomall;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis 配置类
 * @author: Ming Qiu
 * @date: Created in 12:49 2019/12/3
 **/
@Configuration
public class RedisConfiguration {
    @Bean
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //打开事务支持
        template.setEnableTransactionSupport(true);
        return template;
    }
}
