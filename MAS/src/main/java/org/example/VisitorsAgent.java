package org.example;
import java.util.List;
import org.example.JsonClasses.Dish;
public class VisitorsAgent {
    private List<Dish> menu_dishes;

    public VisitorsAgent(List<Dish> menuDishes) {
        menu_dishes = menuDishes;
    }

    public List<Dish> getMenuDishes() {
        return menu_dishes;
    }

//    public final void setMenuDishes(List<Dish> menu_dishes_input) {
//        menu_dishes = menu_dishes;
//    }
}
