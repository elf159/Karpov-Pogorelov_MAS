package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DishInfo {
    @SerializedName("card_id")
    private int cardId;
    @SerializedName("dish_name")
    private String dish_name;
    @SerializedName("card_descr")
    private String cardDescr;
    @SerializedName("card_time")
    private double cardTime;
    @SerializedName("equip_type")
    private int equipType;
    @SerializedName("operations")
    private List<Operation> operations;

    public int getCardId() {
        return cardId;
    }

    public String getDish_name() {
        return dish_name;
    }

    public String getCardDescr() {
        return cardDescr;
    }

    public double getCardTime() {
        return cardTime;
    }

    public int getEquipType() {
        return equipType;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public void setCardDescr(String cardDescr) {
        this.cardDescr = cardDescr;
    }

    public void setCardTime(int cardTime) {
        this.cardTime = cardTime;
    }

    public void setEquipType(int equipType) {
        this.equipType = equipType;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
