import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import Home from "../pages/Home";
import Login from "../pages/loginAdmin.jsx";
import Logincustomer from "../pages/Logincustomer.jsx";
import Location from "../pages/Location";
import Vehicle from "../pages/Vehicles";
import Register from "../pages/Register.jsx";
import Vehicleadmin from "../pages/VehicleAdmin.jsx";
import Vehicleedit from "../pages/VehicleEdit.jsx";
import Vehicleform from "../pages/VehicleForm.jsx";
import About from "../pages/About";
import CarListing from "../pages/CarListing";
import CarDetails from "../pages/CarDetails";
import Blog from "../pages/Blog";
import BlogDetails from "../pages/BlogDetails";
import NotFound from "../pages/NotFound";
import Contact from "../pages/Contact";

const Routers = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/home" />} />
      <Route path="/home" element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="/cars" element={<CarListing />} />
      <Route path="/cars/:slug" element={<CarDetails />} />
      <Route path="/blogs" element={<Blog />} />
      <Route path="/blogs/:slug" element={<BlogDetails />} />
      <Route path="/contact" element={<Contact />} />
      <Route path="/Login" element={<Login />} />
      <Route path="/logincustomer" element={<Logincustomer />} />
      <Route path="/vehicle" element={<Vehicle />} />
      <Route path="/location" element={<Location />} />
      <Route path="/vehicleadmin" element={<Vehicleadmin />} />
      <Route path="/form" element={<Vehicleform />} />
      <Route path="/edit/:vehicleId" element={<Vehicleedit />}/>
      <Route path="/register" element={<Register />} />
      
      <Route path="*" element={<NotFound />} />
    </Routes>
  );
};

export default Routers;
