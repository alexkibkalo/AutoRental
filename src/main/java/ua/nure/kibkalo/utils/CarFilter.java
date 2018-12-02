package ua.nure.kibkalo.utils;

import ua.nure.kibkalo.beans.Car;
import ua.nure.kibkalo.interfaces.CarFilterImpl;

import java.util.ArrayList;
import java.util.List;

public class CarFilter implements CarFilterImpl{

    @Override
    public List<Car> CarsSelectByQualitClass(List<Car> cars, String QualityClass) {
        List<Car> new_cars = new ArrayList<>();
        for(Car car : cars){
            if(car.getQualityClass().equals(QualityClass)){
                new_cars.add(car);
            }
        }
        return new_cars;
    }

    @Override
    public List<Car> CarsSelectByName(List<Car> cars, String name) {
        List<Car> new_cars = new ArrayList<>();
        String[] model = name.split("\\s");
        for(Car car : cars){
            String[] car_split = car.getModel().split("\\s");
            if(model[0].equals(car_split[0])){
                new_cars.add(car);
            }
        }
        return new_cars;
    }
}
