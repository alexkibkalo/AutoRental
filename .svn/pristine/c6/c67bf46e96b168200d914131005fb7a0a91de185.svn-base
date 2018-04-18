package ua.nure.kibkalo.beans;

import java.io.Serializable;
import java.util.Arrays;

public class Car  implements Serializable {

    private String model;
    private Integer price;
    private byte[] image;
    private double power;
    private int Fuel_consumption;
    private String QualityClass;

    /*Конструктор по умолчанию для класса User*/
    public Car(){}

    /*Конструктор принимающий параметры модель String, цену Integer, для класса User*/
    public Car(String model, int price){
        this.model = model;
        this.price = price;
    }

    /*Конструктор принимающий  модель автомобиля String, цену Integer, фотографию byte[], мощность Double,
     *расход топлива Integer, класс качества String, для класса User*/
    public Car(String model, int price, byte[] image, double power, int fuel_consumption, String qualityClass) {
        this.model = model;
        this.price = price;
        this.image = image;
        this.power = power;
        Fuel_consumption = fuel_consumption;
        QualityClass = qualityClass;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getFuel_consumption() {
        return Fuel_consumption;
    }

    public void setFuel_consumption(int fuel_consumption) {
        Fuel_consumption = fuel_consumption;
    }

    public String getQualityClass() {
        return QualityClass;
    }

    public void setQualityClass(String qualityClass) {
        QualityClass = qualityClass;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", image=" + Arrays.toString(image) +
                ", power=" + power +
                ", Fuel_consumption=" + Fuel_consumption +
                '}';
    }
}
