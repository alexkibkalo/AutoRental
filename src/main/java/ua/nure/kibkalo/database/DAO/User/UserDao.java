package ua.nure.kibkalo.database.DAO.User;

import ua.nure.kibkalo.beans.User;

import java.sql.SQLException;
import java.util.List;

interface UserDao {

    /*Метод для авторизации пользователя, входящий параметр login, возвращает обїект типа User*/
    User checkUserConnection(String login);

    /*Метод создает нового пользователя входящие параметры: логин String, пароль String, возвращает значение boolean*/
    boolean createNewUser(String login, String pass) throws SQLException;

    /*Метод получения всех пользователей из базы данных, возвращаемый параметр List<User>*/
    List<User> getAllUser();

    /*Метод обновляет счет пользователя, входящие параметры счет пользователя Integer, имя пользователя String*/
    void countUpdate(Integer count, String username);

    /*Метод добавление менеджера, входящие параметры: логин String, пароль-метка String*/
    void addManager(String login, String password);

    /*Метод обновление статуса пользователя blocked/unlocked, входящие параметры новый статус спользователя String,
     *имя пользователя String*/
    void statusUpdate(String new_status, String username);

}
