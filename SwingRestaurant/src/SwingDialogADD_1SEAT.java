import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class SwingDialogADD_1SEAT extends JDialog {
	public SwingDialogADD_1SEAT(RestaurantManager rm) {
		super();
		setLayout(new GridLayout(5,2,10,10));
		setTitle("ÁÂ¼®¼±ÅÃ");
		setSize(300,500);
		
		JButton btn1 = new JButton("A");
		button(rm,btn1,"A");
		JButton btn2 = new JButton("B");
		button(rm,btn2,"B");
		JButton btn3 = new JButton("C");
		button(rm,btn3,"C");
		JButton btn4 = new JButton("D");
		button(rm,btn4,"D");
		JButton btn5 = new JButton("E");
		button(rm,btn5,"E");
		JButton btn6 = new JButton("F");
		button(rm,btn6,"F");
		JButton btn7 = new JButton("G");
		button(rm,btn7,"G");
		JButton btn8 = new JButton("H");
		button(rm,btn8,"H");
		JButton btn9 = new JButton("I");
		button(rm,btn9,"I");
		JButton btn10 = new JButton("J");
		button(rm,btn10,"J");
		
		seat(rm, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10);
		
	} // SwingDialogADD_1SEAT end
	
	public void button (RestaurantManager rm, JButton btn, String seat) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals(seat)) {
					SwingDialogADD_2MENUPAN dialogMENUPAN = new SwingDialogADD_2MENUPAN(rm,seat);
					dialogMENUPAN.setVisible(true);
					setVisible(false);
				} // if
			}}
		); // addActionListener end
		add(btn);
	} // button end
	
	public void seat(RestaurantManager rm, JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5, JButton btn6, JButton btn7, JButton btn8, JButton btn9, JButton btn10) {
		String[] timeSeat = new String[10];
		for(int i=0;i<timeSeat.length;i++) { timeSeat[i]=rm.timeSeat()[i]; }

		if(timeSeat[0].equals("O")) { btn1.setEnabled(false); }
		if(timeSeat[1].equals("O")) { btn2.setEnabled(false); }
		if(timeSeat[2].equals("O")) { btn3.setEnabled(false); }
		if(timeSeat[3].equals("O")) { btn4.setEnabled(false); }
		if(timeSeat[4].equals("O")) { btn5.setEnabled(false); }
		if(timeSeat[5].equals("O")) { btn6.setEnabled(false); }
		if(timeSeat[6].equals("O")) { btn7.setEnabled(false); }
		if(timeSeat[7].equals("O")) { btn8.setEnabled(false); }
		if(timeSeat[8].equals("O")) { btn9.setEnabled(false); }
		if(timeSeat[9].equals("O")) { btn10.setEnabled(false); }
	} // seat end
} // class end
	
	
	