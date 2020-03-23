package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.*;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryGrade;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPersonType;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStaff;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class startViewController {

    private Person user;
    private Credentials credentials;

    @Autowired
    private iRepositoryStudent repositoryStudent;

    @Autowired
    private iRepositoryGrade repositoryGrade;

    @Autowired
    private iRepositoryStaff repositoryStaff;

    @Autowired
    private iRepositoryPersonType repositoryPersonType;

    private List<Grade> gradeList;
    private List<Student> studentList;
    private List<Staff> staffList;


    public startViewController() {
    }

    @RequestMapping("/greetuser")
    public String greetUser(Model theModel) {

        studentList = repositoryStudent.findAll();
        staffList = repositoryStaff.findAll();
        gradeList = repositoryGrade.findAll();


        if (credentials.getUserPermission() == 1) {
            for (Student student : studentList) {
                System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                System.out.println("Role: " + student.getPersonType().getPersonTypeTitle());
                System.out.println("StudentId: " + student.getStudentId());
                System.out.println("Student semester: " + student.getSemester());
                System.out.println("Enlisted on program " + student.getEnlistedProgram().getProgramName());
                System.out.println("Courses in program: ");
                for (Course course : student.getEnlistedProgram().getCourseList()) {
                    System.out.println(course.getCourseName());
                }
                System.out.println("====GRADES===\n");

                for (StudentGrade studentGrade : student.getStudentGrades()) {
                    System.out.println(studentGrade.getCourse().getCourseName() + ": " + studentGrade.getGrade().getScore());
                }
            }


            for (Grade grade : gradeList) {
                System.out.println(grade.getScore());
            }
            System.out.println("====END OF PERSON===\n");

        } else if (credentials.getUserPermission() == 3) {
            for (Staff staff : staffList) {
                System.out.println("Name: " + staff.getFirstName() + " " + staff.getLastName());
                System.out.println("Role: " + staff.getPersonType().getPersonTypeTitle());
                System.out.println("StaffID: " + staff.getStaffId());
            }
            System.out.println("====END OF PERSON===\n");
        }

        theModel.addAttribute("theuser", user);
        return "welcome-" + credentials.getUserPermission();
    }
  
    public void setUser(Person user) {
        this.user = user;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

}
