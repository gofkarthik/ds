package ds_ref.greedyAlgorithms;


import java.util.ArrayList;
import java.util.List;

class Employee{
    int i=10;

    public String toString(){
        return ""+this.i;
    }
}
public class Test {

    static void test(int [] abc){
        abc=null;
    }

    static int[] test1(int [] abc){
        abc=null;
        return abc;
    }

    static void  test1(Employee e){
        e.i=40;
    }

    public static void main(String[] args) {
        /*Employee e=new Employee();
        e.i=20;
        List<Employee> e1=new ArrayList<>();
        e1.add(e);
        Employee e2 = e1.get(0);
        e2.i=25;
        System.out.println(e1);
        System.out.println(e.i);
        System.out.println(e2.i);*/
        int[] aa=new int[]{1,2};
        test(aa);
        System.out.println(aa);
        aa=test1(aa);
        System.out.println(aa);
        Employee e=new Employee();
        e.i=20;
        System.out.println(e);
        test1(e);
        System.out.println(e);

    }
}
