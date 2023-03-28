package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;
//Класс "OperProduct" представляет продукты, которые используются в операциz[. Он содержит два поля: "prodType" - тип продукта и "prodQuantity" - количество продукта.
// Оба поля аннотированы с помощью "@SerializedName" для того, чтобы правильно сопоставить имена полей с соответствующими именами в JSON-файле.
// Класс также содержит геттеры и сеттеры для каждого поля.
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
