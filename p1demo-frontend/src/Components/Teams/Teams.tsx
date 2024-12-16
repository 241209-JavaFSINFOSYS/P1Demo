import axios from "axios"
import { useEffect, useState } from "react"
import { Button, Container, Table } from "react-bootstrap"

//interface to model Team objects 
interface Team {
    teamId:number,
    teamName:string,
    teamLocation:string
}

export const Teams:React.FC = () => {

    //We'll store a state object that holds an Array of Team objects.
    //This will get filled after the GET request
    const [teams, setTeams] = useState<Team[]>([])

    //useEffect to send a GET request for teams on component load
    useEffect(()=>{
        getAllTeams()
    }, []) //this useEffect will trigger once, on component load

    //The function that sends the GET request
    const getAllTeams = async () => {

        //axios GET request
        const response = await axios.get("http://localhost:4444/teams")

        //populate the teams state object
        setTeams(response.data)

        console.log(response.data) //data holds the actual data stored in the response body 

    }

    return(
        <Container>

            <h3>Teams:</h3>

            <Table>
                <thead>
                    <tr>
                        <th>Team Id</th>
                        <th>Team Name</th>
                        <th>Team Location</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>
                    {/*map() for teams gather from the GET request */}
                    {teams.map((team:Team) => (
                        <tr>
                            <td>{team.teamId}</td>
                            <td>{team.teamName}</td>
                            <td>{team.teamLocation}</td>
                            <td>
                                <Button className="btn-danger">Delete</Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>

        </Container>
    )

}