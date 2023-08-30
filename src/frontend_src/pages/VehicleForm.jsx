import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

 const VehicleForm=(props)=>{

    let [vehicle,setVehicleDetails]=useState({brand:"",model:"",category:"",vehicleType:"",city:"",rate:"",insurance:""});
    const navigate=useNavigate();
    let addVehicle=()=>{
        console.log("inside addVehicle");
        if(vehicle.brand===""||vehicle.model===""||vehicle.category===""||vehicle.category===""||vehicle.type===""||vehicle.city===""||vehicle.rate===""||vehicle.insurance===""){
            alert("fields cant be blank");
            return;
        }

        axios.post("http://localhost:8080/vehicle/addvehicle",vehicle)
        .then((result)=>{
            console.log(result)
             setVehicleDetails({brand:"",model:"",category:"",type:"",city:"",rate:"",insurance:""})
            navigate("/vehicleadmin");
        })
        .catch((err)=>{
            console.log("error occured"+err);
        })
    }


    return(
        <div>
            <form>
                <h1>Vehicle Form</h1>
                    <div className="form-group">
                        <label htmlFor="brand">Brand</label>
                        <input type="text" className="form-control" id="brand" name="brand" 
                         value={vehicle.brand}
                         onChange={(event)=>{setVehicleDetails({...vehicle,brand:event.target.value})}}   
                        />                  
                    </div>
                    
                    <div className="form-group">
                        <label htmlFor="model">Model</label>
                        <input type="text" className="form-control" id="model" name="model"
                        value={vehicle.model}
                         onChange={(event)=>{setVehicleDetails({...vehicle,model:event.target.value})}}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="category">Category</label>
                        <input type="text" className="form-control" id="category" name="category"
                        value={vehicle.category}
                         onChange={(event)=>{setVehicleDetails({...vehicle,category:event.target.value})}}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="ename">Type</label>
                        <input type="text" className="form-control" id="type" name="type"
                        value={vehicle.vehicleType}
                         onChange={(event)=>{setVehicleDetails({...vehicle,vehicleType:event.target.value})}}
                        />
                    </div>
                    
                    <div className="form-group">
                        <label htmlFor="city">City</label>
                        <input type="text" className="form-control" id="city" name="city"
                        value={vehicle.city}
                         onChange={(event)=>{setVehicleDetails({...vehicle,city:event.target.value})}}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="rate">Rate</label>
                        <input type="text" className="form-control" id="rate" name="rate"
                        value={vehicle.rate}
                         onChange={(event)=>{setVehicleDetails({...vehicle,rate:event.target.value})}}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="insurance">Insurance</label>
                        <input type="text" className="form-control" id="insurance" name="insurance"
                        value={vehicle.insurance}
                         onChange={(event)=>{setVehicleDetails({...vehicle,insurance:event.target.value})}}
                        />
                    </div>
                    <button type="button" className="btn btn-primary" onClick={()=>{addVehicle()}}>Add vehicle</button>
           </form>
        </div>
      )
}
export default VehicleForm;