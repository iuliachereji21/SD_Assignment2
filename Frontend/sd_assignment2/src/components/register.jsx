import React, { Component } from 'react';
import axios from 'axios'
import { Link } from "react-router-dom";
import NavBarLogIn from './navBarLogIn';

class Register extends Component {
    state = { 
        errorMessage : ""
    } 
    handleSubmit = (event) => {
        // Prevent page reload
        event.preventDefault();
        var { uname, pass, rep_pass, phone} = document.forms[0];
        axios.post("http://localhost:8080/sd_assignment2/register",{username: uname.value, password: pass.value, repeated_password: rep_pass.value, phone: phone.value})
        .then(response =>{
            console.log(response);
            this.setState({errorMessage : response.data.message})
        })
        .catch(({ response }) => { 
            this.setState({errorMessage : response.data.message})
        })
      };
    render() { 
        return (
                <div>
                    <NavBarLogIn></NavBarLogIn>
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
                        <div className="input-container">
                            <label>Repeated password </label>
                            <input type="password" name="rep_pass" required />
                        
                        </div>
                        <div className="input-container">
                            <label>Phone </label>
                            <input type="text" name="phone"/>
                        
                        </div>
                        <div>
                            <label>{this.state.errorMessage} </label>
                        </div>
                        <div className="button-container">
                            <input type="submit" value="register" />
                        </div>
                    </form>
                    
                </div>
                </div>
                
        );
    }
}
 
export default Register;