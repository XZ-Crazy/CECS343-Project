package project;

/**
 *  Warehouse class
 * @author Steven Duran
 * @version 1.0
 * @since 2020-11-29
 * CECS 343 - Electronic Store Management App
 *
 */

import java.util.*;

public class Warehouse {
	
	private HashMap<Product, Integer> productList; //inventory for warehouse
	private String name; //warehouse name
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String warehouseID; //ID of warehouse
	private Product product; //not included in List of Entity Methods
	private Integer productID; //not included in List of Entity Methods
	
	public Warehouse() {
		
		this.productList = new HashMap<Product, Integer>();
		this.streetAddress = "";
		this.city = "";
		this.state = "";
		this.zipCode = "";
		this.name = "";
		this.warehouseID = "";
	}
	
	public Warehouse(HashMap<Product, Integer> pl, String n, String sa, String c, String st, String z, String w) {
		
		this.productList = pl;
		this.name = n;
		this.streetAddress = sa;
		this.city = c;
		this.state = st;
		this.zipCode = z;
		this.warehouseID = w;
	}
	
	/**
	 * Entity Methods
	 */
	public HashMap<Product, Integer> getInventory() {
		
		return productList;
	}
	
	public void addStock(HashMap<Product, Integer> productList) {
		
		productList.put(product, productID);
	}
	
	public void removeStock(HashMap<Product, Integer> productList) {
		
		productList.remove(product, productID);
	}
	
	public String getName() {
		
		return name;
	}
	
	public String getAddress() {
		
		return streetAddress + "," + city + "," + state + "," + zipCode;
	}
	
	public String getID() {
		
		return warehouseID;
	}
	
	/**
	 * Returns a string in a specified format.
	 */
	@Override
	public String toString() {
		
		return "Inventory Name and ID:" + productList + "Warehouse Name: " + name + ", Address: " + this.getAddress() + 
				", Warehouse ID: " + warehouseID;
	}
}
