import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RestaurantObjectOutput{
    
    public void output(ArrayList restaurant) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
        ArrayList list = new ArrayList();
        list=restaurant;
        
        try{
            fout = new FileOutputStream("restaurantlist.dat");
            oos = new ObjectOutputStream(fout);
            
            oos.writeObject(list);
            oos.reset();
            oos.writeObject(list);
            oos.reset();
            
            System.out.println("저장되었습니다");
            
        }catch(Exception ex){
        }finally{
            try{
                oos.close();
                fout.close();
            }catch(IOException ioe){}
        } // finally
    } // output end
} // class end
