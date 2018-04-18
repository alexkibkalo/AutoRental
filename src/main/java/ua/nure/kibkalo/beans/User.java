package ua.nure.kibkalo.beans;


import java.io.Serializable;

public class User implements Serializable{
    private String username;
    private String password;
    private int count;
    private String status;

    /*Конструктор по умолчанию для класса User*/
    public User() {}

    /*Конструктор принимающий параметр имя пользователя String, для класса User*/
    public User(String username){
        this.username = username;
    }

    /*Конструктор принимающий  имя пользователя String, пароль String, счет Integer, статус String, для класса User*/
    public User(String username, String password, int count, String status) {
        this.username = username;
        this.password = password;
        this.count = count;
        this.status = status;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
