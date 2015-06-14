import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SwingRestaurantStart extends JFrame {
	private JLabel imageLabel;
	public SwingRestaurantStart() {
		setLayout(new BorderLayout());
		setSize(780,590);
		setVisible(true);
		
		//setContentPane(contentPane);
		
		imageLabel = new JLabel(new ImageIcon("picture.jpg"));
		imageLabel.setSize(900, 900);
		add(imageLabel, BorderLayout.CENTER);
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				SwingRestaurantManager srm = new SwingRestaurantManager();
				setVisible(false);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingRestaurantStart srs = new SwingRestaurantStart();
	}
}