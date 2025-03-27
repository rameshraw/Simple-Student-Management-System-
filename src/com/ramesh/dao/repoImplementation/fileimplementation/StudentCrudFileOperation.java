package com.ramesh.dao.repoImplementation.fileimplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ramesh.dao.repository.StudentCrud;
import com.ramesh.models.Student;

public class StudentCrudFileOperation implements StudentCrud {
    private String filename;
    private List<Student> students = new ArrayList<>();

    public StudentCrudFileOperation(){

    }

    public StudentCrudFileOperation(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(Student student) {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(student.getId() + "," + student.getName() + "," + student.getEmail() + "\n");
            students.add(student);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Student> getall() {
         
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int i=0;
            int studentsize = students.size();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if(students.get(i).getId()!=Integer.parseInt(data[0]) && studentsize>0){

                    students.add(new Student(Integer.parseInt(data[0]), data[1], data[2]));
                }
                else{
                    continue;
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void update( int id,Student updatedStudent) {
        List<Student> students = getall();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                if (s.getId() == id) {
                    writer.write(updatedStudent.getId() + "," + updatedStudent.getName() + "," + updatedStudent.getEmail() + "\n");
                } else {
                    writer.write(s.getId() + "," + s.getName() + "," + s.getEmail() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        List<Student> students = getall();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                if (s.getId() != id) {
                    writer.write(s.getId() + "," + s.getName() + "," + s.getEmail() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    

