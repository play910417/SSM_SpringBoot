package com.bdqn.ssm_springboot.service;

import com.bdqn.ssm_springboot.dao.UserMapper;
import com.bdqn.ssm_springboot.pojo.User;
import com.bdqn.ssm_springboot.pojo.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User userLogin(User user) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andUserCodeEqualTo(user.getUserCode())
                .andUserPasswordEqualTo(user.getUserPassword());
        List<User> list = userMapper.selectByExample(example);
        User login = null;
        if (list.size() != 0) {
            login = list.get(0);
        }
        return login;
    }

    public List<User> selectUserList() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }
}
