package org.example;
import java.util.List;
import org.example.JsonClasses.*;
public class VisitorsAgent {
    private List<Dish> menu_dishes;

    public VisitorsAgent(List<Dish> menuDishes) {
        menu_dishes = menuDishes;
    }

    public List<Dish> getMenuDishes() {
        return menu_dishes;
    }
}
