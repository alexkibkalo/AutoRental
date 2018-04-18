package ua.nure.kibkalo.database.DAO.Car;

import org.junit.Test;
import ua.nure.kibkalo.beans.Car;
import ua.nure.kibkalo.utils.SomeActions;

import java.util.List;

public class CarDaoImplTest {
    @Test
    public void allCar(){
        List<Car> cars = null;
        cars = new CarDaoImpl().findAllCar();
        assert cars != null;
    }

    @Test
    public void delete(){
        new CarDaoImpl().removeCar("model");
        List<Car> cars = new CarDaoImpl().findAllCar();
        Car car = new SomeActions().getCarByModel("model");
        assert !cars.contains(car);
    }

    @Test
    public void edit(){
        new CarDaoImpl().editCar("BMW 2", 600, "new_model", 20);
        Car car = new SomeActions().getCarByModel("new_model");
        assert car.getPrice() == 20;
    }
}
