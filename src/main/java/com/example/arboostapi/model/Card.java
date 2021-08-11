package com.example.arboostapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CARD")
public class Card {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @Id
    private String card_number;

    private String type;

    private Float account_limit;

    private Float debt;

    private Date cutoff_date;

    private Date payment_due_date;

    private Boolean is_contactless;

    private Boolean is_ecom;

    private Date expire_date;

    private Boolean mail_order;

    private String e_account_statement;

    private String account_number;

    private Float balance;

    private Float flexible_account_limit;


    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getFlexible_account_limit() {
        return flexible_account_limit;
    }

    public void setFlexible_account_limit(Float flexible_account_limit) {
        this.flexible_account_limit = flexible_account_limit;
    }

    // Getters and Setters
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Float getAccount_limit() {
        return account_limit;
    }

    public void setAccount_limit(Float account_limit) {
        this.account_limit = account_limit;
    }

    public Float getDebt() {
        return debt;
    }

    public void setDebt(Float debt) {
        this.debt = debt;
    }

    public Date getCutoff_date() {
        return cutoff_date;
    }

    public void setCutoff_date(Date cutoff_date) {
        this.cutoff_date = cutoff_date;
    }

    public Date getPayment_due_date() {
        return payment_due_date;
    }

    public void setPayment_due_date(Date payment_due_date) {
        this.payment_due_date = payment_due_date;
    }

    public Boolean getIs_contactless() {
        return is_contactless;
    }

    public void setIs_contactless(Boolean is_contactless) {
        this.is_contactless = is_contactless;
    }

    public Boolean getIs_ecom() {
        return is_ecom;
    }

    public void setIs_ecom(Boolean is_ecom) {
        this.is_ecom = is_ecom;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public Boolean getMail_order() {
        return mail_order;
    }

    public void setMail_order(Boolean mail_order) {
        this.mail_order = mail_order;
    }

    public String getE_account_statement() {
        return e_account_statement;
    }

    public void setE_account_statement(String e_account_statement) {
        this.e_account_statement = e_account_statement;
    }
}
