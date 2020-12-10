

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

//import org.json.JSONException;
//import org.json.JSONObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import project.InvoiceController;
import project.WarehouseController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

//import sun.jvmstat.perfdata.monitor.v2_0.TypeCode;

/**
 * 12-5-2020 - Updates, added addCustomer and printCustomerList
 * @author Sam
 *
 */

public class Runner 
{
	public static void main(String[] args) //throws JSONException 
	{
		System.out.println("---Creates new customer---");
		Customer Sam = new Customer("Samuel Winchester", (float) 0.1, false);
		System.out.println("Customer created -> " + Sam);
		
		System.out.println("\n---Creates new salesperson/employee---"); 
		Salesperson Dean = new Salesperson("Dean Winchester", 0, 0, (float) 0.3);
		System.out.println("Salesperson created -> " + Dean);
		
	    System.out.println("\n---Sets delinquency status---"); 
		Sam.setDelinquencyStatus(true);
		System.out.println("Current delinquency status of " + Sam.getName() + " = " + Sam.getDelinquencyStatus());
		
//		System.out.println("\n---Creates new warehouse---");
		HashMap<Product, Integer> inventory = new HashMap<>();
//		Product apple = new Product("Apple", (float) 2.00, (float) 10.00);
//		inventory.put(apple, 1);
//		Warehouse w1 = new Warehouse(inventory, "Warehouse 1", "800 Socal Ave", "Los Angeles", "CA", "90035", "5623336425", "1");
//		System.out.println("Warehouse created: -> " + w1);
//		w1.addStock(apple, 2);
//		System.out.println("After adding two more apples: " + w1.getInventory());
//		w1.removeStock(apple, 1);
//		System.out.println("After removing one apple: " + w1.getInventory());
//		
//		Product chocopie = new Product("Choco Pie", (float) 1.50, (float) 5.00);
//		w1.addStock(chocopie, 1);
//		System.out.println("Added one choco pie: " + w1.getInventory());
//		
//		w1.removeStock(chocopie, 1);
//		System.out.println("Removed choco pie: " + w1.getInventory());
		
		System.out.println("\n---Warehouse Controller---");
		//WarehouseController wc = new WarehouseController();
		//Warehouse w1 = new Warehouse();
		
		System.out.println(WarehouseController.addWarehouse(inventory, "Warehouse 1", "800 Socal Ave", "Los Angeles", "CA", "90035", "5623336425", "1"));
		System.out.println(WarehouseController.getWarehouses());
		System.out.println(WarehouseController.addProduct("Blueberry", 200.00f, 100.00f));
		System.out.println(WarehouseController.getProducts());
		//Warehouse w1 = new Warehouse();
		//Warehouse w1 = new Warehouse();
		//Product prod = new Product("pizza", 5.00f, 100.00f);
		ArrayList<Warehouse> w = new ArrayList<Warehouse>();
		//WarehouseController.addStock(prod, 1);
		//System.out.println(WarehouseController.checkInStock(inventory));
		//System.out.println(WarehouseController.getProducts());
		//WarehouseController.printStockIn();
		//System.out.println(WarehouseController.getProducts());
		//System.out.println(WarehouseController.printStockIn());
		
		System.out.println("\n---Creates current or customer dates---"); 
		Date date1 = new Date();
		System.out.println("Current date is " + date1);
		
		Calendar date2 = Calendar.getInstance();
		System.out.println("Current date is " + date2.getTime());
		
		Calendar date3 = Calendar.getInstance();
		date3.set(1969, 4, 20);
		System.out.println("date3 date is " + date3.getTime());
		
		System.out.println("\n---Compares two different dates---"); 
		if (date2.after(date3) == true) // checks to see if date2 comes after date3
		{
			System.out.println("Date2 = " + date2.getTime());
			System.out.println("Date3 = " + date3.getTime());
			System.out.println("Date2 is more in the future than Date3");
		}
		if (date3.before(date2) == true)
		{
			System.out.println("\nDate3 = " + date3.getTime());
			System.out.println("Date2 = " + date2.getTime());
			System.out.println("Date3 is more in the past than Date2\n");
		}
		
		/*
		System.out.println("---Create a JSON string---"); 
		Customer c1 = new Customer();
		c1.setName("Sam");
		
		Gson json = new Gson();
		
		String response = json.toJson(c1); // converts c1 object to json string
		System.out.println(response);
		
		Customer c2 = json.fromJson(response, Customer.class); // takes in string version of a customer object and assigns it to an object in java
		System.out.println(c2 + "\n"); // prints c2.toString()
		*/
		
		// Writing JSON File
		System.out.println("---Write JSON File---");
		ArrayList <Customer> customerList = new ArrayList<>();
		customerList.add(new Customer("Samuel Garcia", (float) 0.0, false));
		customerList.add(new Customer("Steven", (float) 0.0, false));
		customerList.add(new Customer("Alex", (float) 0.0, false));
		customerList.add(new Customer("Anthony", (float) 0.0, false));
		writeJSONFile(customerList, "customer");
		System.out.println("Customer JSON File created");
		
		ArrayList <Salesperson> salespersonList = new ArrayList<>();
		salespersonList.add(new Salesperson("Samuel Winchester", (float) 0.0, (float) 0.0, (float) 0.0));
		salespersonList.add(new Salesperson("Dean Winchester", (float) 0.0, (float) 0.0, (float) 0.0));
		writeJSONFile(salespersonList, "salesperson");
		System.out.println("Salesperson JSON File created");
		
		System.out.println("\nOriginal salesperson list");
		printSalespersonList(); 
		System.out.println("\nOriginal customer list");
		printCustomerList();
		
		System.out.println("\nUpdated salersperson list");
		addSalesperson(new Salesperson("Castiel", (float) 0.0, (float) 0.0, (float) 0.0));
		printSalespersonList();
		System.out.println("\nUpdated customer list");
		addCustomer(new Customer("Garth", (float) 0.0, false));
		printCustomerList(); // this is not printing garth
		
		
		// Reading JSON File
		System.out.println("\n---Read JSON File---");
		String customerJsonString = readJSONFile("customer").toJSONString();
		System.out.println(customerJsonString);
		
		Gson gson = new Gson();
		Type customerType = new TypeToken<ArrayList<Customer>>(){}.getType();
		ArrayList <Customer> readCustomerList = gson.fromJson(customerJsonString, customerType);
		System.out.println(readCustomerList.get(0)); 
		
		// Testing Warehouse and invoice Controllers
		System.out.println("\n---Testing Warehouse and invoice Controllers---");
		WarehouseController.initializeJSONFile();
		InvoiceController.initializeJSONFile();
		
	}
	
	public static void writeJSONFile(Object obj, String className) 
	{
		Gson gson = new Gson();
		String gsonString = gson.toJson(obj);
		try(FileWriter file = new FileWriter(className + ".json"))
		{
			file.write(gsonString);
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static JSONArray readJSONFile(String className)
	{
		JSONParser jsonP = new JSONParser();
		JSONArray jsonArray = null;
		
		try(FileReader reader = new FileReader(className + ".json"))
		{
			//Read JSON File
			Object obj = jsonP.parse(reader);
			jsonArray = (JSONArray) obj;
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
		
		return jsonArray;
	}
	
	public static void addSalesperson(Salesperson salesperson)
	{
		// reads in json file
		String salespersonJsonString = readJSONFile("salesperson").toJSONString();
		Gson gson = new Gson();
		Type salespersonType = new TypeToken<ArrayList<Salesperson>>(){}.getType();
		ArrayList <Salesperson> readSalespersonList = gson.fromJson(salespersonJsonString, salespersonType);
		readSalespersonList.add(salesperson);
		
		// updates json file
		writeJSONFile(readSalespersonList, "salesperson");
	}
	
	public static void addCustomer(Customer customer)
	{
		// reads in json file
		String jsonString = readJSONFile("customer").toJSONString();
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
		ArrayList <Customer> readCustomerList = gson.fromJson(jsonString, type);
		readCustomerList.add(customer);
		
		// updates json file
		writeJSONFile(readCustomerList, "customer");
	}

	public static void printSalespersonList()
	{
		// reads in json file
		String salespersonJsonString = readJSONFile("salesperson").toJSONString();
		Gson gson = new Gson();
		Type salespersonType = new TypeToken<ArrayList<Salesperson>>(){}.getType();
		ArrayList <Customer> readSalespersonList = gson.fromJson(salespersonJsonString, salespersonType);
		
		// prints each element in array list
		for (int i = 0; i < readSalespersonList.size(); i++)
		{
			System.out.println(readSalespersonList.get(i));
		}
	}
	
	public static void printCustomerList()
	{
		// reads in json file
		String jsonString = readJSONFile("customer").toJSONString();
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
		ArrayList <Customer> readCustomerList = gson.fromJson(jsonString, type);
		
		// prints each element in array list
		for (int i = 0; i < readCustomerList.size(); i++)
		{
			System.out.println(readCustomerList.get(i));
		}
	}
}

/*
System.out.println("---Creating JSON files---");
ArrayList <Customer> customerList = new ArrayList<>();
customerList.add(new Customer("Sam", (float) 0.0, false));
customerList.add(new Customer("Steven", (float) 0.0, false));
customerList.add(new Customer("Alex", (float) 0.0, false));
customerList.add(new Customer("Anthony", (float) 0.0, false));

Gson customerJson = new Gson();

String customerJsonString = json.toJson(customerList);
//System.out.println(customerJsonString);

Type customerALType = new TypeToken<ArrayList<Customer>>(){}.getType();

ArrayList <Customer> readCustomerList = json.fromJson(customerJsonString, customerALType);

System.out.println(readCustomerList.get(0)); 
System.out.println(readCustomerList.get(1).getDelinquencyStatus()); // false
*/


// save a hash map of the inventory and the intergers that go with it
// inventory stored in hashmap to be put into jsonobject
