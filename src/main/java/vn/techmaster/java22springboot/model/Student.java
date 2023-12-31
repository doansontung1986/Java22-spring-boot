package vn.techmaster.java22springboot.model;

import lombok.ToString;

@ToString
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        System.out.println("Student constructor");
        this.id = id;
        this.name = name;
    }
}
