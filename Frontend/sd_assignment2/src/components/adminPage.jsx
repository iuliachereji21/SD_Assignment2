import React, { Component } from 'react';
import NavBarLogOut from './navBarLogOut';

class AdminPage extends Component {
    state = {  } 
    render() { 
        return (
            <div>
                <NavBarLogOut></NavBarLogOut>
                <h1>Admin page</h1>
            </div>
        
        );
    }
}
 
export default AdminPage;