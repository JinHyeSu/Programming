import java.io.Serializable;
import java.util.Date;

public class Restaurant implements Serializable {// 시리얼(직렬)<-->pararell(병렬)시킬 수 있는 인터페이스가 있다는 의미.
    private Date date; //식사시간
    private String name; //고객명
    private String seat; //좌석
    private String[] food; //주문한 음식들
    private static String[] menu = {"곱창", "막창", "대창", "모듬", "염통", "육회.간", "볶음밥", "소주", "맥주", "막걸리"}; //주문 가능한 음식들
    private static int[] price = {10000,  12000, 13000, 15000, 6000,   5000,   2000,   4000,  4000,  3000}; //음식들 가격
    private int money; //가격
    private String reservation; //일반손님인지 예약손님인지 구분(R:예약손님 ,N: 일반손님)
    private static String[] canSEAT = new String[10]; //좌석이 차있는지 아닌지 구분
    
    public Restaurant(Date date, String name, String seat, String[] food, int money, String reservation) {//데이터클래스라 메인 없이 그냥 생성자
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