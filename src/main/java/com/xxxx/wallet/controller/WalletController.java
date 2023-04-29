package com.xxxx.wallet.controller;

import com.xxxx.wallet.result.RespBean;
import com.xxxx.wallet.service.impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    //获取余额
    @Autowired
    private WalletServiceImpl walletService;
    @GetMapping("getBalance/{user_id}/{id}")
    public RespBean getBalance(@PathVariable Long user_id,@PathVariable Long id){
        return walletService.getBalance(user_id,id);
    }


    @PutMapping("/consume/{user_id}/{id}")
    public RespBean consume(@PathVariable Long user_id,@PathVariable Long id,BigDecimal amount){
        return walletService.consume(user_id,id,amount);
    }

    @PutMapping("/refund/{user_id}/{id}")
    public RespBean refund(@PathVariable Long user_id,@PathVariable Long id){
        return walletService.refund(user_id,id);
    }


    @GetMapping("/getDetail/{id}")
    public RespBean getWalletDetailListById(@PathVariable Long id){
        return walletService.getWalletDetailListById(id);
    }

//    todo 充值
}
