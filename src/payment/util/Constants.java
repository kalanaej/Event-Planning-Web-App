package payment.util;

/*
 * Declare values and link them to keys
 */
public class Constants {
	
	/*
	 * Link path of jdbc.properties and assign it's properties to Keys
	 */
	public static final String PROPERTIES = "jdbc.properties";
	public static final String URL = "url";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String DRIVER = "driverName";
	
	/*
	 * assign paymentId and balance
	 */
	public static final String ID = "id";
	public static final String PAYMENT_ID = "PID";
	public static final String PAYMENT_BALANCE = "50000";

	/*
	 * Declare query ids of PaymentQuery.xml
	 */
	public static final String TAG = "query";
	public static final String INSERT_PAYMENTS = "insert_payment";
	//public static final String VALIDATE_PAYMENTS = "validate_payment";
	public static final String REMOVE_PAYMENT = "remove_payment";
	public static final String UPDATE_PAYMENT = "update_payment";
	public static final String GET_PAYMENT = "payment_by_id";
	public static final String GET_ALL_PAYMENTS = "all_payments";
	public static final String GET_PAYMENT_IDS = "payment_ids";
	public static final String GET_BALANCE = "payment_balance";
	
	/*
	 * Declare columns of payment table
	 */
	public static final int COLUMN_ONE = 1;
	public static final int COLUMN_TWO = 2;
	public static final int COLUMN_THREE = 3;
	public static final int COLUMN_FOUR = 4;
	public static final int COLUMN_FIVE = 5;
	public static final int COLUMN_SIX = 6;
	public static final int COLUMN_SEVEN = 7;
	/*public static final int COLUMN_EIGHT = 8;*/
}
