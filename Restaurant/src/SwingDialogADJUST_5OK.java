import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SwingDialogADJUST_5OK extends JDialog {
	public SwingDialogADJUST_5OK(RestaurantManager rm, int adjust, String seat, String[] food, String name) {
		super();
		setLayout(new GridLayout(8,2,10,10));
		setTitle("주문 수정 확인");
		setSize(300,500);
		
		String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		Date date = ((Restaurant) rm.list.get(adjust)).getDATE();
		String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
		
		String past_seat = ((Restaurant) rm.list.get(adjust)).getSeat();
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
		JLabel l6 = new JLabel("수정하시겠습니까?" ,JLabel.CENTER);
		
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
					canSeat(date,canSeat,past_seat,seat);
					if(adjust != -1) { rm.adjust(adjust+1,date,name,seat,food,money,"N"); setVisible(false); }
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
	} // SwingDialogADJUST_5OK end
	
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
	
	public void canSeat(Date date, String[] canSeat, String past_seat, String seat) {
		Date now = new Date();
		
		long gap = now.getTime()-date.getTime();
		long minute_gap = gap /1000/60;
		
		int num = whereSeat(past_seat);
		
		if(minute_gap>=0 && minute_gap<60) {
			canSeat[num]="X";
			
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
		} // if
	} // canSeat end
} // class end