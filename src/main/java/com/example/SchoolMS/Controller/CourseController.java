package com.example.SchoolMS.Controller;

import com.example.SchoolMS.Api.ApiResponse;
import com.example.SchoolMS.Model.Course;
import com.example.SchoolMS.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
private final CourseService courseService;
@GetMapping("/get")
public ResponseEntity<?> getAll(){return ResponseEntity.status(200).body(courseService.getAll());}

@PostMapping("/add")
public ResponseEntity<?> addCourse(@RequestBody @Valid Course course){
    courseService.addCourse(course);
    return ResponseEntity.status(200).body(new ApiResponse("added"));
}
@PutMapping("/update/{id}")
public ResponseEntity<?> updateCourse(@PathVariable Integer id,@RequestBody @Valid Course course){
    courseService.updateCourse(id,course);
    return ResponseEntity.status(200).body(new ApiResponse("update"));
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
    courseService.deleteCourse(id);
    return ResponseEntity.status(200).body(new ApiResponse("deleted"));

}

@GetMapping("/course teacher/{id}")
public ResponseEntity<?> whoTeacherOfCourse(@PathVariable Integer id){
    return ResponseEntity.status(200).body(courseService.whoTeacherByCourse(id));

}

@PutMapping("/assign/{teachId}/{coursID}")
public ResponseEntity<?> assignTtoC(@PathVariable Integer teachId, @PathVariable Integer coursID){
    courseService.assignTtoC(teachId,coursID);
    return ResponseEntity.status(200).body(new ApiResponse("assign done"));
}

@GetMapping("/course students/{id}")
public ResponseEntity<?> getAllStudent(@PathVariable Integer id){
    return ResponseEntity.status(200).body( courseService.getStudentsByCourse(id));
}

}
