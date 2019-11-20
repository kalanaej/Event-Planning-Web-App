package payment.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import payment.model.Payment;
import payment.service.IPayment;
import payment.service.PaymentHandle;
import payment.util.Constants;
import payment.util.DBConnect;
import payment.util.IDHandle;
import payment.util.QueryLocation;

public class PaymentHandle implements IPayment {

	//session between java application and database
	private static Connection con;

	
	//use to execute queries with the database
	private static Statement state;
	
	
	// use to execute parameterized query
	private PreparedStatement prepare;
	
	
	//writing log messages during the execution of a program
	public static final Logger log = Logger.getLogger(PaymentHandle.class.getName());
	
	
	/*
	 * Retrive payment Ids and balances from paymentQuery.xml
	 */
	private ArrayList<String> getBalanceAndPaymentIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			con = DBConnect.getDBConnection();
			
			prepare = con.prepareStatement(QueryLocation.paymentQueryIDs(Constants.GET_PAYMENT_IDS));
			prepare = con.prepareStatement(QueryLocation.paymentQueryIDs(Constants.GET_BALANCE));
			
			ResultSet resultSet = prepare.executeQuery();
			
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(Constants.COLUMN_ONE));
			}
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			System.out.println("Error from getPaymentIDs "+e);
		}
		
		return arrayList;
	}
	
	/*
	 * Use to add new payment details
	 * 
	 */
	@Override
	public void addPaymentDetails(Payment payment) {

		String paymentID = IDHandle.generateIDs(getBalanceAndPaymentIDs());
		String balance = IDHandle.generateBalance(getBalanceAndPaymentIDs());
		
		try {
			con = DBConnect.getDBConnection();
			
			/*prepare = con.prepareStatement(QueryLocation.paymentQueryIDs(Constants.VALIDATE_PAYMENTS));
			con.setAutoCommit(false);*/
		
			//Insert payment
			prepare = con.prepareStatement(QueryLocation.paymentQueryIDs(Constants.INSERT_PAYMENTS));
			
			/*
			 * use to set the commit status(true or false)
			 * SQL statement is treated as a transaction and will be automatically committed right after it is executed
			 */
			con.setAutoCommit(false);
			
			payment.setPaymentID(paymentID);
			payment.setBalance(balance);
			prepare.setString(Constants.COLUMN_ONE, payment.getPaymentID());
			prepare.setString(Constants.COLUMN_TWO, payment.getType());
			prepare.setString(Constants.COLUMN_THREE, payment.getCard());
			prepare.setString(Constants.COLUMN_FOUR, payment.getNumber());
			prepare.setString(Constants.COLUMN_FIVE, payment.getCvv());
			prepare.setString(Constants.COLUMN_SIX, payment.getEmail());
			prepare.setString(Constants.COLUMN_SEVEN, payment.getBalance());
			
			//use to execute queries that may return multiple results
			prepare.execute();
			
			//saves the changes made since the previous commit
			con.commit();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			System.out.println("Error from addPaymentDetails "+e);
		}finally {
			/*
			 * Close preparedstatement and database connection
			 */
			try {
				if (prepare != null) {
					prepare.close();
				}
				if (con != null) {
					//closes the connection and Releases a JDBC resources immediately
					con.close();
				}
			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
				System.out.println("Error! "+e);
			}
		} 
	}
	
	/*
	 * Use to remove particular payment
	 * 
	 */
	@Override
	public void removePayment(String paymentID) {
		if (paymentID != null && !paymentID.isEmpty()) {
			try {
				con = DBConnect.getDBConnection();
				
				prepare = con.prepareStatement(QueryLocation.paymentQueryIDs(Constants.REMOVE_PAYMENT));
				
				prepare.setString(Constants.COLUMN_ONE, paymentID);
				prepare.executeUpdate();
				
			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
				System.out.println("Error from removePayment "+e);
			} 
		}
	}
	
	
	/*
	 * Use to Update particular payment details
	 * 
	 */
	@Override
	public Payment updatePaymentDetails(String paymentID, Payment payment) {
		if( paymentID != null && !paymentID.isEmpty()) {
			try {
				con = DBConnect.getDBConnection();
				
				prepare = con.prepareStatement(QueryLocation.paymentQueryIDs(Constants.UPDATE_PAYMENT));
				
				prepare.setString(Constants.COLUMN_ONE, payment.getType());
				prepare.setString(Constants.COLUMN_TWO, payment.getCard());
				prepare.setString(Constants.COLUMN_THREE, payment.getNumber());
				prepare.setString(Constants.COLUMN_FOUR, payment.getCvv());
				prepare.setString(Constants.COLUMN_FIVE, payment.getEmail());
				prepare.setString(Constants.COLUMN_SIX, payment.getPaymentID());
				
				//use to execute specified query
				prepare.executeUpdate();

			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
				System.out.println("Error from updatePaymentDetails "+e);
			} 
		}
		return GetPayments(paymentID);
	}
	
	
	/*
	 * Use to Get particular payment details and Get list of all payments
	 */
	private ArrayList<Payment> collectPayments(String paymentID) {
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		
		try {
			con = DBConnect.getDBConnection();
			
			if (paymentID != null && !paymentID.isEmpty()) {
				prepare = con.prepareStatement(QueryLocation.paymentQueryIDs(Constants.GET_PAYMENT));
				prepare.setString(Constants.COLUMN_ONE, paymentID);
			}
			else {
				prepare = con.prepareStatement(QueryLocation.paymentQueryIDs(Constants.GET_ALL_PAYMENTS));
			}
			
			//represents the result set of a database query
			ResultSet resultSet = prepare.executeQuery();

			while (resultSet.next()) {
				Payment payment = new Payment();
				
				payment.setPaymentID(resultSet.getString(Constants.COLUMN_ONE));
				payment.setType(resultSet.getString(Constants.COLUMN_TWO));
				payment.setCard(resultSet.getString(Constants.COLUMN_THREE));
				payment.setNumber(resultSet.getString(Constants.COLUMN_FOUR));
				payment.setCvv(resultSet.getString(Constants.COLUMN_FIVE));
				payment.setEmail(resultSet.getString(Constants.COLUMN_SIX));
				payment.setBalance(resultSet.getString(Constants.COLUMN_SEVEN));
				
				paymentList.add(payment);
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			System.out.println("Error from collectPayments "+e);
		}
		return paymentList;
	}
	
	
	/*
	 * Get particular Payment Detail by payment ID
	 * 
	 */
	@Override
	public Payment GetPayments(String paymentID) {
		
		// returns the element at the specified index
		return collectPayments(paymentID).get(0);
	}
	
	
	/*
	 * Get all payment list
	 * 
	 */
	@Override
	public ArrayList<Payment> listPayments() {
		return collectPayments(null);
	}
	
	
	
	
}
