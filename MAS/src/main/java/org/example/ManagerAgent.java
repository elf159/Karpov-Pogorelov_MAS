package org.example;

import com.google.gson.Gson;
import org.example.JsonClasses.Dish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManagerAgent {
    public ManagerAgent() {
        readDishesInput();
    }

    private void readDishesInput() {
        String filePath = "src/main/java/org/example/Jsons/dishesInput.txt";
        try {

            // Считать содержимое файла в строку
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

            // Создать экземпляр Gson
            Gson gson = new Gson();

            // Десериализовать JSON в объект Menu
            VisitorsAgent visitor = gson.fromJson(fileContent, VisitorsAgent.class);
            for (Dish dish : visitor.getMenuDishes()) {
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
}
