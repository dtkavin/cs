import com.github.dtkavin.entity.Employee;
import com.github.dtkavin.entity.Person;
import com.github.dtkavin.entity.Student;
import org.junit.Test;

/**
 * Created by john on 17-1-2.
 */
public class ArrayTest {

    @Test
    public void test1(){
          Person[] persons=new Employee[5];
          persons[0]= new Student();
        System.out.println("Hello");

        /**
         * 原因，Java数组是类型兼容的，称为协变数组类型，编译会通过，但是运行会报错，
         * 采用泛型可以将错误提示  提前 到  编译阶段
         *
         * java.lang.ArrayStoreException: com.github.dtkavin.entity.Student

         at ArrayTest.test1(ArrayTest.java:14)
         at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
         at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         */
    }
}
