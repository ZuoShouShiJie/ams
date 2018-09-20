package com.dzjk.ams.endpoint.service;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@SuppressWarnings("serial")
public class Account implements Serializable {
	private String id;

    private double amount;

    private Date   gmtCreate;

    public static Account buildDefaultInstance() {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setAmount(new Random().nextDouble());
        account.setGmtCreate(new Date());
        return account;
    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     *
     * @return property value of amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     *
     * @param amount value to be assigned to property amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     *
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     *
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "Account{" + "id='" + id + '\'' + ", amount=" + amount + ", gmtCreate=" + gmtCreate + '}';
    }

}
