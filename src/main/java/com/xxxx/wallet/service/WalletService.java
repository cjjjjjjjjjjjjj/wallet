package com.xxxx.wallet.service;

import com.xxxx.wallet.result.RespBean;

import java.math.BigDecimal;

public interface WalletService {
    RespBean getBalance(Long user_id, Long id);

    RespBean consume(Long user_id,Long id, BigDecimal amount);

    RespBean refund(Long user_id,Long id);


    RespBean getWalletDetailListById(Long id);

}
