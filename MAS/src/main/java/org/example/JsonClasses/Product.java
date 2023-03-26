package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("prod_type_id")
    private int prod_type_id;
    @SerializedName("prod_type_name")
    private String prod_type_name;
    @SerializedName("prod_is_food")
    private boolean prod_is_food;

    public int getProd_type_id() {
        return prod_type_id;
    }

    public String getProd_type_name() {
        return prod_type_name;
    }

    public boolean isProd_is_food() {
        return prod_is_food;
    }

    public void setProd_is_food(boolean prod_is_food) {
        this.prod_is_food = prod_is_food;
    }

    public void setProd_type_id(int prod_type_id) {
        this.prod_type_id = prod_type_id;
    }

    public void setProd_type_name(String prod_type_name) {
        this.prod_type_name = prod_type_name;
    }
}
