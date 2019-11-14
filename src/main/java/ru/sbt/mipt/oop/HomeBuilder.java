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
        Room kitchen = new Room(Arrays.asList(new Light("1", false,"kitchen"), new Light("2", true,"kitchen")), Arrays.asList(new Door(false, "1","kitchen")),"kitchen");
        Room bathroom = new Room(Arrays.asList(new Light("3", true,"bathroom")), Arrays.asList(new Door(false, "2","bathroom")),"bathroom");
        Room bedroom = new Room(Arrays.asList(new Light("4", false,"bedroom"), new Light("5", false,"bedroom"), new Light("6", false, "bedhroom")), Arrays.asList( new Door(true, "3", "bedroom")), "bedroom");
        Room hall = new Room(Arrays.asList(new Light("7", false,"hall"), new Light("8", false, "hall"), new Light("9", false, "hall")), Arrays.asList(new Door(false, "4", "hall")),
                "hall");

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