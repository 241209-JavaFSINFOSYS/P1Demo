package com.revature.controllers;

//The Controller layer handles HTTP Requests (sends back HTTP responses!)

import com.revature.models.Team;
import com.revature.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Combines @Controller and @ResponseBody
@RequestMapping("/teams") //All HTTP requests ending in /teams will be sent here
//TODO: Add @CrossOrigin annotation to allow HTTP from anywhere
public class TeamController {

    //We're going to use constructor injection to dependency inject the Service
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    //Insert a new Team (any POST request ending in /teams will invoke this method)
    @PostMapping
    public ResponseEntity<Team> insertTeam(@RequestBody Team team) {

        //Send team to the service which will send it to the DAO
        Team newTeam = teamService.insertTeam(team);

        //Send back the returned Team object
        return ResponseEntity.ok(newTeam);

        //ResponseEntity helps us build an HTTP Response
        //.ok() sets the status code to 200
        //we send the team object back in the response body

    }

    //Select all Teams (any GET request ending in /teams will invoke this method)
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams(){

        //This time, I'll just do it in one line
        return ResponseEntity.ok(teamService.getAllTeams());

    }


    //Exception Handlers------------------------------

    //Spring MVC has a built in Exception handler that cleans up our Controller methods

    //Exception handler for IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e){

        //If an IllegalArgument is thrown, send back a 400 (bad request)
        //with the Exception message in the response body
        return ResponseEntity.badRequest().body(e.getMessage());

    }

}
