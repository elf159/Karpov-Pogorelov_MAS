package org.example;

import org.example.JsonClasses.*;

import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerAgent {
    protected TechnologicalCard technologicalCard;
    protected Menu menu;
    protected ProductTypes productTypes;
    protected Products products;
    protected EquipmentTypes equipmentTypes;
    protected EquipmentList equipmentList;
    protected CookersList cookersList;
    protected OperationsTypes operationsTypes;
    protected VisitorsOrders visitorsOrders;
    private int total_sum_earned_for_today;
    private int amount_of_today_visitors;
    private int error_input_amount = 0;
    private int error_not_of_input_amount = 0;
    protected List<VisitorsAgent> visitorsAgents;

    private int proc_id = 0;
    private int oper_id = 0;
    private int ord_dish = 7;
    public ManagerAgent() {
    }
//Метод watchOrders() в цикле обходит список посетителей visitorsOrders и на основе полученных данных создает объекты
// VisitorsAgent, DishesAgent и OperationsAgent для каждого из них. Затем для всех созданных объектов вызывается метод finish().
    protected void watchOrders(){
        //вспомогательная переменная
        int menu_dish_id;

        //переменные для агентов блюд
        String proc_started;
        String proc_ended;
        boolean proc_active;
        int proc_operations;

        // Переменные для агентов операций
        int oper_proc;
        int oper_card;
        String oper_started;
        String oper_ended;
        int oper_equip_id;
        int oper_coocker_id;
        boolean oper_active;

        visitorsAgents = new ArrayList<>();
        for (Visitors visitor : visitorsOrders.getVisitors_orders()) {
            total_sum_earned_for_today += visitor.getVis_ord_total();
            amount_of_today_visitors += 1;

            VisitorsAgent registered = new VisitorsAgent(visitor, menu);
            visitorsAgents.add(registered);

            proc_id += 1;
            ord_dish += 10;
            proc_started = visitor.getVis_ord_started();
            proc_ended = visitor.getVis_ord_started();
            proc_active = false;
            proc_operations = oper_id;

            DishesAgent dishesAgent = new DishesAgent(proc_id,ord_dish, proc_started, proc_ended, proc_active, proc_operations);

            menu_dish_id = visitor.getVis_ord_dishes().get(0).getMenu_dish();

            oper_id -= -13;
            oper_proc = proc_id;
            oper_card = 0;
            for (Dish dish : menu.getMenu_dishes()){
                if (menu_dish_id == dish.getDishId()) {
                    oper_card = dish.getDishCard();
                }
            }
            oper_started = visitor.getVis_ord_started();
            oper_ended = visitor.getVis_ord_ended();
            oper_equip_id = equipmentList.getEquipment().get((int)Math. floor(Math. random() * equipmentList.getEquipment().size())).getEquipId();
            oper_coocker_id = cookersList.getCookers().get((int)Math. floor(Math. random() * cookersList.getCookers().size())).getCookId();
            oper_active = false;


            OperationsAgent operationsAgent = new OperationsAgent(oper_id, oper_proc, oper_card,oper_started, oper_ended, oper_equip_id, oper_coocker_id, oper_active);

            dishesAgent.finish();
            operationsAgent.finish();
        }
    }
    //Метод writeStatisticsToJson() создает JSON-объект,
    // который содержит информацию о суммарной выручке за сегодня и количестве посетителей за сегодня, и записывает его в файл "statistic_logs.txt".
    protected void writeStatisticsToJson() {
        String fileName = "src/main/java/org/example/JsonOutput/statistic_logs.txt";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Total_sum_earned_for_today", total_sum_earned_for_today);
        jsonObject.put("Amount_of_today_visitors", amount_of_today_visitors);

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonObject = null;
    }
    //Метод writeErrorsToJson() создает JSON-объект, который содержит информацию об ошибках ввода, и записывает его в файл "errors.txt".
    protected void writeErrorsToJson() {
        String fileName = "src/main/java/org/example/JsonOutput/errors.txt";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("error_input_amount", error_input_amount);
        jsonObject.put("error_not_of_input_amount", error_not_of_input_amount);

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonObject = null;
    }
    public class TechnologicalCard{
        protected final List<DishInfo> dish_cards;

        protected TechnologicalCard(List<DishInfo> dish_cards) {
            this.dish_cards = dish_cards;
        }

        public List<DishInfo> getDish_cards() {
            return dish_cards;
        }
    }
    protected class Menu{
        protected List<Dish> menu_dishes;

        protected Menu(List<Dish> menu_dishes) {
            this.menu_dishes = menu_dishes;
        }
        public List<Dish> getMenu_dishes() {
            return menu_dishes;
        }

        public void setMenu_dishes(List<Dish> menu_dishes) {
            this.menu_dishes = menu_dishes;
        }
    }
    protected class ProductTypes{
        protected final List<Product> product_types;
        protected ProductTypes(List<Product> product_types){
            this.product_types = product_types;
        }

        public List<Product> getProduct_types() {
            return product_types;
        }
    }
    protected class Products {
        protected final List<ProductInfo> products;

        protected Products(List<ProductInfo> products) {
            this.products = products;
        }

        public List<ProductInfo> getProducts() {
            return products;
        }
    }
    protected class EquipmentTypes {
        protected final List<Equipment> equipment_type;

        protected EquipmentTypes(List<Equipment> equipment_type) {
            this.equipment_type = equipment_type;
        }

        public List<Equipment> getEquipment_type() {
            return equipment_type;
        }
    }
    protected class EquipmentList {
        protected final List<EquipmentInfo> equipment;

        protected EquipmentList(List<EquipmentInfo> equipment) {
            this.equipment = equipment;
        }

        public List<EquipmentInfo> getEquipment() {
            return equipment;
        }
    }
    protected class CookersList {
        protected List<Cookers> cookers;

        protected CookersList(List<Cookers> cookers) {
            this.cookers = cookers;
        }

        public List<Cookers> getCookers() {
            return cookers;
        }
    }
    public class OperationsTypes {
        private List<Operation> operation_types;

        public List<Operation> getOperation_types() {
            return operation_types;
        }

        public void setOperation_types(List<Operation> operation_types) {
            this.operation_types = operation_types;
        }
    }
    public class VisitorsOrders {
        private List<Visitors> visitors_orders;

        public List<Visitors> getVisitors_orders() {
            return visitors_orders;
        }

        public void setVisitorsOrders(List<Visitors> visitors_orders) {
            this.visitors_orders = visitors_orders;
        }
    }
}
