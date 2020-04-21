package com.ac.array;

/**
 * Description:
 * <p>
 * Created by aochong on 2020/4/18
 *
 * @author aochong
 * @version 1.0
 */
public class Student {
    private String name;
    private int age;

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, age: %d)",name, age);
    }

    public static void main(String[] args) {
        Array<Student> students = new Array<Student>();
        students.addLast(new Student("Alice",17));
        students.addLast(new Student("Bob",15));
        students.addLast(new Student("Charlie",20));
        System.out.println(students);
    }
}
