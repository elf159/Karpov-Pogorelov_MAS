package org.example;
import java.util.List;
import org.example.JsonClasses.Dish;
public class VisitorsAgent {
    private List<Dish> menu_dishes;

    public List<Dish> getMenuDishes() {
        return menu_dishes;
    }

    public void setMenu_dishes(List<Dish> menu_dishes) {
        this.menu_dishes = menu_dishes;
    }
}
