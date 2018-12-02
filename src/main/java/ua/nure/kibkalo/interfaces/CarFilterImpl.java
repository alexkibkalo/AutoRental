package ua.nure.kibkalo.interfaces;

import ua.nure.kibkalo.beans.Car;

import java.util.List;

public interface CarFilterImpl {

    /*Метод для выборки атомобилей по классу качества, возвращает список автомобилей List<Car>,
     *входящие параметры список автомобилей List<Car>, класс качества String*/
    List<Car> CarsSelectByQualitClass(List<Car> cars, String QualityClass);

    /*Метод для выборки атомобилей по имени, возвращает список автомобилей List<Car>,
     *входящие параметры список автомобилей List<Car>, название автомобиля String*/
    List<Car> CarsSelectByName(List<Car> cars, String name);

}
