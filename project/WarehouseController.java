package project;

import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
				return false;
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
		
		//pObj = (Product) inventory.keySet();
		
		// value of the inventory
		//int quantityToAdd = inventory.get(pObj);
		/*
		 * Add product and quantity to inventory to have at least one product in the warehouse.
		 * This eliminates the error-condition of the database not containing at least one product
		 * before adding any product (use case #4)
		 */
		inventory.put(pObj, quantityToAdd);
		
		/*
		 * For all warehouses, call addStock() from Warehouse class to add Product and Quantity.
		 * Then compare if the elements in warehouses arrayLists are equal to the instances of Warehouse Entity Object
		 * Finally, add the instance of Warehouse to the warehouses ArrayList
		 */
		for(int i = 0; i < warehouses.size(); i++) {
//			if(inventory.containsKey(pObj)) {
//				warehouse.addStock(pObj, quantityToAdd);
//			}
			//inventory.put(pObj, quantityToAdd);
			warehouse.addStock(pObj, quantityToAdd);
			warehouses.get(i).equals(warehouse);
		}
		warehouses.add(warehouse);
	}
}