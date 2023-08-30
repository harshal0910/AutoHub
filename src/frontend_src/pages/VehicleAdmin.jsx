import React, {useState, useEffect} from 'react'
import axios from 'axios';
import {Link} from "react-router-dom";

export default function VehicleAdmin() {
    const [vehicle, setVehicle] = useState([]);

    let fetchdata=()=>{
      axios.get('http://localhost:8080/vehicle/getAll')
          .then((response) => {
            console.log("hello");
            console.log(response.data);
            setVehicle(response.data);
            console.log(vehicle);
          })
          .catch(error => {
            console.log("error occured "+error);
          });
    }

    useEffect(() => {
        fetchdata();
      }, []);
      
    
      const deleteVehicle = (id) => {
        axios.delete(`http://localhost:8080/vehicle/deleteVehicle?id=${id}`)
          .then(response => {
            console.log(response);
            fetchdata();
          })
          .catch(error => {
            console.log(error);
          });
      };

    
  return(
        <div>
      <h2 style={{paddingTop : 100}}>List of Vehicles</h2>
      <div className='container'>
        <div className='py-4'>
        <Link to='/form'>
              <button type="button" name="btn" id="btn" className="btn btn-success" >Add new vehicle</button>
            </Link><br/><br/>
        <table className="table border shadow">
  <thead>
    <tr>
    <th scope="col">Id</th>
    
      <th scope="col">Brand</th>
      <th scope="col">model</th>
      <th scope="col">category</th>
      <th scope="col">vehicleType</th>
      <th scope="col">city</th>
      <th scope="col">rate</th>

    </tr>
  </thead>
  <tbody>
    {
       vehicle.map((vehicle, index) => (
            <tr key={vehicle.id}>
             { <th scope="row" key={index}>{index+1}</th>}
              {/* <td><img src={vehicle.image} style={{width: 100, height: 60}}/></td> */}
              <td>{vehicle.brand}</td>
              <td>{vehicle.model}</td>
              <td>{vehicle.category}</td>
              <td>{vehicle.type}</td>
              <td>{vehicle.location.city}</td>
              <td>{vehicle.rate}</td>
              <td>
              <Link to={`/edit/${vehicle.vid}`} state={{vehicle:vehicle}} className='btn btn-warning mx-2'>Update</Link>&nbsp;
                  <button type='button' className='btn btn-danger mx-2' onClick={()=>{deleteVehicle(vehicle.vid)}}>Delete</button>
              </td>
            </tr>
          
          ))


    }
    </tbody>
</table>

        </div>
    </div>
    </div>
    
  )
}