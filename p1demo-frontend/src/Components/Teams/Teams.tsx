import { Container, Table } from "react-bootstrap"

export const Teams:React.FC = () => {


    //TODO: useEffect to send a GET request for teams on component load
    


    return(
        <Container>

            <h3>Teams:</h3>

            <Table>
                <thead>
                    <tr>
                        <th>Team Id</th>
                        <th>Team Name</th>
                        <th>Team Location</th>
                    </tr>
                </thead>
                <tbody>
                    {/* TODO: map() for teams gathere from the GET request */}
                </tbody>
            </Table>

        </Container>
    )

}