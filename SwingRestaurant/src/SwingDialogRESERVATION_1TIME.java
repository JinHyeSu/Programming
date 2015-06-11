import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class SwingDialogRESERVATION_1TIME extends JDialog {
	public SwingDialogRESERVATION_1TIME(RestaurantManager rm) {
		super();
		setLayout(new GridLayout(1,5,10,10));
		setTitle("���� �ð�");
		setSize(700,100);
		
		JTextField tf1 = new JTextField();
		JLabel l1 = new JLabel("��",JLabel.CENTER);
		add(tf1); add(l1);
		
		JTextField tf2 = new JTextField();
		JLabel l2 = new JLabel("��",JLabel.CENTER);
		add(tf2); add(l2);
		
		JTextField tf3 = new JTextField();
		JLabel l3 = new JLabel("��",JLabel.CENTER);
		add(tf3); add(l3);
		
		JTextField tf4 = new JTextField();
		JLabel l4 = new JLabel("��",JLabel.CENTER);
		add(tf4); add(l4);
		
		JButton enter = new JButton("�Է�");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("�Է�")) {
					makeTime(rm, tf1, tf2, tf3, tf4);
				} // if
			}}
		); // addActionListener end
		add(enter);
	} // SwingDialogRESERVATION_1TIME end
	//! tf1.equals("") && ! tf2.equals("") && ! tf3.equals("") && ! tf4.equals("") && 
	public void makeTime(RestaurantManager rm, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4) {
		if(isNum(tf1) && isNum(tf2) && isNum(tf3) && isNum(tf4)) {
			int month = Integer.parseInt(tf1.getText()); //��
			int day = Integer.parseInt(tf2.getText()); //��
			int hour = Integer.parseInt(tf3.getText()); //��
			int minute = Integer.parseInt(tf4.getText()); //��
			Date date = new Date(115,month-1,day,hour,minute);
			Date now = new Date();
			long gap = date.getTime() - now.getTime();
			long hour_gap = gap /1000/60/60;
			long month_gap = gap /1000/60/60/24/30;
			if(hour_gap>=1 && month_gap<1) {
				SwingDialogRESERVATION_2SEAT dialogSEAT = new SwingDialogRESERVATION_2SEAT(rm,date);
				dialogSEAT.setVisible(true);
				setVisible(false);
			}
		}
	} // time end
	
	public boolean isNum(JTextField tf) {
		String text = (String) tf.getText();
		boolean result = false;
		try{
			Integer.parseInt(text);
			result = true;
		}catch(Exception e) {}
		
		return result;
	} // isNum end
} // class end
