package project;

import java.util.Calendar;
import java.util.Date;

public class TestRunner 
{
	public static void main(String[] args) 
	{
		Customer Sam = new Customer("Samuel Winchester", (float) 0.1, false);
		System.out.println("Customer created -> " + Sam);
		
		Salesperson Dean = new Salesperson("Dean Winchester", 0, 0, (float) 0.3);
		System.out.println("\nSalesperson created -> " + Dean);
		
		Sam.setDelinquencyStatus(true);
		System.out.println("\nCurrent delinquency status of " + Sam.getName() + " = " + Sam.getDelinquencyStatus());
		
		Date date1 = new Date();
		System.out.println("\nCurrent date is " + date1);
		
		Calendar date2 = Calendar.getInstance();
		System.out.println("\nCurrent date is " + date2.getTime());
		
		Calendar date3 = Calendar.getInstance();
		date3.set(1969, 4, 20);
		System.out.println("\ndate3 date is " + date3.getTime());
		
		if (date2.after(date3) == true) // checks to see if date2 comes after date3
		{
			System.out.println("\nDate2 = " + date2.getTime());
			System.out.println("Date3 = " + date3.getTime());
			System.out.println("Date2 is more in the future than Date3");
		}
		else
		{
			System.out.println("\nDate2 = " + date2.getTime());
			System.out.println("Date3 = " + date3.getTime());
			System.out.println("Date2 is more in the past than Date3");
		}
	}

}
