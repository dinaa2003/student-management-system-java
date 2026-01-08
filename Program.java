/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dina120220014;

import java.util.ArrayList;
import java.util.List;

public class Program {
     List<Students> students;

    public Program() {
        this.students= new ArrayList<>();

    }
    // Add new student to the list
    public void addStudents(Students student){
        students.add(student);
    }
    // Display Students with their details
   public void getStudentInfo(){
       for(int student=0;student<students.size();student++){
        System.out.println("Student Name: "+ students.get(student).getFirstName()+" "+students.get(student).getLastName() );
           System.out.println("GPA: "+ students.get(student).CalculateGPA());
           System.out.println("Student Courses : ");
           
           for(int i=0;i<students.get(student).getCourses().size();i++){
           Courses course= students.get(student).getCourses().get(i);
               System.out.println("* "+course.getCourseName()+" Total of Marks : "+ course.calTotal());

         }
       }
   } 

  }
