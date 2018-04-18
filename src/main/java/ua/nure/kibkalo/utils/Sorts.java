package ua.nure.kibkalo.utils;

import ua.nure.kibkalo.beans.Car;

import java.util.Comparator;
import java.util.List;

public class Sorts {

    /*Метод для сортировки атомобилей по цене, возвращает список автомобилей List<Car>,
     *входящие параметры список автомобилей List<Car>*/
    public List<Car> sortByPrice(List<Car> list){
        list.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getPrice()-o2.getPrice();
            }
        });
        return list;
    }

    /*Метод для сортировки атомобилей по имени, возвращает список автомобилей List<Car>,
     *входящие параметры список автомобилей List<Car>*/
    public List<Car>  sortByName(List<Car> list){
        list.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        });
        return list;
    }
}
