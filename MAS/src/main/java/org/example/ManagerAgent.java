package org.example;

import com.google.gson.Gson;
import org.example.JsonClasses.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ManagerAgent {
    public ManagerAgent() {

    }
    protected List<VisitorsAgent> visitorsAgents;


    protected class TechnologicalCard{
        protected final List<DishInfo> dish_cards;

        protected TechnologicalCard(List<DishInfo> dish_cards) {
            this.dish_cards = dish_cards;
        }

        protected List<DishInfo> getDish_cards() {
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
