

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
import project.Product;
import project.Warehouse;
import project.WarehouseController;

public class AddStockBoundary
{
	JComboBox warehouseField;
	JComboBox productsField;
	JTextField quantityField;
	
	JFrame frame;
	@SuppressWarnings("unchecked")
	public AddStockBoundary()
	{
		frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		JLabel warehouseLabel = new JLabel("Select Warehouse:");
		warehouseLabel.setBounds(10,  25,  120,  25);
		panel.add(warehouseLabel);
		
		String[] warehouseOptions = new String[WarehouseController.getWarehouses().size()];
		for(int i = 0; i < warehouseOptions.length; i++)
			warehouseOptions[i] = WarehouseController.getWarehouses().get(i).getName();
		warehouseField = new JComboBox(warehouseOptions);
		warehouseField.setBounds(150,  25,  120,  25);
		panel.add(warehouseField);

		JLabel productLabel = new JLabel("Select Warehouse:");
		productLabel.setBounds(10,  25,  120,  25);
		panel.add(productLabel);
		
		JLabel productsLabel = new JLabel("Select Product:");
		productsLabel.setBounds(10,  75,  120,  25);
		panel.add(productsLabel);
		
		String[] productOptions = new String[WarehouseController.getProducts().size()];
		for(int i = 0; i < productOptions.length; i++)
			productOptions[i] = WarehouseController.getProducts().get(i).getName();
		productsField = new JComboBox(productOptions);
		productsField.setBounds(150,  75,  120,  25);
		panel.add(productsField);

		JLabel quantityLabel = new JLabel("Quantity:");
		quantityLabel.setBounds(10,  125,  120,  25);
		panel.add(quantityLabel);
		
		quantityField = new JTextField();
		quantityField.setBounds(150,  125,  120,  25);
		panel.add(quantityField);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 175, 80, 25);
		cancelButton.addActionListener(new CancelAction());
		panel.add(cancelButton);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(190, 175, 80, 25);
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
			WarehouseController.addStock(WarehouseController.getWarehouses().get(warehouseField.getSelectedIndex()), hashmap);
			frame.dispose();
			new MenuBoundary();
		}
	}
}
