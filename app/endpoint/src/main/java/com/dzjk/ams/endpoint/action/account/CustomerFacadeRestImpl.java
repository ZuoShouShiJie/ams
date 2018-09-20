package com.dzjk.ams.endpoint.action.account;

import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.dal.dao.CustomerInfoDAO;
import com.dzjk.ams.dal.dataobject.CustomerInfoDO;
import com.dzjk.ams.facade.api.account.CustomerRestFacade;
import com.dzjk.ams.facade.form.Customer.CustomerInfoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by daixiaohu on 2018/3/6.
 */
@Service("ams.CustomerFacadeRest")
public class CustomerFacadeRestImpl implements CustomerRestFacade {
    private static final Logger logger = LoggerFactory.getLogger(AccountFacadeRestImpl.class);
    @Resource
    private CustomerInfoDAO customerInfoDAO;

    @Override
    public CustomerInfoDO queryCustomerInfo(CustomerInfoForm form) {
        return customerInfoDAO.queryCustomerInfo(form.getIdNo(), form.getIdType(), form.getUserName());
    }

    @Override
    public CustomerInfoDO queryCustomerInfoByUserId(CustomerInfoForm form) {
        return customerInfoDAO.queryCustomerInfoByUserId(form.getUserId());
    }

    @Override
    public CustomerInfoDO queryCustomerInfoByIdNo(CustomerInfoForm form) {
        return customerInfoDAO.queryCustomerInfoByIdNo(form.getIdNo(), form.getIdType());
    }

    @Override
    public Object insertCustomerInfo(CustomerInfoForm form) {
        CustomerInfoDO entity = new CustomerInfoDO();
        entity.setUserId(form.getUserId());
        entity.setUserName(form.getUserName());
        entity.setIdType(form.getIdType());
        entity.setIdNo(form.getIdNo());
        entity.setOrgId(Long.valueOf(form.getOrgId()));
        entity.setMobile(form.getMobile());
        entity.setStatus("1");
        entity.setCreatedTime(DateUtils.currentDateTime());
        return customerInfoDAO.insert(entity);
    }
}
