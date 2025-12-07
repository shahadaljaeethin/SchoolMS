package com.example.SchoolMS.Service;


import com.example.SchoolMS.Api.ApiException;
import com.example.SchoolMS.Model.Course;
import com.example.SchoolMS.Model.Student;
import com.example.SchoolMS.Repository.CourseRepository;
import com.example.SchoolMS.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public void addStudent(Student student){
    studentRepository.save(student);
    }
    public List<Student> getAll(){return studentRepository.findAll();}
    public void updateStudent(Integer id, Student edit){
        Student student = studentRepository.findStudentById(id);
        if(student==null) throw new ApiException("student not found");

        student.setName(edit.getName());
        student.setAge(edit.getAge());
        student.setCourses(edit.getCourses());
        studentRepository.save(student);
    }

    public void removeStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student==null) throw new ApiException("student not found");
        studentRepository.delete(student);
    }

    public void changeMajor(Integer id,String major){
        Student student = studentRepository.findStudentById(id);
        if(student==null) throw new ApiException("student not found");

        student.setMajor(major);
        student.getCourses().clear(); //drop all courses :)

        studentRepository.save(student);
    }


    public void takeCourse(Integer st,Integer cr){
        Course course = courseRepository.findCourseById(cr);
        Student student = studentRepository.findStudentById(st);
        if(student==null||course==null) throw new ApiException("student or course not found");

        course.getStudents().add(student);
        student.getCourses().add(course);
        courseRepository.save(course);
        studentRepository.save(student);
    }
}
