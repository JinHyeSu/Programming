import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;

public class SwingDialogADJUST_2SEAT extends JDialog {
	public SwingDialogADJUST_2SEAT(RestaurantManager rm, int num) {
		super();
		setLayout(new GridLayout(5,2,10,10));
		setTitle("ÁÂ¼® ¼öÁ¤");
		setSize(300,500);
		
		int count = 0;
		int adj = -1;
		for(int i=0;i<rm.listSize();i++) {
			String reservation = ((Restaurant) rm.list.get(i)).getReservation();
			if(reservation.equals("N")) { count++; }
			if(count == num) { adj=i+1; break; }
		}
		int adjust= adj-1;
		
		JButton btn1 = new JButton("A");
		button(rm, adjust, btn1, "A");
		JButton btn2 = new JButton("B");
		button(rm, adjust, btn2, "B");
		JButton btn3 = new JButton("C");
		button(rm, adjust, btn3, "C");
		JButton btn4 = new JButton("D");
		button(rm, adjust, btn4, "D");
		JButton btn5 = new JButton("E");
		button(rm, adjust, btn5, "E");
		JButton btn6 = new JButton("F");
		button(rm, adjust, btn6, "F");
		JButton btn7 = new JButton("G");
		button(rm, adjust, btn7, "G");
		JButton btn8 = new JButton("H");
		button(rm, adjust, btn8, "H");
		JButton btn9 = new JButton("I");
		button(rm, adjust, btn9, "I");
		JButton btn10 = new JButton("J");
		button(rm, adjust, btn10, "J");
		
		btn1.setEnabled(false);
		String seat = ((Restaurant) rm.list.get(adjust)).getSeat();
		Date date = ((Restaurant) rm.list.get(adjust)).getDATE();
		
		seat(rm, date, seat, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10);
		
	} // SwingDialogADJUST_2SEAT end
	
	public void button (RestaurantManager rm, int adjust, JButton btn, String seat) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals(seat)) {
					SwingDialogADJUST_3MENUPAN dialogMENUPAN = new SwingDialogADJUST_3MENUPAN(rm,adjust,seat);
					dialogMENUPAN.setVisible(true);
					setVisible(false);
				} // if
			}}
		); // addActionListener end
		add(btn);
	} // button end
	
	public int whereSeat(String seat) {
		int num = -1;
		if(seat.equals("A")) { num = 0; }
		else if(seat.equals("B")) { num = 1; }
		else if(seat.equals("C")) { num = 2; }
		else if(seat.equals("D")) { num = 3; }
		else if(seat.equals("E")) { num = 4; }
		else if(seat.equals("F")) { num = 5; }
		else if(seat.equals("G")) { num = 6; }
		else if(seat.equals("H")) { num = 7; }
		else if(seat.equals("I")) { num = 8; }
		else if(seat.equals("J")) { num = 9; }
		
		return num;
	} // whereSeat end
	
	public void seat(RestaurantManager rm, Date date, String seat, JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5, JButton btn6, JButton btn7, JButton btn8, JButton btn9, JButton btn10) {
		String[] timeSeatA = new String[10];
		for(int i=0;i<timeSeatA.length;i++) { timeSeatA[i]=rm.timeSeatA(date)[i]; }
		
		int num = whereSeat(seat);
		timeSeatA[num]="X";
		
		if(timeSeatA[0].equals("O")) { btn1.setEnabled(false); }
		if(timeSeatA[1].equals("O")) { btn2.setEnabled(false); }
		if(timeSeatA[2].equals("O")) { btn3.setEnabled(false); }
		if(timeSeatA[3].equals("O")) { btn4.setEnabled(false); }
		if(timeSeatA[4].equals("O")) { btn5.setEnabled(false); }
		if(timeSeatA[5].equals("O")) { btn6.setEnabled(false); }
		if(timeSeatA[6].equals("O")) { btn7.setEnabled(false); }
		if(timeSeatA[7].equals("O")) { btn8.setEnabled(false); }
		if(timeSeatA[8].equals("O")) { btn9.setEnabled(false); }
		if(timeSeatA[9].equals("O")) { btn10.setEnabled(false); }
	} // seat end	
} // class end