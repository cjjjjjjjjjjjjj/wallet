package com.xxxx.wallet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.wallet.entities.User;
import com.xxxx.wallet.mapper.UserMapper;
import com.xxxx.wallet.result.RespBean;
import com.xxxx.wallet.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public RespBean selectById(Long id) {
        return RespBean.success(baseMapper.selectById(id));
    }
}
