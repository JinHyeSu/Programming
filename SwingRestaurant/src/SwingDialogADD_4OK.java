import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class SwingDialogADD_4OK extends JDialog {
	public SwingDialogADD_4OK(RestaurantManager rm, String seat, String[] food, String name) {
		super();
		setLayout(new GridLayout(8,2,10,10));
		setTitle("주문 추가 확인");
		setSize(300,500);
		
		String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		Date date = new Date();
		String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
		
		String[] canSeat = Restaurant.getCanSeat();
		
		String selectFood = null;
		String[] menu = Restaurant.getMenu();
		int calc = 0;
		int[] price = Restaurant.getPrice();
		
		for(int i=0;i<food.length;i++) {
			if(food[i].equals("O")) {
				selectFood += ", "+menu[i];
				calc += price[i];
			}
		}
		selectFood = selectFood.substring(6);
		
		JLabel l1 = new JLabel("시각: " + time ,JLabel.CENTER);
		JLabel l2 = new JLabel("고객명: " + name ,JLabel.CENTER);
		JLabel l3 = new JLabel("좌석: " + seat ,JLabel.CENTER);
		JLabel l4 = new JLabel("주문하신 음식들: " + selectFood,JLabel.CENTER);
		JLabel l5 = new JLabel("총합: " + calc,JLabel.CENTER);
		JLabel l6 = new JLabel("주문하시겠습니까?" ,JLabel.CENTER);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		
		final int money = calc;
		
		JButton yes = new JButton("네");
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("네")) {
					canSeat(canSeat,seat);
					rm.add(date,name,seat,food,money,"N");
					setVisible(false);
				} // if
			}}
		); // addActionListener end
		add(yes);
		
		JButton no = new JButton("아니오");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("아니오")) {
					setVisible(false);
				} // if
			}}
		); // addActionListener end
		add(no);
	} // SwingDialogADD_4OK end
	
	public void canSeat(String[] canSeat, String seat) {
		if(seat.equals("A")) { canSeat[0]="O"; }
		else if(seat.equals("B")) { canSeat[1]="O"; }
		else if(seat.equals("C")) { canSeat[2]="O"; }
		else if(seat.equals("D")) { canSeat[3]="O"; }
		else if(seat.equals("E")) { canSeat[4]="O"; }
		else if(seat.equals("F")) { canSeat[5]="O"; }
		else if(seat.equals("G")) { canSeat[6]="O"; }
		else if(seat.equals("H")) { canSeat[7]="O"; }
		else if(seat.equals("I")) { canSeat[8]="O"; }
		else if(seat.equals("J")) { canSeat[9]="O"; }
		
		Restaurant.setCanSeat(canSeat);
	} // canSeat end
} // class end
