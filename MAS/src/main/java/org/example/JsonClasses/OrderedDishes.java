package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;
//Класс OrderedDishes содержит поля ord_dish_id и menu_dish, которые соответствуют идентификатору заказанного блюда и идентификатору блюда в меню.

public class OrderedDishes {
    @SerializedName("ord_dish_id")
    private int ord_dish_id;
    @SerializedName("menu_dish")
    private int menu_dish;

    public int getOrd_dish_id() {
        return ord_dish_id;
    }

    public int getMenu_dish() {
        return menu_dish;
    }

    public void setOrd_dish_id(int ord_dish_id) {
        this.ord_dish_id = ord_dish_id;
    }

    public void setMenu_dish(int menu_dish) {
        this.menu_dish = menu_dish;
    }
}
