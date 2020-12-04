package project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class Runner 
{
	public static void main(String[] args) throws JSONException 
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
		
		System.out.println("---Create a JSON string---"); 
		Customer c1 = new Customer();
		c1.setName("Sam");
		
		Gson json = new Gson();
		
		String response = json.toJson(c1); // converts c1 object to json string
		System.out.println(response);
		
		Customer c2 = json.fromJson(response, Customer.class); // takes in string version of a customer object and assigns it to an object in java
		System.out.println(c2 + "\n"); // prints c2.toString()
		
		
		
		System.out.println("---Creating JSON files---");
		ArrayList <Customer> customerList = new ArrayList<>();
		customerList.add(new Customer("Sam", (float) 0.0, false));
		customerList.add(new Customer("Steven", (float) 0.0, false));
		customerList.add(new Customer("Alex", (float) 0.0, false));
		customerList.add(new Customer("Anthony", (float) 0.0, false));
		
		Gson customerJson = new Gson();
		
		String customerJsonString = json.toJson(customerList);
		System.out.println(customerJsonString);
		
		ArrayList <Customer> readCustomerList = json.fromJson(customerJsonString, ArrayList.class);
		
		System.out.println(readCustomerList.get(0)); // this is not returning a customer
		
		
		// save a hash map of the inventory and the intergers that go with it
		// inventory stored in hashmap to be put into jsonobject
		
		

		
	}

}

//ArrayList<Student> students = new ArrayList<Student>();
//students.add(new Student("Tom",3.921));
//students.add(new Student("Dave",4.0));
//students.add(new Student("Bill",2.0));
//
//
//
//JSONObject database = new JSONObject();
//database.put("firstname", "Jason");
//database.put("lastname", "Cox");
//database.put("website", "www.jsonc.com");
