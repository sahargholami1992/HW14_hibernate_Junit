package org.example.q2;

import org.example.q2.entity.Person;
import org.example.q2.entity.Student;
import org.example.q2.entity.Teacher;
import org.example.q2.service.PersonService;
import org.example.q2.service.StudentService;
import org.example.q2.service.TeacherService;
import org.example.q2.util.ApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PersonService personService = ApplicationContext.getPersonService();
        StudentService studentService = ApplicationContext.getStudentService();
        TeacherService teacherService = ApplicationContext.getTeacherService();

//
//        Person person1 = personService.signUp("samaneh","movahedi");
//        Person person2 = personService.signUp("sama","boshagh");
//
      Student student1= studentService.signUp("sahar","gholami",100);
//        Student student2= studentService.signUp("pegah","rad",101);
//
//        Teacher teacher1 = teacherService.signUp("ali","aliii",1000);
//        Teacher teacher2 = teacherService.signUp("sara","saraiii",1001);


       student1.setBirthDay(new Date("2010/12/11"));
       studentService.update(student1,1);
//
//
//        studentService.delete(3);
//
//
//        Student student = studentService.findById(4);
//        System.out.println(student);
//
//
//        List<Student> students = studentService.loadAll();
//        for (Student st:students) {
//            System.out.println(st);
//        }




//        boolean containsStudent = studentService.contains("student1","student111");
//        System.out.println(containsStudent);



    }
}