

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import GUI.CreateNewProductBoundary.CancelAction;
import GUI.CreateNewProductBoundary.EnterAction;
import project.InvoiceController;
import project.Product;
import project.Warehouse;
import project.WarehouseController;

public class AddInvoiceBoundary
{
	JComboBox customerField;
	JComboBox salespersonsField;
	JComboBox productsField;
	JTextField quantityField;
	JTextField addressField;
	
	JFrame frame;
	@SuppressWarnings("unchecked")
	public AddInvoiceBoundary()
	{
		frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		JLabel customerLabel = new JLabel("Select Customer:");
		customerLabel.setBounds(10,  25,  120,  25);
		panel.add(customerLabel);
		
		String[] customersOptions = new String[InvoiceController.getCustomer().size()];
		for(int i = 0; i < customersOptions.length; i++)
			customersOptions[i] = InvoiceController.getCustomer().get(i).getName();
		customerField = new JComboBox(customersOptions);
		customerField.setBounds(150,  25,  120,  25);
		panel.add(customerField);
		
		


		JLabel salespersonLabel = new JLabel("Select Salesperson:");
		salespersonLabel.setBounds(10,  75,  120,  25);
		panel.add(salespersonLabel);
		
		String[] salespersonsOptions = new String[InvoiceController.getSalespersons().size()];
		for(int i = 0; i < salespersonsOptions.length; i++)
			salespersonsOptions[i] = InvoiceController.getSalespersons().get(i).getName();
		salespersonsField = new JComboBox(salespersonsOptions);
		salespersonsField.setBounds(150,  75,  120,  25);
		panel.add(salespersonsField);
		
		
		

		
		JLabel productsLabel = new JLabel("Select Product:");
		productsLabel.setBounds(10,  125,  120,  25);
		panel.add(productsLabel);
		
		String[] productOptions = new String[WarehouseController.getProducts().size()];
		for(int i = 0; i < productOptions.length; i++)
			productOptions[i] = WarehouseController.getProducts().get(i).getName();
		productsField = new JComboBox(productOptions);
		productsField.setBounds(150,  125,  120,  25);
		panel.add(productsField);

		JLabel quantityLabel = new JLabel("Quantity:");
		quantityLabel.setBounds(10,  175,  120,  25);
		panel.add(quantityLabel);
		
		quantityField = new JTextField();
		quantityField.setBounds(150,  175,  120,  25);
		panel.add(quantityField);

		JLabel addressLabel = new JLabel("Shipping Address:");
		addressLabel.setBounds(10,  225,  120,  25);
		panel.add(addressLabel);
		
		addressField = new JTextField();
		addressField.setBounds(150,  225,  120,  25);
		panel.add(addressField);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 275, 80, 25);
		cancelButton.addActionListener(new CancelAction());
		panel.add(cancelButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(190, 275, 80, 25);
		enterButton.addActionListener(new EnterAction());
		panel.add(enterButton);
		
		
		
		frame.setTitle("Create New Product");
		frame.setVisible(true);
	}
	
	


	class CancelAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
			new MenuBoundary();
		}
	}

	class EnterAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			HashMap<Product, Integer> hashmap = new HashMap<Product, Integer>();
			hashmap.put(WarehouseController.getProducts().get(productsField.getSelectedIndex()), Integer.parseInt(quantityField.getText()));
			InvoiceController.addInvoice(InvoiceController.getCustomer().get(customerField.getSelectedIndex()), InvoiceController.getSalespersons().get(salespersonsField.getSelectedIndex()), hashmap, addressField.getText(), 0);
			frame.dispose();
			new MenuBoundary();
		}
	}
}
