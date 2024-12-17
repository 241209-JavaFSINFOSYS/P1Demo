import { SyntheticEvent } from "react"
import { Button, Container, Form } from "react-bootstrap"

export const Register:React.FC = () => {


    //function that stores values when input boxes change
    //SyntheticEvent is just the type of event coming in, we didn't need to specify data type, I'm just being typesafe
    const storeValues = (event:SyntheticEvent) => {

        console.log(event)

    }

    return(
        <Container className="d-flex align-items-center flex-column mt-5">
            <h3>Register</h3>

            {/* Making a separate div for each input box */}
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
                <Button>Back</Button>
                <Button>Register</Button>
            </div>

        </Container>
    )

}