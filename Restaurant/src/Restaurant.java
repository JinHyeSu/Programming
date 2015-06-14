import java.io.Serializable;
import java.util.Date;

public class Restaurant implements Serializable {// �ø���(����)<-->pararell(����)��ų �� �ִ� �������̽��� �ִٴ� �ǹ�.
    private Date date; //�Ļ�ð�
    private String name; //����
    private String seat; //�¼�
    private String[] food; //�ֹ��� ���ĵ�
    private static String[] menu = {"��â", "��â", "��â", "���", "����", "��ȸ.��", "������", "����", "����", "���ɸ�"}; //�ֹ� ������ ���ĵ�
    private static int[] price = {10000,  12000, 13000, 15000, 6000,   5000,   2000,   4000,  4000,  3000}; //���ĵ� ����
    private int money; //����
    private String reservation; //�Ϲݼմ����� ����մ����� ����(R:����մ� ,N: �Ϲݼմ�)
    private static String[] canSEAT = new String[10]; //�¼��� ���ִ��� �ƴ��� ����
    
    public Restaurant(Date date, String name, String seat, String[] food, int money, String reservation) {//������Ŭ������ ���� ���� �׳� ������
        this.date = date;
        this.name = name;
        this.seat = seat;
        this.food = food;
        this.money = money;
        this.reservation = reservation;
    }
    
    public Date getDATE() { return date; }
    public String getName() { return name; }
    public String getSeat() { return seat; }
    public String[] getFood() { return food; }
    public static String[] getMenu() { return menu; }
    public static int[] getPrice() { return price; }
    public int getMoney() { return money; }
    public String getReservation() { return reservation; }
    public static String[] getCanSeat() { return canSEAT; }
    
    public void setDATE(Date date) { this.date = date; }
    public void setName(String name) { this.name = name; }
    public void setSeat(String seat) { this.seat = seat; }
    public void setFood(String[] food) { this.food = food; }
    public void setMoney(int money) { this.money = money; }
    public void setReservation(String reservation) { this.reservation = reservation; }
    public static void setCanSeat(String[] canSeat) { canSEAT = canSeat; }
    
    public String toString(){
    	String tostring = getDATE() + "," + getName() + "," + getSeat() + ",";
    	for(int i=0;i<food.length;i++) {
    		tostring += food[i] + ",";
    	}
    	tostring += getMoney() + "," + getReservation();
        return tostring;
    }
} // class end