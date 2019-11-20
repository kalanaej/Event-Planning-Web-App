package payment.service;

import java.util.ArrayList;

import java.util.logging.Logger;

import payment.model.Payment;

public interface IPayment {
		
		//Add payments to payment table
		public void addPaymentDetails(Payment payment);
		
		//Remove added particular payment
		public void removePayment(String paymentID);
		
		//Update added particular payment
		public Payment updatePaymentDetails(String paymentID, Payment payment);
		
		//Get a particular payment for update
		public Payment GetPayments(String paymentID);
		
		//Get all payment list
		public ArrayList<Payment> listPayments();
}
