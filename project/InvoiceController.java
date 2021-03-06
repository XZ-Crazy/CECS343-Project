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


public class InvoiceController 
{
	private static ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Salesperson> salespersons = new ArrayList<Salesperson>();
	
	public static void initializeJSONFile()
	{
		// create empty invoices json file
		try(FileWriter file = new FileWriter("invoices.json"))
		{
			file.write("");
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// create empty customers json file
		try(FileWriter file = new FileWriter("customers.json"))
		{
			file.write("");
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// create empty salespersons json file
		try(FileWriter file = new FileWriter("salespersons.json"))
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
		// read in json file and add invoices to its arraylists
		try(FileReader reader = new FileReader("invoices.json"))
		{
			//Read JSON File
			JSONParser jsonP = new JSONParser();
			JSONArray jsonArray = null;
			Object obj = jsonP.parse(reader);
			jsonArray = (JSONArray) obj;
			
			//Assign that jsonArray to a invoices arraylist
			String invoiceJSONString = jsonArray.toJSONString();
			Gson gson = new Gson();
			Type invoiceType = new TypeToken<ArrayList<Invoice>>(){}.getType();
			invoices = gson.fromJson(invoiceJSONString, invoiceType);
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
		
		// read in json file and add customers to its arraylists
		try(FileReader reader = new FileReader("customers.json"))
		{
			//Read JSON File
			JSONParser jsonP = new JSONParser();
			JSONArray jsonArray = null;
			Object obj = jsonP.parse(reader);
			jsonArray = (JSONArray) obj;
			
			//Assign that jsonArray to a customers arraylist
			String customerJSONString = jsonArray.toJSONString();
			Gson gson = new Gson();
			Type customerType = new TypeToken<ArrayList<Customer>>(){}.getType();
			customers = gson.fromJson(customerJSONString, customerType);
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
		
		// read in json file and add salespersons to its arraylists
		try(FileReader reader = new FileReader("salespersons.json"))
		{
			//Read JSON File
			JSONParser jsonP = new JSONParser();
			JSONArray jsonArray = null;
			Object obj = jsonP.parse(reader);
			jsonArray = (JSONArray) obj;
			
			//Assign that jsonArray to a salespersons arraylist
			String salespersonJSONString = jsonArray.toJSONString();
			Gson gson = new Gson();
			Type salespersonType = new TypeToken<ArrayList<Salesperson>>(){}.getType();
			salespersons = gson.fromJson(salespersonJSONString, salespersonType);
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
		// Serialize invoices json file
		try(FileWriter file = new FileWriter("invoices.json"))
		{
			Gson gson = new Gson();
			String gsonString = gson.toJson(invoices);
			file.write(gsonString);
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// Serialize customers json file
		try(FileWriter file = new FileWriter("customers.json"))
		{
			Gson gson = new Gson();
			String gsonString = gson.toJson(customers);
			file.write(gsonString);
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// Serialize salespersons json file
		try(FileWriter file = new FileWriter("salespersons.json"))
		{
			Gson gson = new Gson();
			String gsonString = gson.toJson(salespersons);
			file.write(gsonString);
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean addCustomer(String name, float taxPercentage) {
		Customer temp = new Customer(name, taxPercentage, false);
		if(customers.isEmpty())
			customers.add(temp);
		else {
			for(int i = 0; i < customers.size(); i++) {
				if (customers.get(i).equals(temp))
					return false;
			}
			customers.add(temp);
		}
		return true;
	}
	
	public static boolean addSalesperson(String name, float totalSales, float totalCommission, float commissionRate) {
		Salesperson temp = new Salesperson(name, totalSales, totalCommission, commissionRate);
		for(int i = 0; i < salespersons.size(); i++) {
			if(salespersons.get(i).equals(temp))
				return false;
		}
		salespersons.add(temp);
		return true;
	}
	// We can change dateOfPurchase accordingly if needed
	// I'm assuming that the customer pays a certain amount upfront for the totalPaid to be applicable
	public static boolean addInvoice(Customer customer, Salesperson salesperson, HashMap<Product, Integer> productList, String shippingAddress, float totalPaid) {
		float paymentRequired = 0;
		for (Map.Entry<Product, Integer> entry : productList.entrySet())  
            paymentRequired += entry.getKey().getSellingPrice() * entry.getValue();
		Date dateOfPurchase = new Date();
		Invoice temp = new Invoice(customer, salesperson, productList, shippingAddress, dateOfPurchase, paymentRequired, totalPaid);
		invoices.add(temp);
		return true;
	}
	
	public static ArrayList<Invoice> getInvoices(){
		return invoices;
	}
	
	public static ArrayList<Customer> getCustomer(){
		return customers;
	}
		
	
	public static ArrayList<Salesperson> getSalespersons(){
		return salespersons;
	}
		
	
	
	
	public static boolean isDelinquent(Customer customer) {
		
		Date temp = new Date();
		Date check = new Date();
		for(int i = 0; i < invoices.size(); i++) {
			if(invoices.get(i).getCustomer().equals(customer) && invoices.get(i).getCurrentBalance() != 0)
				temp = invoices.get(i).getDateOfPurchase();
		}
		long diff = Math.abs(temp.getTime() - check.getTime());
		int diffDays = (int) (diff / 24 * 60 * 60 * 1000);
		if(diffDays > 30)
			customer.setDelinquencyStatus(true);
		return customer.getDelinquencyStatus();
		 
	}
	
	public static boolean makePayment(Invoice invoice, float payment) {
		if(invoices.contains(invoice)) {
			Date curr = new Date();
			int diffDays = (int) (Math.abs(invoice.getDateOfPurchase().getTime() - curr.getTime()) / (24 * 60 * 60 * 1000) );
			
			// To find if this payment is within 10 days of making the purchase to deduct 10% and completely pays it off
			if(invoice.getCurrentBalance() == payment && diffDays <= 10) {
				float nPay = (float) (invoice.getPaymentRequired() * .90);
				invoice.setPaymentRequired(nPay);
				invoice.payInvoice(invoice.getCurrentBalance());
				return true;
			}
			
			// To update the invoice to be 1.02^^the days since dateOfPurchase divided by 30, we have paymentRequired
			// which is the amount that needs to be paid and originalBalance which is the originalPaymentRequired that never changes to
			// alter every time makePayment is called depending on how many days has passed
			double late = (double) (Math.floorDiv(diffDays, 30));
			double charge = (double) (1.02);
			float amount = (float) (Math.pow(charge, late) * invoice.getOriginalBalance());
			if(30 <= diffDays)
				invoice.setPaymentRequired(amount);
				
			
			invoice.payInvoice(payment);
			return true;
		}
		else
			return false;
		
	}
	
	public static String printOpenInvoices() {
		HashMap<Invoice, Integer> list = new HashMap<Invoice, Integer>();
		String temp = "";
		
		for(int i = 0; i < invoices.size(); i++) {
			if(invoices.get(i).getCurrentBalance() > 0)
				list.put(invoices.get(i), invoices.get(i).getDateOfPurchase().getDate());
		}
		
		// Creating a list from elements of inventory hashmap
		List<Map.Entry<Invoice, Integer>> sortedOpenInvoices = new ArrayList<Map.Entry<Invoice, Integer>>(list.entrySet());
		
		// Sort list in ascending order with Java Collections Framework and Comparator interface
		Collections.sort(sortedOpenInvoices, new Comparator<Map.Entry<Invoice, Integer>>() {
			@Override
			public int compare(Map.Entry<Invoice, Integer> o1, Map.Entry<Invoice, Integer> o2) {
				   return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		// Put data from sorted list to inventory hashmap using for each loop
		for(Map.Entry<Invoice, Integer> prod : sortedOpenInvoices) {
			list.put(prod.getKey(), prod.getValue());
//			System.out.println("Products: " + prod.getKey() + ", Quantity: " + prod.getValue());
			temp += prod.getKey() + "\n";
		}
		return temp;
	}
	
	
	
	
	public static String printClosedInvoices() {
		HashMap<Invoice, Float> list = new HashMap<Invoice, Float>();
		String temp = "";
		
		for(int i = 0; i < invoices.size(); i++) {
			if(invoices.get(i).getCurrentBalance() <= 0)
				list.put(invoices.get(i), invoices.get(i).getPaymentRequired());
		}
		
		// Creating a list from elements of inventory hashmap
		List<Map.Entry<Invoice, Float>> sortedOpenInvoices = new ArrayList<Map.Entry<Invoice, Float>>(list.entrySet());
		
		// Sort list in ascending order with Java Collections Framework and Comparator interface
		Collections.sort(sortedOpenInvoices, new Comparator<Map.Entry<Invoice, Float>>() {
			@Override
			public int compare(Map.Entry<Invoice, Float> o1, Map.Entry<Invoice, Float> o2) {
				   return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		// Put data from sorted list to inventory hashmap using for each loop
		for(Map.Entry<Invoice, Float> prod : sortedOpenInvoices) {
			list.put(prod.getKey(), prod.getValue());
//			System.out.println("Products: " + prod.getKey() + ", Quantity: " + prod.getValue());
			temp += prod.getKey() + "\n";
		}
		return temp;
	}
	
	public static String printEmployeeSales() {
		String temp = "";
		for(int i = 0; i < salespersons.size(); i++) {
			temp += "Name: " + salespersons.get(i).getName() + "\nTotal Sales: " + salespersons.get(i).getTotalSales() + 
					"\nTotal Commission: " + salespersons.get(i).getTotalCommission() + "\n";
		}
		return temp;
	}
	
}
