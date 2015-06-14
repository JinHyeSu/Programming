import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SwingDialogADD_2MENUPAN extends JDialog implements ItemListener {
	private String[] menu = Restaurant.getMenu();
	private String[] food = new String[menu.length];
	private int num = 0;
	private JPanel pan1;
	private JPanel pan2;
	public SwingDialogADD_2MENUPAN(RestaurantManager rm, String seat) {
		super();
		setLayout(new BorderLayout());
		setTitle("∏ﬁ¥∫ º±≈√");
		setSize(300,500);
		
		pan1 = new JPanel();
		pan1.setLayout(new GridLayout(5,2));
		
		for(int i=0;i<food.length;i++) { food[i]="X"; }
		
		Checkbox cb1 = null, cb2 = null, cb3 = null, cb4 = null, cb5 = null, cb6 = null, cb7 = null, cb8 = null, cb9 = null, cb10 = null;
		
		checkbox(cb1,0); // ∞ˆ√¢
		checkbox(cb2,1); // ∏∑√¢
		checkbox(cb3,2); // ¥Î√¢
		checkbox(cb4,3); // ∏µÎ
		checkbox(cb5,4); // ø∞≈Î
		checkbox(cb6,5); // ¿∞»∏.∞£
		checkbox(cb7,6); // ∫∫¿Ωπ‰
		checkbox(cb8,7); // º“¡÷
		checkbox(cb9,8); // ∏∆¡÷
		checkbox(cb10,9); // ∏∑∞…∏Æ
		
		pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		
		JButton select = new JButton("º±≈√");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("º±≈√")) {
					if(num>0) {
						SwingDialogADD_3NAME dialogNAME = new SwingDialogADD_3NAME(rm,seat,food);
						dialogNAME.setVisible(true);
						setVisible(false);
					}
				}
			}}
		); // addActionListener end
		pan2.add(select);
		
		add(pan1, BorderLayout.CENTER);
		add(pan2, BorderLayout.SOUTH);
	} // SwingDialogADD_2MENUPAN end
	
	public void checkbox(Checkbox cb, int i) {
		cb = new Checkbox(menu[i]);
		pan1.add(cb);
		cb.addItemListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			for(int i=0;i<food.length;i++) {
				if(menu[i].equals((String) e.getItem())) {
					food[i] = "O";
					if(i>=0 && i<4) { num++; }
				} // if
			} // for
		} // if
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			for(int i=0;i<food.length;i++) {
				if(menu[i] == (String) e.getItem()) {
					food[i] = "X";
					if(i>=0 && i<4) { num--; }
				} // if
			} // for
		} // if
	} // itemStateChanged end
} // class end
