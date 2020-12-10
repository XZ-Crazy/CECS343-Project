

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ViewBoundary
{
	public ViewBoundary(String title, String message)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setSize(640, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
			
		panel.setLayout(null);
			
			
		JTextArea area = new JTextArea(message);
		area.setBounds(15,  20, 595,  350);
		panel.add(area);
			
		JButton button = new JButton("Okay");
		button.setBounds(500, 375, 80, 25);
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						frame.dispose();
					}
				});
		panel.add(button);
			
		frame.setTitle(title);
		frame.setVisible(true);
	}

}
