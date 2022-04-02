import React, { useState, useEffect } from 'react';
import { useParams, Link} from 'react-router-dom';
import axios from 'axios'
import AddFoodDialog from './addFoodDialog';

function AdminRestaurantPage() {
    let {restaurantId} = useParams();
    restaurantId= restaurantId.slice(1);
    let {adminId} = useParams();
    adminId= adminId.slice(1);

    const [data, setData] = useState([]);
    const [isAddFoodDialogOpen, setIsAddFoodDialogOpen]= useState(false);

    useEffect(()=>{
        axios.get(`http://localhost:8080/sd_assignment2/admin/${adminId}/restaurants/${restaurantId}`)
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
            Admin restaurant page {restaurantId}
            <button onClick={()=>{setIsAddFoodDialogOpen(true)}}>Add</button>
            <AddFoodDialog 
                restaurantId = {restaurantId}
                adminId = {adminId}
                isvisible = {isAddFoodDialogOpen} 
                onSave = {(obj)=>{
                    console.log(obj);
                    data.push(obj);
                    setIsAddFoodDialogOpen(false)
                    console.log("on Save");
                }}
                onCancel = {()=>{
                    setIsAddFoodDialogOpen(false);
                    }}>
            </AddFoodDialog>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Category</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((food)=>(
                        <tr>
                            <td>{food.id}</td>
                            <td>{food.name}</td>
                            <td>{food.description}</td>
                            <td>{food.price}</td>
                            <td>{food.category}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
     );
}

export default AdminRestaurantPage;