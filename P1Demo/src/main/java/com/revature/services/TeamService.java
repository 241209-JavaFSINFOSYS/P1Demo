package com.revature.services;

//The Service layer is where we have our business logic
//User input validation, Data manipulation/reformatting, User authentication, etc.

import com.revature.models.Team;

public class TeamService {

    //TODO: autowire the DAO

    //This method inserts new Teams into the DB once they have been validated
    public Team insertTeam(Team team) {

        //Not too much to check, but we can make sure the values are valid

        if (team.getTeamName() == null || team.getTeamName().isBlank()){
            throw new IllegalArgumentException("Team name can't be null or blank!");
        }

        if (team.getTeamLocation() == null || team.getTeamLocation().isBlank()){
            throw new IllegalArgumentException("Team location can't be null or blank!");
        }

        //if none of these ifs get triggered, the Team is valid and can be sent to the DAO

        return team;

    }

}
