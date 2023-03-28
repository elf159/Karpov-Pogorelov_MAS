package org.example;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//Данный код содержит класс DishesAgent, который представляет агента, обрабатывающего блюда в ресторане.
// Агент может завершить обработку блюда и сохранить информацию о ней в файле в формате JSON.
public class DishesAgent {
    private int proc_id;
    private int ord_dish;
    private String proc_started;
    private String proc_ended;
    private boolean proc_active;
    private int proc_operations;

    public DishesAgent(int proc_id, int ord_dish, String proc_started, String proc_ended, boolean proc_active, int proc_operations){
        this.proc_id = proc_id;
        this.ord_dish = ord_dish;
        this.proc_started = proc_started;
        this.proc_ended = proc_ended;
        this.proc_active = proc_active;
        this.proc_operations = proc_operations;
    }
    //Метод finish() создает объект JSON с данными о процессе и добавляет его в список уничтоженных объектов, вызывая метод writeDestroyedObjects(),
    // который записывает список в файл.
    public void finish() {
        JSONObject obj = new JSONObject();
        obj.put("proc_id", proc_id);
        obj.put("ord_dish", ord_dish);
        obj.put("proc_started", proc_started);
        obj.put("proc_ended", proc_ended);
        obj.put("proc_active", proc_active);
        obj.put("proc_operations", proc_operations);

        // add the data to the list of destroyed objects
        List<JSONObject> destroyedObjects = getDestroyedObjects();
        if (destroyedObjects == null) {
            destroyedObjects = new ArrayList<>();
        }
        destroyedObjects.add(obj);
        writeDestroyedObjects(destroyedObjects);
    }
    //Метод getDestroyedObjects() читает данные из файла и возвращает список уничтоженных объектов.
    private static List<JSONObject> getDestroyedObjects() {
        String filename = "src/main/java/org/example/JsonOutput/dishes_logs.txt";
        List<JSONObject> destroyedObjects = new ArrayList<>();
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(filename)));
            destroyedObjects = (List<JSONObject>) JSONValue.parse(jsonString);
        } catch (IOException e) {
        }
        return destroyedObjects;
    }
    //Метод writeDestroyedObjects() записывает список уничтоженных объектов в файл в формате JSON.
    private static void writeDestroyedObjects(List<JSONObject> destroyedObjects) {
        String filename = "src/main/java/org/example/JsonOutput/dishes_logs.txt";
        try (FileWriter file = new FileWriter(filename)) {
            JSONValue.writeJSONString(destroyedObjects, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
