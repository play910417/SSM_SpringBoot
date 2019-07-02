package com.bdqn.ssm_springboot.service;

import com.bdqn.ssm_springboot.dao.BillMapper;
import com.bdqn.ssm_springboot.pojo.Bill;
import com.bdqn.ssm_springboot.pojo.BillCustom;
import com.bdqn.ssm_springboot.pojo.BillExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public List<BillCustom> selectBillList(Bill bill){
        List<BillCustom> list = billMapper.selectByBill(bill);
        return list;
    }
}
