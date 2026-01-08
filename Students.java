
package dina120220014;

import java.util.ArrayList;
import java.util.List;

public class Students {
    
   //Student details 
   private String FirstName;
     private String LastName;
    private String ID;
    private String Gender;
    private List <Courses> courses;// list to hold the courses for student

    //Default constructor
    public Students() {
         this.courses = new ArrayList<>();
    }
    
  // parameterized constructor
    public Students(String FirstName, String LastName, String ID, String Gender) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.ID = ID;
        this.Gender = Gender;
        this.courses = new ArrayList<>();
    }
    
     // parameterized constructor
    public Students(String FirstName, String LastName, String ID, String Gender, List<Courses> courses) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.ID = ID;
        this.Gender = Gender;
        this.courses = courses;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void addCourses(Courses course) {
        this.courses.add(course);
    }
  
    
    //calculate and returns the GPA
    public double CalculateGPA(){
        if(courses.isEmpty())
            return 0;
        double totalMarks=0.0;
       for(int i=0;i<courses.size();i++){
      totalMarks+= courses.get(i).calTotal();
  }
    return totalMarks/ courses.size();
    }
    
   }
    

