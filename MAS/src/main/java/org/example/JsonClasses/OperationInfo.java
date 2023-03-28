package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//Класс OperationInfo содержит информацию об операциях
public class OperationInfo {
    @SerializedName("oper_type")
    private int operType;
    @SerializedName("oper_time")
    private double operTime;
    @SerializedName("oper_async_point")
    private int operAsyncPoint;
    @SerializedName("equip_type")
    private int equipType;
    @SerializedName("oper_products")
    private List<OperProduct> operProducts;

    public int getOperType() {
        return operType;
    }

    public double getOperTime() {
        return operTime;
    }

    public int getOperAsyncPoint() {
        return operAsyncPoint;
    }

    public int getEquipType() {
        return equipType;
    }

    public List<OperProduct> getOperProducts() {
        return operProducts;
    }

    public void setOperType(int operType) {
        this.operType = operType;
    }

    public void setOperTime(int operTime) {
        this.operTime = operTime;
    }

    public void setOperAsyncPoint(int operAsyncPoint) {
        this.operAsyncPoint = operAsyncPoint;
    }

    public void setEquipType(int equipType) {
        this.equipType = equipType;
    }

    public void setOperProducts(List<OperProduct> operProducts) {
        this.operProducts = operProducts;
    }
}
