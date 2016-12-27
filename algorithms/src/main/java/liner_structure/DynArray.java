package liner_structure;

/**
 * Created by john on 16-12-27.
 * function: 动态数组自我实现
 */
public class DynArray<T> {
    /**
     * 动态数组增长倍率
     */
    private int increaseRate=2;
    private final int INITLENGTH=2;
    private int index=0;
    private int max=INITLENGTH;

    private T[] array=(T[])new Object[max];

    public synchronized void put(T elem){
        //1、 insert
        array[index++]=elem;
        //2、check space
        checkSpace();
    }

    public synchronized T get(int index){
        T t=null;
        if(index<=max && index>=0){
            return array[index];
        }
        return t;
    }

    /**
     * 对数组 空间容量做检查，容量不够则扩容
     */
    private void checkSpace(){
        if(index>=max){
            //extend space
            synchronized (this){
                while(index>=max){
                    max=max * increaseRate;
                    T[] newArray=(T[])new Object[max];
                    copyArray(array,newArray);
                    array=newArray;
                }
            }
        }
    }

    private void copyArray(T[] oldArray,T[] newArray){
        for(int i=0;i<oldArray.length;i++){
            newArray[i]=oldArray[i];
        }
    }

    public int getSize(){
        return index;
    }
}
