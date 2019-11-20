package event.model;

public class EditEvent {
	
	
	private String EventID_up;
	
	private String Name_up;

	private String Category_up;

	private String Description_up;
	
	private String Place_up;

	double  Price_up;
	
	private int hidden_id;
	
	

	public EditEvent(String eventID_up, String name_up, String category_up, String description_up, String place_up,
			double price_up, int hidden_id) {
		super();
		EventID_up = eventID_up;
		Name_up = name_up;
		Category_up = category_up;
		Description_up = description_up;
		Place_up = place_up;
		Price_up = price_up;
		this.hidden_id = hidden_id;
	}


	public int getHidden_id() {
		return hidden_id;
	}

	public void setHidden_id(int hidden_id) {
		this.hidden_id = hidden_id;
	}



	public String getEventID_up() {
		return EventID_up;
	}

	public void setEventID_up(String eventID_up) {
		EventID_up = eventID_up;
	}

	public String getName_up() {
		return Name_up;
	}

	public void setName_up(String name_up) {
		Name_up = name_up;
	}

	public String getCategory_up() {
		return Category_up;
	}

	public void setCategory_up(String category_up) {
		Category_up = category_up;
	}

	public String getDescription_up() {
		return Description_up;
	}

	public void setDescription_up(String description_up) {
		Description_up = description_up;
	}

	public String getPlace_up() {
		return Place_up;
	}

	public void setPlace_up(String place_up) {
		Place_up = place_up;
	}

	public double getPrice_up() {
		return Price_up;
	}

	public double setPrice_up(double price_up) {
		return Price_up = price_up;
	}

}
