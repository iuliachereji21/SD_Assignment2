import React, { Component } from 'react';
import { useParams } from 'react-router-dom';
function AdminOrders() {
    let {adminId} = useParams();
    adminId= adminId.slice(1);
    return (
        <div>
            <h1>Admin orders {adminId}</h1>
        </div>
      );
}

export default AdminOrders;