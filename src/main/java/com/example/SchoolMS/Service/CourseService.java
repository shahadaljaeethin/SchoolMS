package com.example.SchoolMS.Service;

import com.example.SchoolMS.Api.ApiException;
import com.example.SchoolMS.DTO.TeacherDTO;
import com.example.SchoolMS.Model.Course;
import com.example.SchoolMS.Model.Teacher;
import com.example.SchoolMS.Repository.CourseRepository;
import com.example.SchoolMS.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
private final CourseRepository courseRepository;
private final TeacherRepository teacherRepository;
//  --------------------------------------------

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course edit){
        Course course = courseRepository.findCourseById(id);
        if(course==null) throw new ApiException("course not found");
        //          -------------------------           \\

        course.setName(edit.getName());
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course==null) throw new ApiException("course not found");
        courseRepository.delete(course);
    }

    public TeacherDTO whoTeacherByCourse(Integer courseId){
    Course course = courseRepository.findCourseById(courseId);
    if(course==null) throw new ApiException("course not found");
    if(course.getTeacher()==null) throw new ApiException("no teacher assigned to this course currently");
    return new TeacherDTO(course.getTeacher().getName(), course.getName());
    }

    public void assignTtoC(Integer teacherId, Integer courseId){

        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);
        if(teacher==null||course==null) throw new ApiException("course or teacher not found");

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

}
