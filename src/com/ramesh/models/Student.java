package com.ramesh.models;



public class Student {
    private int id;
    private String name;
    private String email;
    public static int count;

    // Constructor
    
    public Student(int id, String name, String email) {
        count++;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student() {
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Display student info
    @Override
    public String toString() {
        return id + ", " + name + ", " + email;
    }
}
 
