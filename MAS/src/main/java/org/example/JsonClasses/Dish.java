package org.example.JsonClasses;
//Класс для сериализации 
import com.google.gson.annotations.SerializedName;

public class Dish {
    @SerializedName("menu_dish_id")

    private int dishId;
    @SerializedName("menu_dish_card")

    private int dishCard;
    @SerializedName("menu_dish_price")

    private int dishPrice;
    @SerializedName("menu_dish_active")

    private boolean dishActive;

    public int getDishCard() {
        return dishCard;
    }

    public int getDishId() {
        return dishId;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public boolean isDishActive() {
        return dishActive;
    }
}
