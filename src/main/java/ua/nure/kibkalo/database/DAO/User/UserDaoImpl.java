package ua.nure.kibkalo.database.DAO.User;

import ua.nure.kibkalo.beans.User;
import ua.nure.kibkalo.database.ConnectionDB;
import ua.nure.kibkalo.utils.SomeActions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public User checkUserConnection(String login) {
        String sql = "SELECT * FROM autoproject.users WHERE login=?;";
        PreparedStatement statement = null;
        ResultSet rs = null;
        Connection connection = null;

        User user = null;

        connection = ConnectionDB.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            rs = statement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SomeActions.closeActions(statement, rs, connection);
        }
        return user;
    }

    @Override
    public boolean createNewUser(String login, String pass) throws SQLException {
        String sql_insert = "INSERT INTO autoproject.users (login, password, count, status) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = null;
        Connection connection = ConnectionDB.getConnection();

        ResultSet resultSets = null;
        String sql_find = "SELECT * FROM autoproject.users WHERE login=? OR password=?;";
        User user = null;
        boolean flag = false;
        int count = (int) (Math.random()*1000);
        try {
            statement = connection.prepareStatement(sql_find);
            statement.setString(1, login);
            statement.setString(2, pass);
            resultSets = statement.executeQuery();
            while (resultSets.next()) {
                user = new User();
                user.setUsername(resultSets.getString("login"));
                user.setPassword(resultSets.getString("password"));
                user.setCount((int) (Math.random() * 3000));
            }
            if(user == null) {
                statement = connection.prepareStatement(sql_insert);
                statement.setString(1, login);
                statement.setString(2, pass);
                statement.setString(3, Double.toString(count));
                statement.setString(4, "unlocked");
                statement.executeUpdate();
                flag = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SomeActions.closeActions(statement, resultSets, connection);
        }
        return flag;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();

        String sql_search = "SELECT * FROM autoproject.users;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        User user = null;

        connection = ConnectionDB.getConnection();

        try{
            statement = connection.prepareStatement(sql_search);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setCount(resultSet.getInt("count"));
                user.setStatus(resultSet.getString("status"));
                users.add(user);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            SomeActions.closeActions(statement, resultSet, connection);
        }
        return users;
    }

    @Override
    public void countUpdate(Integer count, String username) {
        String sql_change = "UPDATE autoproject.users SET count=? WHERE login=?;";
        PreparedStatement statement = null;
        Connection connection = ConnectionDB.getConnection();
        ResultSet rs = null;

        try{
            statement = connection.prepareStatement(sql_change);
            statement.setInt(1, count);
            statement.setString(2, username);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            SomeActions.closeActions(statement, rs, connection);
        }
    }

    @Override
    public void addManager(String login, String password) {
        String sql_insert = "INSERT INTO autoproject.users (login, password) VALUES (?, ?);";
        PreparedStatement statement = null;
        Connection connection = ConnectionDB.getConnection();
        ResultSet resultSet = null;

        CommonTryCatch(login, password, sql_insert, statement, connection, resultSet);
    }

    @Override
    public void statusUpdate(String new_status, String username) {
        String sql_change = "UPDATE autoproject.users SET status=? WHERE login=?;";
        PreparedStatement statement = null;
        Connection connection = ConnectionDB.getConnection();
        ResultSet rs = null;

        CommonTryCatch(new_status, username, sql_change, statement, connection, rs);
    }

    @Override
    public void CommonTryCatch(String parametr1, String parametr2, String sql, PreparedStatement statement, Connection connection, ResultSet rs) {
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1, parametr1);
            statement.setString(2, parametr2);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            SomeActions.closeActions(statement, rs, connection);
        }
    }
}
