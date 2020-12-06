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
	
	private HashMap<Product, Integer> inventory; //inventory for warehouse
	private String name; //warehouse name
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String warehouseID; //ID of warehouse
	private Product product; //not included in List of Entity Methods
	private Integer productID; //not included in List of Entity Methods
	
	public Warehouse() {
		
		this.inventory = new HashMap<Product, Integer>();
		this.streetAddress = "";
		this.city = "";
		this.state = "";
		this.zipCode = "";
		this.name = "";
		this.warehouseID = "";
	}
	
	public Warehouse(HashMap<Product, Integer> inventory, String name, String streetAddress, String city, String state, String zipCode, String warehouseID) {
		
		this.inventory = inventory;
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.warehouseID = warehouseID;
	}
	
	/**
	 * Entity Methods
	 */
	public HashMap<Product, Integer> getInventory() {
		
		return inventory;
	}
	
	public void addStock(Product product, int quantityToAdd) {
		
		inventory.put(product, quantityToAdd);
	}
	
	public void removeStock(Product product, int quantityToRemove) {
		
		inventory.remove(product, quantityToRemove);
	}
	
	public String getName() {
		
		return name;
	}
	
	public String getAddress() {
		
		return streetAddress + ", " + city + ", " + state + " " + zipCode;
	}
	
	public String getID() {
		
		return warehouseID;
	}
	
	/**
	 * Returns a string in a specified format.
	 */
	@Override
	public String toString() {
		
		return "Inventory Name and ID:" + inventory + ", Warehouse Name: " + name + ", Address: " + this.getAddress() + 
				", Warehouse ID: " + warehouseID;
	}
}
