package com.bdqn.ssm_springboot.service;

import com.bdqn.ssm_springboot.dao.ProviderMapper;
import com.bdqn.ssm_springboot.pojo.Provider;
import com.bdqn.ssm_springboot.pojo.ProviderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProviderService {
    @Resource
    private ProviderMapper providerMapper;

    public List<Provider> findProviderList(Provider provider) {
        ProviderExample example = new ProviderExample();
        ProviderExample.Criteria criteria = example.createCriteria();
        if (provider.getProCode() != null) {
            criteria.andProCodeLike("%" + provider.getProCode() + "%");
        }
        if (provider.getProName() != null) {
            criteria.andProNameLike("%" + provider.getProName() + "%");
        }
        List<Provider> list = providerMapper.selectByExample(example);
        return list;
    }

    public Provider findProviderById(Long id){
        Provider provider = providerMapper.selectByPrimaryKey(id);
        return provider;
    }

    public int updateProvider(Provider provider){
        int i = providerMapper.updateByPrimaryKeySelective(provider);
        return i;
    }
}
