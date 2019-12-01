package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.payment.Payment;

import java.util.List;

/**
 * 支付服务
 * @author: Ming Qiu
 * @date: Created in 14:48 2019/11/30
 **/
@Service
public interface PaymentService {

    /**
     * 增加一个支付服务
     * @param payments 支付对象列表
     */
    void addPayment(List<Payment> payments);
}
