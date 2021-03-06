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
	private String phoneNumber;
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
		this.phoneNumber = "";
		this.warehouseID = "";
	}
	
	public Warehouse(HashMap<Product, Integer> inventory, String name, String streetAddress, String city, String state, String zipCode, String phoneNumber, String warehouseID) {
		
		this.inventory = inventory;
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
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
			else if(inventory.isEmpty() || inventory.get(product) == null || inventory.get(product) == 0) { // this statement is ran when adding a product that isn't already in stock
				inventory.put(product, quantityToAdd);
			}
			else { // for all other cases
				inventory.put(product, quantityToAdd);
			}
		} catch(NullPointerException e) {
			System.out.println("There is(are) no product(s) available!");
		}
	}
	
	/**
	 * If the user wants to remove a product that's already in stock (or lower the quantity)
	 * the function will check if a product is already in stock and if so, quantity of said 
	 * product is decremented.
	 * @param product - product in the inventory
	 * @param quantityToRemove - quantity to remove from the original quantity present in the inventory
	 */
	public void removeStock(Product product, int quantityToRemove) {
		
		try {
			// is a particular product already in stock? if so, decrement quantity of said product
			if(inventory.containsKey(product) && inventory.get(product) > 1) {
				
				// quantity present is removed by the quantity that user wants to remove
				inventory.put(product, inventory.get(product) - quantityToRemove);
			}
			else if(inventory.containsKey(product) && inventory.get(product) <= 1) {
				inventory.remove(product);
			}
		} catch(NullPointerException e) {
			System.out.println("There is(are) no product(s) available!");
		}
	}
	
	/**
	 * Displays the products that have quantities less than or equal to 5.
	 * This is also sorted in increasing order by quantity.
	 * @param inventory - the inventory hashmap or maybe Product product and/or Integer integer can be params too alt.
	 * @return the inventory
	 */
	public HashMap<Product, Integer> displayAscendingQuantity(HashMap<Product, Integer> inventory) {
		
		if(inventory.get(product) <= 5) {
			
			// Creating a list from elements of inventory hashmap
			List<Map.Entry<Product, Integer>> list = new ArrayList<Map.Entry<Product, Integer>>(inventory.entrySet());
						
			// Sort list in ascending order with Java Collections Framework and Comparator interface
			Collections.sort(list, new Comparator<Map.Entry<Product, Integer>>() {
				@Override
				public int compare(Map.Entry<Product, Integer> o1, Map.Entry<Product, Integer> o2) {
					return o1.getValue().compareTo(o2.getValue());
				}
			});
			// Put data from sorted list to inventory hashmap using for each loop
			for(Map.Entry<Product, Integer> prod : list) {
				inventory.put(prod.getKey(), prod.getValue());
			}
		}
		return inventory;
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
	
	public String getphoneNumber() {
		
		return phoneNumber;
	}
	
	/**
	 * Returns a string in a specified format.
	 */
	@Override
	public String toString() {
		
		return "\nInventory Name and ID:" + inventory + "\nWarehouse Name: " + name + "\nAddress: " + this.getAddress() + 
				"\nPhone Number: " + phoneNumber + "\nWarehouse ID: " + warehouseID + "\n";
	}
}
