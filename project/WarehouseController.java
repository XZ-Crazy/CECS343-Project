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
	
	public static void initialize()
	{
		// create empty json file
		try(FileWriter file = new FileWriter("warehouse.json"))
		{
			file.write("");
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		try(FileWriter file = new FileWriter("product.json"))
		{
			file.write("");
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void deserializeJSON()
	{
		// read in json file and add warehouse and product objects to their arraylists
		JSONParser jsonP = new JSONParser();
		JSONArray jsonArray = null;
		
		try(FileReader reader = new FileReader("warehouse.json"))
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
	}
	
	public static void serializeJSON()
	{
		// 
	}

}
