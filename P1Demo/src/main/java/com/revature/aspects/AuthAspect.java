package com.revature.aspects;

import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect //This Class is an ASPECT - a class that can trigger functionality at any point in our application
//When a certain method is called, this class can listen for that, and trigger some method invocation
@Component
public class AuthAspect {

    //2 use cases we'll see:
        //1) When any method in the controller is called, we'll check if the user is logged in first
            //We can bypass this check for login/register though
        //2) When a method with our custom @AdminOnly annotation is called, check that the user is a manager




}
