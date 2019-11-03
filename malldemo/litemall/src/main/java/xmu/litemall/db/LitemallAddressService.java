package xmu.litemall.db;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Service;
import xmu.litemall.dao.LitemallAddressMapper;
import xmu.litemall.domain.LitemallAddressExample;
import xmu.litemall.domain.LitemallAddress;

@Service
public class LitemallAddressService {
    @Mapper
    private LitemallAddressMapper addressMapper;

    public LitemallAddress query(Integer userId, Integer id) {
        LitemallAddressExample example = new LitemallAddressExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

}
