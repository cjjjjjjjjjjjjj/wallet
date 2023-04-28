package com.xxxx.wallet.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.wallet.entities.Wallet;
import com.xxxx.wallet.result.RespBean;
import java.math.BigDecimal;

public interface WalletMapper extends BaseMapper<Wallet> {
    RespBean getBalance(Long id);
    RespBean consume(Long user_id,Long id, BigDecimal amount);
    RespBean refund(Long user_id,Long id);
    RespBean getWalletDetailListById(Long id);

}
