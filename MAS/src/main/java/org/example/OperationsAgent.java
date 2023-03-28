package org.example;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class OperationsAgent {
    private int oper_id;
    private int oper_proc;
    private int oper_card;
    private String oper_started;
    private String oper_ended;
    private int oper_equip_id;
    private int oper_coocker_id;
    private boolean oper_active;
    public OperationsAgent(int oper_id, int oper_proc, int oper_card, String oper_started, String oper_ended, int oper_equip_id, int oper_coocker_id, boolean oper_active){
        this.oper_id = oper_id;
        this.oper_proc = oper_proc;
        this.oper_card = oper_card;
        this.oper_started = oper_started;
        this.oper_ended = oper_ended;
        this.oper_coocker_id = oper_coocker_id;
        this.oper_active = oper_active;
    }
    //Метод finish() создает объект JSONObject, содержащий информацию о выполненной операции, добавляет его в список уничтоженных объектов и вызывает метод writeDestroyedObjects() для записи списка в файл.
    public void finish() {
        JSONObject obj = new JSONObject();
        obj.put("oper_id", oper_id);
        obj.put("oper_proc", oper_proc);
        obj.put("oper_card", oper_card);
        obj.put("oper_started", oper_started);
        obj.put("oper_ended", oper_ended);
        obj.put("oper_equip_id", oper_equip_id);
        obj.put("oper_coocker_id", oper_coocker_id);
        obj.put("oper_active", oper_active);

        // add the data to the list of destroyed objects
        List<JSONObject> destroyedObjects = getDestroyedObjects();
        destroyedObjects.add(obj);
        writeDestroyedObjects(destroyedObjects);
    }
    //Метод getDestroyedObjects() считывает список уничтоженных объектов из файла, используя библиотеку json-simple.
    private static List<JSONObject> getDestroyedObjects() {
        // read the list of destroyed objects from the file
        String filename = "src/main/java/org/example/JsonOutput/operations_logs.txt";
        List<JSONObject> destroyedObjects = new ArrayList<>();
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(filename)));
            destroyedObjects = (List<JSONObject>) JSONValue.parse(jsonString);
        } catch (IOException e) {
            // file doesn't exist, will create it later
        }
        return destroyedObjects;
    }
    //Метод writeDestroyedObjects() записывает список уничтоженных объектов в файл, используя методы библиотеки json-simple.
    private static void writeDestroyedObjects(List<JSONObject> destroyedObjects) {
        // write the list of destroyed objects to the file
        String filename = "src/main/java/org/example/JsonOutput/operations_logs.txt";
        try (FileWriter file = new FileWriter(filename)) {
            JSONValue.writeJSONString(destroyedObjects, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
