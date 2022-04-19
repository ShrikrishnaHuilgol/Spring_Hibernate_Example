package com.bean;

import com.dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring.xml");
        EmployeeDao employeeDao=(EmployeeDao) applicationContext.getBean("edao");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String name,city;
        float salary;

        do{
            System.out.println("1.Insert\n2.Update\n3.Display\n4.Delete\n5.Exit");
            int ch= Integer.parseInt(br.readLine());

            switch (ch){
                case 1:System.out.println("Enter employee name,city,salary");
                        Employee employee=new Employee();
                        employee.setName(br.readLine());
                        employee.setCity(br.readLine());
                        employee.setSalary(Float.parseFloat(br.readLine()));
                        employeeDao.insert(employee);
                        System.out.println("Employee added successfully");
                        break;
                case 2:
                    System.out.println("Enter employee id,name,city,salary");
                    Employee employee1 = new Employee();
                    employee1.setId(Integer.parseInt(br.readLine()));
                    employee1.setName(br.readLine());
                    employee1.setCity(br.readLine());
                    employee1.setSalary(Float.parseFloat(br.readLine()));
                    employeeDao.updateEmployee(employee1);
                    System.out.println("Employee updated successfully");
                    break;
                case 3:
                    List<Employee> employees=employeeDao.displayEmployee();
                    for(Employee employee2:employees){
                        System.out.println(employee2);
                    }
                    break;
                case 4:
                    System.out.println("Enter employee id");
                    int id=Integer.parseInt(br.readLine());
                    employeeDao.deleteEmployee(id);
                    System.out.println("Employee removed successfully");
                    break;
                case 5:System.exit(0);
            }
        }while (true);
    }
}
