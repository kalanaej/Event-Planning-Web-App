package payment.model;

public class Payment {

	private String paymentID;
	
	private String type;
	
	private String card;
	
	private String number;
	
	private String cvv;

	private String email;
	
	private String balance;

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
