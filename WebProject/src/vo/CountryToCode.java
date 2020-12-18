package vo;

public class CountryToCode {
	private int id;
	private  String country;
	private  String code;
	
	
	public CountryToCode() {
		super();
	}
	
	
	public CountryToCode(int id, String country, String code) {
		super();
		this.id = id;
		this.country = country;
		this.code = code;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
