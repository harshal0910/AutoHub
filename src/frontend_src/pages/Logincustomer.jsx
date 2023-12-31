import React , {useState}from 'react'
import { useNavigate } from 'react-router-dom';

import Axios from 'axios';

 function Logincustomer() {
  const[email, setEmail]=useState('');
    const[password, setPassword]=useState('');
    const navigate=useNavigate();
    const handlelogin=(e)=>{
         e.preventDefault();
               Axios.post('http://localhost:8080/customer/logincustomer',{
                email,
                password
               }).then((response) => {
                console.log(response)
                if (response.status>=200) {
                  navigate("/vehicle")
                } else {
                  alert(response.data.message);
                }
              }).catch((error) => {
                alert(error.response.data.message);
              });
    }
    
  return (
    <div className='container' style={{paddingTop :100}}>
     
        <div className='container'>
      <div className='row'>
          <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
              <h2 className='text-center m-4'>Login as Customer</h2>
              <div className='mb-3'>
                    
                    <label htmlFor='email' className='form-label'>
                       Email
                    </label>
                    <input type={"email"} className="form-control" placeholder="yourname@xyz.com" name="email" value={email} onChange={(e)=>setEmail(e.target.value)}/>
                    <label htmlFor='pass' className='form-label'>
                       Password
                    </label>
                    <input type={"password"} className="form-control" placeholder="password" name="pass" value={password} onChange={(e)=>setPassword(e.target.value)}/>
                   <button type="submit" className="btn btn-outline-success" onClick={handlelogin}>
                        Login
                   </button>
              </div>
          </div>
      </div>
    </div>

    </div>
      
  )
}

export default Logincustomer;