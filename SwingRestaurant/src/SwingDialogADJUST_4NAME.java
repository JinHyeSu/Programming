import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingDialogADJUST_4NAME extends JDialog {
	public SwingDialogADJUST_4NAME(RestaurantManager rm,int adjust, String seat, String[] food) {
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
						SwingDialogADJUST_5OK dialogOK = new SwingDialogADJUST_5OK(rm,adjust,seat,food,name);
						dialogOK.setVisible(true);
						setVisible(false);
					}
				} // if
			}}
		); // addActionListener end
		add(enter);
	} // SwingDialogADJUST_4NAME end
} // class end
