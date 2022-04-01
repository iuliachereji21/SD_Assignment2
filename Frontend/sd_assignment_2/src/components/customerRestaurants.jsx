import React, { Component } from 'react';
import { useParams } from 'react-router-dom';
function CustomerRestaurants() {
    let {customerId} = useParams();
    customerId= customerId.slice(1);
    return (
        <div>
            <h1>Customer restaurants {customerId}</h1>
        </div>
      );
}

export default CustomerRestaurants;