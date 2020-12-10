
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.InvoiceController;
import project.WarehouseController;

public class MenuBoundary
{
	JFrame frame;
	
	public MenuBoundary()
	{
		frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(665, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		JLabel createLabel = new JLabel("Create New:");
		createLabel.setBounds(10,  25,  80,  25);
		panel.add(createLabel);
		
		JButton createCustomerButton = new JButton("Customer");
		createCustomerButton.setBounds(100, 25, 120, 25);
		createCustomerButton.addActionListener(new CreateCustomerAction());
		panel.add(createCustomerButton);
		
		JButton createProductButton = new JButton("Product");
		createProductButton.setBounds(235, 25, 120, 25);
		createProductButton.addActionListener(new CreateProductAction());
		panel.add(createProductButton);
		
		JButton createSalespersonButton = new JButton("Salesperson");
		createSalespersonButton.setBounds(370, 25, 120, 25);
		createSalespersonButton.addActionListener(new CreateSalespersonAction());
		panel.add(createSalespersonButton);
		
		JButton createWarehouseButton = new JButton("Warehouse");
		createWarehouseButton.setBounds(505, 25, 120, 25);
		createWarehouseButton.addActionListener(new CreateWarehouseAction());
		panel.add(createWarehouseButton);



		JLabel addLabel = new JLabel("Add:");
		addLabel.setBounds(10,  75,  80,  25);
		panel.add(addLabel);

		JButton addInvoiceButton = new JButton("Invoice");
		addInvoiceButton.setBounds(100, 75, 165, 25);
		addInvoiceButton.addActionListener(new AddInvoiceAction());
		panel.add(addInvoiceButton);
		
		JButton addPOButton = new JButton("Purchase Order");
		addPOButton.setBounds(280, 75, 165, 25);
		addPOButton.addActionListener(new AddPOAction());
		panel.add(addPOButton);
		
		JButton addPaymentButton = new JButton("Payment");
		addPaymentButton.setBounds(460, 75, 165, 25);
		addPaymentButton.addActionListener(new AddPaymentAction());
		panel.add(addPaymentButton);



		JLabel viewLabel = new JLabel("View:");
		viewLabel.setBounds(10,  125,  80,  25);
		panel.add(viewLabel);

		JButton viewStockButton = new JButton("Total Stock");
		viewStockButton.setBounds(100, 125, 165, 25);
		viewStockButton.addActionListener(new ViewStockAction());
		panel.add(viewStockButton);
		
		JButton viewLowStockButton = new JButton("Low Stock");
		viewLowStockButton.setBounds(280, 125, 165, 25);
		viewLowStockButton.addActionListener(new ViewLowStockAction());
		panel.add(viewLowStockButton);
		
		JButton stockByWarehouseButton = new JButton("Stock By Warehouse");
		stockByWarehouseButton.setBounds(460, 125, 165, 25);
		stockByWarehouseButton.addActionListener(new ViewStockByWarehouseAction());
		panel.add(stockByWarehouseButton);

		JButton viewOpenInvoicesButton = new JButton("Open Invoices");
		viewOpenInvoicesButton.setBounds(100, 160, 165, 25);
		viewOpenInvoicesButton.addActionListener(new ViewOpenInvoicesAction());
		panel.add(viewOpenInvoicesButton);
		
		JButton viewClosedInvoicesButton = new JButton("Closed Invoices");
		viewClosedInvoicesButton.setBounds(280, 160, 165, 25);
		viewClosedInvoicesButton.addActionListener(new ViewClosedInvoicesAction());
		panel.add(viewClosedInvoicesButton);
		
		JButton viewEmployeeSalesButton = new JButton("Employee Sales");
		viewEmployeeSalesButton.setBounds(460, 160, 165, 25);
		viewEmployeeSalesButton.addActionListener(new ViewEmployeeSalesAction());
		panel.add(viewEmployeeSalesButton);
		
		
		
		

		frame.setTitle("Menu");
		frame.setVisible(true);
	}
	
	
	
	
	
	
	//List of all Action Listeners
	class CreateCustomerAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new CreateNewCustomerBoundary();
		}
	}

	class CreateProductAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new CreateNewProductBoundary();
		}
	}

	class CreateSalespersonAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new CreateNewSalespersonBoundary();
		}
	}

	class CreateWarehouseAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new CreateNewWarehouseBoundary();
		}
	}
	


	class AddInvoiceAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new AddInvoiceBoundary();
		}
	}

	class AddPOAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new AddStockBoundary();
		}
	}

	class AddPaymentAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new MakePaymentBoundary();
		}
	}
	
	

	class ViewStockAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			new ViewBoundary("View Stock", WarehouseController.printTotalStock());
		}
	}

	class ViewLowStockAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			new ViewBoundary("View Low Stock", WarehouseController.printLowStock());
		}
	}

	class ViewStockByWarehouseAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			new ViewBoundary("View Stock In Warehouse", WarehouseController.printStockIn());
		}
	}

	class ViewOpenInvoicesAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			new ViewBoundary("View Open Invoices", InvoiceController.printOpenInvoices());
		}
	}

	class ViewClosedInvoicesAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			new ViewBoundary("View Closed Invoices", InvoiceController.printClosedInvoices());
		}
	}

	class ViewEmployeeSalesAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			new ViewBoundary("View Employee Sales", InvoiceController.printEmployeeSales());
		}
	}
	
}
