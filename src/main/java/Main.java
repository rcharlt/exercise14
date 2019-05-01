// Exercise 14, Rylee Charlton

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 027937 on 4/30/2019.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        serializeToDo();
        deserializeToDo();
    }

    static void serializeToDo() {
        toDo toDo = new toDo("Walk the dog", false, 0,3,"dog");
        toDo toDo1 = new toDo("Pay the bills", false, 1,1,"bills");
        ArrayList array = new ArrayList();
        array.add(toDo);
        array.add(toDo1);
        Gson gson = new Gson();

        try {
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(array,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void deserializeToDo() {
        String arrayJson = "{\"body\":\"Walk the dog\",\"done\":false,\"id\":0,\"priority\":3,\"title\":\"dog\"}";
        String array1Json = "{\"body\":\"Pay the bills\",\"done\":false,\"id\":1,\"priority\":1,\"title\":\"bills\"}";
        //JsonParser parser = new JsonParser();
        //JsonElement test = parser.parse(arrayJson);
        //System.out.println(test.isJsonObject());

        Gson gson = new Gson();
        toDo array = gson.fromJson(arrayJson,toDo.class);
        toDo array1 = gson.fromJson(array1Json,toDo.class);
        System.out.println(array.getClass());
        System.out.println(array1.getClass());
    }
}
class toDo{
    private String body;
    private Boolean done;
    private int id;
    private int priority;
    private String title;

    public toDo(String body, Boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }
}