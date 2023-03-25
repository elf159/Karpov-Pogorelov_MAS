package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;

public class OperProduct {
    @SerializedName("prod_type")
    private int prodType;
    @SerializedName("prod_quantity")
    private double prodQuantity;

    public int getProdType() {
        return prodType;
    }

    public double getProdQuantity() {
        return prodQuantity;
    }

    public void setProdType(int prodType) {
        this.prodType = prodType;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }
}
