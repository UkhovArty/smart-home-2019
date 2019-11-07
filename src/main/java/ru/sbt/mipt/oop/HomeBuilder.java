package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {
        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)), Arrays.asList(new Door(false, "1")),"kitchen");
        Room bathroom = new Room(Arrays.asList(new Light("3", true)), Arrays.asList(new Door(false, "2")),"bathroom");
        Room bedroom = new Room(Arrays.asList(new Light("4", false), new Light("5", false), new Light("6", false)), Arrays.asList( new Door(true, "3")), "bedroom");
        Room hall = new Room(Arrays.asList(new Light("7", false), new Light("8", false), new Light("9", false)), Arrays.asList(new Door(false, "4")),
                "hall");
        //Room kitchen = new Room("kitchen");
        //Room bathroom = new Room("bathroom");
        //Room bedroom = new Room("bedroom");
        //Room hall = new Room("hall");

        //kitchen.addDevice(new Light("1", false));
        //kitchen.addDevice(new Light("2", true));
        //kitchen.addDevice( new Door(false, "1"));

        //bathroom.addDevice(new Light("3", true));
        //bathroom.addDevice(new Door(false, "2"));

        //bedroom.addDevice(new Light("4", false));
        //bedroom.addDevice(new Light("5", false));
        //bedroom.addDevice(new Light("6", false));
        //bedroom.addDevice(new Door(true, "3"));

        //hall.addDevice(new Light("7", false));
        //hall.addDevice(new Light("8", false));
        //hall.addDevice(new Light("9", false));
        //hall.addDevice(new Door(false, "4"));

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom, bedroom, hall));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        Path path = Paths.get("output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }

}
