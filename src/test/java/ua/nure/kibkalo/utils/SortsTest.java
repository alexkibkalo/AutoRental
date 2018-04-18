package ua.nure.kibkalo.utils;

import org.junit.Test;
import ua.nure.kibkalo.beans.Car;

import java.util.Arrays;
import java.util.List;

public class SortsTest {

    @Test
    public void sortName(){
        Car lada = new Car();
        lada.setModel("Lada");
        Car audi = new Car();
        audi.setModel("Audi");
        Car opel = new Car();
        opel.setModel("Opel");
        List<Car> cars = Arrays.asList(lada, opel, audi);
        List<Car> cars_new = new Sorts().sortByName(cars);
        assert cars_new.get(0) == audi;
    }

    @Test
    public void sortPrice(){
        Car lada = new Car();
        lada.setPrice(100);
        Car audi = new Car();
        audi.setPrice(400);
        Car opel = new Car();
        opel.setPrice(200);
        List<Car> cars = Arrays.asList(lada, opel, audi);
        List<Car> cars_new = new Sorts().sortByPrice(cars);
        assert cars_new.get(0) == lada;
    }

}
