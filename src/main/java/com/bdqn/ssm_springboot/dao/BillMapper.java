package com.bdqn.ssm_springboot.dao;

import com.bdqn.ssm_springboot.pojo.Bill;
import com.bdqn.ssm_springboot.pojo.BillCustom;
import com.bdqn.ssm_springboot.pojo.BillExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    long countByExample(BillExample example);

    int deleteByExample(BillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Bill record);

    int insertSelective(Bill record);

    List<Bill> selectByExample(BillExample example);

    Bill selectByPrimaryKey(Long id);

    List<BillCustom> selectByBill(Bill bill);

    int updateByExampleSelective(@Param("record") Bill record, @Param("example") BillExample example);

    int updateByExample(@Param("record") Bill record, @Param("example") BillExample example);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
}