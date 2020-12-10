

import java.util.HashMap;

import project.InvoiceController;
import project.Product;
import project.WarehouseController;

public class GUITestMain
{
	public static void main(String[] args)
	{
		//InvoiceController.deserializeJSONFile();
		//WarehouseController.deserializeJSONFile();
		
		//
		WarehouseController.addWarehouse(new HashMap<Product, Integer>(), "American Warehouse", "", "", "", "", "", "");
		WarehouseController.addWarehouse(new HashMap<Product, Integer>(), "Warehouse in Space", "", "", "", "", "", "");
		WarehouseController.addProduct("Test Soap", 5, 2);
		WarehouseController.addProduct("Red Crayon", 2, 1);
		WarehouseController.addProduct("Diamond Sword", 200, 60);
		InvoiceController.addCustomer("Mx Cash", 0);
		InvoiceController.addCustomer("Dr Lucky", 5);
		InvoiceController.addSalesperson("Self Checkout", 0, 0, 0);
		InvoiceController.addSalesperson("Creeper Ahman", 0, 0, 0.3f);
		
		//
		
		new LoginBoundary();
	}
	
	public static void firstTimeSetup(String[] args)
	{
		InvoiceController.initializeJSONFile();
		WarehouseController.initializeJSONFile();
	}
}
