package ua.nure.kibkalo.utils;

import ua.nure.kibkalo.beans.Car;
import ua.nure.kibkalo.beans.User;
import ua.nure.kibkalo.database.DAO.Car.CarDaoImpl;
import ua.nure.kibkalo.database.DAO.User.UserDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SomeActions {

    private List<Car> cars = new CarDaoImpl().findAllCar();
    private List<User> users = new UserDaoImpl().getAllUser();

    /*Метод для закрытия поток выполнения, входящие параметры объекты: PreparedStatement, ResultSet, Connection*/
    public static void closeActions(PreparedStatement statement, ResultSet rs, Connection connection){
        try {
            if (statement != null)
                statement.close();
            if (rs != null)
                rs.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Метод для получения цены по модели автомобиля, возвращает Integer, входящие параметры модель автомобиля String*/
    public Integer getPriceAcrossModel(String model){
        for(Car car : cars){
            if(car.getModel().equals(model)){
                return car.getPrice();
            }
        }
        return 0;
    }

    /*Метод для получения счета пользователя по его имени, возвращает Integer, входящие параметры имя пользователя String*/
    public Integer getCountAcrossName(String username){
        for(User user : users){
            if(username.equals(user.getUsername())){
                return user.getCount();
            }
        }
        return 0;
    }

    /*Метод для проверки наличия пустых полей при заполнении форм, возвращает Integer, входящие параметры:
     *модель автомобиля String, имя мользователя String, фамилия пользователя String, количество дней для заказа автомобиля Integer,
     *адрес почты String, данные паспорта String, наличие водителя String*/
    public int Test(String model, String name, String surname, Integer day, String email, String passport, String isDriver){
        if(!model.isEmpty()
                && !name.isEmpty()
                && !surname.isEmpty()
                && !email.isEmpty()
                && !passport.isEmpty()
                && !isDriver.isEmpty()
                && !day.toString().isEmpty()){
            return 1;
        }else
            return -1;
    }

    /*Метод для получения автомобиля(объекта) по его модели, возвращает Car, входящие параметры модель автомобиля String*/
    public Car getCarByModel(String model){
        for(Car car : cars){
            if(car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }

    /*Метод для получения пользователя(объекта) по его имени, возвращает User, входящие параметры имя пользователя String*/
    public User getUserByName(String name){
        for(User user : users){
            if(user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }
}
