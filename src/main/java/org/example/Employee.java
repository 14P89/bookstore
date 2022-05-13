package org.example;

import javax.persistence.*;

@Entity
@Table (name = "employees")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String surname;
    private String jobTitle;
    private int age;
    private int salary;

    public Employee() {
    }

    public Employee(int id, String name, String surname, String jobTitle, int age, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "org.example.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
