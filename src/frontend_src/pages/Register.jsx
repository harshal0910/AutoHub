import React, { useState } from 'react';
import Axios from 'axios';
import {  useNavigate } from 'react-router-dom';

// eslint-disable-next-line import/no-anonymous-default-export
export default function () {

       const navigate=useNavigate();

    const[username, setUsername]=useState('')
    const[email, setEmail]=useState('')
    const[password, setPassword]=useState('')
    const[firstName,setFirst_Name]=useState('');
    const[lastName,setLast_Name]=useState('');
    const[creditCardDetails,setCredit_Card_Details]=useState('')
    const[contact,setContact]=useState('');
    const[drivingLicenseNumber,setDriving_License_Number]=useState('');
    const[address,setAddress]=useState('');

    const postData=(e)=>{
               e.preventDefault();
               alert("Data registered successfully!!")
               Axios.post('http://localhost:8080/customer/register',{
                
               address,
               contact,
               creditCardDetails,
               drivingLicenseNumber,
                email,
                firstName,
                lastName,
                password,
                username
               
               }).then((res) =>{ 
                console.log("data posted",res)
                 navigate("/logincustomer")
              }).catch(err => console.log(err))
    }
   

  return (
    <div>
      <div className='container'>
      <div className='row'>
          <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
              <h2 className='text-center m-4'>Register</h2>
              <div className='mb-3'>
                    <label htmlFor='uname' className='form-label'>
                       Username
                    </label>
                    <input type={"text"} className="form-control" placeholder="Enter username" name="uname" value={username} onChange={(e)=>setUsername(e.target.value)}/>
                    <label htmlFor='email' className='form-label'>
                       Email
                    </label>
                    <input type={"email"} className="form-control" placeholder="Enter valid email id" name="email" value={email} onChange={(e)=>setEmail(e.target.value)}/>
                    <label htmlFor='pass' className='form-label'>
                       Password
                    </label>
                    <input type={"password"} className="form-control" placeholder="Enter password" name="pass" value={password} onChange={(e)=>setPassword(e.target.value)}/>
                   
                    <label htmlFor='fname' className='form-label'>
                       First Name
                    </label>
                    <input type={"text"} className="form-control" placeholder="Enter First Name" name="fname" value={firstName} onChange={(e)=>setFirst_Name(e.target.value)}/>

                    <label htmlFor='lname' className='form-label'>
                       Last Name
                    </label>
                    <input type={"text"} className="form-control" placeholder="Enter Last Name" name="lname" value={lastName} onChange={(e)=>setLast_Name(e.target.value)}/>
                    
                    <label htmlFor='lname' className='form-label'>
                       Contact
                    </label>
                    <input type={"text"} className="form-control" placeholder="Enter Contact" name="lname" value={contact} onChange={(e)=>setContact(e.target.value)}/>
                    
                    <label htmlFor='ccd' className='form-label'>
                       Credit Card Details
                    </label>
                    <input type={"text"} className="form-control" placeholder="Enter Credit Card Details" name="ccd" value={creditCardDetails} onChange={(e)=>setCredit_Card_Details(e.target.value)}/>
                    
                    <label htmlFor='dln' className='form-label'>
                    Driving License Number
                    </label>
                    <input type={"text"} className="form-control" placeholder="Enter Driving License Number" name="dln" value={drivingLicenseNumber} onChange={(e)=>setDriving_License_Number(e.target.value)}/>
                    
                    <label htmlFor='dln' className='form-label'>
                    Address
                    </label>
                    <input type={"text"} className="form-control" placeholder="Enter  Address" name="dln" value={address} onChange={(e)=>setAddress(e.target.value)}/>
                   
                    <button type="submit" className="btn btn-outline-success" onClick={postData}>
                        Submit
                   </button>
                   <button type="submit" className="btn btn-outline-danger">
                        Reset
                   </button>
              </div>
          </div>
      </div>
    </div>
        
    </div>
  )
}