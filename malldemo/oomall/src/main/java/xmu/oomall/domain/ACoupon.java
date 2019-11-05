package xmu.oomall.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description:一张优惠卷
 * @Date: Created in 14:10 2019/11/5
 * @Modified By:
 **/
public class ACoupon {

    private Integer id;
    private String couponSN; //优惠卷序号
    private String name; //优惠卷名称
    private String picUrl; //优惠卷图片
    private LocalDateTime beginTime; //优惠卷启用时间，默认2019年10月1日
    private LocalDateTime endTime; //优惠卷无效时间，默认3019年10月1日
    private Short status; //优惠卷状态, 未使用，已使用，过期等等
    private List<Goods> goods; //适用商品， 在数据库中用JSON数组存放id
    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Boolean deleted;
}
