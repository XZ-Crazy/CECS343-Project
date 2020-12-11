package project;

import java.util.HashMap;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Invoice
{
	private Customer customer;
	private Salesperson salesperson;
	private HashMap<Product, Integer> productList;
	private String shippingAddress;
	private Date dateOfPurchase;
	private float paymentRequired;
	private float totalPaid;
	private float currentBalance;// not on list of entity methods
	private float originalBalance;// not on list of entity methods
	
	public Invoice(Customer customer, Salesperson salesperson, HashMap<Product, Integer> productList, String shippingAddress, Date dateOfPurchase, float paymentRequired, float totalPaid)
	{
		this.customer = customer;
		this.salesperson = salesperson;
		this.productList = productList;
		this.shippingAddress = shippingAddress;
		this.dateOfPurchase = dateOfPurchase;
		this.paymentRequired = paymentRequired;
		this.totalPaid = totalPaid;
		this.currentBalance = paymentRequired - totalPaid;
		this.originalBalance = paymentRequired; // this will never change
	}
	
	
	public void setPaymentRequired(float amount) {
		this.paymentRequired = amount;
	}
	public float getPaymentRequired() {
		return this.paymentRequired;
	}
	public void payInvoice(float amount)
	{
		this.totalPaid = totalPaid + amount;
		this.currentBalance = paymentRequired - totalPaid;
	}
	
	public float getCurrentBalance()
	{
		return this.currentBalance;
	}
	
	public float getOriginalBalance()
	{
		return this.originalBalance;
	}
	
	public Customer getCustomer()
	{
		return this.customer;
	}
	
	public Salesperson getSalesperson()
	{
		return this.salesperson;
	}
	
	public HashMap<Product, Integer> getProductList()
	{
		return this.productList;
	}
	
	public String getAddress()
	{
		return this.shippingAddress;
	}
	
	public Date getDateOfPurchase()
	{
		return this.dateOfPurchase;
	}
	public String toString()
    {
        return "Customer Name: " + customer.getName() + ", Salesperson: " + salesperson.getName() + ", Product List: " + Arrays.asList(productList) + ", Shipping Address: "
    + shippingAddress + ", Date:" + dateOfPurchase.toString() + ", Payment Required: " + paymentRequired + ", Total Paid: " + totalPaid;
    }
	
}
