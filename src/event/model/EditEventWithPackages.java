package event.model;

public class EditEventWithPackages extends EditEvent {
	
	
	private String dj_up;
	private String cake_up;
	private String flower_up;
	
	
	

	public EditEventWithPackages(String eventID_up, String name_up, String category_up, String description_up,
			String place_up, double price_up, int hidden_id, String dj_up, String cake_up, String flower_up) {
		super(eventID_up, name_up, category_up, description_up, place_up, price_up, hidden_id);
		this.dj_up = dj_up;
		this.cake_up = cake_up;
		this.flower_up = flower_up;
	}




	public String getDj_up() {
		return dj_up;
	}




	public void setDj_up(String dj_up) {
		this.dj_up = dj_up;
	}




	public String getCake_up() {
		return cake_up;
	}




	public void setCake_up(String cake_up) {
		this.cake_up = cake_up;
	}




	public String getFlower_up() {
		return flower_up;
	}




	public void setFlower_up(String flower_up) {
		this.flower_up = flower_up;
	}



}
