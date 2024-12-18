import axios from "axios"
import { useState } from "react"
import { Button, Container, Form } from "react-bootstrap"
import { useNavigate } from "react-router-dom"

export const Login:React.FC = () => {

    //state object that stores username and password
    const [loginCreds, setLoginCreds] = useState({
        username:"",
        password:""
    })


    //we can use the useNavigate hook to navigate between components programatically
        //(which means we don't have to manually change the URL to switch components)
    const navigate = useNavigate()

    //function that stores user input for username/password
    const storeValues = (event:React.ChangeEvent<HTMLInputElement>) => {

        //very similar to what we did in Register.tsx - check that for notes

        const name = event.target.name //the name of the input box
        const value = event.target.value //the value of the input box

        setLoginCreds((loginCreds)=>({...loginCreds, [name]:value}))

    }

    //function that sends the user credentials to the backend
    //navigates to /teams if the user is a player, and /users if the user is a manager
    const login = async () => {

        //TODO: make sure the username and password are present before proceeding

        //use the username/password from the state object
        const response = await axios.post("http://localhost:4444/auth", loginCreds, {withCredentials:true}) //withCredentials lets us interact with sessions on the BackEnd
        .then(

            (response) => {
                console.log(response)

                //TODO: save this data globally

                //players will get sent to the teams component, managers get sent to users
                if(response.data.role === "player"){
                    navigate("/teams")
                } else {
                    navigate("/users")
                }

            }

        )

    }


    return(
        <Container className="d-flex align-items-center flex-column mt-5">
            <h3>Login</h3>

            <div>
                <Form.Control
                    type="text"
                    placeholder="username"
                    name="username"
                    onChange={storeValues}
                />
            </div>
            <div>
                <Form.Control
                    type="password"
                    placeholder="password"
                    name="password"
                    onChange={storeValues}
                />
            </div>

            <div className="d-flex gap-1">
                <Button onClick={login}>Login</Button>
                <Button onClick={()=>navigate("/register")}>Register</Button>
            </div>

        </Container>
    )

}