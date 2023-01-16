import java.util.ArrayList;
import java.util.List;

public class ApiSQL {

	private List<String> web_pages;
	private String state_province;
	private String alpha_two_code;
	private String name;
	private String country;

	private List<String> domains;

	public String getState_province() {
		return state_province;
	}

	public void setState_province(String State_province) {
		this.state_province = State_province;
	}

	public String getAlpha_two_code() {
		return alpha_two_code;
	}

	public void setAlpha_two_code(String Alpha_two_code) {
		this.alpha_two_code = Alpha_two_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setWeb_pages(List<String> web_pages) {
		this.web_pages = web_pages;
	}
	public List<String> getWeb_pages() {
		return web_pages;
	}
   
	
	public void setdomains(List<String> domains) {
		this.domains = domains;
	}
	public List<String> getdomains() {
		return domains;
	}
	

	

}
