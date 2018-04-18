package ua.nure.kibkalo.database.DAO.Car;

import ua.nure.kibkalo.beans.Car;

import javax.servlet.http.Part;
import java.util.List;

interface CarDao {

    /*Метод получения всех автомобилей из базы данных, возвращаемый параметр List<Car>*/
    List<Car> findAllCar();

    /*Метод добавления автомобиля в базу данных параметры: модель автомобиля String, цена автомобиля Integer,
     *мощность автомобиля String, расход топлива автомобиля Integer, класс качества автомобиля String, фотография автомобиля Part*/
    void addNewCar(String model, Integer price, Double power, Integer fc, String qc, Part img);

    /*Метод удаления автомобиля в базу данных входящий параметр модель автомобиля String*/
    void removeCar(String model);

    /*Метод редкатирования автомобиля в базе данных, входящие параметры: старая модель автомобиля String,
     *новая модель автомобиля введена пользователем в форме String, старая цена автомобиля Integer, новая цена автомобиля Integer*/
    void editCar(String old_model, Integer old_price, String new_model, Integer new_price);

}
