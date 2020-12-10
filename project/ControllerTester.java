package project;

import java.util.*;

//import org.json.JSONException;
//import org.json.JSONObject;

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

public class ControllerTester 
{

	public static void main(String[] args) 
	{
		WarehouseController.initializeJSONFile(); // creates blank warehouses json file
		InvoiceController.initializeJSONFile(); // creates blank invoices json file
		
		// For warehouse controller
		HashMap<Product, Integer> inventory = new HashMap<>();
		WarehouseController.addWarehouse(inventory, "Warehouse 1", "800 Socal Ave", "Los Angeles", "CA", "90035", "5623336425", "1");
		
		WarehouseController.serializeJSON();
		
		WarehouseController.deserializeJSONFile();
		ArrayList<Warehouse> warehouseList = WarehouseController.getWarehouses();
		System.out.println("Warehouse toString() = " + warehouseList.get(0));
		
		// for invoice controller
		HashMap<Product, Integer> productList = new HashMap<>();
		Customer c1 = new Customer("Sam", (float) 0.0, false);
		Salesperson s1 = new Salesperson("Dean", (float) 0.0, (float) 0.0, (float) 0.0);
		InvoiceController.addInvoice(c1, s1, productList, "123 Shit St", (float) 420.69);
		
		InvoiceController.serializeJSON();
		
		InvoiceController.deserializeJSONFile();
		ArrayList<Invoice> invoiceList = InvoiceController.getInvoices();
		System.out.println("Invoince toString() = " + invoiceList.get(0));		
	}
}