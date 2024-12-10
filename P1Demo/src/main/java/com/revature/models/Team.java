package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

//Check the User model comments for notes on each annotation

@Component
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    @Column(nullable=false)
    private String teamName;

    @Column(nullable=false)
    private String teamLocation;

    //TODO: connection to user FK

    //boilerplate code-----------------------no args, all args, getter/setter, toString

    public Team() {
    }

    public Team(int teamId, String teamName, String teamLocation) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLocation = teamLocation;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLocation() {
        return teamLocation;
    }

    public void setTeamLocation(String teamLocation) {
        this.teamLocation = teamLocation;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamLocation='" + teamLocation + '\'' +
                '}';
    }
}
