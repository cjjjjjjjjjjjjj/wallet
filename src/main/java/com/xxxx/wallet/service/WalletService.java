package com.xxxx.wallet.service;

import com.xxxx.wallet.entities.Wallet;
import com.xxxx.wallet.result.RespBean;
import com.xxxx.wallet.vo.walletDetail;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {
    RespBean getBalance(Long user_id, Long id);

    RespBean consume(Long user_id,Long id, BigDecimal amount);

    RespBean refund(Long user_id,Long id);


    RespBean getWalletDetailListById(Long id);
}
