package com.example.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

   //define fields
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_Name")
    private String first_Name;
    @Column(name = "last_Name")
    private String last_Name;
    @Column (name = "email")
    private String email;

    Employee(){

    }

    public Employee(String first_Name, String last_Name, String email) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfirst_Name() {
        return first_Name;
    }

    public void setfirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getlast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

