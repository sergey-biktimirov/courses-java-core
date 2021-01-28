package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.app.security;

public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
}
