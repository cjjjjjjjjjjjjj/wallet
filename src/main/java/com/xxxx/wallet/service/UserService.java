package com.xxxx.wallet.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.wallet.entities.User;
import com.xxxx.wallet.mapper.UserMapper;
import com.xxxx.wallet.result.RespBean;

public interface UserService {
    //todo 注册
    //todo 登录
    RespBean selectById(Long id);
}
