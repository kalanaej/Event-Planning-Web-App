package payment.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import payment.service.IPayment;
import payment.util.Constants;
import payment.util.QueryLocation;

/*
 * 
 * Add paymentID and balance each account
 */
public class IDHandle {

	public static String generateIDs(ArrayList<String> arrayList) {
		
		String id;
		int next = arrayList.size();
		next++;
		id = Constants.PAYMENT_ID + next;
		if (arrayList.contains(id)) {
			next++;
			id = Constants.PAYMENT_ID + next;
		}
		return id;
	}
	
	/*
	 * add balance each account
	 */
	public static String generateBalance(ArrayList<String> arrayList) {
		
		String bal;
		bal = Constants.PAYMENT_BALANCE;
		if (arrayList.contains(bal)) {
			bal = Constants.PAYMENT_BALANCE;
		}
		return bal;
	}
}
