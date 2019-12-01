package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.payment.Payment;

import java.util.List;

/**
 * @author: Ming Qiu
 * @date: Created in 14:50 2019/11/30
 **/
@Mapper
public interface PaymentMapper {
    /**
     * 新增一个Payment对象
     * @param payments payment对象List
     * @return 行数
     */
    int addPayment(List<Payment> payments);
}
