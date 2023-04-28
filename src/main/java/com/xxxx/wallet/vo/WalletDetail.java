package com.xxxx.wallet.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("wallet_detail")
@AllArgsConstructor
public class WalletDetail {
    private Long id;
    private Long user_id;
    private Integer type;
//    类型（1：充值，2：消费，3：退款）
    private BigDecimal amount;
    private Date create_date;
}
