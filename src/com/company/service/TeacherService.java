package com.company.service;

import com.company.bean.Student;
import com.company.bean.Teacher;
import com.company.store.AppStorage;

import java.util.Scanner;

public class TeacherService {
    public static void showMenu() {
        System.out.println("Please choose action from menu:\n" +
                "1.Register Teacher\n" +
                "2.delete Teacher\n" +
                "3.find Teacher\n" +
                "4.show all Teacher\n" +
                "5.Assign Student to Teacher\n" +
                "6. Exit");
        int menuId = new Scanner(System.in).nextInt();
        if (menuId == 1) {
            registerTeacher();
        } else if (menuId == 2) {
            deleteTeacher();
        } else if (menuId == 3) {
            findTeacher();
        } else if (menuId == 4) {
            showAllTeacher();
        } else if (menuId == 5) {
            assignStudentToTeacher();
        } else if (menuId == 6) {
            System.out.println("App exited");
            return;
        } else {
            System.out.println("menu id is wrong. please choose again");
        }
    }


    public static void registerTeacher() {
        Teacher teacher = new Teacher(AppStorage.currentTeacherIndex + 1,
                requireString("enter name"), requireString("enter surname"),
                requireDouble("enter salary"));
        AppStorage.teachers[AppStorage.currentTeacherIndex++] = teacher;
        System.out.println("student successfully registered" + teacher);
    }


    public static void deleteTeacher() {
        showAllTeacher();
        int id = requireInteger("type Teacher id to  delete");
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null && AppStorage.teachers[i].getId() == id) {
                System.out.println("sucessfully deleted" + AppStorage.teachers[i]);
                AppStorage.teachers[i] = null;
            }
        }
        showAllTeacher();
    }

    public static void findTeacher() {
        String findKey = requireString("type name , surname , salary or id ");
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null) {
                if (AppStorage.teachers[i].print().contains(findKey)) {
                    System.out.println("found:" + AppStorage.teachers[i]);

                }

            }
        }
    }

    public static Teacher findTeacherById(int id) {
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null) {
                if (AppStorage.teachers[i].getId() == id) {
                    return AppStorage.teachers[i];
                }

            }

        }
        return null;
    }

    public static void showAllTeacher() {
        System.out.println("All teacher:");
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null)
                System.out.println(AppStorage.teachers[i]);

        }

    }

    public static void assignStudentToTeacher() {
        System.out.println("hansi muellime yeni telebe elave etmek isdeyirsiniz");
        showAllTeacher();
        int teacherId = new Scanner(System.in).nextInt();
        Teacher foundTeacher = findTeacherById(teacherId);
        System.out.println("hansi telebeni teyin etmek isdeyirsen");
        StudentService.showAllStudents();
        int studentId = new Scanner(System.in).nextInt();
        Student foundStudent = StudentService.findStudentById(studentId);
        boolean isAlreadyAssigned = false;
        for (int i = 0; i < foundTeacher.getStudents().length; i++) {
            if (foundTeacher.getStudents()[i].getId() == studentId) {
                System.out.println("already assigned");
                isAlreadyAssigned = true;
                break;
            }

        }
        if (!isAlreadyAssigned)
            foundTeacher.getStudents()[foundTeacher.lastStudetIndex++] = foundStudent;
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
