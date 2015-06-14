import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class SwingDialogFIND extends JDialog implements ActionListener {
	private String[] colName = {"번호","시각","고객명","좌석","주문 음식","총합","예약","관리 Number(수정.삭제)"};
	private DefaultTableModel model = new DefaultTableModel(colName, 0);
	private JTable table = new JTable(model);
	private String text = null;
	private JTextField tf;
	private JPanel pan1;
	private JPanel pan2;
	private int num = 0;
	public SwingDialogFIND(RestaurantManager rm) {
		super();
		setLayout(new BorderLayout());
		setTitle("주문 검색");
		setSize(1150,500);
		
		pan1 = new JPanel();
		pan1.setLayout(new GridLayout(1,4,10,10));
		
		JLabel l = new JLabel("검색방법",JLabel.CENTER);
		pan1.add(l);
		
		Vector<String> find = new Vector<String>();
		find.add("검색 방법");
		find.add("날짜");
		find.add("고객명");
		find.add("좌석");
		find.add("음식");
		find.add("예약");
		
		JComboBox cb = new JComboBox(find);
		cb.addActionListener(this);
		pan1.add(cb);
		
		tf = new JTextField();
		pan1.add(tf);
		
		JButton btn = new JButton("FIND");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("FIND")) {
					model.setNumRows(0); //테이블 데이터 전부 지우기
					
					if(num==1 || num==2 || num==3 || num==4 || num==5) { text = (String) tf.getText(); }
					
					String[][] result = new String[rm.listSize()][rm.findSize()+2];
					if(text != null) {
						if(num>1 && num<6) {
							result=rm.find(text,num);
							for(int i=0;i<result.length;i++) { if(! result[i][0].equals("-")) { model.addRow(result[i]); } } // 테이블 데이터 생성
						}
						else if(num==1) {
							result=rm.find(text);
							for(int i=0;i<result.length;i++) { if(! result[i][0].equals("-")) { model.addRow(result[i]); } } // 테이블 데이터 생성
						}
					}
					//setVisible(false);
				} // if
				
			}}
		); // addActionListener end
		
		pan1.add(btn);
		
		pan2 = new JPanel();
		pan2.setLayout(new BorderLayout(20,10));
		
		table.setSize(300, 400);
		pan2.add(new JScrollPane(table));
		
		add(pan1, BorderLayout.CENTER);
		add(pan2, BorderLayout.SOUTH);
	} // SwingDialogFIND end
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JComboBox b = (JComboBox) e.getSource();
		
		if(b.getSelectedItem().equals("날짜")) { num = 1; }
		else if(b.getSelectedItem().equals("고객명")) { num = 2; }
		else if(b.getSelectedItem().equals("좌석")) { num = 3; }
		else if(b.getSelectedItem().equals("음식")) { num = 4; }
		else if(b.getSelectedItem().equals("예약")) { num = 5; }
	} // actionPerformed end
} // class end