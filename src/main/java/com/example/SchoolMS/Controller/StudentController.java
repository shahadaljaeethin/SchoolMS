package com.example.SchoolMS.Controller;

import com.example.SchoolMS.Api.ApiResponse;
import com.example.SchoolMS.Model.Student;
import com.example.SchoolMS.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("added"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody @Valid Student update){
        studentService.updateStudent(id,update);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.removeStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("removed"));

    }
    @PutMapping("/change major/{id}/{major}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer id, @PathVariable String major){
        studentService.changeMajor(id,major);
        return ResponseEntity.status(200).body(new ApiResponse("major changed to "+major));
    }

    @PutMapping("/add course/{student}/{course}")
    public ResponseEntity<?> takeCourse(@PathVariable Integer student, @PathVariable Integer course){
        studentService.takeCourse(student,course);
        return ResponseEntity.status(200).body(new ApiResponse("course added to the list"));
    }



}
