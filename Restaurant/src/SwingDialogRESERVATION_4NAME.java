import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class SwingDialogRESERVATION_4NAME extends JDialog {
	public SwingDialogRESERVATION_4NAME(RestaurantManager rm, Date date, String seat, String[] food) {
		super();
		setLayout(new GridLayout(1,3,10,10));
		setTitle("���� ����");
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
						SwingDialogRESERVATION_5OK dialogOK = new SwingDialogRESERVATION_5OK(rm,date,seat,food,name);
						dialogOK.setVisible(true);
						setVisible(false);
					}
				} // if
			}}
		); // addActionListener end
		add(enter);
	} // SwingDialogRESERVATION_4NAME end
} // class end
