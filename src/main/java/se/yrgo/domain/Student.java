package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;
    private int numberOfCourses;

    public Student() {}

    public Student(String name)
    {
    	this.name = name;
        this.numberOfCourses = 10;
    }

   @Override
    public String toString() {
        return "Student: " + name;
    }
}
