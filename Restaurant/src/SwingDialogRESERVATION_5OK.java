import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SwingDialogRESERVATION_5OK extends JDialog {
	public SwingDialogRESERVATION_5OK(RestaurantManager rm, Date date, String seat, String[] food, String name) {
		super();
		setLayout(new GridLayout(8,2,10,10));
		setTitle("예약 확인");
		setSize(300,500);
		
		String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
				
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
		JLabel l6 = new JLabel("예약하시겠습니까?" ,JLabel.CENTER);
		
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
					rm.add(date,name,seat,food,money,"R");
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
	} // SwingDialogRESERVATION_5OK end
} // class end
