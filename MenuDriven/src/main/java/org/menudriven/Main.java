package org.menudriven;

import org.menudriven.Entity.Emp;
import org.menudriven.db.EmpDao;

import java.util.Scanner;

public class Main {
    private static int choice=0;
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[]args){
        EmpDao ed=new EmpDao();
        ed.connectTodb();
        do {
            System.out.println("1.Register\n2.GetNameByid\n3.Getall\n4.Update\n5.Delete");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    Emp emp=new Emp();
                    System.out.println("Enter Id");
                    emp.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter Name");
                    emp.setName(sc.nextLine());
                    System.out.println("Enter Department");
                    emp.setDepartment(sc.nextLine());
                    System.out.println("Enter Salary");
                    emp.setSalary(sc.nextDouble());
                    int register=ed.register(emp);
                    if(register>0){
                        System.out.println(emp.getName()+" added successfully");
                    }else{
                        System.out.println("Issue in register");
                    }
                    break;
                case 2:
                    System.out.println("Enter Id:");
                    ed.getNameByid(sc.nextInt());
                    break;
                case 3:
                    ed.getAll();
                    break;
                case 4:
                    Emp e=new Emp();
                    System.out.println("Enter Id");
                    e.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter new name");
                    e.setName(sc.nextLine());
                    System.out.println("Enter new department");
                    e.setDepartment(sc.nextLine());
                    System.out.println("Enter new salary");
                    e.setSalary(sc.nextDouble());
                    if(ed.update(e)>0){
                        System.out.println("Updated Successfully");
                    }else{
                        System.out.println("Id not found");
                    }
                    break;
                case 5:
                    System.out.println("Enter Id");
                    int deleteId=sc.nextInt();
                    int delete=ed.delete(deleteId);
                    if(delete>0){
                        System.out.println("Deleted successfully");
                    }else{
                        System.out.println("Id not found");
                    }
                    break;
                default:
                    System.out.println("Enter valid choice");

            }
        }while(choice!=0);
    }
}
