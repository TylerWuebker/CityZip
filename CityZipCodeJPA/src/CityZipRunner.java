import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import controller.CityZipAssist;
import model.CityZip;

/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Feb 11, 2021
 */

/**
 * @author wuebk
 *
 */
public class CityZipRunner {
static CityZipAssist CZA = new CityZipAssist();
static Scanner sc = new Scanner(System.in);


	public static void addCityZip() {
		System.out.println("Enter City name : ");
		String city = sc.nextLine();
		System.out.println("Enter zipCode : ");
		String zip = sc.nextLine();
		CityZip NewCityZip = new CityZip(zip, city);
	}
	
	public static void deleteCityZip() {
		System.out.println("Enter the zipCode to delete");
		String zipCode = sc.nextLine();
		CityZip Delete = new CityZip(zipCode);
		
	}
	
	public static void editCityZip() {
		System.out.println("Enter the zipCode : ");
		String zip = sc.nextLine();
		
		List<CityZip> foundZip = CZA.lookForZip(zip);//searching database for zip
		if(!foundZip.isEmpty()) {
			System.out.println("This is what we found...");
			for(CityZip cz : foundZip) {
				System.out.println(cz.printCity());
			}
			System.out.println("1. Update City");
			System.out.println("2. Update ipCode");
			int edit = sc.nextInt();
			sc.nextLine();
			
			if(edit == 1) {
				System.out.println("Enter the new City name : ");
				String newName = sc.nextLine();
				
			}
			else if(edit == 2) {
				System.out.println("Enter the new Zip Code : ");
				String newZipCode = sc.nextLine();
				CZA.update(foundZip);
			}
		}
	}
	
	public static void showAllZips() {
		List<CityZip> cityList = CZA.showAllZip();
		for(CityZip oneZip : cityList) {
			System.out.println(oneZip.printCity());
		}
	}
public static void main(String[] args) {
	menu();
}
public static void menu() {
	boolean cont = true;
	while(cont) {
		System.out.println("Make a selection");
		System.out.println("1. Add a city");
		System.out.println("2. Edit a city");
		System.out.println("3. Delete a city");
		System.out.println("4. Show all entered cities");
		System.out.println("5. Exit");
		
		int choice = sc.nextInt();
		sc.nextLine();
		
		if (choice == 1) {
			addCityZip();
		} else if (choice == 2) {
			editCityZip();
		} else if (choice == 3) {
			deleteCityZip();
		} else if (choice == 4) {
			showAllZips();
		} else {
				System.out.println("Exiting...");
				cont = false;
		}
	}
}//</menu>
}
