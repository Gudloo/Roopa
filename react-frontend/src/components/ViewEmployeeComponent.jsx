import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService'

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            employee: {}
        }
    }

    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.id).then( res => {
            this.setState({employee: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Employee Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Organisation Name: </label>
                            <div> { this.state.employee.org_Name }</div>
                        </div>
                        <div className = "row">
                            <label> Employee MailId: </label>
                            <div> { this.state.employee.emp_mail_Id }</div>
                        </div>
                        <div className = "row">
                            <label> Student Email ID: </label>
                            <div> { this.state.employee.student_id}</div>
                        </div>
                        <div className = "row">
                            <label> Verification Purpose: </label>
                            <div> { this.state.employee.cerrtificate_Verify}</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewEmployeeComponent
