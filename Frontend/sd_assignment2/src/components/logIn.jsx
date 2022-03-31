import React, { Component } from 'react';
import axios from 'axios'
import { Link, Navigate } from "react-router-dom";

class LogIn extends Component {
    state = { 
        errorMessage : "",
        loggedIn: false
    } 
    handleSubmit = (event) => {
        // Prevent page reload
        event.preventDefault();
        var { uname, pass} = document.forms[0];
        axios.post("http://localhost:8080/sd_assignment2/login",{username: uname.value, password: pass.value})
        .then(response =>{
            this.setState({loggedIn: true, userId: response.data.userId, customerId: response.data.customerId, adminId : response.data.adminId})
        })
        .catch(({ response }) => { 
            this.setState({errorMessage : response.data.message})
        })
      };
    render() { 
        if(this.state.loggedIn){
            if(this.state.customerId)
                return (<Navigate to='/customer' />);
            else return (<Navigate to='/admin' />);
        }
        return (
                <div className="form">
                    <form onSubmit= {this.handleSubmit}>
                        <div className="input-container">
                            <label>Username </label>
                            <input type="text" name="uname" required />
                            
                        </div>
                        <div className="input-container">
                            <label>Password </label>
                            <input type="password" name="pass" required />
                        
                        </div>
                        <div>
                            <label>{this.state.errorMessage} </label>
                        </div>
                        <div className="button-container">
                            <Link to="/register">Register</Link>
                            <input type="submit" value="log in" />
                        </div>
                    </form>
                    
                </div>
        );
    }
}
 
export default LogIn;