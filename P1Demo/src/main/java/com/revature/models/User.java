package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component //1 of the 4 stereotype annotations (makes the class a Bean)
@Entity //This annotation makes a DB table based on this Class
@Table(name = "users") //This annotation lets us specify properties (like table name)
public class User {

    @Id //This annotation makes the field a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This makes our PK auto-increment integers
    private int userId;

    //@Column isn't necessary UNLESS you want to set DB column name or constraints

    @Column(nullable = false) //This column MUST have a value on insert
    private String name;

    @Column(nullable = false)
    private String role = "player"; //Every new user will be a player by default

    //TODO: FK to team

    //boilerplate code-----------------------no args, all args, getter/setter, toString

    public User() {
    }

    public User(int userId, String name, String role) {
        this.userId = userId;
        this.name = name;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
