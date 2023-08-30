import React, { useState, useEffect } from 'react';
import { useParams,useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function VehicleEdit() {
    const params = useParams();
    const navigate=useNavigate();
    const [vehicleDetails, setVehicleDetails] = useState({location:{city:''}});

    useEffect(() => {
        console.log(params.vehicleId);
        axios.get(`http://localhost:8080/vehicle/getById/${params.vehicleId}`)
            .then((response) => {
                console.log(response.data);
                setVehicleDetails({ ...response.data });
            })
            .catch(error => {
                console.log(error);
            });
    }, [params.vehicleId]);

    let updateCar=()=>{
      //  console.log(vehicleDetails);
       // var vid=vehicleDetails.vid;
        axios.put(`http://localhost:8080/vehicle/updateVehicle?id=${vehicleDetails.vid}`,vehicleDetails)
        .then((res)=>{
            console.log(res);
            navigate("/vehicleadmin")
        })
        .catch((err)=>{
            console.log("Error updating vehicle:", err.response.data);
        })
        
    }
    return(
        <div>
            <form>
                <div className="mb-3">
                    <label htmlFor="brand" className="form-label">
                        Brand
                    </label>
                    <input
                        type="text"
                        className="form-control"
                        id="brand"
                        aria-describedby="emailHelp"
                        value={vehicleDetails.brand}
                        onChange={(event)=>{
                            setVehicleDetails({...vehicleDetails,brand:event.target.value})
                        }}
                    />

                </div>
                <div className="mb-3">
                    <label htmlFor="clr" className="form-label">
                    model
                    </label>
                    <input
                        type="text"
                        className="form-control"
                        id="clr"
                        value={vehicleDetails.model}
                        onChange={(event)=>{
                            setVehicleDetails({...vehicleDetails,model:event.target.value})
                        }}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="img" className="form-label">
                    category 
                    </label>
                    <input
                        type="text"
                        className="form-control"
                        id="img"
                        value={vehicleDetails.category}
                        onChange={(event)=>{
                            setVehicleDetails({...vehicleDetails,category:event.target.value})
                        }}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="model" className="form-label">
                    type
                    </label>
                    <input
                        type="text"
                        className="form-control"
                        id="model"
                        value={vehicleDetails.type}
                        onChange={(event)=>{
                            setVehicleDetails({...vehicleDetails,type:event.target.value})
                        }}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="production_year" className="form-label">
                        city
                    </label>
                    <input
                        type="text"
                        className="form-control"
                        id="production_year"
                        value={vehicleDetails.location.city}
                        onChange={(event)=>{
                            setVehicleDetails({...vehicleDetails.location,city:event.target.value})
                        }}
                    />
                </div>
                
                <div className="mb-3">
                    <label htmlFor="rate" className="form-label">
                        Rate
                    </label>
                    <input
                        type="text"
                        className="form-control"
                        id="crate"
                        value={vehicleDetails.rate}
                        onChange={(event)=>{
                            setVehicleDetails({...vehicleDetails,rate:event.target.value})
                        }}
                    />
                </div>

                <button type="button" className="btn btn-primary" onClick={updateCar}>
                    Submit
                </button>
            </form>

        </div>
    )
}