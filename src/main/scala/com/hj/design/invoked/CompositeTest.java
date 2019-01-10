package com.hj.design.invoked;

import com.hj.design.Composite_model.Employee;
import scala.collection.JavaConversions;
import scala.collection.immutable.List;

/**
 * @author hejin-Yu
 * @desc
 */
public class CompositeTest {
    public static void main(String[] args) {

        Employee employee1 = new Employee("张三", "01", 30000);

            /*
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 * 构建树形层次结构
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 */
        employee1.add(new Employee("张思思","01",10000));
        employee1.add(new Employee("张思齐","01",15000));


            /*
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 * 输出这个层次结构
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 */
        List<Employee> subordinates = employee1.getSubordinates();

        java.util.List<Employee> employees = JavaConversions.seqAsJavaList(subordinates);

        for(Employee e : employees){
            System.out.println(e);
        }
    }
}
