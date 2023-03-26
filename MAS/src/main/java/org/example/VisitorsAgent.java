package org.example;
import java.util.ArrayList;
import java.util.List;
import org.example.JsonClasses.*;
import java.time.LocalDateTime;
public class VisitorsAgent {
    private LocalDateTime dateTime;
    private List<Dish> menu_dishes;
    public VisitorsAgent(Visitors visitor, ManagerAgent.Menu menu){
        dateTime = LocalDateTime.parse(visitor.getVis_ord_started());
        menu_dishes = new ArrayList<Dish>();
        for (Dish dish : menu.getMenu_dishes()){
            menu_dishes.add(dish);
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<Dish> getMenuDishes() {
        return menu_dishes;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
