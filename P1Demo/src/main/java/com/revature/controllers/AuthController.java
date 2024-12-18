package com.revature.controllers;

import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    //autowire the service
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //uninitialized HttpSession (filled upon login)
    public static HttpSession session;

    //TODO: we could make getter/setter for this session so we don't break encapsulation

    @PostMapping
    public ResponseEntity<OutgoingUserDTO> login(@RequestBody LoginDTO loginDTO, HttpSession session){

        //NOTE: we have an HTTP Session coming in via parameters, inherently included in HTTP requests
        //This is a different session than the static one declared above
        //We're going to use it to help initialize our static session

        //send the loginDTO to the service
        OutgoingUserDTO user = authService.login(loginDTO);

        //If we get here, login was successful and we can create the session!
        AuthController.session = session; //the passed in session initializes our static session

        AuthController.session.setAttribute("userId", user.getUserId());
        AuthController.session.setAttribute("username", user.getUsername());
        AuthController.session.setAttribute("role", user.getRole());

        System.out.println("User " + user.getUsername() + " logged in!");

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

        //Return the user info to the client
        return ResponseEntity.ok(user);

    }


    //TODO: We've duplicated this exc handling code
    //Which tells us we should probably make a global exception handler instead

    //Exception Handling for IllegalArgExc
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e){

        //If an IllegalArgument is thrown, send back a 400 (bad request)
        //with the Exception message in the response body
        return ResponseEntity.badRequest().body(e.getMessage());

    }


}
