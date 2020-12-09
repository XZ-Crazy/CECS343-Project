package pkg;

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
	private static ArrayList<Invoice> invoices;
	private static ArrayList<Customer> customers;
	private static ArrayList<Salesperson> salespersons;
	
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
		for(int i = 0; i < customers.size(); i++) {
			if (customers.get(i).equals(temp))
				return false;
		}
		customers.add(temp);
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
		return customer.getDelinquencyStatus();
		/* I wrote this without thinking about what this method wanted, if we need it later we can use it
		 * It's basically a DelinquentStatusChanger based off customer
		Date temp = new Date();
		Date check = new Date();
		for(int i = 0; i < invoices.size(); i++) {
			if(invoices.get(i).getCustomer().equals(customer))
				temp = invoices.get(i).getDateOfPurchase();
		}
		long diff = Math.abs(temp.getTime() - check.getTime());
		int diffDays = (int) (diff / 24 * 60 * 60 * 1000);
		if(diffDays > 30)
			customer.setDelinquencyStatus(true);
		 */
	}
	
	public static boolean makePayment(Invoice invoice, float payment) {
		if(invoices.contains(invoice)) {
			Date curr = new Date();
			// To find if this payment is within 10 days of making the purchase to deduct 10% or after 30 to charge 2% more
			int diffDays = (int) (Math.abs(invoice.getDateOfPurchase().getTime() - curr.getTime()) / (24 * 60 * 60 * 1000) );
			if(invoice.getCurrentBalance() == payment && diffDays <= 10) {
				float nPay = (float) (invoice.getPaymentRequired() * .90);
				invoice.setPaymentRequired(nPay);
				invoice.payInvoice(invoice.getCurrentBalance());
				return true;
			}
			invoice.payInvoice(payment);
			return true;
		}
		else
			return false;
	}
	
	public static String printOpenInvoices() {
		ArrayList<Invoice> temp = invoices;
		String sTemp = "";
		Collections.sort(temp);
		for(Invoice str : temp)
			sTemp += temp;
		return sTemp;
	}
	/*
	public static String printClosedInvoices()
	public static String printEmployeeSales()
	*/
}
