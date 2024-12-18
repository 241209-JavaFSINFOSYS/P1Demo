package com.revature.services;

import com.revature.DAOs.AuthDAO;
import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //autowire the DAO
    private final AuthDAO authDAO;

    @Autowired
    public AuthService(AuthDAO authDAO){
        this.authDAO = authDAO;
    }

    //method that takes in a username/password and returns the matching User if found
    //AKA a login method
    public OutgoingUserDTO login(LoginDTO loginDTO, HttpSession session){

        //Use the DTO to find a User in the DB
        User u = authDAO.findByUsernameAndPassword(
                loginDTO.getUsername(), loginDTO.getPassword());

        //If no User is found, throw an exception
        if(u == null){
            //TODO: we could have made a custom "LoginFailedException"
            throw new IllegalArgumentException("No user found with those credentials");
        }

        //If a User is found, login was successful! Save their data to our session
        //This session is coming from the Controller layer
        //TODO: initialize the session

        session.setAttribute("userId", u.getUserId());
        session.setAttribute("username", u.getUsername());
        session.setAttribute("role", u.getRole());

        //Why store all this info in a session?

        /*
        -It lets us store User info that we can use to check if:
            -they're logged in
            -their role is appropriate for the functionality they want to access
            -personalize the app (use their name in the UI, etc.)
            -simplify our URLs!
                ex: use the stored userId in "findXByUserId" methods
                instead of passing it in the path variable
         */

        //Return an OutUserDTO to the controller
        return new OutgoingUserDTO(
                u.getUserId(), u.getUsername(), u.getRole(), u.getTeam());

    }

}
