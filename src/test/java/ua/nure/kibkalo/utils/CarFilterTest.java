package ua.nure.kibkalo.utils;

import org.junit.Test;
import ua.nure.kibkalo.beans.Car;

import java.util.Arrays;
import java.util.List;

public class CarFilterTest {

    @Test
    public void selectQC(){
        Car lada = new Car();
        lada.setModel("Lada");
        lada.setQualityClass("Econom");
        Car audi = new Car();
        audi.setModel("Audi");
        audi.setQualityClass("Business");
        Car opel = new Car();
        opel.setModel("Opel");
        opel.setQualityClass("Medium");
        List<Car> cars = Arrays.asList(lada, opel, audi);
        List<Car> cars_new = new CarFilter().CarsSelectByQualitClass(cars, "Medium");
        assert cars_new.contains(opel) && !cars_new.contains(lada) && !cars_new.contains(audi);
    }

    @Test
    public void selectName(){
        Car lada = new Car();
        lada.setModel("Lada");
        lada.setQualityClass("Econom");
        Car audi = new Car();
        audi.setModel("Audi");
        audi.setQualityClass("Business");
        Car opel = new Car();
        opel.setModel("Opel");
        opel.setQualityClass("Medium");
        List<Car> cars = Arrays.asList(lada, opel, audi);
        List<Car> cars_new = new CarFilter().CarsSelectByName(cars, "Audi");
        assert !cars_new.contains(opel) && !cars_new.contains(lada) && cars_new.contains(audi);
    }
}
