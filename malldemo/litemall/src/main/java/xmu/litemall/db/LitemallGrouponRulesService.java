package xmu.litemall.db;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import xmu.litemall.domain.LitemallGrouponRules;
import xmu.litemall.domain.LitemallGrouponRulesExample;
import xmu.litemall.dao.LitemallGrouponRulesMapper;

import java.time.LocalDateTime;

@Service
public class LitemallGrouponRulesService {
    @Mapper
    private LitemallGrouponRulesMapper mapper;

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public LitemallGrouponRules queryById(Integer id) {
        LitemallGrouponRulesExample example = new LitemallGrouponRulesExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 判断某个团购活动是否已经过期
     *
     * @return
     */
    public boolean isExpired(LitemallGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

}