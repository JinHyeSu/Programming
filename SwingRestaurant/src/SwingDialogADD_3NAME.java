import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SwingDialogADD_3NAME extends JDialog {
	public SwingDialogADD_3NAME(RestaurantManager rm, String seat, String[] food) {
		super();
		setLayout(new GridLayout(1,3,10,10));
		setTitle("���� �Է�");
		setSize(500,100);
		
		JLabel l = new JLabel("����",JLabel.CENTER);
		JTextField tf = new JTextField();
		add(l); add(tf);
		
		JButton enter = new JButton("�Է�");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("�Է�")) {
					String name = (String) tf.getText();
					if(! name.equals("")) {
						SwingDialogADD_4OK dialogOK = new SwingDialogADD_4OK(rm,seat,food,name);
						dialogOK.setVisible(true);
						setVisible(false);
					}
				} // if
			}}
		); // addActionListener end
		add(enter);
	} // SwingDialogADD_3NAME end
} // class end