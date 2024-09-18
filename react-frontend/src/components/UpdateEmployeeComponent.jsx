import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService';

class UpdateEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            org_Name: '',
            emp_mail_Id: '',
            student_id: '',
            cerrtificate_Verify:''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.updateEmployee = this.updateEmployee.bind(this);
    }

    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.id).then( (res) =>{
            let employee = res.data;
            this.setState({org_Name: employee.org_Name,
                emp_mail_Id: employee.emp_mail_Id,
                student_id : employee.student_id,
                cerrtificate_Verify :employee.cerrtificate_Verify
            });
        });
    }

    updateEmployee = (e) => {
        e.preventDefault();
        let employee = {org_Name: this.state.org_Name, emp_mail_Id: this.state.emp_mail_Id, student_id: this.state.student_id, cerrtificate_Verify: this.state.cerrtificate_Verify};
        console.log('employee => ' + JSON.stringify(employee));
        console.log('id => ' + JSON.stringify(this.state.id));
        EmployeeService.updateEmployee(employee, this.state.id).then( res => {
            this.props.history.push('/employees');
        });
    }
    
    changeFirstNameHandler= (event) => {
        this.setState({org_Name: event.target.value});
    }

    changeLastNameHandler= (event) => {
        this.setState({emp_mail_Id: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({student_id: event.target.value});
    }

    changePuposeHandler= (event) => {
        this.setState({cerrtificate_Verify: event.target.value});
    }


    cancel(){
        this.props.history.push('/employees');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Employee</h3>
                                <div className = "card-body">
                                    <form>
                                    <div className = "form-group">
                                            <label> Organisation Name: </label>
                                            <input placeholder="Organisation Name" name="org_Name" className="form-control" 
                                                value={this.state.org_Name} onChange={this.changeFirstNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Employee MailID </label>
                                            <input placeholder="Employee Mail_Id" name="emp_mail_Id" className="form-control" 
                                                value={this.state.emp_mail_Id} onChange={this.changeLastNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label>Student MailId: </label>
                                            <input placeholder="Student Mail_Id" name="student_id" className="form-control" 
                                                value={this.state.student_id} onChange={this.changeEmailHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Verification Purpose </label>
                                            <input placeholder="Verification Purpose" name="cerrtificate_Verify" className="form-control" 
                                                value={this.state.cerrtificate_Verify} onChange={this.changePuposeHandler}/>
                                        </div>


                                        <button className="btn btn-success" onClick={this.updateEmployee}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateEmployeeComponent
