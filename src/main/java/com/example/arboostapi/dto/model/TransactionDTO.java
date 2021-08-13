package com.example.arboostapi.dto.model;

import java.util.Date;

public class TransactionDTO {
    private String card_number;

    private String sector;

    private String store;

    private Float total_amount;

    private Date date;

    private Float world_point;


    // Getters and Setters
    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Float total_amount) {
        this.total_amount = total_amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getWorld_point() {
        return world_point;
    }

    public void setWorld_point(Float world_point) {
        this.world_point = world_point;
    }
}
