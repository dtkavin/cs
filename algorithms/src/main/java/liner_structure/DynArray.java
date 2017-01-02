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
    private final int INIT_LENGTH=8;
    private int index=0;
    private int max=INIT_LENGTH;

    private T[] array=(T[])new Object[max];

    /**
     * 按顺序放置
     * @param elem
     */
    public synchronized void put(T elem){
        //1、 insert
        array[index++]=elem;
        //2、check space
        checkSpace();
    }

    /**
     * 提取index数据，如果没有数，则返回null
     * @param index
     * @return
     */
    public synchronized T get(int index){
        T t=null;
        if(index<=max && index>=0){
            return array[index];
        }
        return t;
    }

    /**
     * 对应位置添加,如果原来位置有数据，则覆盖
     * @param index
     * @param elem
     */
    public synchronized boolean addOrUpdate(int index,T elem){
        if(index<0)return false;
        if(index>=0 || index <= max){
            array[index]=elem;
        }else{

        }

        return true;
    }

    /**
     * 删除对应数据，如果没有数，则 返回null
     * @param index
     */
    public synchronized void remove(int index){

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
