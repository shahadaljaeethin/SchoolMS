package com.example.SchoolMS.Controller;

import com.example.SchoolMS.Api.ApiResponse;
import com.example.SchoolMS.Model.Teacher;
import com.example.SchoolMS.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    //  -----------------------------------
    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher "+teacher.getName()+" is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeTeacher(@PathVariable Integer id){
        teacherService.removeTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("removed"));
    }
//          ====================================================================

    @GetMapping("id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getById(id));
    }

}
