import java.awt.event.*;
import java.awt.*;
import java.io.*;

import javax.swing.*;

public class SwingRestaurantManager extends JFrame implements ActionListener {
	SwingRestaurantManager() {
		super();
		RestaurantManager rm = new RestaurantManager();
		setLayout(new GridLayout(7,10,10,10));
		setTitle("RestaurantManager");
		setSize(300,500);
		setVisible(true);
		
		JButton add = new JButton("주문 추가");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("주문 추가")) {
					SwingDialogADD_1SEAT dialogSEAT = new SwingDialogADD_1SEAT(rm);
					dialogSEAT.setVisible(true);
				} // if
			}}
		); // addActionListener end
		add(add);
		
		JButton adjust = new JButton("주문 수정");
		adjust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("주문 수정")) {
					SwingDialogADJUST_1LIST dialogADJUST = new SwingDialogADJUST_1LIST(rm);
					dialogADJUST.setVisible(true);
				} // if
			}}
		); // addActionListener end
		add(adjust);
		
		
		JButton delete = new JButton("주문 삭제");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("주문 삭제")) {
					SwingDialogDELETE_1LIST dialogDELETE = new SwingDialogDELETE_1LIST(rm);
					dialogDELETE.setVisible(true);
				} // if
			}}
		); // addActionListener end
		add(delete);
		
		
		JButton find = new JButton("주문 검색");
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("주문 검색")) {
					SwingDialogFIND dialogFIND = new SwingDialogFIND(rm);
					dialogFIND.setVisible(true);
				} // if
			}}
		); // addActionListener end
		add(find);
		
		JButton list = new JButton("전체 리스트");
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("전체 리스트")) {
					SwingDialogLIST dialogLIST = new SwingDialogLIST(rm);
					dialogLIST.setVisible(true);
				} // if
			}}
		); // addActionListener end
		add(list);
		
		JButton reservation = new JButton("예약");
		reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("예약")) {
					SwingDialogRESERVATION_1TIME dialogRESERVATION = new SwingDialogRESERVATION_1TIME(rm);
					dialogRESERVATION.setVisible(true);
				} // if
			}}
		); // addActionListener end
		add(reservation);
		
		JButton deleteReservation = new JButton("예약 취소");
		deleteReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("예약 취소")) {
					SwingDialogDELETERESERVATION_1LIST dialogDELETERESERVATION = new SwingDialogDELETERESERVATION_1LIST(rm);
					dialogDELETERESERVATION.setVisible(true);
				} // if
			}}
		); // addActionListener end
		add(deleteReservation);
		
		JMenuBar mb = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		JMenuItem menuOpen = new JMenuItem("open");
		JMenuItem menuSave = new JMenuItem("save");
		JMenuItem menuExit = new JMenuItem("exit");
		menu1.add(menuOpen);
		menu1.add(menuSave);
		menu1.add(menuExit);
		mb.add(menu1);
		setJMenuBar(mb);
		
		menuOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rm.open();
			}}
		);
		
		menuSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rm.save();
			}}
		);
		
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}}
		);
	} //SwingRestaurantManager end
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingRestaurantManager srm = new SwingRestaurantManager();
	}*/

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
} // class end