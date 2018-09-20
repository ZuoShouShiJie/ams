package com.dzjk.ams.facade.api.account;

import com.dzjk.ams.facade.form.Customer.CustomerInfoForm;

/**
 * Created by daixiaohu on 2018/3/6.
 */
public interface CustomerRestFacade {
    Object queryCustomerInfo(CustomerInfoForm form);

    Object queryCustomerInfoByUserId(CustomerInfoForm form);

    Object insertCustomerInfo(CustomerInfoForm form);

Object queryCustomerInfoByIdNo(CustomerInfoForm form);
}
