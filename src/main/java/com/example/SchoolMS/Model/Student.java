package com.example.SchoolMS.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "enter name")
    @Size(min = 3,max=20)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Min(value = 18)
    @Positive
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty
    @Size(min = 4,max=50)
    @Column(columnDefinition = "varchar(50) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
