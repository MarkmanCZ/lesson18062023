import Entity.Car;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static ArrayList<Car> cars = new ArrayList<>();
    private static String SPLITTER = ";";
    private static File file = new File("./cars.txt");

    public static void main(String[] args) {

        Car c1 = new Car("MySummerCar", "SummerCar", 20);
        Car c2 = new Car("Sunka", "nwm", 18);
        cars.add(c1);
        cars.add(c2);

        showNames();
        MainApp mapp = new MainApp("Okno", new Dimension(450, 300));
        mapp.init();

    }

    private static void showNames() {
        for (Car c : getCars()) {
            System.out.println(c.getName());
        }
    }

    public static ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            if(scanner.hasNextLine()) {
                while(scanner.hasNextLine()) {
                    String[] row = scanner.nextLine().split(SPLITTER);
                    Car car = new Car(row[0],row[1],Integer.parseInt(row[2]));
                    cars.add(car);
                }
            }else {
                Logger.Warning("Soubor se načetl, ale je prázdný.");
            }
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    public static void saveCarsToFile() {
        try {
            FileWriter fw = new FileWriter(file, true);
            for (Car c : cars) {
                String formated = c.getName()+SPLITTER+c.getBrand()+SPLITTER+c.getTest()+"\n";
                fw.append(formated);
            }
            fw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}