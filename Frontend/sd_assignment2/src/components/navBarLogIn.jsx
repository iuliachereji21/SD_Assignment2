import React, { Component } from 'react';
import { Link } from "react-router-dom";

class NavBarLogIn extends Component {
    state = {  } 
    render() { 
        return (
            <div>
                <Link to="/">Home</Link>
                <Link to="/login">Login</Link>
            </div>
        );
    }
}
 
export default NavBarLogIn;