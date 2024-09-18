import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService';

class CreateEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            org_Name: '',
            emp_mail_Id: '',
            student_id: '',
            cerrtificate_Verify:''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            EmployeeService.getEmployeeById(this.state.id).then( (res) =>{
                let employee = res.data;
                this.setState({org_Name: employee.org_Name,
                    emp_mail_Id: employee.emp_mail_Id,
                    student_id : employee.student_id,
                    cerrtificate_Verify :employee.cerrtificate_Verify
                });
            });
        }        
    }
    saveOrUpdateEmployee = (e) => {
        e.preventDefault();
        let employee = {org_Name: this.state.org_Name, emp_mail_Id: this.state.emp_mail_Id, student_id: this.state.student_id, cerrtificate_Verify: this.state.cerrtificate_Verify};
        console.log('employee => ' + JSON.stringify(employee));

        // step 5
        if(this.state.id === '_add'){
            EmployeeService.createEmployee(employee).then(res =>{
                this.props.history.push('/employees');
            });
        }else{
            EmployeeService.updateEmployee(employee, this.state.id).then( res => {
                this.props.history.push('/employees');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Employee</h3>
        }else{
            return <h3 className="text-center">Update Employee</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container" >
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEmployee}>Save</button>
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

export default CreateEmployeeComponent
