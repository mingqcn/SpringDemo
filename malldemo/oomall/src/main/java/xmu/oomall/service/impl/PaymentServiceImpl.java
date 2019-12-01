package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.domain.payment.Payment;
import xmu.oomall.mapper.PaymentMapper;
import xmu.oomall.service.PaymentService;

import java.util.List;

/**
 * 支付服务实现类
 * @author: Ming Qiu
 * @date: Created in 14:49 2019/11/30
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public void addPayment(List<Payment> payments) {
        paymentMapper.addPayment(payments);
    }
}
