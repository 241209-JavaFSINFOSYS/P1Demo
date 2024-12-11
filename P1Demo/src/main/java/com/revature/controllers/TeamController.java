package com.revature.controllers;

//The Controller layer handles HTTP Requests (sends back HTTP responses!)

import com.revature.models.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Combines @Controller and @ResponseBody
@RequestMapping("/teams") //All HTTP requests ending in /teams will be sent here
//TODO: Add @CrossOrigin annotation to allow HTTP from anywhere
public class TeamController {

    //TODO: Add a service layer

    //Insert a new Team (any POST request ending in /teams will invoke this method)
    @PostMapping
    public ResponseEntity<Team> insertTeam(@RequestBody Team team) {

        //TODO: send team to the service which will send it to the DAO

        return ResponseEntity.ok(team);

        //ResponseEntity helps us build an HTTP Response
        //.ok() sets the status code to 200
        //we send the team object back in the response body

    }

}
