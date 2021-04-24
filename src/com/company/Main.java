package com.company;

import com.company.service.StudentService;
import com.company.service.TeacherService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Teacher or student");
            String type = new Scanner(System.in).nextLine();
            if (type.equalsIgnoreCase("Student")) {
                StudentService.showMenu();
            } else if (type.equalsIgnoreCase("Teacher")) {
                TeacherService.showMenu();
            }
        }
    }

}
