import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class SwingDialogLIST extends JDialog {
	private String[] colName = {"��ȣ","�ð�","����","�¼�","�ֹ� ����","����","����"};
	private DefaultTableModel model = new DefaultTableModel(colName, 0);
	private JTable table = new JTable(model);
	public SwingDialogLIST(RestaurantManager rm) {
		super();
		setLayout(new GridLayout(1,1,10,10));
		setTitle("�ֹ� ����Ʈ Ȯ��");
		setSize(950,500);
		
		String[][] result = new String[rm.listSize()][rm.findSize()+1];
		int num = 1;
		for(int i=0;i<rm.listSize();i++) {
			String[] dayOFtheWeek = {"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};
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
			
			result[i][0]=Integer.toString(num);
			result[i][1]=time;
			result[i][2]=name;
			result[i][3]=seat;
			result[i][4]=food;
			result[i][5]=money;
			result[i][6]=reservation;
			num++;
		} // for
		
		for(int i=0;i<result.length;i++) { model.addRow(result[i]); } //���̺� ������ ����
		
		table.setSize(300, 400);
		add(new JScrollPane(table));
	} // SwingDialogLIST end
} // class end