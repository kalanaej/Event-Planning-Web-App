package event.model;

public class Event {

	private String Name;

	private String Category;

	private String Description;

	private String Place;

	private double Price;



	public Event(String name, String category, String description, String place, double price) {
		super();
		Name = name;
		Category = category;
		Description = description;
		Place = place;
		Price = price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPlace() {
		return Place;
	}

	public void setPlace(String string) {
		Place = string;
	}

	public void setPrice(double price) {
		Price = price;
	}
	

	public double getPrice() {
		return Price;
	}


}
