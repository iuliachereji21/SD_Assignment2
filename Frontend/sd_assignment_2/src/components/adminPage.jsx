import React from 'react';
import { useParams } from 'react-router-dom';
import NavBarLogOut from './navBarLogOut';

function AdminPage() {
    let {adminId} = useParams();
    return (
        <div>
            <NavBarLogOut/>
            <h1>Admin page {adminId}</h1>
        </div>
      );
}

export default AdminPage;