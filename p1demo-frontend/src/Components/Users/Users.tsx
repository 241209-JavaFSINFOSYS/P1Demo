import axios from "axios"
import { useEffect, useState } from "react"
import { Container, Table } from "react-bootstrap"

//TODO: User Interface for type safety

export const Users:React.FC  = () => {

    //state object to store the User Array from the DB
    const [users, setUsers] = useState([])

    //useEffect to call the get request to get all users on component load
    useEffect(()=>{
        getAllUsers()
    }, []) //[] so that this runs only once, when the component re-renders



    //Function to get all users 
    const getAllUsers = async () => {

        const response = await axios.get("http://localhost:4444/users")
        .then((response)=>{
            console.log(response)
            setUsers(response.data)
        })

    }


    return(
        <Container>

            <Table className="table-primary table-hover">
                <thead>
                    <tr>
                        <th>User Id</th>
                        <th>Username</th>
                        <th>Role</th>
                        <th>Team Name</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>
                    {/* TODO: map thru selected users */}
                </tbody>
            </Table>

            {/* TODO: if no users, say that */}

        </Container>
    )

}