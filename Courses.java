
package dina120220014;
public class Courses {
   //the parameeter
    private String courseName;
    private String courseID;
    private double firstExamMark;
    private double SecondExamMark;
    private double finalExamMark;

     // parameterized constructor
    public Courses(String courseName, String courseID, double firstExamMark, double SecondExamMark, double finalExamMark) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.firstExamMark = firstExamMark;
        this.SecondExamMark = SecondExamMark;
        this.finalExamMark = finalExamMark;
    }
      // // default  constructor
    public Courses() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public double getFirstExamMark() {
        return firstExamMark;
    }

    public void setFirstExamMark(double firstExamMark) {
        this.firstExamMark = firstExamMark;
    }

    public double getSecondExamMark() {
        return SecondExamMark;
    }

    public void setSecondExamMark(double SecondExamMark) {
        this.SecondExamMark = SecondExamMark;
    }

    public double getFinalExamMark() {
        return finalExamMark;
    }

    public void setFinalExamMark(double finalExamMark) {
        this.finalExamMark = finalExamMark;
    }
    // calculate and return the total marks  
   public double calTotal(){
    return firstExamMark+SecondExamMark+finalExamMark;
}    
    
}


