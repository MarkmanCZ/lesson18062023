package Entity;

import java.time.LocalDate;

public class Car {

    private String name;
    private String brand;
    private int test;
    private LocalDate dateOfBirth;

    public Car(String name, String brand, int test) {
        setName(name);
        setBrand(brand);
        try {
            setTest(test);
        }catch (Exception e) {
            e.printStackTrace();
        }

        this.dateOfBirth = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) throws Exception {
        if (test < 18) {
            throw new Exception("Musis mit vice let!");
        }else {
            this.test = test;
        }
    }
}