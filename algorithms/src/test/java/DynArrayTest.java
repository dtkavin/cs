import liner_structure.DynArray;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by john on 16-12-27.
 */
public class DynArrayTest {
    DynArray<Integer> array=null;
    @Before
    public void init(){
        array=new DynArray<Integer>();
    }

    //@Test
    public void cycle(){
        put();
        get();
    }

    @Test
    public void mult_cycle(){

        Thread thread1=new Thread(){
            @Override
            public void run() {
                int i=0;
                while(i++<3333){
                  array.put(i);
                System.out.println(Thread.currentThread().getName()+", "+i);
                }
            }
        };
        Thread thread2=new Thread(){
            @Override
            public void run() {
                int i=3333;
                while(i++<6666){
                    array.put(i);
                System.out.println(Thread.currentThread().getName()+", "+i);
                }
            }
        };
        Thread thread3=new Thread(){
            @Override
            public void run() {
                int i = 6666;
                while(i++<9999){
                    array.put(i);
                System.out.println(Thread.currentThread().getName()+", "+i);
                }
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
try{

        Thread.sleep(10000);
}catch (Exception e){
    e.printStackTrace();
}
        get();
    }

    public void get(){
        System.out.println("================================");
        System.out.println("array length: "+array.getSize());
        Integer int2 = array.get(2);
        System.out.println(int2);

        Integer int10 = array.get(888);
        System.out.println(int10);
    }


    public void put(){
        for (int i=0;i<12;i++){
            array.put(new Integer(i));
        }
        System.out.println("array length: "+array.getSize());
    }




}
