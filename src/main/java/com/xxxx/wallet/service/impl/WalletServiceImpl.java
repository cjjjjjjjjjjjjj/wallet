package com.xxxx.wallet.service.impl;

import com.xxxx.wallet.entities.User;
import com.xxxx.wallet.entities.Wallet;
import com.xxxx.wallet.mapper.UserMapper;
import com.xxxx.wallet.mapper.WalletDetailMapper;
import com.xxxx.wallet.mapper.WalletMapper;
import com.xxxx.wallet.result.RespBean;
import com.xxxx.wallet.result.RespBeanEnum;
import com.xxxx.wallet.service.WalletService;
import com.xxxx.wallet.vo.WalletDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletMapper walletMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WalletDetailMapper walletDetailMapper;

    //    根据用户id和钱包id查询余额
    @Override
    public RespBean getBalance(Long user_id, Long id) {
//        首先判断是否在登陆状态
//        if (needLogin())return RespBean.error(RespBeanEnum.LOGIN_NEEDED)
//        else
//        根据用户id获取当前用户实体
        User user = userMapper.selectById(user_id);
//        根据钱包id获取钱包实体
        Wallet wallet = walletMapper.selectById(id);
//        如果用户实体为空
        if (user==null){
            //返回错误
            return RespBean.error(RespBeanEnum.USER_EXIST_ERROR);
        }
//        如果钱包实体为空
        if (wallet==null){
            return RespBean.error(RespBeanEnum.WALLET_EXIST_ERROR);
        }
        return walletMapper.getBalance(id);
    }

    //    根据用户id和钱包id进行消费
    @Override
    public RespBean consume(Long user_id,Long id, BigDecimal amount) {
        User user = userMapper.selectById(user_id);
        Wallet wallet = walletMapper.selectById(id);
        WalletDetail walletDetail = wallet.getWalletDetail();
        //        如果用户实体为空
        if (user==null){
            //返回错误
            return RespBean.error(RespBeanEnum.USER_EXIST_ERROR);
        }
//        如果钱包实体为空
        if (wallet==null){
            return RespBean.error(RespBeanEnum.WALLET_EXIST_ERROR);
        }
//        获取当前钱包的余额
        BigDecimal balance = wallet.getBalance();
        if (balance.compareTo(amount)<0){
//            如果钱包余额不够则不允许消费
            return RespBean.error(RespBeanEnum.CONSUME_REFUSED);
        }
//        设置消费日志
        walletDetail.setId(id);
        walletDetail.setUser_id(user_id);
        walletDetail.setType(2);
        walletDetail.setCreate_date(new Date());
        walletDetail.setAmount(amount);
        walletDetailMapper.insert(walletDetail);
        return walletMapper.consume(user_id,id,amount);
    }

    //    根据用户id和钱包id退款
    @Override
    public RespBean refund(Long user_id,Long id) {
//        获取消费日志
        User user = userMapper.selectById(user_id);
        Wallet wallet = walletMapper.selectById(id);
        WalletDetail walletDetail = wallet.getWalletDetail();
        //        如果用户实体为空
        if (user==null){
            //返回错误
            return RespBean.error(RespBeanEnum.USER_EXIST_ERROR);
        }
//        如果钱包实体为空
        if (wallet==null){
            return RespBean.error(RespBeanEnum.WALLET_EXIST_ERROR);
        }
//        更新操作时间
        walletDetail.setCreate_date(new Date());
//        更新操作类型
        walletDetail.setId(id);
        walletDetail.setUser_id(user_id);
        walletDetail.setCreate_date(new Date());
        walletDetail.setType(3);
        walletDetailMapper.insert(walletDetail);
        walletMapper.refund(user_id,id);
        return RespBean.success();
    }


    @Override
    public RespBean getWalletDetailListById(Long id) {
        List<WalletDetail> list= (List<WalletDetail>) walletMapper.getWalletDetailListById(id);
        if (list==null){
            return RespBean.error(RespBeanEnum.LIST_NULL);
        }
        return RespBean.success(list);
    }
}
