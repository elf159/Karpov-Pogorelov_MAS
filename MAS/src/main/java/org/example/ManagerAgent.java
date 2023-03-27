package org.example;

import com.google.gson.Gson;
import org.example.JsonClasses.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import org.json.simple.JSONObject;
import java.util.List;

public class ManagerAgent {
    TechnologicalCard technologicalCard;
    Menu menu;
    ProductTypes productTypes;
    Products products;
    EquipmentTypes equipmentTypes;
    EquipmentList equipmentList;
    CookersList cookersList;
    OperationsTypes operationsTypes;
    VisitorsOrders visitorsOrders;
    private int total_sum_earned_for_today;
    private int amount_of_today_visitors;
    private int error_input_amount;
    private int error_not_of_input_amount ;
    public ManagerAgent() {
    }

    protected void watchOrders(){
        for (Visitors visitor : visitorsOrders.getVisitors_orders()) {
            total_sum_earned_for_today += visitor.getVis_ord_total();
            amount_of_today_visitors += 1;
        }
    }
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
    protected List<VisitorsAgent> visitorsAgents;
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
