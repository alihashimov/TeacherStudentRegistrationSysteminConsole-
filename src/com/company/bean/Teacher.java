package com.company.bean;

import java.util.Arrays;

public class Teacher {
    public int lastStudetIndex = 0;
    private Integer id;
    private String name;
    private String surname;
    private Double salary;
    private Student[] students = new Student[100];

    public Teacher(Integer id, String name, String surname, Double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }


    public String print() {
        return id +
                "," + name + '\'' +
                "," + surname + '\'' +
                "," + salary;

    }

    @Override
    public String toString() {
        return
                id +
                        "," + name + '\'' +
                        "," + surname + '\'' +
                        "," + salary +
                        "," + Arrays.toString(students);

    }
}
