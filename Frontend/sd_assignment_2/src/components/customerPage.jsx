import React from 'react';
import { useParams } from 'react-router-dom';
import NavBarLogOut from './navBarLogOut';

function CustomerPage() {
    let {customerId} = useParams();
    return (
        <div>
            <NavBarLogOut/>
            <h1>Customer page {customerId}</h1>
        </div>
      );
}

export default CustomerPage;