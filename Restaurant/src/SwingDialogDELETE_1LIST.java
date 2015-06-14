import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SwingDialogDELETE_1LIST extends JDialog {
	private String[] colName = {"번호","시각","고객명","좌석","주문 음식","총합","예약"};
	private DefaultTableModel model = new DefaultTableModel(colName, 0);
	private JTable table = new JTable(model);
	private JPanel pan1;
	private JPanel pan2;
	public SwingDialogDELETE_1LIST(RestaurantManager rm) {
		super();
		setLayout(new BorderLayout());
		setTitle("주문 삭제");
		setSize(950,500);
		
		pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());
		
		String[][] result = new String[rm.listSize()][rm.findSize()+1];
		int num = 0;
		for(int i=0;i<rm.listSize();i++) {
			String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
			Date date = ((Restaurant) rm.list.get(i)).getDATE();
			String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
			
			String name = ((Restaurant) rm.list.get(i)).getName();
			String seat = ((Restaurant) rm.list.get(i)).getSeat();
			
			String[] foods = ((Restaurant) rm.list.get(i)).getFood();
			String[] menu = Restaurant.getMenu();
			String food = null;
			for(int f=0;f<foods.length;f++) {
				if(foods[f].equals("O")) { food += ", "+menu[f]; }
			}
			food = food.substring(6);
			
			String money = Integer.toString(((Restaurant) rm.list.get(i)).getMoney());
			String reservation = ((Restaurant) rm.list.get(i)).getReservation();
			
			if(! reservation.equals("R")) { num++; }
			
			result[i][0]=Integer.toString(num);
			result[i][1]=time;
			result[i][2]=name;
			result[i][3]=seat;
			result[i][4]=food;
			result[i][5]=money;
			result[i][6]=reservation;					
		} // for
		
		for(int i=0;i<result.length;i++) { if(! result[i][6].equals("R")) { model.addRow(result[i]); } } //테이블 데이터 생성
		
		table.setSize(300, 400);
		pan1.add(new JScrollPane(table));
		
		pan2 = new JPanel();
		pan2.setLayout(new BorderLayout(20,10));
		
		JLabel l = new JLabel("          주문 번호",JLabel.CENTER);
		JTextField tf = new JTextField();
		pan2.add(l, BorderLayout.WEST); pan2.add(tf, BorderLayout.CENTER);
		
		JButton select = new JButton("선택");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("선택")) {
					String text = (String) tf.getText();
					if(! text.equals("") && isNum(text)) {
						int num = Integer.parseInt(tf.getText());
						int count = 0, del = -1;
						for(int i=0;i<rm.listSize();i++) {
							String reservation = ((Restaurant) rm.list.get(i)).getReservation();
							if(reservation.equals("N")) { count++; }
							if(count == num) { del=i+1; break; }
						}
						
						if(del>0 && del<=rm.listSize()) {
							SwingDialogDELETE_2OK dialogOK = new SwingDialogDELETE_2OK(rm,del);
							dialogOK.setVisible(true);
							setVisible(false);
						}
					}
				}
			}}
		); // addActionListener end
		pan2.add(select, BorderLayout.EAST);
		
		add(pan1, BorderLayout.CENTER);
		add(pan2, BorderLayout.SOUTH);
	} // SwingDialogDELETE_1LIST end
	
	public boolean isNum(String text) {
		boolean result = false;
		try{
			Integer.parseInt(text);
			result = true;
		}catch(Exception e) {}
		
		return result;
	} // isNum end
} // class end