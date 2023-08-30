import React from "react";
import "../../styles/booking-form.css";
import { Form, FormGroup } from "reactstrap";

const BookingForm = () => {
  const submitHandler = (event) => {
    event.preventDefault();
  };
  return (
    <Form onSubmit={submitHandler}>
      <FormGroup className="booking__form d-inline-block me-4 mb-4">
      UserName <input type="text" placeholder="UserName" />
      </FormGroup>
     
      <FormGroup className="booking__form d-inline-block ms-1 mb-4">
      Vehicle Id <input type="number" placeholder="Vehicle Id" />
      </FormGroup>

      <FormGroup className="booking__form d-inline-block me-4 mb-4">
      Email <input type="email" placeholder="Email" />
      </FormGroup>
      <FormGroup className="booking__form d-inline-block me-4 mb-4">
       Pickup Address <input type="text" placeholder="From Address" />
      </FormGroup>

      <FormGroup className="booking__form d-inline-block me-4 mb-4">
      Start Date <input type="date" placeholder="Journey Date" />
      </FormGroup>
      <FormGroup className="booking__form d-inline-block me-4 mb-4">
      End Date <input type="date" placeholder="End Date" />
      </FormGroup>
      

      <FormGroup>
        <textarea
          rows={5}
          type="textarea"
          className="textarea"
          placeholder="Write"
        ></textarea>
      </FormGroup>
    </Form>
  );
};

export default BookingForm;
