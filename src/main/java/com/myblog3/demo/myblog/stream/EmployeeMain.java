package com.myblog3.demo.myblog.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> emp = Arrays.asList(
                new Employee("Ahmed",23,"Mumbai"),
                new Employee("jabir",25,"Gujarat"),
                new Employee("Mohammed",23,"Mumbai"),
                new Employee("Jawad",32,"Hyderabad")
                );
//===========Group the Data Based On The same City=====================
//        Map<String, List<Employee>> collect = emp.stream().collect(Collectors.groupingBy(e -> e.getCity()));
//
//        for(Map.Entry<String,List<Employee>> entry : collect.entrySet()){
//            String city = entry.getKey();
//            List<Employee> listEmp = entry.getValue();
//            System.out.println("City --> : "+city);
//            listEmp.forEach(employee -> System.out.println("Name : "+employee.getName()+"\n"+"Age : "+employee.getAge()));
//            System.out.println();
//        }

//=============Group the data based on the same age=======================

//        Map<Integer, List<Employee>> collect = emp.stream().collect(Collectors.groupingBy(e -> e.getAge()));
//
//        for(Map.Entry<Integer,List<Employee>> entry : collect.entrySet()){
//            Integer age = entry.getKey();
//            List<Employee> allValue = entry.getValue();
//            System.out.println("Age : "+age);
//            allValue.forEach(e -> System.out.println("Name : "+e.getName()+"\n"+"City : "+e.getCity()));
//            System.out.println();
//        }

//==============Find the Data Which name is startWith("A")=======================================
//        List<Employee> result = emp.stream().filter(e -> e.getName().startsWith("A")).collect(Collectors.toList());
//        for (Employee e : result){
//            System.out.println(e.getName());
//            System.out.println(e.getCity());
//            System.out.println(e.getAge());
//            System.out.println();
//        }

//==============Find the Even Number And Square that number========================================
//        List<Integer> number  = Arrays.asList(292,32,34,12,43,36);
//        List<Integer> collect = number.stream().filter(e -> e % 2==0).map(e -> e * e).collect(Collectors.toList());
//        System.out.println(collect);
    }
}
