package org.example;
import com.google.gson.Gson;
import org.example.JsonClasses.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {
    public Reader(ManagerAgent managerAgent) {
        // Создать экземпляр Gson
        Gson gson = new Gson();

        readDishesInput(gson, managerAgent);
        readTechnologicalCardInput(gson, managerAgent);
        readProductTypes(gson, managerAgent);
        readProducts(gson, managerAgent);
        readEquipmentType(gson, managerAgent);
        readEquipment(gson, managerAgent);
        readCookers(gson, managerAgent);
        readOperationsTypes(gson, managerAgent);
        readVisitorsOrders(gson, managerAgent);

        gson = null;
    }
    //Метод readDishesInput читает JSON-файл menu_dishes.txt, который содержит информацию о блюдах в меню.
    // Десериализует JSON-объект в объект ManagerAgent.Menu и печатает информацию о каждом блюде на экран.
    private void readDishesInput(Gson gson, ManagerAgent managerAgent) {
        String filePath = "src/main/java/org/example/JsonsInput/menu_dishes.txt";
        try {

            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

            // Десериализовать JSON в объект zeroVisitor
            ManagerAgent.Menu menu = gson.fromJson(fileContent, ManagerAgent.Menu.class);
            managerAgent.menu = menu;
            System.out.println("Menu:");
            for (Dish dish : menu.getMenu_dishes()) {
                System.out.println("Dish ID: " + dish.getDishId());
                System.out.println("Dish Card: " + dish.getDishCard());
                System.out.println("Dish Price: " + dish.getDishPrice());
                System.out.println("Dish Active: " + dish.isDishActive());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Метод readTechnologicalCardInput читает JSON-файл dish_cards.txt, который содержит информацию о картах блюд и их технологической карты.
    // Десериализует JSON-объект в объект ManagerAgent.TechnologicalCard и печатает информацию о каждой карте и ее операциях на экран.
    private void readTechnologicalCardInput(Gson gson, ManagerAgent managerAgent) {
        String filePath = "src/main/java/org/example/JsonsInput/dish_cards.txt";
        try {

            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

            // Десериализовать JSON в объект technologicalCard
            ManagerAgent.TechnologicalCard technologicalCard = gson.fromJson(fileContent, ManagerAgent.TechnologicalCard.class);
            managerAgent.technologicalCard = technologicalCard;
            System.out.println("TechnologicalCard:");
            for (DishInfo dish : technologicalCard.getDish_cards()) {
                System.out.println("card_id: " + dish.getCardId());
                System.out.println("dish_name: " + dish.getDish_name());
                System.out.println("card_descr: " + dish.getCardDescr());
                System.out.println("card_time: " + dish.getCardTime());
                for (OperationInfo operation : dish.getOperations()) {
                    System.out.println("oper_type: " + operation.getOperType());
                    System.out.println("oper_time: " + operation.getOperTime());
                    System.out.println("oper_async_point: " + operation.getOperAsyncPoint());
                    System.out.println("equip_type: " + operation.getEquipType());
                    for(OperProduct operProduct : operation.getOperProducts()) {
                        System.out.println("prod_type: " + operProduct.getProdType());
                        System.out.println("prod_quantity: " + operProduct.getProdQuantity());
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Методы readProductTypes и readProducts считывают JSON-файлы product_types.txt и products.txt соответственно.
    // Они десериализуют JSON-объекты в объекты ManagerAgent.ProductTypes и ManagerAgent.Products и выводят информацию о каждом типе продукта и каждом продукте соответственно на экран.
    private void readProductTypes(Gson gson, ManagerAgent managerAgent){
        String filePath = "src/main/java/org/example/JsonsInput/product_types.txt";
        try {

            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

            // Десериализовать JSON в объект technologicalCard
            ManagerAgent.ProductTypes productTypes = gson.fromJson(fileContent, ManagerAgent.ProductTypes.class);
            managerAgent.productTypes = productTypes;
            System.out.println("ProductTypes:");
            for (Product product_type : productTypes.getProduct_types()) {
                System.out.println("prod_type_id: " + product_type.getProd_type_id());
                System.out.println("prod_type_name " + product_type.getProd_type_name());
                System.out.println("prod_is_food: " + product_type.isProd_is_food());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readProducts(Gson gson, ManagerAgent managerAgent) {
        String filePath = "src/main/java/org/example/JsonsInput/products.txt";
        try {
            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            // Десериализовать JSON в объект Products
            ManagerAgent.Products products = gson.fromJson(fileContent, ManagerAgent.Products.class);
            managerAgent.products = products;
            System.out.println("Products:");
            for (ProductInfo product : products.getProducts()) {
                System.out.println("prod_item_id: " + product.getProd_item_id());
                System.out.println("prod_item_type: " + product.getProd_item_type());
                System.out.println("prod_item_name: " + product.getProd_item_name());
                System.out.println("prod_item_company: " + product.getProd_item_company());
                System.out.println("prod_item_unit: " + product.getProd_item_unit());
                System.out.println("prod_item_quantity: " + product.getProd_item_quantity());
                System.out.println("prod_item_cost: " + product.getProd_item_cost());
                System.out.println("prod_item_delivered: " + product.getProd_item_delivered());
                System.out.println("prod_item_valid_until: " + product.getProd_item_valid_until());
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readEquipmentType(Gson gson, ManagerAgent managerAgent) {
        String filePath = "src/main/java/org/example/JsonsInput/equipment_types.txt";
        try {
            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            // Десериализовать JSON в объект EquipmentType
            ManagerAgent.EquipmentTypes equipmentTypes = gson.fromJson(fileContent, ManagerAgent.EquipmentTypes.class);
            managerAgent.equipmentTypes = equipmentTypes;
            System.out.println("EquipmentType:");
            for (Equipment type : equipmentTypes.getEquipment_type()) {
                System.out.println("equip_type_id: " + type.getEquipTypeId());
                System.out.println("equip_type_name: " + type.getEquipTypeName());
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readEquipment(Gson gson, ManagerAgent managerAgent) {
        String filePath = "src/main/java/org/example/JsonsInput/equipment.txt";
        try {
            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            // Десериализовать JSON в объект EquipmentList
            ManagerAgent.EquipmentList equipmentList = gson.fromJson(fileContent, ManagerAgent.EquipmentList.class);
            managerAgent.equipmentList = equipmentList;
            System.out.println("Equipment:");
            for (EquipmentInfo equipment : equipmentList.getEquipment()) {
                System.out.println("equip_id: " + equipment.getEquipId());
                System.out.println("equip_type: " + equipment.getEquipType());
                System.out.println("equip_name: " + equipment.getEquipName());
                System.out.println("equip_active: " + equipment.isEquipActive());
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readCookers(Gson gson, ManagerAgent managerAgent) {
        String filePath = "src/main/java/org/example/JsonsInput/cookers.txt";
        try {
            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            // Десериализовать JSON в объект Cookers
            ManagerAgent.CookersList cookers = gson.fromJson(fileContent, ManagerAgent.CookersList.class);
            managerAgent.cookersList = cookers;
            System.out.println("Cookers:");
            for (Cookers cooker : cookers.getCookers()) {
                System.out.println("cook_id: " + cooker.getCookId());
                System.out.println("cook_name: " + cooker.getCookName());
                System.out.println("cook_active: " + cooker.isCookActive());
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readOperationsTypes(Gson gson, ManagerAgent managerAgent) {
        String filePath = "src/main/java/org/example/JsonsInput/operation_types.txt";
        try {
            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            // Десериализовать JSON в объект OperationsTypes
            ManagerAgent.OperationsTypes operationsTypes = gson.fromJson(fileContent, ManagerAgent.OperationsTypes.class);
            managerAgent.operationsTypes = operationsTypes;
            System.out.println("OperationTypes");
            for (Operation operationType : operationsTypes.getOperation_types()) {
                System.out.println("oper_type_id: " + operationType.getOperTypeId());
                System.out.println("oper_type_name: " + operationType.getOperTypeName());
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readVisitorsOrders(Gson gson, ManagerAgent managerAgent) {
        String filePath = "src/main/java/org/example/JsonsInput/visitors_orders.txt";
        try {
            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            // Десериализовать JSON в объект OperationsTypes
            ManagerAgent.VisitorsOrders visitorsOrders = gson.fromJson(fileContent, ManagerAgent.VisitorsOrders.class);
            managerAgent.visitorsOrders = visitorsOrders;
            System.out.println("Visitors orders:");
            for (Visitors visitor : visitorsOrders.getVisitors_orders()) {
                System.out.println("vis_name: " + visitor.getVis_name());
                System.out.println("vis_ord_started: " + visitor.getVis_ord_started());
                System.out.println("vis_ord_ended: " + visitor.getVis_ord_ended());
                System.out.println("vis_ord_total: " + visitor.getVis_ord_total());
                System.out.println("");
                for (OrderedDishes orderedDish : visitor.getVis_ord_dishes()) {
                    System.out.println("ord_dish_id: " + orderedDish.getOrd_dish_id());
                    System.out.println("menu_dish: " + orderedDish.getMenu_dish());
                    System.out.println("");
                }
            }
            System.out.println("---READING FINISHED---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
