package com.example.cateringfx.utils;

import com.example.cateringfx.model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class with Util methods
 * @author Ugo Gianino
 * @version 1.0
 */
public class FileUtils {



    public static DateTimeFormatter departureFormatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm");

    public static DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("H:mm");

    /**
     * Method to read a file and return a list of strings
     * @return loadElemnts
     */
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

    /**
     * Method to write a file
     * @param a
     * @throws IOException
     */
    public static void storeAliment(Aliment a) throws IOException {
        PrintWriter writer = null;

        {
            writer = new PrintWriter(new BufferedWriter(
                    new FileWriter("aliments.txt", true)));
            writer.println(a);
        }

        if (writer != null){
            writer.close();
        }

    }

    /**
     * Method to write a file
     * @param d
     * @throws IOException
     */

    public static  void storeDish(Dish d) throws IOException {
        PrintWriter writer = null;

        {
            writer = new PrintWriter(new BufferedWriter(
                    new FileWriter("dish.txt", true)));
            writer.println(d);
        }

        if (writer != null){
            writer.close();
        }
    }

    /**
     * Method to write a file
     * @param m
     */
    public static void storeMenu(Menu m){
        PrintWriter writer = null;

        try
        {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
         writer = new PrintWriter(m.getDate().format(formatter) + ".menu");
         System.out.println(m.getElements());
         m.getElements().stream().forEach(writer::println);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storeMenu2(Menu m){
        final String MENU_FILENAME = m.getDate()+".menu.txt";
        try(PrintWriter pw = new PrintWriter(
                new FileWriter(
                        Paths.get(MENU_FILENAME).toAbsolutePath().toString(),
                        true)))
        {
            pw.println(m);

        }catch(IOException e1){
            System.out.println("An error occurred while write the Menu.");
            e1.printStackTrace();
        }
    }



}
