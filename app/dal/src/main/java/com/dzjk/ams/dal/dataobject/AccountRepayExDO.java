package com.dzjk.ams.dal.dataobject;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by daixiaohu on 2018/3/11.
 */
public class AccountRepayExDO extends AccountRepayPlanDO {
    private BigDecimal allServiceFee;
    private List<AccountRepayServiceFeeDO> feeList;

    public List<AccountRepayServiceFeeDO> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<AccountRepayServiceFeeDO> feeList) {
        this.feeList = feeList;
    }

    public BigDecimal getAllServiceFee() {
        return allServiceFee;
    }

    public void setAllServiceFee(BigDecimal allServiceFee) {
        this.allServiceFee = allServiceFee;
    }
}
