import React, { Component } from 'react';
import { Link } from "react-router-dom";

class NavBarLogOut extends Component {
    state = {  } 
    render() { 
        return (
            <div>
                <Link to="/">Home</Link>
                <Link to="/">Log Out</Link>
            </div>
        );
    }
}
 
export default NavBarLogOut;