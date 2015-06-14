import java.util.*;

public class RestaurantManager {
	Scanner sc = new Scanner(System.in);
	ArrayList list = new ArrayList();
	
	public void open() {
		RestaurantObjectInput input = new RestaurantObjectInput();
		list = input.input();
	} // open
	
	public void save() {
		RestaurantObjectOutput output = new RestaurantObjectOutput();
		output.output(list);
	} // save
	
	public void add(Date date, String name, String seat, String[] food, int money, String reservation) {
		Restaurant r = new Restaurant(date, name, seat, food, money, reservation);
		
		list.add(r);
	} // add
	
	public void adjust(int num, Date date, String name, String seat, String[] food, int money, String reservation) {
		if(list.size() > 0) {
			if(num<=list.size() && num>0) {
				Restaurant r = new Restaurant(date, name, seat, food, money, reservation);
				
				list.set(num-1, r);
			}
		}
	} // adjust
	
	public void delete(int num) {
		if(list.size() > 0) {
			if(num<=list.size() && num>0) { list.remove(num-1); }
		}
	} // delete
	
	public String[][] find(String find, int num) {
		String[][] result = new String[listSize()+1][findSize()+2];
		for(int i=0;i<result.length;i++) { result[i][0] = "-"; result[i][1] = "-"; }
		int row = 0; // 행
		int all_money = 0; // 총합
		if(num==2) { // 고객명 검색
			for(int i=0;i<list.size();i++) {
				if(find.equals( ((Restaurant) list.get(i)).getName() ) ) {
					String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
					Date date = ((Restaurant) list.get(i)).getDATE();
					String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
					
					String seat = ((Restaurant) list.get(i)).getSeat();
					
					String[] foods = ((Restaurant) list.get(i)).getFood();
					String[] menu = Restaurant.getMenu();
					String food = null;
					for(int f=0;f<foods.length;f++) {
						if(foods[f].equals("O")) { food += ", "+menu[f]; }
					}
					food = food.substring(6);
					
					String money = Integer.toString(((Restaurant) list.get(i)).getMoney());
					String reservation = ((Restaurant) list.get(i)).getReservation();
					
					String managerNum = managerNum(reservation, date, find);
					
					result[row][0]=Integer.toString(row+1);
					result[row][1]=time;
					result[row][2]=find;
					result[row][3]=seat;
					result[row][4]=food;
					result[row][5]=money;
					result[row][6]=reservation;
					result[row][7]=managerNum;
					row++;
					all_money += ((Restaurant) list.get(i)).getMoney();
				} // if
			} // for
		} // if
		else if(num==3) { // 좌석 검색
			for(int i=0;i<list.size();i++) {
				if(find.equals( ((Restaurant) list.get(i)).getSeat() ) ) {
					String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
					Date date = ((Restaurant) list.get(i)).getDATE();
					String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
					
					String name = ((Restaurant) list.get(i)).getName();
					
					String[] foods = ((Restaurant) list.get(i)).getFood();
					String[] menu = Restaurant.getMenu();
					String food = null;
					for(int f=0;f<foods.length;f++) {
						if(foods[f].equals("O")) { food += ", "+menu[f]; }
					}
					food = food.substring(6);
					
					String money = Integer.toString(((Restaurant) list.get(i)).getMoney());
					String reservation = ((Restaurant) list.get(i)).getReservation();
					
					String managerNum = managerNum(reservation, date, name);
					
					result[row][0]=Integer.toString(row+1);
					result[row][1]=time;
					result[row][2]=name;
					result[row][3]=find;
					result[row][4]=food;
					result[row][5]=money;
					result[row][6]=reservation;
					result[row][7]=managerNum;
					row++;
					all_money += ((Restaurant) list.get(i)).getMoney();
				} // if
			} // for
		} // if
		else if(num==4) { // 음식 검색
			String[] menu = Restaurant.getMenu();
			int find_num = -1;
			for(int i=0;i<menu.length;i++) {
				if(find.equals(menu[i])) {
					find_num=i;
				}
			}
			for(int i=0;i<list.size();i++) {
				String[] foodS = ((Restaurant) list.get(i)).getFood();
				if(find_num != -1 && foodS[find_num].equals("O")) {
					String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
					Date date = ((Restaurant) list.get(i)).getDATE();
					String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
					
					String name = ((Restaurant) list.get(i)).getName();
					String seat = ((Restaurant) list.get(i)).getSeat();
					
					String[] foods = ((Restaurant) list.get(i)).getFood();
					String food = null;
					for(int ff=0;ff<foods.length;ff++) {
						if(foods[ff].equals("O")) { food += ", "+menu[ff]; }
					}
					food = food.substring(6);
					
					String money = Integer.toString(((Restaurant) list.get(i)).getMoney());
					String reservation = ((Restaurant) list.get(i)).getReservation();
					
					String managerNum = managerNum(reservation, date, name);
					
					result[row][0]=Integer.toString(row+1);
					result[row][1]=time;
					result[row][2]=name;
					result[row][3]=seat;
					result[row][4]=food;
					result[row][5]=money;
					result[row][6]=reservation;
					result[row][7]=managerNum;
					row++;
					all_money += ((Restaurant) list.get(i)).getMoney();
				} // if
			} // for
		} // if
		else if(num==5) { // 예약 검색
			for(int i=0;i<list.size();i++) {
				if(find.equals( ((Restaurant) list.get(i)).getReservation() ) ) { // reservation 검색
					String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
					Date date = ((Restaurant) list.get(i)).getDATE();
					String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
					
					String name = ((Restaurant) list.get(i)).getName();
					String seat = ((Restaurant) list.get(i)).getSeat();
					
					String[] foods = ((Restaurant) list.get(i)).getFood();
					String[] menu = Restaurant.getMenu();
					String food = null;
					for(int f=0;f<foods.length;f++) {
						if(foods[f].equals("O")) { food += ", "+menu[f]; }
					}
					food = food.substring(6);
					
					String money = Integer.toString(((Restaurant) list.get(i)).getMoney());
					
					String managerNum = managerNum(find, date, name);
					
					result[row][0]=Integer.toString(row+1);
					result[row][1]=time;
					result[row][2]=name;
					result[row][3]=seat;
					result[row][4]=food;
					result[row][5]=money;
					result[row][6]=find;
					result[row][7]=managerNum;
					row++;
					all_money += ((Restaurant) list.get(i)).getMoney();
				} // if
			} // for
		}//if
		
		result[listSize()][0]="ALL";
		result[listSize()][1]="-";
		result[listSize()][2]="-";
		result[listSize()][3]="-";
		result[listSize()][4]="-";
		result[listSize()][5]=Integer.toString(all_money);
		result[listSize()][6]="-";
		result[listSize()][7]="-";
		
		return result;
	} // find
	
	public String[][] find(String find) { // 날짜 검색
		String[][] result = new String[listSize()+1][findSize()+2];
		for(int i=0;i<result.length;i++) { result[i][0] = "-"; result[i][1] = "-"; }
		int row = 0; // 행
		int all_money = 0; // 총합
		boolean right = false;
		int find_year = -1; // 년
		int find_month = -1; // 월
		int find_day = -1; // 일
		int index = find.indexOf(".");
		if(index == -1 && isNum(find)) { // 년도
			find_year = Integer.parseInt(find);
			right = true;
		}
		else if(index == 4 && isNum(find.substring(0, index))) {
			String year = find.substring(0, index);
			find_year = Integer.parseInt(year);
			String month = find.substring(index+1);
			index = month.indexOf(".");
			if(index == -1 && isNum(month)) { // 년도.월
				find_month = Integer.parseInt(month);
				right = true;
			}
			else if(index == 1 || index == 2) {
				String day = month.substring(index+1);
				month = month.substring(0, index);
				if(isNum(day) && isNum(month)) { // 년도.월.일
					find_day = Integer.parseInt(day);
					find_month = Integer.parseInt(month);
					right = true;
				}
			}
		}
		
		if(right) {
			for(int i=0;i<list.size();i++) {
				Date date = ((Restaurant) list.get(i)).getDATE();
				int date_year = date.getYear()+1900;
				int date_month = date.getMonth()+1;
				int date_date = date.getDate();
				
				String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
				String time = date_year+"/"+date_month+"/"+date_date +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
				
				String name = ((Restaurant) list.get(i)).getName();
				String seat = ((Restaurant) list.get(i)).getSeat();
				
				String[] foods = ((Restaurant) list.get(i)).getFood();
				String[] menu = Restaurant.getMenu();
				String food = null;
				for(int f=0;f<foods.length;f++) {
					if(foods[f].equals("O")) { food += ", "+menu[f]; }
				}
				food = food.substring(6);
				
				String money = Integer.toString(((Restaurant) list.get(i)).getMoney());
				String reservation = ((Restaurant) list.get(i)).getReservation();
				
				String managerNum = managerNum(reservation, date, name);
				
				if(find_day == -1 && find_month == -1 && date_year==find_year) { // 년
					result[row][0]=Integer.toString(row+1);
					result[row][1]=time;
					result[row][2]=name;
					result[row][3]=seat;
					result[row][4]=food;
					result[row][5]=money;
					result[row][6]=reservation;
					result[row][7]=managerNum;
					row++;
					all_money += ((Restaurant) list.get(i)).getMoney();
				}
				else if(find_day == -1 && date_year==find_year && date_month==find_month) { // 년.월
					result[row][0]=Integer.toString(row+1);
					result[row][1]=time;
					result[row][2]=name;
					result[row][3]=seat;
					result[row][4]=food;
					result[row][5]=money;
					result[row][6]=reservation;
					result[row][7]=managerNum;
					row++;
					all_money += ((Restaurant) list.get(i)).getMoney();
				}
				else if(find_day != -1 && date_year==find_year && date_month==find_month && date_date==find_day) { // 년.월.일
					result[row][0]=Integer.toString(row+1);
					result[row][1]=time;
					result[row][2]=name;
					result[row][3]=seat;
					result[row][4]=food;
					result[row][5]=money;
					result[row][6]=reservation;
					result[row][7]=managerNum;
					row++;
					all_money += ((Restaurant) list.get(i)).getMoney();
				}
			} // for
			
		result[listSize()][0]="ALL";
		result[listSize()][1]="-";
		result[listSize()][2]="-";
		result[listSize()][3]="-";
		result[listSize()][4]="-";
		result[listSize()][5]=Integer.toString(all_money);
		result[listSize()][6]="-";
		result[listSize()][7]="-";

		} // if
		return result;
	} // find
	
	public String[] listAll() {
		String[] listAll = new String[list.size()];
		for(int i=0;i<list.size();i++) {
			String[] dayOFtheWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
			Date date = ((Restaurant) list.get(i)).getDATE();
			String time = (date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate() +" "+ dayOFtheWeek[date.getDay()] +" "+date.getHours()+":"+date.getMinutes();
			
			String[] foods = ((Restaurant) list.get(i)).getFood();
			String[] menu = Restaurant.getMenu();
			String food = null;
			for(int f=0;f<foods.length;f++) {
				if(foods[f].equals("O")) { food += ", "+menu[f]; }
			}
			food = food.substring(6);
			
			String order = (i+1)+") "+time+" "+((Restaurant) list.get(i)).getName()+" "+((Restaurant) list.get(i)).getSeat()+" "+food+" "+((Restaurant) list.get(i)).getMoney();
			listAll[i] = order;
		}
		return listAll;
	} // listAll
	
	public String time(Date now, Date time) {
		long gap = time.getTime() - now.getTime();
		long minute_gap = gap /1000/60;
		if(minute_gap>-60 && minute_gap<60) { return "O"; }
		else if(minute_gap<-60 || minute_gap>60) { return "X"; }
		else { return "X"; }
	} // time
	
	public String[] timeSeat() {
		String[] timeSeat = new String[10];
		for(int i=0;i<timeSeat.length;i++) { timeSeat[i]="X"; }
		for(int i=0;i<list.size();i++) {
			Date time = ((Restaurant) list.get(i)).getDATE();
			String seat = ((Restaurant) list.get(i)).getSeat();
			Date now = new Date();
			if(now.getYear() == time.getYear() && now.getMonth() == time.getMonth() && now.getDate() == time.getDate()) {
				if(seat.equals("A")) { timeSeat[0]=time(now,time); }
				else if(seat.equals("B")) { timeSeat[1]=time(now,time); }
				else if(seat.equals("C")) { timeSeat[2]=time(now,time); }
				else if(seat.equals("D")) { timeSeat[3]=time(now,time); }
				else if(seat.equals("E")) { timeSeat[4]=time(now,time); }
				else if(seat.equals("F")) { timeSeat[5]=time(now,time); }
				else if(seat.equals("G")) { timeSeat[6]=time(now,time); }
				else if(seat.equals("H")) { timeSeat[7]=time(now,time); }
				else if(seat.equals("I")) { timeSeat[8]=time(now,time);}
				else if(seat.equals("J")) { timeSeat[9]=time(now,time); }
			}
		}
		return timeSeat;
	} // timeSeat
	
	public String timeA(Date date, Date time) {
		long gap = time.getTime() - date.getTime();
		long minute_gap = gap /1000/60;
		if(minute_gap<-60 || minute_gap>60) { return "X"; }
		else if(minute_gap>-60 && minute_gap<60) { return "O"; }
		else { return "X"; }
	} // time_adjust
	
	public String[] timeSeatA(Date time) { // time: 수정할 주문의 시간
		String[] timeSeatA = new String[10];
		for(int i=0;i<timeSeatA.length;i++) { timeSeatA[i]="X"; }
		for(int i=0;i<list.size();i++) {
			Date date = ((Restaurant) list.get(i)).getDATE();
			String seat = ((Restaurant) list.get(i)).getSeat();
			if(date.getYear() == time.getYear() && date.getMonth() == time.getMonth() && date.getDate() == time.getDate()) {
				if(seat.equals("A")) { timeSeatA[0]=timeA(date,time); }
				else if(seat.equals("B")) { timeSeatA[1]=timeA(date,time); }
				else if(seat.equals("C")) { timeSeatA[2]=timeA(date,time); }
				else if(seat.equals("D")) { timeSeatA[3]=timeA(date,time); }
				else if(seat.equals("E")) { timeSeatA[4]=timeA(date,time); }
				else if(seat.equals("F")) { timeSeatA[5]=timeA(date,time); }
				else if(seat.equals("G")) { timeSeatA[6]=timeA(date,time); }
				else if(seat.equals("H")) { timeSeatA[7]=timeA(date,time); }
				else if(seat.equals("I")) { timeSeatA[8]=timeA(date,time); }
				else if(seat.equals("J")) { timeSeatA[9]=timeA(date,time); }
			}
		}
		
		return timeSeatA;
	} // timeSeat_adjust
	
	public String timeR(Date date, Date time) {
		long gap = time.getTime() - date.getTime();
		long minute_gap = gap /1000/60;
		if(minute_gap<-60 || minute_gap>60) { return "X"; }
		else if(minute_gap>-60 && minute_gap<60) { return "O"; }
		else { return "X"; }
	} // timeR
	
	public String[] timeSeatR(Date time) { // time: 예약할 시간
		String[] timeSeatR = new String[10];
		for(int i=0;i<timeSeatR.length;i++) { timeSeatR[i]="X"; }
		for(int i=0;i<list.size();i++) {
			Date date = ((Restaurant) list.get(i)).getDATE();
			if(date.getYear() == time.getYear() && date.getMonth() == time.getMonth() && date.getDate() == time.getDate()) {
				String seat = ((Restaurant) list.get(i)).getSeat();
				if(seat.equals("A")) { timeSeatR[0]=timeR(date,time); }
				else if(seat.equals("B")) { timeSeatR[1]=timeR(date,time); }
				else if(seat.equals("C")) { timeSeatR[2]=timeR(date,time); }
				else if(seat.equals("D")) { timeSeatR[3]=timeR(date,time); }
				else if(seat.equals("E")) { timeSeatR[4]=timeR(date,time); }
				else if(seat.equals("F")) { timeSeatR[5]=timeR(date,time); }
				else if(seat.equals("G")) { timeSeatR[6]=timeR(date,time); }
				else if(seat.equals("H")) { timeSeatR[7]=timeR(date,time); }
				else if(seat.equals("I")) { timeSeatR[8]=timeR(date,time); }
				else if(seat.equals("J")) { timeSeatR[9]=timeR(date,time); }
			}
		}
		return timeSeatR;
	} // timeSeatR
	
	public boolean isNum(String text) {
		boolean result = false;
		try{
			Integer.parseInt(text);
			result = true;
		}catch(Exception e) {}
		
		return result;
	} // isNum end
	
	public String managerNum(String wantNum, Date wantNumDate, String wantNumName) {
		int num = 1;
		String getNum = "0";
		for(int i=0;i<list.size();i++) {
			if(wantNum.equals( ((Restaurant) list.get(i)).getReservation() ) ) {
				Date date = ((Restaurant) list.get(i)).getDATE();
				String name = ((Restaurant) list.get(i)).getName();
				if(wantNumDate == date && wantNumName.equals(name)) { getNum = Integer.toString(num); }
				num++;
			} // if
		} // for
		
		return getNum;
	}
	
	public int listSize() { return list.size(); }
	public int findSize() { return 6;}
}