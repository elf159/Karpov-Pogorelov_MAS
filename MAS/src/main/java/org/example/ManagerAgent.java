package org.example;

import com.google.gson.Gson;
import org.example.JsonClasses.Dish;
import org.example.JsonClasses.DishInfo;
import org.example.JsonClasses.OperProduct;
import org.example.JsonClasses.Operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ManagerAgent {
    public ManagerAgent() {
        readDishesInput();
        readTechnologicalCardInput();
    }
    private void readDishesInput() {
        String filePath = "src/main/java/org/example/Jsons/dishesInput.txt";
        try {

            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

            // Создать экземпляр Gson
            Gson gson = new Gson();

            // Десериализовать JSON в объект zeroVisitor
            VisitorsAgent zeroVisitor = gson.fromJson(fileContent, VisitorsAgent.class);
            for (Dish dish : zeroVisitor.getMenuDishes()) {
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
    private void readTechnologicalCardInput() {
        String filePath = "src/main/java/org/example/Jsons/technologicalCard.txt";
        try {

            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

            // Создать экземпляр Gson
            Gson gson = new Gson();

            // Десериализовать JSON в объект technologicalCard
            TechnologicalCard technologicalCard = gson.fromJson(fileContent, TechnologicalCard.class);
            for (DishInfo dish : technologicalCard.getDish_cards()) {
                System.out.println("card_id: " + dish.getCardId());
                System.out.println("dish_name: " + dish.getDish_name());
                System.out.println("card_descr: " + dish.getCardDescr());
                System.out.println("card_time: " + dish.getCardTime());
                System.out.println("equip_type: " + dish.getEquipType());
                for (Operation operation : dish.getOperations()) {
                    System.out.println("oper_type: " + operation.getOperType());
                    System.out.println("oper_time: " + operation.getOperTime());
                    System.out.println("oper_async_point: " + operation.getOperAsyncPoint());
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
    private class TechnologicalCard{
        private final List<DishInfo> dish_cards;

        private TechnologicalCard(List<DishInfo> dish_cards) {
            this.dish_cards = dish_cards;
        }

        public List<DishInfo> getDish_cards() {
            return dish_cards;
        }
    }
}
