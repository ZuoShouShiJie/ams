package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by daixiaohu on 2018/3/1.
 */
public class AccountEarningsExDO extends  AccountEarningsDO  implements Serializable {
    private BigDecimal serviceFee;
    private List<AccountEarningsServiceFeeDO> feeDOS;

    public List<AccountEarningsServiceFeeDO> getFeeDOS() {
        return feeDOS;
    }

    public void setFeeDOS(List<AccountEarningsServiceFeeDO> feeDOS) {
        this.feeDOS = feeDOS;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }
}
