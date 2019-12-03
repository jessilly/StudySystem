/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.bean;

/**
 *
 * @author Administrator
 */
public class Grade {
    private int id;
    private String gradeName;
    private String subject;
    private int amount;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the gradeName
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * @param gradeName the gradeName to set
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
