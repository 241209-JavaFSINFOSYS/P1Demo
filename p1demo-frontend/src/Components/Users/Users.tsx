import { Container, Table } from "react-bootstrap"

export const Users:React.FC  = () => {


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

        </Container>
    )

}