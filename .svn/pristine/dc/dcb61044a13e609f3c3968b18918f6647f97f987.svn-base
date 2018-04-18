package ua.nure.kibkalo.database.DAO.Car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.beans.Car;
import ua.nure.kibkalo.database.ConnectionDB;
import ua.nure.kibkalo.utils.SomeActions;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    private static final Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);

    @Override
    public List<Car> findAllCar() {
        List<Car> cars = new ArrayList<>();

        String sql_search = "SELECT * FROM autoproject.cars;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        Car car = null;

        connection = ConnectionDB.getConnection();
        try{
            statement = connection.prepareStatement(sql_search);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                car = new Car();
                car.setModel(resultSet.getString("name"));
                car.setPrice(Integer.parseInt(resultSet.getString("price")));
                car.setImage(resultSet.getBytes("img"));
                car.setPower(Double.parseDouble(resultSet.getString("power")));
                car.setFuel_consumption(Integer.parseInt(resultSet.getString("fuel_consumption")));
                car.setQualityClass(resultSet.getString("quality_class"));
                cars.add(car);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            SomeActions.closeActions(statement, resultSet, connection);
        }
        return cars;
    }

    @Override
    public void addNewCar(String model, Integer price, Double power, Integer fc, String qc, Part img) {
        logger.info("Method addNew car is working...");
        String sql_insert = "INSERT INTO autoproject.cars (name, price, img, power, fuel_consumption, quality_class) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = null;
        Connection connection = ConnectionDB.getConnection();
        InputStream inputStream = null;
        ResultSet resultSets = null;

        if(img != null){
            try {
                inputStream = img.getInputStream();
                logger.info("initialised inputStream with img bytes.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            statement = connection.prepareStatement(sql_insert);
            statement.setString(1, model);
            statement.setString(2, price.toString());

            if(inputStream != null){
                statement.setBlob(3, inputStream);
            }
            statement.setString(4, power.toString());
            statement.setString(5, fc.toString());
            statement.setString(6, qc);

            int res = statement.executeUpdate();
            if(res > 0){
                logger.info("File " + img.getName() + " uploaded and saved into ua.nure.kibkalo.database");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SomeActions.closeActions(statement, resultSets, connection);
        }
    }

    @Override
    public void removeCar(String model) {
        String sql_remove = "DELETE FROM autoproject.cars WHERE name=?;";
        PreparedStatement statement = null;
        Connection connection = ConnectionDB.getConnection();
        ResultSet rs = null;

        try{
            statement = connection.prepareStatement(sql_remove);
            statement.setString(1, model);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            SomeActions.closeActions(statement, rs, connection);
        }
    }

    @Override
    public void editCar(String old_model, Integer old_price, String new_model, Integer new_price) {
        String sql_change = "UPDATE autoproject.cars SET name=?, price=? WHERE name=? and price=?;";
        PreparedStatement statement = null;
        Connection connection = ConnectionDB.getConnection();
        ResultSet rs = null;

        try{
            statement = connection.prepareStatement(sql_change);
            statement.setString(1, new_model);
            statement.setString(2, new_price.toString());
            statement.setString(3, old_model);
            statement.setString(4, old_price.toString());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            SomeActions.closeActions(statement, rs, connection);
        }
    }
}
