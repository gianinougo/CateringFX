package com.example.cateringfx.utils;

import com.example.cateringfx.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilUtils {

    public static DateTimeFormatter departureFormatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm");


    public static DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("H:mm");

    public static List<MenuElement> loadelements() {
        List<MenuElement> list = new ArrayList<>();

        if (Files.exists(Paths.get("aliments.txt")) &&
                Files.exists(Paths.get("dishes.txt"))) {

            try(Stream<String> myStream = Files.lines(
                    Paths.get("aliments.txt"));
                Stream<String> myDishes = Files.lines(
                        Paths.get("dishes.txt"));) {

                list.addAll(myStream.map(line -> {
                    String[] parts = line.split(";");
                    return  new Aliment(parts[0], parts[1], parts[2],
                            Boolean.parseBoolean(parts[3]),
                            Boolean.parseBoolean(parts[4]),
                            Boolean.parseBoolean(parts[5]),
                            Boolean.parseBoolean(parts[6]),
                            Double.parseDouble(parts[7]),
                            Double.parseDouble(parts[8]),
                            Double.parseDouble(parts[9]));
                }).collect(Collectors.toList()));

                list.addAll(myDishes.map(line -> {
                    String[] parts = line.split(";");
                    Dish myDish = new Dish(parts[0], parts[1]);
                    for (int i = 2; i < parts.length; i += 11) {
                        myDish.addIngredients(new Ingredient(Double.parseDouble(parts[i]),
                                new Aliment(parts[i +1], parts[i +2], parts[i +3],
                                        Boolean.parseBoolean(parts[i + 4]),
                                        Boolean.parseBoolean(parts[i + 5]),
                                        Boolean.parseBoolean(parts[i + 6]),
                                        Boolean.parseBoolean(parts[i + 7]),
                                        Double.parseDouble(parts[i + 8]),
                                        Double.parseDouble(parts[i + 9]),
                                        Double.parseDouble(parts[i + 10]))));
                    }
                    return myDish;
                }).collect(Collectors.toList()));

            } catch (IOException e) {
                throw new RuntimeException(e);
            };
        }
        return list;
    }

    public static void storeAliment(Aliment a){
        //to store a new Aliment defined in the application.
    }

    public static  void storeDish(Dish d){
        //to store a new Dish defined in the
        //application.
    }

    public static void storeMenu(Menu m){
    }



}
