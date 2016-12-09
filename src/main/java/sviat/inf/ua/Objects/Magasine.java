package sviat.inf.ua.Objects;

public class Magasine {
	
	private Integer id, periodicity;
	private String title, description;
	private Double price;
	private Boolean is_deleted;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPeriodicity() {
		return periodicity;
	}
	public void setPeriodicity(Integer periodicity) {
		this.periodicity = periodicity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	@Override
	public String toString() {
		return "Magasine [id=" + id + ", periodicity=" + periodicity + ", title=" + title + ", description="
				+ description + ", price=" + price + ", is_deleted=" + is_deleted + "]";
	} 
	

}
