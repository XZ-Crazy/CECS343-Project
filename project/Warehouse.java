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
	
	/**
	 * If the user wants to add a product that's already in stock (or increase the quantity)
	 * the function will check if a product is already in stock and if so, quantity of said 
	 * product is incremented. But if the user wants to add a new product, they can still do so.
	 * 
	 * @param product - product in the inventory
	 * @param quantityToAdd - quantity added to the original quantity present in the inventory
	 */
	public void addStock(Product product, int quantityToAdd) {
		
		try {
			// is a particular product already in stock? if so, increment quantity of said product
			if(inventory.containsKey(product) && inventory.get(product) > 0) {
				
				// inventory.get(product) returns the value/quantity of the product
				// quantity to add is added to the quantity already present 
				inventory.put(product, inventory.get(product) + quantityToAdd);
			}
			else if(inventory.isEmpty() || inventory.get(product) == 0) { // this statement is ran when adding a product that isn't already in stock
				inventory.put(product, quantityToAdd);
			}
			else { // for all other cases
				inventory.put(product, quantityToAdd);
			}
		} catch(NullPointerException e) {
			System.out.println("There is(are) no product(s) available!");
		}
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
