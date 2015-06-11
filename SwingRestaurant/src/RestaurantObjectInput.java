import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RestaurantObjectInput{

	public ArrayList input() {
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		ArrayList list = null;
		
		try{
			fin = new FileInputStream("restaurantlist.dat");
			ois = new ObjectInputStream(fin);
			
			list = (ArrayList)ois.readObject();
			for(int i=0;i<list.size();i++) {
				Restaurant r = (Restaurant)list.get(i);
				System.out.println(r.toString());
			}
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} // finally
		return list;
	} // input end
} // class end