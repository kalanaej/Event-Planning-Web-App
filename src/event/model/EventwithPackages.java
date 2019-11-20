package event.model;

public class EventwithPackages extends Event {
	  
	private String dj;
	private String cake;
	private String flower;
	
	public EventwithPackages(String name, String category, String description, String place, double price, String dj,
			String cake, String flower) {
		super(name, category, description, place, price);
		this.dj = dj;
		this.cake = cake;
		this.flower = flower;
	}

	public String getDj() {
		return dj;
	}

	public void setDj(String dj) {
		this.dj = dj;
	}

	public String getCake() {
		return cake;
	}

	public void setCake(String cake) {
		this.cake = cake;
	}

	public String getFlower() {
		return flower;
	}

	public void setFlower(String flower) {
		this.flower = flower;
	}
	

}
