package com.bdqn.ssm_springboot.service;

import com.bdqn.ssm_springboot.dao.BillMapper;
import com.bdqn.ssm_springboot.pojo.BillExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class BillService {
    @Resource
    private BillMapper billMapper;

    public long selectBillCountByPro(Long id){
        BillExample example = new BillExample();
        example.createCriteria().andProviderIdEqualTo(id);
        long count = billMapper.countByExample(example);
        return count;
    }
}
