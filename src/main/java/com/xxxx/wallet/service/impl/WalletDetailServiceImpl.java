package com.xxxx.wallet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.wallet.mapper.WalletDetailMapper;
import com.xxxx.wallet.result.RespBean;
import com.xxxx.wallet.service.WalletDetailService;
import com.xxxx.wallet.vo.WalletDetail;

public class WalletDetailServiceImpl extends ServiceImpl<WalletDetailMapper,WalletDetail> implements WalletDetailService {
    @Override
    public RespBean insert(WalletDetail walletDetail) {
        return RespBean.success(baseMapper.insert(walletDetail));
    }
}
