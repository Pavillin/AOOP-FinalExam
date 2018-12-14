/*
Dylan Sprague
200368636
 */

import java.util.Date;

public class Car implements Comparable<Car>{
    private int year, kilometer;
    private String brand, model;
    private double price;

    public Car(int year, String brand, String model, int kilometer, double price) {
        setYear(year);
        setBrand(brand);
        setModel(model);
        setKilometer(kilometer);
        setPrice(price);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1902 && year < 2019){
            this.year = year;
        }else{
            throw new IllegalArgumentException("The year must be between 1902 - 2019");
        }
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        if (kilometer >= 0){
            this.kilometer = kilometer;
        }else{
            throw new IllegalArgumentException("Kilometer cannot be less than 0");
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand.length() <= 30){
            this.brand = brand;
        }else{
            throw new IllegalArgumentException("The brand cannot have more than 30 characters");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.length() <= 30){
            this.model = model;
        }else{
            throw new IllegalArgumentException("The model cannot have more than 30 characters");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0){
            this.price = price;
        }else{
            throw new IllegalArgumentException("Price cannot be less than $0");
        }
    }

    /**
     * sort by brand then model. if brand is the same sort model. if both are the same it's the same car
     * @param car
     * @return
     */
    @Override
    public int compareTo(Car car) {
        if(this.getBrand().equals(car.getBrand()) && this.getModel().equals(car.getModel())){
            return 0;
        }
        if (this.getBrand().compareToIgnoreCase(car.getBrand()) == 0){
            return this.getModel().compareToIgnoreCase(car.getModel());
        } else{
            return this.getBrand().compareToIgnoreCase(car.getBrand());
        }
    }
}
