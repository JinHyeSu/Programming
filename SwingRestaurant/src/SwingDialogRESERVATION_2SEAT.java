import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class SwingDialogRESERVATION_2SEAT extends JDialog {
	public SwingDialogRESERVATION_2SEAT(RestaurantManager rm, Date date) {
		super();
		setLayout(new GridLayout(5,2,10,10));
		setTitle("¿¹¾à ÁÂ¼®");
		setSize(300,500);
		
		JButton btn1 = new JButton("A");
		button(rm,date,btn1,"A");
		JButton btn2 = new JButton("B");
		button(rm,date,btn2,"B");
		JButton btn3 = new JButton("C");
		button(rm,date,btn3,"C");
		JButton btn4 = new JButton("D");
		button(rm,date,btn4,"D");
		JButton btn5 = new JButton("E");
		button(rm,date,btn5,"E");
		JButton btn6 = new JButton("F");
		button(rm,date,btn6,"F");
		JButton btn7 = new JButton("G");
		button(rm,date,btn7,"G");
		JButton btn8 = new JButton("H");
		button(rm,date,btn8,"H");
		JButton btn9 = new JButton("I");
		button(rm,date,btn9,"I");
		JButton btn10 = new JButton("J");
		button(rm,date,btn10,"J");
		
		seat(rm, date, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10);
		
	} // SwingDialogRESERVATION_2SEAT end
	
	public void button (RestaurantManager rm, Date date, JButton btn, String seat) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals(seat)) {
					SwingDialogRESERVATION_3MENUPAN dialogMENUPAN = new SwingDialogRESERVATION_3MENUPAN(rm,date,seat);
					dialogMENUPAN.setVisible(true);
					setVisible(false);
				} // if
			}}
		); // addActionListener end
		add(btn);
	} // button end
	
	public void seat(RestaurantManager rm, Date date, JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5, JButton btn6, JButton btn7, JButton btn8, JButton btn9, JButton btn10) {
		String[] timeSeatR = new String[10];
		for(int i=0;i<timeSeatR.length;i++) { timeSeatR[i]=rm.timeSeatR(date)[i]; }
		
		if(timeSeatR[0].equals("O")) { btn1.setEnabled(false); }
		if(timeSeatR[1].equals("O")) { btn2.setEnabled(false); }
		if(timeSeatR[2].equals("O")) { btn3.setEnabled(false); }
		if(timeSeatR[3].equals("O")) { btn4.setEnabled(false); }
		if(timeSeatR[4].equals("O")) { btn5.setEnabled(false); }
		if(timeSeatR[5].equals("O")) { btn6.setEnabled(false); }
		if(timeSeatR[6].equals("O")) { btn7.setEnabled(false); }
		if(timeSeatR[7].equals("O")) { btn8.setEnabled(false); }
		if(timeSeatR[8].equals("O")) { btn9.setEnabled(false); }
		if(timeSeatR[9].equals("O")) { btn10.setEnabled(false); }
	} // seat end
} // class end
