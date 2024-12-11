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

    //TODO: password field

    @Column(nullable = false)
    private String role = "player"; //Every new user will be a player by default

    /* FK to team (every user has a team - many users can belong to one team)
    *
    * fetch - defines when the Dependency is loaded
        * LAZY = loads dependency only when it's called
        * EAGER = loads dependency at runtime (I usually use this)
    * @JoinColumn - defines the column that will be used to link these tables in the DB
        * We have to provide the name of the PK field in Team */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teamId") //This links our FK to the PK in Team (teamId)
    private Team team;

    //boilerplate code-----------------------no args, all args, getter/setter, toString

    public User() {
    }

    public User(int userId, String name, String role, Team team) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.team = team;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", team=" + team +
                '}';
    }
}
