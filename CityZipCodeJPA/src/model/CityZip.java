/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Feb 11, 2021
 */
package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author wuebk
 *
 */
@Entity
@Table(name="Cities")
public class CityZip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ZIPCODE")
	private String zipCode;
	@Column(name="CITY")
	private String city;
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	public CityZip(){
		super();
	}
	
	public CityZip(String zipCode) {
		super();
		setZipCode(zipCode);
	}
	
	public CityZip(String zipCode, String city) {
		super();
		this.setZipCode(zipCode);
		this.setCity(city);
	}
	
	public String printCity() {
		return city + ", " + zipCode;
	}

}
