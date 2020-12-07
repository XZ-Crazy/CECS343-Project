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
}