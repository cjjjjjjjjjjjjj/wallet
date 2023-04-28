package com.xxxx.wallet.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务器异常"),
    USER_EXIST_ERROR(500300,"用户不存在"),
    WALLET_EXIST_ERROR(500400,"钱包不存在"),
    CONSUME_REFUSED(500500,"余额不足无法消费"),
    LIST_NULL(500600,"没有金额变动");
    private final Integer code;
    private final String message;
}
