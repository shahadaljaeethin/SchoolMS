package com.example.SchoolMS.Service;

import com.example.SchoolMS.Api.ApiException;
import com.example.SchoolMS.Model.Teacher;
import com.example.SchoolMS.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;


    public void addTeacher(Teacher teacher){
    teacherRepository.save(teacher);
    }
    public List<Teacher> getAll(){return teacherRepository.findAll();}
    public void updateTeacher(Integer id,Teacher edit){
    Teacher teacher = teacherRepository.findTeacherById(id);
    if(teacher==null) throw new ApiException("teacher not found");

    teacher.setName(edit.getName());
    teacher.setEmail(edit.getEmail());
    teacher.setSalary(edit.getSalary());
    teacher.setAge(edit.getAge());

    teacherRepository.save(teacher);

    }

    public void removeTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher==null) throw new ApiException("teacher not found");
        teacherRepository.delete(teacher);
    }

    //=========================================

    public Teacher getById(Integer id){
        Teacher t = teacherRepository.findTeacherById(id);
        if(t==null) throw new ApiException("teacher not found");
        return t;
    }

}
