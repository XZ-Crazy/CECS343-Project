package project;

import java.util.HashMap;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Invoice
{
	private Customer customer;
	private Salesperson salesperson;
	//private HashMap<Product, Integer> productList;
	private String shippingAddress;
	private Date dateOfPurchase;
	private float paymentRequired;
	private float totalPaid;
	
	public Invoice(Customer customer, Salesperson salesperson, String shippingAddress, Date dateOfPurchase, float paymentRequired, float totalPaid)
	{
		this.customer = customer;
		this.salesperson = salesperson;
		this.shippingAddress = shippingAddress;
		this.dateOfPurchase = dateOfPurchase;
		this.paymentRequired = paymentRequired;
		this.totalPaid = totalPaid;
	}
	
	public void payInvoice(float amount)
	{}
	
	public float getCurrentBalance()
	{
		return (Float) null;
	}
	
	public float getOriginalBalance()
	{
		return (Float) null;
	}
	
	public Customer getCustomer()
	{
		return null;
	}
	
	public Salesperson getSalesperson()
	{
		return null;
	}
	/*
	public HashMap<Product, Integer> getProductList();
	{
		return null;
	}
	*/
	public String getAddress()
	{
		return null;
	}
	
	public Date getDateOfPurchase()
	{
		return null;
	}
}
