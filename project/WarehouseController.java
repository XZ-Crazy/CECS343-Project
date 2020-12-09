package project;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class WarehouseController 
{
	private static ArrayList<Warehouse> warehouses;
	private static ArrayList<Product> products;
	private static Warehouse wObj;
	private static Product pObj;
	private static int quantityToAdd;
	
	public static void initializeJSONFile()
	{
		// create empty warehouses json file
		try(FileWriter file = new FileWriter("warehouses.json"))
		{
			file.write("");
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// create empty products json file
		try(FileWriter file = new FileWriter("products.json"))
		{
			file.write("");
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void deserializeJSONFile()
	{
		// read in json file and add warehouses to its arraylist
		try(FileReader reader = new FileReader("warehouses.json"))
		{
			//Read JSON File
			JSONParser jsonP = new JSONParser();
			JSONArray jsonArray = null;
			Object obj = jsonP.parse(reader);
			jsonArray = (JSONArray) obj;
			
			//Assign that jsonArray to a warehouse arraylist
			String warehouseJSONString = jsonArray.toJSONString();
			Gson gson = new Gson();
			Type warehouseType = new TypeToken<ArrayList<Warehouse>>(){}.getType();
			warehouses = gson.fromJson(warehouseJSONString, warehouseType);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		// read in json file and add products to its arraylist
		try(FileReader reader = new FileReader("products.json"))
		{
			//Read JSON File
			JSONParser jsonP = new JSONParser();
			JSONArray jsonArray = null;
			Object obj = jsonP.parse(reader);
			jsonArray = (JSONArray) obj;
			
			//Assign that jsonArray to a product arraylist
			String productJSONString = jsonArray.toJSONString();
			Gson gson = new Gson();
			Type productType = new TypeToken<ArrayList<Product>>(){}.getType();
			products = gson.fromJson(productJSONString, productType);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void serializeJSON()
	{
		// Serialize warehouses json file
		try(FileWriter file = new FileWriter("warehouses.json"))
		{
			Gson gson = new Gson();
			String gsonString = gson.toJson(warehouses);
			file.write(gsonString);
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// Serialize products json file
		try(FileWriter file = new FileWriter("products.json"))
		{
			Gson gson = new Gson();
			String gsonString = gson.toJson(products);
			file.write(gsonString);
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the products in the warehouse
	 * @return products arrayList
	 */
	public static ArrayList<Product> getProducts() {
		
		return products;
	}
	
	/**
	 * Returns the warehouses
	 * @return warehouses arrayList
	 */
	public static ArrayList<Warehouse> getWarehouses() {
		
		return warehouses;
	}
	
//	/**
//	 * Gets all of the products in the warehouse
//	 * @return products
//	 */
//	public static ArrayList<Product> getProducts() {
//		for(int i = 0; i < products.size(); i++) {
//			products.get(i);
//		}
//		return products;
//	}
	
	/**
	 * Adds a warehouse
	 * @param inventory
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param phoneNumber
	 * @param warehouseID
	 * @return boolean true
	 */
	public static boolean addWarehouse(HashMap<Product, Integer> inventory, String name, String address, String city, String state, String zipCode, String phoneNumber, String warehouseID) {
		
		wObj = new Warehouse(inventory, name, address, city, state, zipCode, phoneNumber, warehouseID);
		for(int i = 0; i < warehouses.size(); i++) {
			if(warehouses.get(i).equals(wObj))
				return true;
		}
		warehouses.add(wObj);
		return true;
	}
		
	/**
	 * Adds a product to the warehouse
	 * @param name
	 * @param price
	 * @param cost
	 * @return boolean true
	 */
	public static boolean addProduct(String name, float price, float cost) {
		
		pObj = new Product(name, price, cost);
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).equals(pObj))
				return false;
		}
		products.add(pObj);
		return true;
	}
	
	/**
	 * Adds stock to the warehouse
	 * @param warehouse - instance of the Warehouse class
	 * @param inventory - inventory that contains products and quantities
	 */
	public static void addStock(Warehouse warehouse, HashMap<Product, Integer> inventory) {
		
		for(Map.Entry<Product, Integer> products : inventory.entrySet()) {
			
			Product product = products.getKey();
			Integer quantity = products.getValue();
			warehouse.addStock(product, quantity);
			
			if(inventory.isEmpty() || inventory.get(product) == null) {
				warehouse.addStock(product, quantity);
			}
		}
		warehouses.add(warehouse);
	}
	
	/**
	 * Checks if there's any stock in the warehouse
	 * @param inventory
	 * @return boolean true
	 */
	public static boolean checkInStock(HashMap<Product, Integer> inventory) {
		
		if(inventory.containsKey(pObj) && inventory.get(pObj) > 0) {
			return true;
		}
		else if(inventory.isEmpty() || inventory.keySet() == null || inventory.entrySet() == null) {
			return false;
		}
		return true;
	}
	
	public static String printTotalStock() {
		
		//ArrayList<Product> sortedProducts = new ArrayList<Product>(inventory.keySet());
		
		HashMap<Product, Integer> inventory = new HashMap<Product, Integer>();
		String totalStock = "";
		
		// Creating a list from elements of inventory hashmap
		List<Map.Entry<Product, Integer>> sortedProducts = new ArrayList<Map.Entry<Product, Integer>>(inventory.entrySet());
		
		// Sort list in ascending order with Java Collections Framework and Comparator interface
		Collections.sort(sortedProducts, new Comparator<Map.Entry<Product, Integer>>() {
			@Override
			public int compare(Map.Entry<Product, Integer> o1, Map.Entry<Product, Integer> o2) {
				   return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		// Put data from sorted list to inventory hashmap using for each loop
		for(Map.Entry<Product, Integer> prod : sortedProducts) {
			inventory.put(prod.getKey(), prod.getValue());
//			System.out.println("Products: " + prod.getKey() + ", Quantity: " + prod.getValue());
			totalStock = "Products: " + prod.getKey() + ", Quantity: " + prod.getValue();
		}
		return totalStock;
		
		//return new JSONObject(inventory).toString();
		
//		for(Product totalStock : sortedProducts)
//			System.out.println("Products: " + totalStock + ", Quantity: " + inventory.get(totalStock));
	}
	
	public static String printLowStock() {
		
		HashMap<Product, Integer> inventory = new HashMap<Product, Integer>();
		String totalLowStock = "";
		
		if(inventory.get(pObj) <= 5) {
			
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
				totalLowStock = "Products: " + prod.getKey() + ", Quantity: " + prod.getValue();
			}
		}
		return totalLowStock;
		//warehouses.add()
	}
}