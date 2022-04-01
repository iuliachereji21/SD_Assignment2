import React, { Component, useEffect, useState } from 'react';
import { useParams} from 'react-router-dom';
import AddRestaurantDialog from './addRestaurantDialog';
import axios from 'axios'

function AdminRestaurants() {
    let {adminId} = useParams();
    adminId= adminId.slice(1);

    const [isAddRestaurantDialogOpen, setIsAddRestaurantDialogOpen]= useState(false);
    //let restaurants =[];
    // const [restaurants, setRestaurants]= useState([]);

    
    //     fetch(`http://localhost:8080/sd_assignment2/admin/${adminId}/restaurants`)
    //     .then(response =>{
    //         //setRestaurants(response.data);
    //         console.log(response);
    //         //restaurants = response.data;
    //         // if(response.data.customerId)
    //         //     navigate(`/customer/:${response.data.customerId}`);
    //         //this.setState({errorMessage : response.data.message})
    //     })
    //     .catch(({ response }) => { 
            
    //     });

    const [data, setData] = useState([]);
    const [value, setValue] = useState(0);
    let restaurants=[];

    // useEffect(()=>{
    //     fetch(`http://localhost:8080/sd_assignment2/admin/${adminId}/restaurants`)
    //       .then((response) => response.json())
    //       .then((json) => {
    //             restaurants=json;
    //             console.log("json: "+json);
    //             console.log("restaurants: "+restaurants);
                
                
    //             setData(restaurants);
    //       })
    //       .catch(e => console.error(e));
    // },[value]);
  
    // useEffect(async () => {
    //     const result = await axios(
    //         `http://localhost:8080/sd_assignment2/admin/${adminId}/restaurants`,
    //     );
    
    //     setData(result.data);
    //   });
    
    //   useEffect(() => {
    //     async function fetchData() {
    //       // You can await here
    //       const response = await axios(
    //                 `http://localhost:8080/sd_assignment2/admin/${adminId}/restaurants`,
    //             );
    //       setData(response.data);
    //       console.log(response.data);
    //       console.log("THE DATA: "+data);
    //     }
    //     fetchData();
    //   }, [value]); // Or [] if effect doesn't need props or state

    //console.log(restaurants);
    
    //console.log("the data"+data);

    useEffect(()=>{
        axios.get(`http://localhost:8080/sd_assignment2/admin/${adminId}/restaurants`)
            .then(res =>{
                console.log(res);
                setData(res.data);
            })
            .catch(err =>{
                console.log(err);
            })
    },[])

    return (
        <div>
            <div>
                <ul>
                    {data.map(restaurant => (
                        <li key={restaurant.id}>{restaurant.name}</li>
                    ))}
                </ul>
            </div>
            <h1>Admin restaurants {adminId}</h1>
            <button onClick={()=>{setIsAddRestaurantDialogOpen(true)}}>Add</button>
            <AddRestaurantDialog 
                adminId = {adminId}
                isvisible = {isAddRestaurantDialogOpen} 
                onCancel = {()=>{setIsAddRestaurantDialogOpen(false)}}>
            </AddRestaurantDialog>
            <label>hehe3</label>
        </div>
      );
}

export default AdminRestaurants;