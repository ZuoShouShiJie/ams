package com.dzjk.ams.endpoint.action.account;

import com.dzjk.ams.dal.dao.AccountEarningsDAO;
import com.dzjk.ams.dal.dao.AccountEarningsServiceFeeDAO;
import com.dzjk.ams.dal.dataobject.AccountEarningsDO;
import com.dzjk.ams.dal.dataobject.AccountEarningsServiceFeeDO;
import com.dzjk.ams.facade.api.account.AccountPlatRestFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by daixiaohu on 2018/3/6.
 */
@Service("ams.accountPlatFacade")
public class AccountPlatFacadeRestImpl implements AccountPlatRestFacade {
    @Resource
    private AccountEarningsDAO accountEarningsDAO;
    @Resource
    private AccountEarningsServiceFeeDAO accountEarningsServiceFeeDAO;


    /**
     * 平台收益表插入
     *
     * @return
     */
    public Long createPlatEarnings(AccountEarningsDO entity) {
        return accountEarningsDAO.insert(entity);
    }

    /**
     * 平台收益服务费插入
     *
     * @return
     */
    public Long createPlatEarningsServiceFee(AccountEarningsServiceFeeDO entity) {

        return accountEarningsServiceFeeDAO.insert(entity);
    }

}
