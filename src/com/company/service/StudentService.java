package com.company.service;

import com.company.bean.Student;
import com.company.store.AppStorage;

import java.util.Scanner;

public class StudentService {
    public static void showMenu() {
        System.out.println("Please choose action from menu:\n" +
                "1.Register student\n" +
                "2.delete student\n" +
                "3.find student\n" +
                "4.show all student\n" +
                "5. Exit");
        int menuId = new Scanner(System.in).nextInt();
        if (menuId == 1) {
            registerStudent();
        } else if (menuId == 2) {
            deleteStudent();
        } else if (menuId == 3) {
            findStudent();
        } else if (menuId == 4) {
            showAllStudents();
        } else if (menuId == 5) {
            System.out.println("App exited");
            return;
        } else {
            System.out.println("menu id is wrong. please choose again");
        }
    }

    public static Student registerStudent() {
        Student student = new Student(AppStorage.currentStudentIndex + 1,
                requireString("enter name"), requireString("enter surname"),
                requireDouble("enter scholorship"));
        AppStorage.students[AppStorage.currentStudentIndex++] = student;
        System.out.println("student successfully registered" + student);
        return student;
    }


    public static void deleteStudent() {
        showAllStudents();
        int id = requireInteger("type student id to  delete");
        for (int i = 0; i < AppStorage.students.length; i++) {
            if (AppStorage.students[i] != null && AppStorage.students[i].getId() == id) {
                System.out.println("sucessfully deleted" + AppStorage.students[i]);
                AppStorage.students[i] = null;
            }
        }
        showAllStudents();
    }

    public static void findStudent() {
        String findKey = requireString("type name , surname , scholorship or id ");
        for (int i = 0; i < AppStorage.students.length; i++) {
            if (AppStorage.students[i] != null) {
                if (AppStorage.students[i].toString().contains(findKey)) {
                    System.out.println("found:" + AppStorage.students[i]);

                }

            }
        }
    }

    public static Student findStudentById(int id) {
        for (int i = 0; i < AppStorage.students.length; i++) {
            if (AppStorage.students[i] != null) {
                if (AppStorage.students[i].getId() == id) {
                    return AppStorage.students[i];
                }

            }
        }
        return null;
    }

    public static void showAllStudents() {
        System.out.println("All students:");
        for (int i = 0; i < AppStorage.students.length; i++) {
            if (AppStorage.students[i] != null)
                System.out.println(AppStorage.students[i]);

        }
    }

    public static String requireString(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextLine();
    }

    public static Double requireDouble(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextDouble();
    }

    public static Integer requireInteger(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextInt();
    }
}
