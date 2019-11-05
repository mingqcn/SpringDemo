package xmu.oomall.domain;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;

import java.time.LocalDateTime;

/**
 * @Author: Ming Qiu
 * @Description:团购活动
 * 该对象不可以删除
 * @Date: Created in 15:17 2019/11/5
 * @Modified By:
 **/
public class GroupOnRule{
    private Integer id;
    private LocalDateTime endTime; //团购活动结束时间

    private LocalDateTime addTime;
    private LocalDateTime updateTime;
}
